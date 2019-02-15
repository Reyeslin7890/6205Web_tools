package com.me.finalproject.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.me.finalproject.pojo.Coop;
import com.me.finalproject.pojo.CoopStudent;
import com.me.finalproject.pojo.Student;
import com.me.finalproject.pojo.User;

public class StudentDAO extends DAO {
	public User get(String username) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from User where username = :username");
			q.setString("username", username);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get employer " + username, e);
		}
	}

	public Student get(String username, String password) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Student where username = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);
			Student student = (Student) q.uniqueResult();
			commit();
			return student;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get student " + username, e);
		}
	}

	public Student get(int userId) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Student where uid= :uid");
			q.setInteger("uid", userId);
			Student student = (Student) q.uniqueResult();
			commit();
			return student;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get student " + userId, e);
		}
	}

	public Student register(Student s) throws Exception {
		try {
			begin();
			Student student = new Student(s.getUsername(), s.getPassword());
			student.setFirstname(s.getFirstname());
			student.setLastname(s.getLastname());
			student.setEmail(s.getEmail());
			getSession().save(student);
			commit();
			return student;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating student: " + e.getMessage());
		}
	}

	public void delete(Student student) throws Exception {
		try {
			begin();
			getSession().delete(student);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not delete student " + student.getUsername(), e);
		}
	}

	public CoopStudent updateStudent(String cid, Student s) throws Exception {
		try {
			begin();

			Query q1 = getSession().createQuery("from Coop where cid= :cid");
			q1.setString("cid", cid);
			Coop coop = (Coop) q1.uniqueResult();

			Query q2 = getSession().createQuery("from Student where uid= :uid");
			q2.setInteger("uid", s.getUid());
			Student student = (Student) q2.uniqueResult();

			CoopStudent cs = new CoopStudent();
			cs.setCoop(coop);
			cs.setStudent(student);
			cs.setStatus("Undecided");

			Set<CoopStudent> css = student.getCoopstudent();
			for (CoopStudent c : css)
				if (c.getCoop().getCid() == cs.getCoop().getCid())
					return null;
			css.add(cs);
			coop.getCoopstudents().add(cs);
			getSession().save(cs);			
			commit();
			return cs;
		} catch (HibernateException e) {
			rollback();
			System.out.println(e.getMessage());
			throw new Exception("Could not update Student:" + e.getMessage());
		}
	}
}
