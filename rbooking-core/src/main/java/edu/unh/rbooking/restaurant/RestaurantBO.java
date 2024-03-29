package edu.unh.rbooking.restaurant;
// default package
// Generated Dec 3, 2016 3:39:47 PM by Hibernate Tools 5.2.0.Beta1

/**
 * Restaurant generated by hbm2java
 */
public class RestaurantBO implements java.io.Serializable {

	private Integer id;
	private String name;
	private String address;
	private String city;
	private String country;
	private String zipcode;
	private String phoneNumber;
	private String email;
	private String state;

	public RestaurantBO() {
	}

	public RestaurantBO(String name, String address, String city, String country, String zipcode, String phoneNumber,
			String email, String state) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.state = state;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
