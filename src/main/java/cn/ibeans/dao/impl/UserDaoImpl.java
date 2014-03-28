package cn.ibeans.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import cn.ibeans.dao.UserDao;
import cn.ibeans.web.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public User findByName(String name) {
		return null;
	}

	@Override
	public User findByLoginName(String loginName) {
		return null;
	}

	@Override
	public void saveOrUpdate(User user) {
		em.persist(user);
	}

	@Override
	public User findById(int id) {
		return em.find(User.class, id);
	}

}
