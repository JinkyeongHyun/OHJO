package model;

public class PurchaseDTO {

	private int orderno;
	private String id;
	private String date;
	
	public PurchaseDTO(int orderno, String id, String date) {
		this.orderno = orderno;
		this.id = id;
		this.date = date;
	}
	public int getOrderno() {
		return orderno;
	}
	public String getId() {
		return id;
	}
	public String getDate() {
		return date;
	}
	
	
	
	
}
	
	
	
	
	

