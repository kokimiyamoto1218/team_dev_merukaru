package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.ItemBean;
import la.bean.SaleHistoryBean;

public class ItemDAO {
	// URL、ユーザ名、パスワードの準備
	private String url = "jdbc:postgresql:group7";
	private String user = "student";
	private String pass = "himitu";
	
	public ItemDAO() throws DAOException {
		try {
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("ドライバの登録に失敗しました。");
		}
	}

	public List<ItemBean> findAll() throws DAOException {
		// SQL文の作成
		String sql = "SELECT * FROM sale ORDER BY product_id";
		
		try (// データベースへの接続
			 Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatementオブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql);
			 // SQLの実行
			 ResultSet rs = st.executeQuery();) {
			// 結果の取得
			List<ItemBean> list = new ArrayList<ItemBean>();
			while (rs.next()) {
				int product_id=rs.getInt("product_id");
				String  product_name = rs.getString("product_name");
				int price = rs.getInt("price");
				String condition = rs.getString("condition");
				String neworused = rs.getString("neworused");
				int delete_flag =rs.getInt("delete_flag");
				
				
				ItemBean bean = new ItemBean(product_id,product_name,price,condition,neworused,delete_flag);
				list.add(bean);
			}
			// 商品一覧をListとして返す
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}
	public List<SaleHistoryBean> findMysale() throws DAOException {
		// SQL文の作成
		String sql = "SELECT * FROM salehistory ORDER BY product_id";
		
		try (// データベースへの接続
			 Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatementオブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql);
			 // SQLの実行
			 ResultSet rs = st.executeQuery();) {
			// 結果の取得
			List<SaleHistoryBean> list = new ArrayList<SaleHistoryBean>();
			while (rs.next()) {
				int product_id=rs.getInt("product_id");
				String  product_name = rs.getString("product_name");
				int price = rs.getInt("price");
				int sale_id =rs.getInt(1);
				
				SaleHistoryBean bean = new SaleHistoryBean(product_id, product_name, sale_id, price);
				list.add(bean);
			}
			// 商品一覧をListとして返す
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}
	public int addItem(String name,int price,String nu,String lang,String comment,String condition) throws DAOException {
		// SQL文の作成
		String sql = "INSERT INTO sale(product_name, price,condition,neworused) VALUES( ?, ?, ?, ?) RETURNING product_id";
		String sql2 = "INSERT INTO salehistory(product_id, product_name,sale_id,price) VALUES( ?, ?, ?, ?)";
		
		
		
		try (// データベースへの接続
			 Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatementオブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql);
				PreparedStatement st2 = con.prepareStatement(sql2) ;) {
			// 商品名と値段の指定
			st.setString(1, name);
			st.setInt(2, price);
			st.setString(3, condition);
			st.setString(4, nu);
			// SQLの実行
			ResultSet rs = st.executeQuery(); 
			int pid = 0;
			while(rs.next()) {
				pid = rs.getInt("product_id");
			}
			
				// 商品名と値段の指定
				st2.setInt(1, pid);
				st2.setString(2, name);
				st2.setInt(3, 1);
				st2.setInt(4, price);
				// SQLの実行
				int rows = st2.executeUpdate();
				System.out.println("historyadd");
			
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		} 
	}
	public int deleteSalehistory(int pid) throws DAOException {
		// SQL文の作成
		String sql = "DELETE FROM salehistory WHERE product_id = ?";
		String sql2 = "DELETE FROM sale WHERE product_id = ?";
		
		try (// データベースへの接続
			 Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatementオブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql);
			 PreparedStatement st2 = con.prepareStatement(sql2);) {
			// 商品コードの指定
			st.setInt(1, pid);
			st2.setInt(1, pid);
			// SQLの実行
			int rows = st.executeUpdate();
			int rows2 = st2.executeUpdate();
			return rows + rows2;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}
	public List<ItemBean> searchBook(String name, String neworused) throws DAOException {
	String sql = "select * from sale where 1 = 1";

	// 条件の追加
	boolean hasName = (name != null && name.length() != 0);
	boolean hasNewOrUsed = (neworused != null && neworused.length() != 0);
	System.out.println("neworused in seachBook:" + neworused);
	System.out.println("hasName:" + hasName);
	System.out.println("hasNewOrUsed:" + hasNewOrUsed);
	if (hasName) {
		sql += " AND product_name like ?";
	}
	if (hasNewOrUsed) {
		if ("新品".equals(neworused) || "中古".equals(neworused)) {
			sql += " AND neworused = ?";
		}
	}

	try (// データベースへの接続
			Connection con = DriverManager.getConnection(url, user, pass);
			// PreparedStatementオブジェクトの取得
			PreparedStatement st = con.prepareStatement(sql);) {
		System.out.println(st.toString());
		// プレースホルダの設定
		int i = 0; // カウンタ変数
		if (name != null && name.length() != 0) {
			i++;
			st.setString(i, "%" + name + "%");
		}
		if (neworused != null && neworused.length() != 0) {
			if ("新品".equals(neworused) || "中古".equals(neworused)) {
				i++;
				st.setString(i, neworused);
			}

		}
		System.out.println(st.toString());

		try (// SQLの実行
				ResultSet rs = st.executeQuery();) {
			// 結果の取得および表示
			List<ItemBean> list = new ArrayList<ItemBean>();
			while (rs.next()) {
				// ItemBeanオブジェクトを生成してリストに追加する
				list.add(new ItemBean(0, rs.getString("product_name"), rs.getInt("price"),  rs.getString("condition"), rs.getString("neworused"), 0));
			}
			// 商品一覧をListとして返す
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	} catch (

	SQLException e) {
		e.printStackTrace();
		throw new DAOException("レコードの取得に失敗しました。");
	}

}
	
	
	
}