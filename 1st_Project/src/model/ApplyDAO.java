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
				//System.out.println("연결 성공");
			} else {
				//System.out.println("연결 실패");
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
	
	// 신청 테이블에 데이터 삽입
	public void applyInfo(ApplyDTO dto) {
		getConnect();
		String sql= "insert into apply values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, dto.getApplydate());
			pstm.setInt(2, dto.getApplyno());
			pstm.setString(3, dto.getBank());
			pstm.setString(4, dto.getBankaccount());
			pstm.setInt(5, dto.getApplyamount());
			pstm.setString(6, dto.getDoc());
			pstm.setString(7, dto.getIdcard());
			pstm.setString(8, dto.getId());
				
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close();
		}
	}
	
	// 은행이름, 계좌번호 저장
	public int bankInfo (String id, String bank, String bankaccount) {
		int result = 0;
		getConnect();
		String sql = "insert into applydetail(applyno, id, bank, bankaccount) values (applyno_seq.nextval, ?, ?, ?)";
		
		System.out.println(id + " " + bank + " " + bankaccount);
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, bank);
			pstm.setString(3, bankaccount);
			result = pstm.executeUpdate(); 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	// 신청 상세 테이블에 데이터 삽입
	public void applyDetailInfo(ApplyDetailDTO dto) {
	      getConnect();
	      int cnt = 0;
	      String sql= "insert into applydetail values (SEQ_BOARD.NEXTVAL, ?, ?)";
	      try {
	         pstm = conn.prepareStatement(sql);
	         
	         pstm.setString(1, dto.getModel());
	         pstm.setString(2, dto.getApplyamount());
	         cnt = pstm.executeUpdate();   
	            
	      } catch (SQLException e) {
	         e.printStackTrace();
	         
	      } finally {
	         close();
	      }
	   }
}
