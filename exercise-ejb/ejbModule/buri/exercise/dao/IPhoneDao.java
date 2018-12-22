package buri.exercise.dao;

import java.util.List;

import javax.ejb.Local;

import buri.exercise.model.Phone;

/**
 * Bean interface for an EJB that performs CRUD on Phone JPA entities.
 * 
 * @author bu-exercise
 */
@Local
public interface IPhoneDao {

	/**
	 * Create or update a phone entity, based on the existence of an id.
	 * Creation sets a new id on the entity.
	 * 
	 * @param phone
	 *            the saved phone
	 * @return the saved phone
	 */
	public Phone createOrUpdate(Phone phone);

	/**
	 * Delete a phone entity. Does nothing if the entity does not exist in the
	 * database.
	 * 
	 * @param phone
	 *            the phone to delete
	 */
	public void delete(Phone phone);

	/**
	 * Locate a single entity matching the ID value.
	 * 
	 * @param id
	 *            the id of the role
	 * @return the found phone, or null if not found
	 */
	public Phone find(Long id);

	/**
	 * Locate a list of entities associated with a specific user.
	 * 
	 * @param userId
	 *            the id of the owner
	 * @return a list of phones (may be empty)
	 */
	public List<Phone> findByUserId(Long userId);

	/**
	 * Locate all entities.
	 * 
	 * @return a list of phones (may be empty)
	 */
	public List<Phone> findAll();
}
