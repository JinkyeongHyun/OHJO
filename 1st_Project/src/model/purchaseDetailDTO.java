package model;

public class purchaseDetailDTO {

	private int pcd_pc_number;
	private String pcd_p_model;
	private int pcd_amount;
	private String pcd_price;
	private String pcd_address;
	private String pcd_recip;
	private String pcd_recell;
	public purchaseDetailDTO(int pcd_pc_number, String pcd_p_model, int pcd_amount, String pcd_price, String pcd_address,
			String pcd_recip, String pcd_recell) {
		super();
		this.pcd_pc_number = pcd_pc_number;
		this.pcd_p_model = pcd_p_model;
		this.pcd_amount = pcd_amount;
		this.pcd_price = pcd_price;
		this.pcd_address = pcd_address;
		this.pcd_recip = pcd_recip;
		this.pcd_recell = pcd_recell;
	}
	public int getPcd_pc_number() {
		return pcd_pc_number;
	}
	public String getPcd_p_model() {
		return pcd_p_model;
	}
	public int getPcd_amount() {
		return pcd_amount;
	}
	public String getPcd_price() {
		return pcd_price;
	}
	public String getPcd_address() {
		return pcd_address;
	}
	public String getPcd_recip() {
		return pcd_recip;
	}
	public String getPcd_recell() {
		return pcd_recell;
	}
}
