package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.ItemBean;
import la.bean.SaleHistoryBean;
import la.bean.purchasehistoryBean;
import la.dao.ItemDAO;

@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// パラメータの解析は特になし
		HttpSession session = request.getSession();
		
		// 2. カードから会員番号（userId）を取り出す
	    Integer currentUserId = (Integer) session.getAttribute("userId");
	    String currentUserName =  (String) session.getAttribute("userName");
	    String currentUserPass = (String) session.getAttribute("userPass");

	    // 3. ちゃんとログインしているかチェック
	    if (currentUserId != null) {
	        // ★大成功！別のサーブレットでも member_id（currentUserId）が使えます！
	        //System.out.println("別のサーブレットに届いたよ！会員番号は: " + currentUserId);
	        
	        // ここで別のDAOを呼び出したり、その人専用の処理をしたりできるよ！
	        // ex) detailDao.getDetailList(currentUserId);

	    } else {
	        // カードに番号がない ＝ ログインしてない悪い子、または時間が経ってカードが消えちゃった人
	        gotoPage(request, response, "/login.jsp");
	    }
	
		
		// モデルを使って全商品を取得する
		try {
			request.setCharacterEncoding("UTF-8");
			ItemDAO dao = new ItemDAO();
			
			String action = request.getParameter("action");
			//
			
			 if(action == null) {
				
			// Listをリクエストスコープに入れてJSPへフォーワードする
				 gotoPage(request,response,"/login.jsp");
			
			}
			 
			 
			 ////////一覧システム
			 
			 else if(action.equals("mypage")) {
				 //一覧→マイページ
					gotoPage(request, response, "/mypage.jsp");
			 }
			 else if(action.equals("sale")) {
				 //一覧→出品ページ
					gotoPage(request, response, "/sale.jsp");
			 }
			 else if (action.equals("search")) {
					//一覧検索→検索結果表示
					ItemDAO dao1 = new ItemDAO();
					String name = request.getParameter("bookname");
					String neworused = request.getParameter("check");
					System.out.println("neworused:" + neworused);

					List<ItemBean> list = dao1.searchBook(name, neworused);
					request.setAttribute("showitem", list);

					gotoPage(request, response, "/itemlist.jsp");

			} 
			 else if(action.equals("go")) {
				
				 String name = request.getParameter("name");
				// 出品→一覧ページ
				 String price = request.getParameter("price");
				 
				 if (name == null || name.trim().isEmpty()) {
					 
					 request.setAttribute("errorMsg", "教科書名を入力してください。");
					
					 gotoPage(request, response, "/sale.jsp");
					 return; 
				 }
				 if (price == null || price.trim().isEmpty()) {
					 
					 request.setAttribute("errorMsg", "金額を入力してください。");
					
					 gotoPage(request, response, "/sale.jsp");
					 return; 
				 }
				 int intprice = Integer.parseInt(request.getParameter("price"));
				 String nu = request.getParameter("nu"); 
				 
				 String[] langs = request.getParameterValues("lang");
				 String lang = "";
				 if (langs != null) {
					
					 lang = String.join(" ", langs); 
				 }
				 
				 String comment = request.getParameter("comment");
				 String condition = "";
				 
				 
				 dao.addItem(name, intprice, nu, lang, comment, condition, currentUserId);
				 
				 System.out.println("add");
				 List<ItemBean> list = dao.findAll();
				 // Listをリクエストスコープに入れてJSPへフォーワードする
				 request.setAttribute("showitem", list);
				 gotoPage(request, response, "/itemlist.jsp");
			 }
			 else if(action.equals("buy")) {
				 //購入→購入内容確認ページ
				    int product_id = Integer.parseInt(request.getParameter("code"));
				    String name = request.getParameter("name");
				    int price = Integer.parseInt(request.getParameter("price")); 
				    String condition = request.getParameter("condition");
				    String neworused = request.getParameter("neworused");
				    System.out.println(product_id);
				    request.setAttribute("product_id", product_id);
					request.setAttribute("name", name);
					request.setAttribute("price", price);
					request.setAttribute("condition",condition);
					request.setAttribute("neworused",neworused); 
					
					gotoPage(request, response, "/buy.jsp");
			 }
			 else if(action.equals("bhistory")) {;

			 int product_id = Integer.parseInt(request.getParameter("id"));
				 List<purchasehistoryBean> list = dao.findParcashistory(product_id);

				 request.setAttribute("purchasehistory", list);
				//マイページ→購入履歴ページ
					gotoPage(request, response, "/boughthistory.jsp");
			 }
			 else if(action.equals("shistory")) {
				//マイページ→出品履歴ページ
				 
				 List<SaleHistoryBean> list = dao.findMysale(currentUserId);
				 
				 request.setAttribute("showitem", list);
				 
				 
					gotoPage(request, response, "/salehistory.jsp");
			 }
			 else if(action.equals("delete")) {
				 //取り消し→画面上削除、saleテーブル削除
				 int product_id = Integer.parseInt(request.getParameter("pid"));
				 System.out.println(product_id);
				 dao.deleteSalehistory(product_id);
				 
				 List<SaleHistoryBean> list = dao.findMysale(currentUserId);
				 
				 request.setAttribute("showitem", list);
					gotoPage(request, response, "/salehistory.jsp");
			 }
			 else if(action.equals("info")) {
				 //マイページ→会員情報照会ページ
				 request.setAttribute("name", currentUserName);
				 request.setAttribute("pass", currentUserPass);
				 
					gotoPage(request, response, "/info.jsp");
			 }
			 else if(action.equals("res")) {
				 //受け取り予約→一覧ページ
				    String date = request.getParameter("date");
				    int product_id = Integer.parseInt(request.getParameter("code"));
				    System.out.print(product_id);
				    dao.updatePurcahase(product_id,date);
				    dao.deleteFlag(product_id);
				    List<ItemBean> list = dao.findAll();
					 //ログイン認証→一覧ページ
					 request.setAttribute("showitem", list);
					gotoPage(request, response, "/itemlist.jsp");
					
			 }
			 else if(action.equals("apointment")) {
				 //出品→一覧ページ
				 int product_id = Integer.parseInt(request.getParameter("code"));
				 String product_name = request.getParameter("name");

				 int price = Integer.parseInt(request.getParameter("price")); 
				 dao.addPurcahase(product_id,product_name,price,currentUserId);

				 request.setAttribute("product_id", product_id);
				 
					gotoPage(request, response, "/apointment.jsp");
			 }
			 else if(action.equals("cinfo")) {
				 //会員情報照会→会員情報変更ページ
					gotoPage(request, response, "/changeinfo.jsp");
			 }
			
			
		} catch (Exception e) {		//DAOが完成次第DAOExceptionに変更
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
			rd.forward(request, response);
		}
		
		//String action = request.getParameter("action");
		//if(action.equals("regist")) {
            
			
			//gotoPage(request,response,"/addItem.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}