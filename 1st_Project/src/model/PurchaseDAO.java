package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	//구매 테이블 입력
	public int PurchaseInsert(PurchaseDTO dto) {
	getConn();
	int cnt = 0;
	String sql = "insert into purchase values(SEQ_BOARD.NEXTVAL,?,Sysdate)";
	try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, dto.getPc_ID());
		cnt = psmt.executeUpdate(sql);	
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close();
	}return cnt;
	}
	// 결제창에서 구매 상세 테이블로 입력
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


	
