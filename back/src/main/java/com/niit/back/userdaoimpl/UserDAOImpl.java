package com.niit.back.userdaoimpl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.back.domain.User;
import com.niit.back.userdao.UserDAO;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//write user defined constructor with one parameter i.e., sessionFactory
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean save(User user) {
		try
		{
		sessionFactory.getCurrentSession().save(user);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	@Transactional
	public boolean validate(String email, String password) {

			String hql = "from User where mail= '" + email + "' and " + " password ='" + password+"'";
			org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<User> list = (List<User>) query.list();
			if (list != null && !list.isEmpty()) {
				return true;
			}
			return false;
	}
	@Transactional
public List<User> list() {
		
		
		return  sessionFactory.getCurrentSession().createQuery("from User").list();
	}
	@Transactional
	public User get(String email) {
		
		//get method get the date from user table based on primary key i.e., id
		// and set it to User class
		//like select * from user where id = ?
	  return 	(User)  sessionFactory.getCurrentSession().get(User.class, email);
		
	}

	public boolean Validate(String email, String password) {
		String hql = "from User where email= '" + email + "' and " + " password ='" + password+"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		if (list != null && !list.isEmpty()) {
			return true;
		}
		return false;
	
	}
}
