package com.me.finalproject.dao;

import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.query.Query;

import com.me.finalproject.pojo.Coop;
import com.me.finalproject.pojo.CoopStudent;
import com.me.finalproject.pojo.Student;

public class CoopDAO extends DAO {
	public Coop savecoop(Coop c) throws Exception {
		try {
			begin();
			Coop coop = new Coop();
			coop.setTitle(c.getTitle());
			coop.setDescription(c.getDescription());
			coop.setPostedby(c.getPostedby());
			getSession().save(coop);
			commit();
			return coop;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating Coop: " + e.getMessage());
		}
	}

	public List<Coop> get(int userId) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Coop where postedby_uid= :uid");
			q.setInteger("uid", userId);
			List<Coop> coops = q.list();
			System.out.println(coops.size());
			commit();
			return coops;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get coops " + userId, e);
		}
	}

	public Coop getByCoopId(String cid) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Coop where cid= :cid");
			q.setString("cid", cid);
			Coop coop = (Coop) q.uniqueResult();
			commit();
			return coop;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get coops " + cid, e);
		}
	}

	public CoopStudent updateCoopStudent(String csid, String status) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from CoopStudent where id = :id");
			q.setString("id", csid);
			CoopStudent cs = (CoopStudent) q.uniqueResult();
			cs.setStatus(status);
			getSession().update(cs);
			commit();
			return cs;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not update coops:" + e.getMessage());
		}
	}
	
	public List<Coop> searchTitle(String title) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Coop where title like :title");
			q.setString("title", "%" + title + "%");
			List<Coop> coops = q.list();			
			commit();
			return coops;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not search coops by title:" + e);
		}
	}

	public List<Coop> searchEmp(String orgname) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Coop as c  where c.postedby.orgname like :orgname ");
			q.setString("orgname", "%" + orgname + "%");
			List<Coop> coops = q.list();
			commit();
			System.out.println(coops.size());
			return coops;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not search coops by Employer:" + e);
		}
	}

}
