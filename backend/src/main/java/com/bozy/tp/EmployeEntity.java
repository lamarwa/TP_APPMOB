package com.bozy.tp;

public class EmployeEntity {

	
	

	private int id;
	private String firstname ;
	private String lastname;
	
	
	

	public EmployeEntity(int id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}



	public EmployeEntity(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	
	
	public int  getId() {
		return id;
	}
	public String getFarstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", title=" + firstname + ", auther=" + lastname + "]";
	}
}
