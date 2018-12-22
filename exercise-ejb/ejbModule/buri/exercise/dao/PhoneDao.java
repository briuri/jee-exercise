package buri.exercise.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import buri.exercise.model.Phone;

/**
 * Session Bean implementation class for Phones
 */
@Stateless
@LocalBean
public class PhoneDao implements IPhoneDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Phone createOrUpdate(Phone phone) {
		if (phone.getId() == null) {
			em.persist(phone);
		} else {
			em.merge(phone);
		}
		em.flush();
		return phone;
	}

	@Override
	public void delete(Phone phone) {
		System.out.println("Deleting " + phone.getId() + "!");
		em.remove(phone);
		em.flush();
	}

	@Override
	public Phone find(Long id) {
		return em.find(Phone.class, id);
	}

	@Override
	public List<Phone> findByUserId(Long userId) {
		TypedQuery<Phone> query = em.createNamedQuery("Phone.findByUserId", Phone.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}

	@Override
	public List<Phone> findAll() {
		TypedQuery<Phone> query = em.createNamedQuery("Phone.findAll", Phone.class);
		return query.getResultList();
	}
}