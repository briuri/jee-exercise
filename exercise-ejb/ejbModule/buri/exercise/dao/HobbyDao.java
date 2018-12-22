package buri.exercise.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import buri.exercise.model.Hobby;

/**
 * Session Bean implementation class for Hobbies
 */
@Stateless
@LocalBean
public class HobbyDao implements IHobbyDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Hobby createOrUpdate(Hobby hobby) {
		if (hobby.getId() == null) {
			em.persist(hobby);
		} else {
			em.merge(hobby);
		}
		em.flush();
		return hobby;
	}

	@Override
	public void delete(Hobby hobby) {
		em.remove(hobby);
		em.flush();
	}

	@Override
	public Hobby find(Long id) {
		return em.find(Hobby.class, id);
	}

	@Override
	public List<Hobby> findByUserId(Long userId) {
		TypedQuery<Hobby> query = em.createNamedQuery("Hobby.findByUserId", Hobby.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}

	@Override
	public List<Hobby> findAll() {
		TypedQuery<Hobby> query = em.createNamedQuery("Hobby.findAll", Hobby.class);
		return query.getResultList();
	}
}