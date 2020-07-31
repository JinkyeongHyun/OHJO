package model;

public class ApplyDTO {
	private String applydate;	// 신청일자
	private String applyno;	// 신청번호
	private String bank;	// 은행
	private String bankaccount;	// 계좌번호
	private String applyamount; // 신청수량
	private String doc; // 위임장 사본  경로
	private String idcard; // 신분증 사본 경로
	private String id; // 아이디
	
	public ApplyDTO(String applydate, String applyno, String bank, String bankaccount, String applyamount, String doc,
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

	public String getApplyno() {
		return applyno;
	}

	public String getBank() {
		return bank;
	}

	public String getBankaccount() {
		return bankaccount;
	}

	public String getApplyamount() {
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
