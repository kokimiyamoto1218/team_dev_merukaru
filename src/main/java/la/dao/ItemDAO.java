package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.ItemBean;

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
				int delete_flag =rs.getInt("delete_flog");
				
				
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
	public int addItem(int catecode,String name,int price) throws DAOException {
		// SQL文の作成
		String sql = "INSERT INTO item(category_code,name, price) VALUES(?, ?, ?)";
		
		try (// データベースへの接続
			 Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatementオブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql);) {
			// 商品名と値段の指定
			st.setInt(1, catecode);
			st.setString(2, name);
			st.setInt(3, price);
			// SQLの実行
			int rows = st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		} 
	}
	
	
}