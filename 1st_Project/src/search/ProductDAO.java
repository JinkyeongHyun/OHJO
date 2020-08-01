package search;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ProductDTO;

public class ProductDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	public void getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. DB연결
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user_id = "hr";
			String user_pw = "hr";

			conn = DriverManager.getConnection(url, user_id, user_pw);

			if (conn != null) {
				System.out.println("연결성공");
			} else {
				System.out.println("연결 실패");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void close() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<ProductDTO> select() {
		getConnect();
		String sql = "select * from product";
		ArrayList<ProductDTO> modelList = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String p_model = rs.getString(1);
				String p_name = rs.getString(2);
				String p_category = rs.getString(3);
				String p_class = rs.getString(4);
				String p_maxEv = rs.getString(5);
				int p_eCost = rs.getInt(6);
				int p_price = rs.getInt(7);
				String p_img = rs.getString(8);
				modelList.add(new ProductDTO(p_model, p_name, p_category, p_class, p_maxEv, p_eCost, p_price, p_img));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return modelList;
	}
	
	//검색
	public ArrayList<ProductDTO> search(String model) {
		getConnect();
		String sql = "select * from product where model = ?";
		ArrayList<ProductDTO> modelList = new ArrayList<>();
		System.out.println("디테일 값 : "+model);
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, model);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String p_model = rs.getString(1);
				String p_name = rs.getString(2);
				String p_category = rs.getString(3);
				String p_class = rs.getString(4);
				String p_maxEv = rs.getString(5);
				int p_eCost = rs.getInt(6);
				int p_price = rs.getInt(7);
				String p_img = rs.getString(8);
				modelList.add(new ProductDTO(p_model, p_name, p_category, p_class, p_maxEv, p_eCost, p_price, p_img));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return modelList;
	}
	//오름차순
	public ArrayList<ProductDTO> priceAsce() {
		getConnect();
		String sql = "select * from product order by price";
		ArrayList<ProductDTO> modelList = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String p_model = rs.getString(1);
				String p_name = rs.getString(2);
				String p_category = rs.getString(3);
				String p_class = rs.getString(4);
				String p_maxEv = rs.getString(5);
				int p_eCost = rs.getInt(6);
				int p_price = rs.getInt(7);
				String p_img = rs.getString(8);
				modelList.add(new ProductDTO(p_model, p_name, p_category, p_class, p_maxEv, p_eCost, p_price, p_img));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return modelList;
	}
	//내림차순
	public ArrayList<ProductDTO> priceDesc() {
		getConnect();
		String sql = "select * from product order by price desc";
		ArrayList<ProductDTO> modelList = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String p_model = rs.getString(1);
				String p_name = rs.getString(2);
				String p_category = rs.getString(3);
				String p_class = rs.getString(4);
				String p_maxEv = rs.getString(5);
				int p_eCost = rs.getInt(6);
				int p_price = rs.getInt(7);
				String p_img = rs.getString(8);
				modelList.add(new ProductDTO(p_model, p_name, p_category, p_class, p_maxEv, p_eCost, p_price, p_img));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return modelList;
	}
	
	public ArrayList<ProductDTO> eclss(String eclass, String sorted) {
		getConnect();
		String sql = "select * from product where class = ? order by price "+ sorted;
		ArrayList<ProductDTO> modelList = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, eclass);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String p_model = rs.getString(1);
				String p_name = rs.getString(2);
				String p_category = rs.getString(3);
				String p_class = rs.getString(4);
				String p_maxEv = rs.getString(5);
				int p_eCost = rs.getInt(6);
				int p_price = rs.getInt(7);
				String p_img = rs.getString(8);
				modelList.add(new ProductDTO(p_model, p_name, p_category, p_class, p_maxEv, p_eCost, p_price, p_img));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return modelList;
	}
}
