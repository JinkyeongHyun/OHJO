package model;

public class ApplyDTO {
	private String applydate;	// ��û����
	private int applyno;	// ��û��ȣ
	private String bank;	// ����
	private String bankaccount;	// ���¹�ȣ
	private int applyamount; // ��û����
	private String doc; // ������ �纻  ���
	private String idcard; // �ź��� �纻 ���
	private String id; // ���̵�
	
	public ApplyDTO(String applydate, int applyno, String bank, String bankaccount, int applyamount, String doc,
			String idcard, String id) {
		
		this.applydate = applydate;
		this.applyno = applyno;
		this.bank = bank;
		this.bankaccount = bankaccount;
		this.applyamount = applyamount;
		this.doc = doc;
		this.idcard = idcard;
		this.id = id;
	}

	public String getApplydate() {
		return applydate;
	}

	public int getApplyno() {
		return applyno;
	}

	public String getBank() {
		return bank;
	}

	public String getBankaccount() {
		return bankaccount;
	}

	public int getApplyamount() {
		return applyamount;
	}

	public String getDoc() {
		return doc;
	}

	public String getIdcard() {
		return idcard;
	}

	public String getId() {
		return id;
	}

	
	
	public void BankInfoDTO (String bank, String bankaccount) {
		
		this.bank = bank;
		this.bankaccount = bankaccount;
	}

	public void setBank() {
		this.bank = bank;
	}

	public void setBankaccount() {
		this.bankaccount = bankaccount;
	}
	
	
	
	
		
}
