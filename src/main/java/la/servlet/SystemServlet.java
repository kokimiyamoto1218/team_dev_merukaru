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
				    String name = request.getParameter("name");
				    String pass = request.getParameter("pass");
				    String passcheck = request.getParameter("newpass");
				    
				    // 1. まずパスワードの長さをチェック
				    if(pass != null && pass.length() >= 6 && pass.length() <= 16) {
				        
				        // 2. パスワードの一致をチェック
				        if(pass.equals(passcheck)) {
				            
				            // 3. 名前の入力チェック（null または 空文字 の場合は else へ行く）
				            if(name != null && !name.trim().isEmpty()) {
				                // 名前もパスワードも正しい場合のみ登録
				                dao.addMember(name, pass);
				                gotoPage(request, response, "/login.jsp");
				                return; 
				            } else {
				                // 【重要】名前が未入力（nullや空文字）ならここを通る
				                request.setAttribute("message", "名前は１文字以上で入力してください");
				                gotoPage(request, response, "/newmember.jsp"); 
				                return;
				            }
				            
				        } else {
				            request.setAttribute("message", "パスワードとパスワード確認用が異なります");
				            gotoPage(request, response, "/newmember.jsp"); 
				            return;
				        }
				    } else {
				        request.setAttribute("message", "パスワードは６字以上16字以下で入力して下さい");
				        gotoPage(request, response, "/newmember.jsp"); 
				        return;
				    }
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
				    
				    // if文でログイン成功・失敗を判定
				    if(id >= 1) {
				        // 【修正】別のサーブレットへパラメータ付きで遷移させる場合はリダイレクトを使う
				        response.sendRedirect(request.getContextPath() + "/ItemServlet?action=drgonsearch");
				        return; // 処理をここで確実に終了させる
				    }
				    // 失敗の場合ログイン画面を再表示し、ログインできなかった理由を表示する     
				    else {
				        request.setAttribute("message", "ユーザIDまたはパスワードが異なります");
				        gotoPage(request, response, "/seikyoulogin.jsp"); 
				        return; // 処理をここで確実に終了させる
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