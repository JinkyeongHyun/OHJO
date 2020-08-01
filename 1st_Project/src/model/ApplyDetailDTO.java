package model;

public class ApplyDetailDTO {
	
	private int applyno;
	private String model;
	private String applyamount;
	
	public ApplyDetailDTO(int applyno, String model, String applyamount) {
;
		this.applyno = applyno;
		this.model = model;
		this.applyamount = applyamount;
	}

	public int getApplyno() {
		return applyno;
	}

	public String getModel() {
		return model;
	}

	public String getApplyamount() {
		return applyamount;
	}

}
