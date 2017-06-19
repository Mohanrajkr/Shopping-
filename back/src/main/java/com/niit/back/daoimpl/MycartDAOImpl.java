package com.niit.back.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.back.dao.MycartDAO;
import com.niit.back.domain.Mycart;


@Repository("MycartDAO")
@Transactional

public class MycartDAOImpl implements MycartDAO{
	@Autowired
	private SessionFactory sessionFactory;
	public MycartDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	
	

	@SuppressWarnings("unchecked")
	public List<Mycart> list() {
		return  sessionFactory.getCurrentSession().createQuery("from Mycart").list();

	}

	public boolean validate(String email, String password) {
		Query query=sessionFactory.getCurrentSession().createQuery(" from Mycart where email = ? and password = ?");
		query.setString(1, email);     
		query.setString(2, password);
		 if(  query.uniqueResult()  == null)
		 {
			 
			 return false;
		 }
		 else
		 {
			 
			 return true;
		 }
		
		}
	

	public void delete(int cartId) {
		Mycart mycartToDelete = new Mycart();
		mycartToDelete.setCartId(cartId);
		sessionFactory.getCurrentSession().delete(mycartToDelete);
			
	}


	public boolean save(Mycart mycart) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(mycart);
		}catch (Exception e) {
						e.printStackTrace();
			return false;
		}
		return true;
	}


	@Transactional
	public boolean update(Mycart mycart) {
		try {
			sessionFactory.getCurrentSession().update(mycart);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public List<Mycart> getEmail(String email) {
		String hql = "from Mycart where email ='" + email +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Mycart> list = (List<Mycart>) query.list();
		
		return list;
	}


	public Mycart getByProductName(String productName) {
		String hql = "from Mycart where Productname ='" + productName + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Mycart> listMycart = (List<Mycart>) (query).list();

		if (listMycart != null && !listMycart.isEmpty()) {
			return listMycart.get(0);
		}
		return null;
	}


	public boolean itemAlreadyExist(String email, int productId) {
		String hql = "from Mycart where email= '" + email + "' and " + " productId ='" + productId+"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Mycart> list = (List<Mycart>) query.list();
		if (list != null && !list.isEmpty()) {
			return true;
		}
		return false;
	}


	public Mycart getByUserandProduct(String email, int productId) {
		String hql = "from Mycart where email= '" + email + "' and " + " productId ='" + productId+"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Mycart> listMycart = (List<Mycart>) query.list();
		
		if (listMycart != null && !listMycart.isEmpty()){
			return listMycart.get(0);
		}
		return null;
	}

	
	@Transactional
	public Mycart get(int cartId) {
		
		//get method get the date from user table based on primary key i.e., id
		// and set it to User class
		//like select * from user where id = ?
	  return 	(Mycart)  sessionFactory.getCurrentSession().get(Mycart.class, cartId);
		
	}

	
	

	public Long getTotal(String email) {
		
		String hql = "select sum(total) from Mycart where email = " + "'" + email + "'" + "and status = '" + "N" +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Long sum = (Long) query.uniqueResult();
			return sum;
	}


	@Transactional
	public void updateshipping(String email, int shippingId) {
		String hql = " update Mycart set shippingId = '" + shippingId + "' where email = '" + email + "'";
		sessionFactory.getCurrentSession().createQuery(hql);
	
	}

	@Transactional
	public Integer getQuantity(int userId, String productName) {
		String hql = "select quantity from  Mycart where userId = ?  and  productName =?";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, userId);
		query.setString(1, productName);

		return (Integer) query.uniqueResult();
	}
	
}
