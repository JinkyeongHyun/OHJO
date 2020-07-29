package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
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
				//System.out.println("���� ����");
			}else {
				//System.out.println("���� ����");
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
	
	//�α���
	public CustomerDTO loginSelect(String id, String pw) {
		getConnect();
		String sql = "select * from customer where id=? and pw=?";
		try {		
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			
			rs = pstm.executeQuery();
			while(rs.next()) {
				String loginId = rs.getString(1);
				String loginPw = rs.getString(2);
				String loginName = rs.getString(3);
				String loginCell = rs.getString(4);
				dto = new CustomerDTO(loginId, loginPw, loginName, loginCell);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	
	//ȸ������
	public int signUpInsert(CustomerDTO dto) {
		int result = 0;
		getConnect();
		String sql= "insert into customer values (?,?,?,?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, dto.getC_id());
			pstm.setString(2, dto.getC_pw());
			pstm.setString(3, dto.getC_name());
			pstm.setString(4, dto.getC_cell());
			
			result = pstm.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	
	//���̵� �ߺ�üũ
	public boolean signUpCheck(String id) {
		getConnect();
		String sql = "select * from customer where id=?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
		
			rs = pstm.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//������(�ߺ��̸�) true
		//������(�ߺ��̾ƴϸ�) false ��ȯ
		return false;
	}
}