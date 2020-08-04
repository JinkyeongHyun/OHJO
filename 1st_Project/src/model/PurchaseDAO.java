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
	String sql = "insert into purchase values(SEQ_BOARD.NEXTVAL,?,?)";
	try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, dto.getId());
		psmt.setString(2, dto.getDate());
		cnt = psmt.executeUpdate();
	
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close();
	}return cnt;
	}
	// 결제창에서 구매 상세 테이블로 입력
	public int purchaseDetailInsert(PurchaseDetailDTO dto) {
		getConn();
		int cnt = 0;
		String sql = "insert into purchasedetail values(?,?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, dto.getOrderno());
			psmt.setString(2, dto.getModel());
			psmt.setInt(3, dto.getAmount());
			psmt.setString(4,dto.getTotalprice());
			psmt.setString(5,dto.getAddress());
			psmt.setString(6,dto.getReceiver());
			psmt.setString(7,dto.getReceivercell());
			cnt = psmt.executeUpdate();	
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}return cnt;
		}
//	public ArrayList<CustomerDTO> IDselect() {
//		getConn();
//		String sql = "select * from customer";
//		ArrayList<CustomerDTO> IDList = new ArrayList<>();
//		System.out.println("실행됨");
//		try {
//			psmt = conn.prepareStatement(sql);
//			rs = psmt.executeQuery();
//
//			while (rs.next()) {
//				String c_id = rs.getString(1);
//				String c_pw = rs.getString(2);
//				String c_name = rs.getString(3);
//				String c_cell = rs.getString(4);
//				
//				IDList.add(new CustomerDTO(c_id, c_pw, c_name, c_cell));
//			}
//				} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//		return IDList;
//}
	
	//검색
	public ArrayList<PurchaseDetailDTO> search() {
		getConn();
		String sql = "select * from purchasedetail";
		ArrayList<PurchaseDetailDTO> pdetailList = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				int orderno = rs.getInt(1);
				String model = rs.getString(2);
				int amount = rs.getInt(3);
				String totalprice = rs.getString(4);
				String address = rs.getString(5);
				String receiver = rs.getString(6);
				String receivercell = rs.getString(7);
				pdetailList.add(new PurchaseDetailDTO(orderno, model, amount, totalprice, address, receiver, receivercell));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return pdetailList;
}  //구매 테이블 정보를 불러와 2차배열에 기입한다.
	public ArrayList<PurchaseDTO> numsearch() {
		getConn();
		String sql = "select * from purchase";
		ArrayList<PurchaseDTO> purchaseList = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				int orderno = rs.getInt(1);
				String id = rs.getString(2);
				String date = rs.getString(3);
				
				purchaseList.add(new PurchaseDTO(orderno, id, date));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return purchaseList;
	
}
}
	


	
