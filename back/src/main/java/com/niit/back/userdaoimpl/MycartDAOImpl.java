package com.niit.back.userdaoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.back.domain.Mycart;
import com.niit.back.userdao.MycartDAO;

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
		Query query=sessionFactory.getCurrentSession().createQuery(" from Mykart where email = ? and password = ?");
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
	

	public void delete(String cartId) {
		Mycart mycartToDelete = new Mycart();
		mycartToDelete.setCartId(cartId);
		sessionFactory.getCurrentSession().delete(mycartToDelete);
			
	}


	public boolean saveOrUpdate(Mycart mycart) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(mycart);
		}catch (Exception e) {
						e.printStackTrace();
			return false;
		}
		return true;
	}


	public List<Mycart> getEmail(String email) {
		String hql = "from Mykart where email ='" + email +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Mycart> list = (List<Mycart>) query.list();
		
		return list;
	}


	public Mycart getByProductName(String productName) {
		String hql = "from Mykart where Productname ='" + productName + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Mycart> listMycart = (List<Mycart>) (query).list();

		if (listMycart != null && !listMycart.isEmpty()) {
			return listMycart.get(0);
		}
		return null;
	}


	public boolean itemAlreadyExist(String email, String productId, boolean b) {
		String hql = "from Mycart where email= '" + email + "' and " + " id ='" + productId+"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Mycart> list = (List<Mycart>) query.list();
		if (list != null && !list.isEmpty()) {
			return true;
		}
		return false;
	}


	public Mycart getByUserandProduct(String email, String productId) {
		String hql = "from Mycart where email= '" + email + "' and " + " productId ='" + productId+"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Mycart> listMycart = (List<Mycart>) query.list();
		
		if (listMycart != null && !listMycart.isEmpty()){
			return listMycart.get(0);
		}
		return null;
	}


	
	

	public Long getTotal(String cartId) {
		// TODO Auto-generated method stub
		return null;
	}


	


	
}
