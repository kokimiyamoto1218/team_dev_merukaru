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
	public int addItem(String name,int price,String nu,String lang,String comment) throws DAOException {
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
			st.setString(3, lang + ":" + comment);
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
				
			
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		} 
	}
//	public int addSaleistory(int id,String name, int sale_id, int price) throws DAOException {
//		// SQL文の作成
//		String sql = "INSERT INTO salehistory(product_id, product_name,sale_id,price) VALUES( ?, ?, ?, ?)";
//		String sql3 = "INSERT INTO salehistory(product_id, product_name,sale_id,price) VALUES( ?, ?, ?, ?)";
//		
//		try (// データベースへの接続
//			 Connection con = DriverManager.getConnection(url, user, pass);
//			 // PreparedStatementオブジェクトの取得
//			 PreparedStatement st = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
//			// 商品名と値段の指定
//			st.setInt(1, id);
//			st.setString(2, name);
//			st.setInt(3, sale_id);
//			st.setInt(4, price);
//			// SQLの実行
//			int rows = st.executeUpdate();
//			ResultSet rs = st.getGeneratedKeys();
//			int iid = 0;
//			while(rs.next()) {
//				id = rs.getInt(1);
//			}
//			
//			
//			
//			
//			return rows;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new DAOException("レコードの操作に失敗しました。");
//		} 
//	}
	
	
	
}