package edu.unh.rbooking.employee;
// default package
// Generated Dec 3, 2016 3:39:47 PM by Hibernate Tools 5.2.0.Beta1

import java.util.ArrayList;
import java.util.List;

import edu.unh.rbooking.credential.CredentialDO;
import edu.unh.rbooking.table.TableDO;

/**
 * Employee generated by hbm2java
 */
public class EmployeeDO implements java.io.Serializable {

	private Integer id;
	private String firstName;
	private String type;
	private String lastName;
	private String phoneNumber;
	private String email;
	
	private List<CredentialDO> credentials = new ArrayList<CredentialDO>(0);
	private List<TableDO> tables = new ArrayList<TableDO>(0);

	public EmployeeDO() {
	}

	public EmployeeDO(String firstName, String employeeType, String lastName, String phoneNumber, String email,
			List<CredentialDO> credentials, List<TableDO> tables) {
		this.firstName = firstName;
		this.type = employeeType;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.credentials = credentials;
		this.tables = tables;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public List<CredentialDO> getCredentials() {
		return this.credentials;
	}

	public void setCredentials(List<CredentialDO> credentials) {
		this.credentials = credentials;
	}

	public List<TableDO> getTables() {
		return this.tables;
	}

	public void setTables(List<TableDO> tables) {
		this.tables = tables;
	}

}
