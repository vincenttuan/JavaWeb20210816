package com.lab.user.dao;

import java.util.Date;

public class User {
	private Integer u_id;
	private String u_username;
	private String u_password;
	private Integer u_priority;
	private Date u_createtime;
	
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public String getU_username() {
		return u_username;
	}
	public void setU_username(String u_username) {
		this.u_username = u_username;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public Integer getU_priority() {
		return u_priority;
	}
	public void setU_priority(Integer u_priority) {
		this.u_priority = u_priority;
	}
	public Date getU_createtime() {
		return u_createtime;
	}
	public void setU_createtime(Date u_createtime) {
		this.u_createtime = u_createtime;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_username=" + u_username + ", u_password=" + u_password + ", u_priority="
				+ u_priority + ", u_createtime=" + u_createtime + "]";
	}
	
}
