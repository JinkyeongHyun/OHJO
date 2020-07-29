package model;

public class PurchaseDTO {

	private String pc_number;
	private String pc_Date;
	private String pc_amount;
	private int pc_cost;
	
	public PurchaseDTO(String pc_number, String pc_Date, String pc_amount, int pc_cost, String pc_applyNumber) {
		super();
		this.pc_number = pc_number;
		this.pc_Date = pc_Date;
		this.pc_amount = pc_amount;
		this.pc_cost = pc_cost;
		
	}
	public String getPc_number() {
		return pc_number;
	}
	public String getPc_Date() {
		return pc_Date;
	}
	public String getPc_amount() {
		return pc_amount;
	}
	public int getPc_cost() {
		return pc_cost;
	}
	
	
	
	
	
}
