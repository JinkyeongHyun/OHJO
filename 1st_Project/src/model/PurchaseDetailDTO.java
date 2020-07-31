package model;

public class PurchaseDetailDTO {

	private int orderno;
	private String model;
	private int amount;
	private String totalprice;
	private String address;
	private String receiver;
	private String receivercell;
	
	
	public PurchaseDetailDTO(int orderno, String model, int amount, String totalprice, String address, String receiver,
			String receivercell) {
		this.orderno = orderno;
		this.model = model;
		this.amount = amount;
		this.totalprice = totalprice;
		this.address = address;
		this.receiver = receiver;
		this.receivercell = receivercell;
	}
	public int getOrderno() {
		return orderno;
	}
	public String getModel() {
		return model;
	}
	public int getAmount() {
		return amount;
	}
	public String getTotalprice() {
		return totalprice;
	}
	public String getAddress() {
		return address;
	}
	public String getReceiver() {
		return receiver;
	}
	public String getReceivercell() {
		return receivercell;
	}
	
	
	
}
