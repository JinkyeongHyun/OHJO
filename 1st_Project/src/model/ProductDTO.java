package model;

public class ProductDTO {
	private String p_model;		//��ǰ�𵨸�
	private String p_name;		//��ǰ�̸�
	private String p_category;	//��ǰī�װ�
	private String p_class;		//��ǰ���
	private String p_maxEv;		//��ǰ�ִ�Һ�����
	private String p_eCost;		//��ǰ�������������
	private String p_price;		//��ǰ�ݾ�
	private String p_img;		//��ǰ�̹������ϰ��
	
	public ProductDTO(String p_model, String p_name, String p_category, String p_class, String p_maxEv, String p_eCost,
			String p_price, String p_img) {
		this.p_model = p_model;
		this.p_name = p_name;
		this.p_category = p_category;
		this.p_class = p_class;
		this.p_maxEv = p_maxEv;
		this.p_eCost = p_eCost;
		this.p_price = p_price;
		this.p_img = p_img;
	}

	public String getP_model() {
		return p_model;
	}

	public String getP_name() {
		return p_name;
	}

	public String getP_category() {
		return p_category;
	}

	public String getP_class() {
		return p_class;
	}

	public String getP_maxEv() {
		return p_maxEv;
	}

	public String getP_eCost() {
		return p_eCost;
	}

	public String getP_price() {
		return p_price;
	}

	public String getP_img() {
		return p_img;
	}	
}
