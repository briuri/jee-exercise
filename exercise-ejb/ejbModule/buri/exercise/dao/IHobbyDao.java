package buri.exercise.dao;

import java.util.List;

import javax.ejb.Local;

import buri.exercise.model.Hobby;

/**
 * Bean interface for an EJB that performs CRUD on Hobby JPA entities.
 * 
 * @author bu-exercise
 */
@Local
public interface IHobbyDao {

	/**
	 * Create or update a hobby entity, based on the existence of an id.
	 * Creation sets a new id on the entity.
	 * 
	 * @param hobby
	 *            the saved hobby
	 * @return the saved hobby
	 */
	public Hobby createOrUpdate(Hobby hobby);

	/**
	 * Delete a hobby entity. Does nothing if the entity does not exist in the
	 * database.
	 * 
	 * @param hobby
	 *            the hobby to delete
	 */
	public void delete(Hobby hobby);

	/**
	 * Locate a single entity matching the ID value.
	 * 
	 * @param id
	 *            the id of the role
	 * @return the found hobby, or null if not found
	 */
	public Hobby find(Long id);

	/**
	 * Locate a list of entities associated with a specific user.
	 * 
	 * @param userId
	 *            the id of the owner
	 * @return a list of hobbies (may be empty)
	 */
	public List<Hobby> findByUserId(Long userId);

	/**
	 * Locate all entities.
	 * 
	 * @return a list of hobbies (may be empty)
	 */
	public List<Hobby> findAll();
}
