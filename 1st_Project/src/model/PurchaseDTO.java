package model;

public class PurchaseDTO {

	private int pc_number;
	private String pc_ID;
	private String pc_Date;
	public PurchaseDTO(int pc_number, String pc_Date, String pc_ID) {
		super();
		this.pc_number = pc_number;
		this.pc_Date = pc_Date;
		this.pc_ID = pc_ID;
	}
	public int getPc_number() {
		return pc_number;
	}
	public String getPc_Date() {
		return pc_Date;
	}
	public String getPc_ID() {
		return pc_ID;
	}
	
	
	
	
	
	
	}
	
	
	
	
	

