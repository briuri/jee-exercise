package buri.exercise.dao;

import java.util.List;

import javax.ejb.Local;

import buri.exercise.model.Role;

/**
 * Bean interface for an EJB that performs CRUD on Role JPA entities.
 * 
 * @author bu-exercise
 */
@Local
public interface IRoleDao {

	/**
	 * Create or update a role entity, based on the existence of an id. Creation
	 * sets a new id on the entity.
	 * 
	 * @param role
	 *            the saved role
	 * @return the saved role
	 */
	public Role createOrUpdate(Role role);

	/**
	 * Delete a role entity. Does nothing if the entity does not exist in the
	 * database.
	 * 
	 * @param role
	 *            the role to delete
	 */
	public void delete(Role role);

	/**
	 * Locate a single entity matching the ID value.
	 * 
	 * @param id
	 *            the id of the role
	 * @return the found role, or null if not found
	 */
	public Role find(Long id);

	/**
	 * Locate a list of entities associated with a specific user.
	 * 
	 * @param userId
	 *            the id of the owner
	 * @return a list of roles (may be empty)
	 */
	public List<Role> findByUserId(Long userId);

	/**
	 * Locate all entities.
	 * 
	 * @return a list of roles (may be empty)
	 */
	public List<Role> findAll();
}
