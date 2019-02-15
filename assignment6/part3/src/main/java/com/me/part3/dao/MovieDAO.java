package com.me.part3.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.part3.pojo.Movie;

public class MovieDAO extends DAO {
	public Movie create(Movie movie) throws Exception {
		try {
			begin();
			getSession().save(movie);
			commit();
			return movie;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create movie", e);
			throw new Exception("Exception while creating movie: " + e.getMessage());
		}
	}

	public List<Movie> search(String keyword, String searchby) throws Exception {
		try {
			begin();
			String hql = "from Movie where ";
			if (searchby.equals("title") || searchby.equals("actor") || searchby.equals("actress"))
				hql += searchby + " like :keyword ";
			else return null;
			Query q = getSession().createQuery(hql);
			q.setString("keyword", "%"+keyword+"%");
			List<Movie> movies = q.list();
			System.out.println(keyword+" "+searchby+" "+movies.size());
			q.getQueryString();
			commit();
			return movies;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not search movie", e);
			throw new Exception("Exception while searching movie: " + e.getMessage());
		}
	}

}
