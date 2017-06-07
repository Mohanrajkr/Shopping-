package com.niit.back.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.back.dao.ShippingaddressDAO;
import com.niit.back.domain.Shippingaddress;

@Transactional
@Repository("ShippingaddressDAO")
public class ShippingaddressDAOImpl implements ShippingaddressDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	public ShippingaddressDAOImpl (SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	
	public List<Shippingaddress> list() {
		@SuppressWarnings("unchecked")
		List<Shippingaddress> listShippingaddress = (List<Shippingaddress>) sessionFactory.getCurrentSession().createCriteria(Shippingaddress.class)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return listShippingaddress;  
		}


	public List<Shippingaddress> list(String email) {
		String hql = "from Shippingaddress where email='" + email + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Shippingaddress> list = (List<Shippingaddress>) query.list();
		
		return list;
	}
	public Shippingaddress getByShippingAddress(String address) {
		String hql = "from Shippingaddress where address ='" + address + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Shippingaddress> listShippingaddress = (List<Shippingaddress>) (query).list();

		if (listShippingaddress != null && !listShippingaddress.isEmpty()) {
			return listShippingaddress.get(0);
		}
		return null;
	}
	public Shippingaddress getByUserName(String userName) {
		String hql = "from Shippingaddress where userName='" + userName + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Shippingaddress> listShippingaddress = (List<Shippingaddress>) (query).list();

		if (listShippingaddress != null && !listShippingaddress.isEmpty()) {
			return listShippingaddress.get(0);
		}
		return null;
	}
	public void saveOrUpdate(Shippingaddress address) {
		sessionFactory.getCurrentSession().saveOrUpdate(address);
		
	}
	public void delete(int shippingId) {
		Shippingaddress shippingaddressToDelete = new Shippingaddress();
		shippingaddressToDelete.setShippingId(shippingId);
		sessionFactory.getCurrentSession().delete(shippingaddressToDelete);

		
	}
	public Shippingaddress getByShippingId(int shippingId) {
		String hql = "from Shippingaddress where shippingId='" + shippingId + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Shippingaddress> listShippingaddress = (List<Shippingaddress>) (query).list();

		if (listShippingaddress != null && !listShippingaddress.isEmpty()) {
			return listShippingaddress.get(0);
		}
		return null;	
	}
}
