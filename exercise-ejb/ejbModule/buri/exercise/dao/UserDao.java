package buri.exercise.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import buri.exercise.model.User;

/**
 * Session Bean implementation class for Users
 */
@Stateless
@LocalBean
public class UserDao implements IUserDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public User createOrUpdate(User user) {
		if (user.getId() == null) {
			em.persist(user);
		} else {
			em.merge(user);
		}
		em.flush();
		return user;
	}

	@Override
	public void delete(User user) {
		em.remove(user);
		em.flush();
	}

	@Override
	public User find(Long id) {
		return em.find(User.class, id);
	}

	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}
}