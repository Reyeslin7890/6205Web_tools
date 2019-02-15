package com.me.finalproject.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;


@Entity
@Table(name = "coop_table")
public class Coop{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid", unique = true, nullable = false)
	private int cid;
	private String title;
	private String description;

	@ManyToOne(cascade = CascadeType.ALL)
	private Employer postedby;

	@OneToMany(mappedBy = "coop")
	@JsonBackReference
	
	private Set<CoopStudent> coopstudents;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employer getPostedby() {
		return postedby;
	}

	public void setPostedby(Employer postedby) {
		this.postedby = postedby;
	}

	public Set<CoopStudent> getCoopstudents() {
		return coopstudents;
	}

	public void setCoopstudents(Set<CoopStudent> coopstudents) {
		this.coopstudents = coopstudents;
	}



}
