package edu.unh.rbooking.menu;
// default package
// Generated Dec 3, 2016 3:39:47 PM by Hibernate Tools 5.2.0.Beta1

/**
 * Menu generated by hbm2java
 */
public class MenuDO implements java.io.Serializable {

	private Integer id;
	private String description;
	private String name;
	private Byte price;

	public MenuDO() {
	}

	public MenuDO(String description, String name, Byte price) {
		this.description = description;
		this.name = name;
		this.price = price;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte getPrice() {
		return this.price;
	}

	public void setPrice(Byte price) {
		this.price = price;
	}

}
