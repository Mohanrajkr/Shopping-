package com.niit.back.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.back.dao.RoleDAO;
import com.niit.back.domain.Role;

@Repository("RoleDAO")
public class RoleDAOImpl implements RoleDAO {
	@Autowired
	private SessionFactory sessionFactory;

	// write user defined constructor with one parameter i.e., sessionFactory

	public RoleDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * This save method create record in the User table. If the record is
	 * created successfully, it will return true else will return false
	 */
	@Transactional
	public boolean save(Role role) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(role);
		} catch (Exception e) {
			// if any excpetion comes during execute of try block, catch will
			// excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public List<Role> list() {

		return sessionFactory.getCurrentSession().createQuery("from Role").list();
	}

	@Transactional
	public Role get(String email) {

		String hql = "from Role where email ='"+ email +"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Role> listRole = (List<Role>) query.list();
		
		if (listRole != null && !listRole.isEmpty()){
			return listRole.get(0);
		}
		return null;

	}

}
