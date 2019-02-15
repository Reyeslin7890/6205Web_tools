package com.me.finalproject.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@Table(name = "student_table")
@PrimaryKeyJoinColumn(name = "uid")
public class Student extends User {

	@OneToOne(cascade = CascadeType.ALL)
	private Resume resume;

	@OneToMany(mappedBy = "student")
	@JsonBackReference
	private Set<CoopStudent> coopstudent;

	public Student() {
	}

	public Student(String _username, String _password) {
		super(_username, _password);
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Set<CoopStudent> getCoopstudent() {
		return coopstudent;
	}

	public void setCoopstudent(Set<CoopStudent> coopstudent) {
		this.coopstudent = coopstudent;
	}

}
