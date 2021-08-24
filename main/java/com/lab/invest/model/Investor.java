package com.lab.invest.model;

import java.util.Date;

public class Investor {
	private Integer id;
	private String username;
	private String email;
	private Date tdate;
	
	public Investor() {
		
	}
	
	public Investor(Integer id, String username, String email, Date tdate) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.tdate = tdate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

	@Override
	public String toString() {
		return "Investor [id=" + id + ", username=" + username + ", email=" + email + ", tdate=" + tdate + "]";
	}
	
	
	
}
