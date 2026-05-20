package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SystemServlet")
public class SystemServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// パラメータの解析は特になし
		
		// モデルを使って全商品を取得する
		try {
			request.setCharacterEncoding("UTF-8");
			//ItemDAO dao = new ItemDAO();
			
			String action = request.getParameter("action");
			//
			
			 if(action == null) {
				
			// Listをリクエストスコープに入れてJSPへフォーワードする
				 gotoPage(request,response,"/login.jsp");
			
			}
			 else if(action.equals("newmember")) {
				
				gotoPage(request,response,"/login.jsp");
				
			
			}
			 else if(action.equals("logout")) {
					
					gotoPage(request,response,"/login.jsp");
					
				}
			 else if(action.equals("new")) {
				 
					gotoPage(request, response, "/newmember.jsp");
			 }
			 else if(action.equals("login")) {
				 
					gotoPage(request, response, "/itemlist.jsp");
			 }
			 else if(action.equals("mypage")) {
				 
					gotoPage(request, response, "/mypage.jsp");
			 }
			 else if(action.equals("sale")) {
				 
					gotoPage(request, response, "/sale.jsp");
			 }
			 else if(action.equals("search")) {
				 
					gotoPage(request, response, "/itemlist.jsp");
			 }
			 else if(action.equals("go")) {
				 
					gotoPage(request, response, "/itemlist.jsp");
			 }
			 else if(action.equals("buy")) {
				 
					gotoPage(request, response, "/buy.jsp");
			 }
			 else if(action.equals("sale")) {
				 
					gotoPage(request, response, "/itemlist.jsp");
			 }
			 else if(action.equals("bhistory")) {
				 
					gotoPage(request, response, "/boughthistory.jsp");
			 }
			 else if(action.equals("shistory")) {
				 
					gotoPage(request, response, "/salehistory.jsp");
			 }
			 else if(action.equals("info")) {
				 
					gotoPage(request, response, "/info.jsp");
			 }
			 else if(action.equals("cinfo")) {
				 
					gotoPage(request, response, "/changeinfo.jsp");
			 }
			 else if(action.equals("seikyoulogin")) {
				 
					gotoPage(request, response, "/seikyoulogin.jsp");
			 }
			 else if(action.equals("slogin")) {
				 
					gotoPage(request, response, "/seikyouitemlist.jsp");
			 }
			 else if(action.equals("ssearch")) {
				 
					gotoPage(request, response, "/seikyouitemlist.jsp");
			 }
			 else if(action.equals("ssale")) {
				 
					gotoPage(request, response, "/seikyousale.jsp");
			 }
			 else if(action.equals("seikyousale")) {
				 
					gotoPage(request, response, "/seikyouitemlist.jsp");
			 }
			 else if(action.equals("ssalehis")) {
				 
					gotoPage(request, response, "/seikyousalehistory.jsp");
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