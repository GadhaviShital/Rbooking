package edu.unh.rbooking.constant;

public enum RestConstantEnum {
	HTTP_OK("OK"),
	HTTP_ERROR("ERROR");
	
	private String name;
	public String getName() {
		return name;
	}
	
	private RestConstantEnum(String name) {
		this.name = name;
	}
}
