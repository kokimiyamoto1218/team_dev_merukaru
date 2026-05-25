package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.ItemBean;
import la.dao.ItemDAO;

@WebServlet("/SystemServlet")
public class SystemServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// パラメータの解析は特になし
		
		// モデルを使って全商品を取得する
		try {
			request.setCharacterEncoding("UTF-8");
			//ItemDAO dao = new ItemDAO();
			ItemDAO dao = new ItemDAO();
			
			String action = request.getParameter("action");
			//DAOオブジェクト生成
			
			
			 if(action == null) {
				
			// Listをリクエストスコープに入れてJSPへフォーワードする
				 gotoPage(request,response,"/login.jsp");
			
			}
			 else if(action.equals("newmember")) {
				//新規会員登録→ログインページ
				gotoPage(request,response,"/login.jsp");
			}
			 else if(action.equals("logout")) {
					//ログアウト→ログインページ
					gotoPage(request,response,"/login.jsp");
				}
			 else if(action.equals("new")) {
				 //ログイン→新規会員登録ページ
					gotoPage(request, response, "/newmember.jsp");
			 }
			 else if(action.equals("login")) {
				 List<ItemBean> list = dao.findAll();
				 //ログイン認証→一覧ページ
				 request.setAttribute("showitem", list);
				 gotoPage(request, response, "/itemlist.jsp");
				 
			 }
			 
			 
			 //////////////////
			 //////生協システム
			 
			 else if(action.equals("seikyoulogin")) {
				 //生協ログインページ遷移
					gotoPage(request, response, "/seikyoulogin.jsp");
			 }
			 else if(action.equals("slogin")) {
				 //生協ログイン→生協一覧
				 
				 List<ItemBean> list = dao.findAll();
				 request.setAttribute("showitem", list);
					gotoPage(request, response, "/seikyouitemlist.jsp");
			 }
			 else if(action.equals("ssearch")) {
				 //生協検索→検索結果表示
				 String name = request.getParameter("bookname");
				 String neworused = request.getParameter("check");
				 System.out.println("neworused:" + neworused);
				 
				 List<ItemBean> list = dao.searchBook(name, neworused);
				 request.setAttribute("showitem", list);
					gotoPage(request, response, "/seikyouitemlist.jsp");
			 }
			 else if(action.equals("ssale")) {
				 //生協一覧の出品→生協出品ページ
					gotoPage(request, response, "/seikyousale.jsp");
			 }
			 else if(action.equals("seikyousale")) {
				 //生協出品→一覧更新、画面遷移
				 
				 String name = request.getParameter("name");
				 int price = Integer.parseInt(request.getParameter("price"));
				 String nu = request.getParameter("nu");
				 String lang = request.getParameter("lang");
				 String comment = request.getParameter("comment");
				String condition = "";
				 
				 if(lang == null) {
					 condition = comment;
				 }
				 else if(comment.length() == 0 && comment.isEmpty()) {
					 condition = lang;
				 }
				 else if(comment.length() != 0) {
					 condition = lang + ":" + comment;
				 }


				 dao.addItem(name, price,nu,lang,comment,condition);
				 System.out.println("add");
				 List<ItemBean> list = dao.findAll();
					// Listをリクエストスコープに入れてJSPへフォーワードする
					request.setAttribute("showitem", list);
					gotoPage(request, response, "/seikyouitemlist.jsp");
			 }
			 else if(action.equals("sdelete")) {
				 //生協削除ボタン→一覧削除、画面更新
				 int product_id = Integer.parseInt(request.getParameter("pid"));
				 System.out.println(product_id);
				 dao.deleteSalehistory(product_id);
				 
				 List<ItemBean> list = dao.findAll();
				 
				 request.setAttribute("showitem", list);
					gotoPage(request, response, "/seikyouitemlist.jsp");
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