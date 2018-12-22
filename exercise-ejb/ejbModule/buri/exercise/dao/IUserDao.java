package buri.exercise.dao;

import java.util.List;

import javax.ejb.Local;

import buri.exercise.model.User;

/**
 * Bean interface for an EJB that performs CRUD on User JPA entities.
 * 
 * @author bu-exercise
 */
@Local
public interface IUserDao {

	/**
	 * Create or update a user entity, based on the existence of an id. Creation
	 * sets a new id on the entity.
	 * 
	 * @param user
	 *            the saved user
	 * @return the saved user
	 */
	public User createOrUpdate(User user);

	/**
	 * Delete a user entity. Does nothing if the entity does not exist in the
	 * database.
	 * 
	 * @param user
	 *            the user to delete
	 */
	public void delete(User user);

	/**
	 * Locate a single entity matching the ID value.
	 * 
	 * @param id
	 *            the id of the user
	 * @return the found user, or null if not found
	 */
	public User find(Long id);

	/**
	 * Locate all entities.
	 * 
	 * @return a list of users (may be empty)
	 */
	public List<User> findAll();
}
