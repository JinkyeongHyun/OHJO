package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	private void getConn() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String dbid = "hr";
		String dbpw = "hr";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void close() {

		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public int PurchaseInsert(PurchaseDTO dto) {
	getConn();
	int cnt = 0;
	String sql = "insert into purchase values(seq,?,?)";
	try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, dto.getPc_ID());
		psmt.setString(2, dto.getPc_Date());
		cnt = psmt.executeUpdate(sql);	
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close();
	}return cnt;
	}
	public int purchaseDetailInsert(purchaseDetailDTO dto) {
		getConn();
		int cnt = 0;
		String sql = "insert into purchasedetail values(SEQ_BOARD.NEXTVAL,?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getPcd_p_model());
			psmt.setInt(2, dto.getPcd_amount());
			psmt.setString(3, dto.getPcd_price());
			psmt.setString(4,dto.getPcd_address());
			psmt.setString(5,dto.getPcd_recip());
			psmt.setString(6,dto.getPcd_recell());
			cnt = psmt.executeUpdate();	
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}return cnt;
		}
	}
	
