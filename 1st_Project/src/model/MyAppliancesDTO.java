package model;

public class MyAppliancesDTO {
	private String id;
	private String model;
	private String nickname;
	private String category;
	
	public MyAppliancesDTO(String id, String model, String nickname, String category) {
		this.id = id;
		this.model = model;
		this.nickname = nickname;
		this.category = category;
	}
	
	public String getId() {
		return id;
	}
	public String getModel() {
		return model;
	}
	public String getNickname() {
		return nickname;
	}
	public String getCategory() {
		return category;
	}
}