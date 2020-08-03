package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyAppliancesDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	CustomerDTO dto = null;
	
	public void getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user_id = "hr";
			String user_pw = "hr";
			conn = DriverManager.getConnection(url,user_id,user_pw);
			
			if(conn != null) {
				//System.out.println("연결 성공");
			}else {
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
	
	//내가전 전체 조회
	public ArrayList<MyAppliancesDTO> myAppliancesSelectList(String id) {
		ArrayList<MyAppliancesDTO> dtos = new ArrayList<MyAppliancesDTO>();
		getConnect();
		String sql = "select * from myappliances where id = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			while(rs.next()) {
				String model = rs.getString(2);
				String nickname = rs.getString(3);
				String category = rs.getString(4);
				MyAppliancesDTO dto = new MyAppliancesDTO(id, model, nickname, category);
				dtos.add(dto);
			}
		} catch (SQLException e) {
		}finally {
			close();
		}
		return dtos;
	}
	
	//내 가전 추가
	public int myAppliancesInsert(String id, String model, String nickname) {
		getConnect();
		String sql = "insert into myappliances select ?, ?, ?, category from product where model = ?";
		int result = 0;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, model);
			pstm.setString(3, nickname);
			pstm.setString(4, model);
			result = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	
	//내 가전 수정
	public int myAppliancesUpdate(String newNick, String id, String curNick) {
		int result = 0;
		getConnect();
		String sql = "update myappliances set nickname = ? where id = ? and nickname = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, newNick);
			pstm.setString(2, id);
			pstm.setString(3, curNick);
			System.out.println(newNick);
			System.out.println(id);
			System.out.println(curNick);
			result = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	
	//내 가전 삭제
	public int myAppliancesDelete(String id, String model) {
		getConnect();
		String sql = "delete myappliances where id = ? and model = ?";
		int result = 0;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, model);
			result = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	
	//내 가전 정보 조회 - 내 가전 테이블에서 닉네임과 카테고리로 모델명을 조회해서 제품 테이블에서 그 모델의 정보를 조회
	public ProductDTO myAppliancesSelect(String id, String nickname) { 
		ProductDTO pDto = null;
		getConnect();
		String sql ="select * from product where model=(select model from myappliances where id=? and nickname=?) ";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, nickname);
			rs = pstm.executeQuery();
			while(rs.next()){
				String model = rs.getString(1);
				String name = rs.getString(2);
				String category = rs.getString(3);
				String pclass = rs.getString(4);
				String maxEv = rs.getString(5);
				int eCost = rs.getInt(6);
				int price = rs.getInt(7);
				String img = rs.getString(8);
		
				pDto = new ProductDTO(model, name, category, pclass, maxEv, eCost, price, img);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}		
		return pDto;
	}
}