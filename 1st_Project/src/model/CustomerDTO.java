package model;

public class CustomerDTO {
	private String c_id;	//고객아이디
	private String c_pw;	//고객비밀번호
	private String c_name;	//고객이름
	private String c_cell;	//고객전화번호
	
	public CustomerDTO(String c_id, String c_pw, String c_name, String c_cell) {
		this.c_id = c_id;
		this.c_pw = c_pw;
		this.c_name = c_name;
		this.c_cell = c_cell;
	}
	
	public String getC_id() {
		return c_id;
	}
	public String getC_pw() {
		return c_pw;
	}
	public String getC_name() {
		return c_name;
	}
	public String getC_cell() {
		return c_cell;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public void setC_pw(String c_pw) {
		this.c_pw = c_pw;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public void setC_cell(String c_cell) {
		this.c_cell = c_cell;
	}
}
