package com.me.finalproject.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;


@Entity
@Table(name = "coop_student")
public class CoopStudent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cs_id")	
	private int id;

	@ManyToOne
	@JoinColumn(name = "cid")
	@JsonManagedReference	
	private Coop coop;

	@ManyToOne
	@JoinColumn(name = "uid")
	@JsonManagedReference
	private Student student;

	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Coop getCoop() {
		return coop;
	}

	public void setCoop(Coop coop) {
		this.coop = coop;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
