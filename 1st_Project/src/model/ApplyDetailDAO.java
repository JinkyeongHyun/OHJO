package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ApplyDetailDAO {
	
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
	
	// 신청 내역 리스트 불러오기
	public ArrayList<ApplyDetailDTO> applyInfoSelect() {
		ArrayList<ApplyDetailDTO> applyDetailList = new ArrayList<ApplyDetailDTO>();
		getConnect();
		String sql = "select * from applydetail";
		try {
			pstm = conn.prepareStatement(sql);
	
			rs = pstm.executeQuery();
			while (rs.next()) {
				int applyno = rs.getInt(1);
				String model = rs.getString(2);
				String applyamount = rs.getString(3);
				ApplyDetailDTO dto = new ApplyDetailDTO(applyno, model, applyamount);
				applyDetailList.add(dto);
				
				System.out.println(applyno);
				System.out.println(model);
				System.out.println(applyamount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return applyDetailList;
	}

}
