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
import la.bean.MemberBean;
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
				 String name = request.getParameter("name");
				    String pass = request.getParameter("pass");
				    String passcheck = request.getParameter("newpass");
				    
				    // 1. まずパスワードの長さをチェック
				    if(pass != null && pass.length() >= 6 && pass.length() <= 16) {
				        
				        // 2. パスワードの一致をチェック
				        if(pass.equals(passcheck)) {
				        	
				            
				            // 3. 名前の入力チェック（null または 空文字 の場合は else へ行く）
				            if(name != null && !name.trim().isEmpty() && name.length() <= 100) {
				                // 名前もパスワードも正しい場合のみ登録
				                int a = dao.addMember(name, pass);
				                if(a != 5) {
				                	
				                gotoPage(request, response, "/login.jsp");
				                return; 
				                
				            	}else {
					            request.setAttribute("message", "この名前は既に存在します");
					            gotoPage(request, response, "/newmember.jsp"); 
					            return;
					        }
				            } else {
				                // 【重要】名前が未入力（nullや空文字）ならここを通る
				                request.setAttribute("message", "名前は１文字以上１００文字以内で入力してください");
				                gotoPage(request, response, "/newmember.jsp"); 
				                return;
				            }
				        	
				            
				        } else {
				            request.setAttribute("message", "パスワードとパスワード確認用が異なります");
				            gotoPage(request, response, "/newmember.jsp"); 
				            return;
				        }
				    } else {
				        request.setAttribute("message", "パスワードは６字以上１６字以下で入力して下さい");
				        gotoPage(request, response, "/newmember.jsp"); 
				        return;
				    }
				    
				 
			}
			 else if(action.equals("logout")) {
					//ログアウト→ログインページ
				 HttpSession session = request.getSession();
				    
				    session.invalidate(); 
				    
				    request.setAttribute("message", "ログアウトしました。");
					gotoPage(request,response,"/login.jsp");
				}
			 else if(action.equals("new")) {
				 //ログイン→新規会員登録ページ
					gotoPage(request, response, "/newmember.jsp");
			 }
			 else if(action.equals("login")) {
				 
				 String name = request.getParameter("name");
				 String pass = request.getParameter("pass");
				 
				 MemberBean loginUser = new MemberBean(name, pass);
				// メールアドレスとパスワードのチェック
					if (name == null || name.length() == 0 ||
						pass == null || pass.length() == 0 ||
						!dao.checkInfo(loginUser)) {
						request.setAttribute("message", "名前かパスワードが間違っています");
						request.setAttribute("name", name);
						gotoPage(request, response, "/login.jsp");
						return;
					}
					
					HttpSession session = request.getSession();
					String isLogin = (String)session.getAttribute("isLogin");
					if (isLogin == null) {
						// 初めてのログイン
						session = request.getSession();
						session.setAttribute("userId", loginUser.getId());
						session.setAttribute("userName", loginUser.getName());
						session.setAttribute("userPass", loginUser.getPass());
						
					}


				
					    List<ItemBean> list = dao.findAll();
						 //ログイン認証→一覧ページ
						 request.setAttribute("showitem", list);
						 gotoPage(request, response, "/itemlist.jsp");
						 
					}
			 else if(action.equals("back")) {
				 List<ItemBean> list = dao.findAll();
				 //ログイン認証→一覧ページ
				 request.setAttribute("showitem", list);
				 gotoPage(request, response, "/itemlist.jsp");
			 }
			 else if(action.equals("change")) {
				    String name = request.getParameter("name");
				    String pass = request.getParameter("pass"); // 画面で入力された「現在のパスワード」
				    String newpass = request.getParameter("newpass");
				    String passcheck = request.getParameter("newpass2");
				    
				    HttpSession session = request.getSession();
				    Integer currentUserId = (Integer) session.getAttribute("userId");
				    // ★セッションから現在の正しいパスワードを取得
				    String currentUserPass = (String) session.getAttribute("userPass");
				    
				    // 【追加】1. 現在のパスワードが正しいかチェック
				    if (currentUserPass == null || !currentUserPass.equals(pass)) {
				        request.setAttribute("message", "現在のパスワードが間違っています");
				        gotoPage(request, response, "/changeinfo.jsp"); 
				        return; // 処理を中断して送り返す
				    }
				    
				    // 2. 新しいパスワードの長さをチェック
				    if(newpass != null && newpass.length() >= 6 && newpass.length() <= 16) {
				            
				        // 3. 新しいパスワードと確認用の一致チェック
				        if(newpass.equals(passcheck)) {
				                
				            // 4. 名前の入力長さチェック
				            if(name != null && !name.trim().isEmpty() && name.length() <= 100) {
				                    
				                // 自分以外の誰かと名前が被っていないかチェックする
				                if(dao.checkName(name, currentUserId)) {
				                    // 重複なしならDB更新OK！
				                    System.out.println("更新するユーザーID: " + currentUserId);
				                    dao.changeInfo(name, newpass, currentUserId);
				                        
				                    // DB変更に成功したら、セッションに保存されている情報も新しくする
				                    session.setAttribute("userName", name);
				                    session.setAttribute("userPass", newpass);
				                        
				                    // ログインページ、またはマイページ（お好みで）に遷移
				                    request.setAttribute("message", "会員情報が更新されました");
				                    gotoPage(request, response, "/login.jsp");
				                    return; 
				                } else {
				                    // 他の人がすでに使っている名前だった場合
				                    request.setAttribute("message", "この名前は既に別のユーザーに使用されています");
				                    gotoPage(request, response, "/changeinfo.jsp"); 
				                    return;
				                }
				                    
				            } else {
				                request.setAttribute("message", "名前は１文字以上１００文字以内で入力してください");
				                gotoPage(request, response, "/changeinfo.jsp"); 
				                return;
				            }
				                
				        } else {
				            request.setAttribute("message", "新しいパスワードとパスワード確認用が異なります");
				            gotoPage(request, response, "/changeinfo.jsp"); 
				            return;
				        }
				    } else {
				        request.setAttribute("message", "新しいパスワードは６字以上16字以下で入力して下さい");
				        gotoPage(request, response, "/changeinfo.jsp"); 
				        return;
				    }
				}
				 
				
			 
			 
			 //////////////////
			 //////生協システム
			 
			 else if(action.equals("seikyoulogin")) {
				 //生協ログインページ遷移
					gotoPage(request, response, "/seikyoulogin.jsp");
			 }
			 else if(action.equals("sdragon")) {
				 String name = request.getParameter("name");
				 String pass = request.getParameter("pass");
				    //int id = dao.slogin(name, pass);
				    
				    // if文でログイン成功・失敗を判定
				    if(name.equals("Doragon")&&pass.equals("akamaru12")) {
				        // 【修正】別のサーブレットへパラメータ付きで遷移させる場合はリダイレクトを使う
				    	ItemDAO dao1 = new ItemDAO();

						List<ItemBean> list = dao1.findAll();
						request.setAttribute("showitem", list);

						gotoPage(request, response, "/seikyouitemlist.jsp");
				    }
				    // 失敗の場合ログイン画面を再表示し、ログインできなかった理由を表示する     
				    else {
				        request.setAttribute("message", "ユーザIDまたはパスワードが異なります");
				        request.setAttribute("name", name);
				        gotoPage(request, response, "/seikyoulogin.jsp"); 
				        return; // 処理をここで確実に終了させる
				    }
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
			    Integer currentUserId = 1;
				
				 
				 if(lang == null) {
					 condition = comment;
				 }
				 else if(comment.length() == 0 && comment.isEmpty()) {
					 condition = lang;
				 }
				 else if(comment.length() != 0) {
					 condition = lang + ":" + comment;
				 }


				 dao.addItem(name, price,nu,lang,comment,condition,currentUserId);
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
			 else if(action.equals("slogout")) {
				 HttpSession session = request.getSession();
				    
				    // 2. 魔法の呪文！カードをその場で消滅させる
				    session.invalidate(); 
				    
				    // 3. 「ログアウトしました」というメッセージを準備する
				    request.setAttribute("message", "ログアウトしました。");
				    gotoPage(request,response,"/login.jsp");
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