package com.me.finalproject.pojo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="employer_table")
@PrimaryKeyJoinColumn(name = "uid")
public class Employer extends User{

	private String orgname;
	
	public Employer() {}
	public Employer(String _username, String _password) {
		super(_username, _password);
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	
	
}
