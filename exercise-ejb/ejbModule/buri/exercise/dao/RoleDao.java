package buri.exercise.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import buri.exercise.model.Role;

/**
 * Session Bean implementation class for Roles
 */
@Stateless
@LocalBean
public class RoleDao implements IRoleDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Role createOrUpdate(Role role) {
		if (role.getId() == null) {
			em.persist(role);
		} else {
			em.merge(role);
		}
		em.flush();
		return role;
	}

	@Override
	public void delete(Role role) {
		em.remove(role);
		em.flush();
	}

	@Override
	public Role find(Long id) {
		return em.find(Role.class, id);
	}

	@Override
	public List<Role> findByUserId(Long userId) {
		TypedQuery<Role> query = em.createNamedQuery("Role.findByUserId", Role.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}

	@Override
	public List<Role> findAll() {
		TypedQuery<Role> query = em.createNamedQuery("Role.findAll", Role.class);
		return query.getResultList();
	}
}