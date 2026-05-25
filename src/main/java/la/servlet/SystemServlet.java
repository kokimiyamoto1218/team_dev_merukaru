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
		request.setCharacterEncoding("UTF-8");

		// パラメータの解析は特になし
		
		// モデルを使って全商品を取得する
		try {
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
			 
			 
			 
			 //////生協システム
			 
			 else if(action.equals("seikyoulogin")) {
				 //生協ログインページ遷移
					gotoPage(request, response, "/seikyoulogin.jsp");
			 }
			 else if(action.equals("slogin")) {
				 String name = request.getParameter("name");
				 String pass = request.getParameter("pass");
				 int id = dao.slogin(name, pass);
				 //if分でログイン成功・失敗を判定　0行なら失敗、１行以上なら成功
				 if(id >= 1) {
					 gotoPage(request, response, "/ItemServlet?action=drgonsearch");
				 }
				//失敗の場合ログイン画面を再表示し、ログインできなかった理由を表示する	 
				 else {
					 request.setAttribute("message", "ユーザIDまたはパスワードが異なります");
					 gotoPage(request, response, "/seikyoulogin.jsp"); 
				 }
			     
			 }
			 else if(action.equals("ssale")) {
				 //生協一覧の出品→生協出品ページ
					gotoPage(request, response, "/seikyousale.jsp");
			 }
			 else if(action.equals("seikyousale")) {
				 //生協出品→一覧更新、画面遷移
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