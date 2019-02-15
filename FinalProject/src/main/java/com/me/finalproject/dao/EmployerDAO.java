package com.me.finalproject.dao;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.me.finalproject.pojo.Employer;
import com.me.finalproject.pojo.User;

public class EmployerDAO extends DAO {
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
	public Employer get(String username, String password) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Employer where username = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);
			Employer emp = (Employer) q.uniqueResult();
			commit();
			return emp;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get employer " + username, e);
		}
	}

	public Employer get(int userId) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Employer where uid= :uid");
			q.setInteger("uid", userId);
			Employer emp = (Employer) q.uniqueResult();
			commit();
			return emp;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get employer " + userId, e);
		}
	}

	public Employer register(Employer emp) throws Exception {
		try {
			begin();
			Employer employer = new Employer(emp.getUsername(), emp.getPassword());
			employer.setFirstname(emp.getFirstname());
			employer.setLastname(emp.getLastname());
			employer.setEmail(emp.getEmail());
			employer.setOrgname(emp.getOrgname());
			getSession().save(employer);
			commit();
			return employer;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating employer: " + e.getMessage());
		}
	}

	public void delete(Employer employer) throws Exception {
		try {
			begin();
			getSession().delete(employer);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not delete employer " + employer.getUsername(), e);
		}
	}
}
