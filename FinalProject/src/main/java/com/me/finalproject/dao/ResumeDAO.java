package com.me.finalproject.dao;

import org.hibernate.HibernateException;

import com.me.finalproject.pojo.Coop;
import com.me.finalproject.pojo.Resume;
import com.me.finalproject.pojo.Student;

public class ResumeDAO extends DAO {
	public Resume saveResume(Resume r, int uid) throws Exception {
		try {
			begin();
			Resume resume = new Resume();
			resume.setResume(r.getResume());
			resume.setFilename(r.getFilename());
			getSession().save(resume);
			Student student = getSession().get(Student.class, uid);
			student.setResume(resume);
			getSession().update(student);
			commit();
			return resume;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception with saving resume: " + e.getMessage());
		}
	}
}
