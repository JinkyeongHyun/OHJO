package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplyDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	ApplyDTO dto = null;
	
	public void getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user_id = "hr";
			String user_pw = "hr";
			conn = DriverManager.getConnection(url,user_id,user_pw);
			
			if(conn != null) {
				System.out.println("연결 성공");
			} else {
				System.out.println("연결 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(pstm != null) {
				pstm.close();
			}
			if(conn != null) {
				conn.close();
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int applyInfo(ApplyDTO dto) {
		int result = 0;
		getConnect();
		String sql= "insert into apply values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, dto.getApplydate());
			pstm.setString(2, dto.getApplyno());
			pstm.setString(3, dto.getBank());
			pstm.setString(4, dto.getBankaccount());
			pstm.setString(5, dto.getApplyamount());
			pstm.setString(6, dto.getDoc());
			pstm.setString(7, dto.getIdcard());
			pstm.setString(8, dto.getId());
				
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close();
		}
		return result;
	}
	
	// 은행이름, 계좌번호 저장
	public int bankInfo (String id, String bank, String bankaccount) {
		int result = 0;
		getConnect();
		String sql = "update apply set bank = ? and bankaccount = ? where id = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, dto.getBank());
			pstm.setString(2, dto.getBankaccount());
			pstm.setString(3, dto.getId());
			result = pstm.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

}
