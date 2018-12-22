package buri.exercise.rest;

import java.util.List;

import buri.exercise.model.Hobby;
import buri.exercise.model.User;

/**
 * REST API interface for exercise
 * 
 * @author bu-exercise
 */
public interface IExerciseService {

	/**
	 * Add a new user to the database.
	 * 
	 * @param user the new user record (without existing id)
	 */
	public void addUser(User user);
	
	/**
	 * Deletes a single phone number from the database. Does nothing if that
	 * type of phone number doesn't exist.
	 * 
	 * @param userId
	 *            the owner of the phone number
	 * @param type
	 *            which phone number to delete (e.g. OFFICE, HOME, MOBILE)
	 */
	public void deletePhone(Long userId, String type);
	
	/**
	 * Updates a phone number in the database, or adds it, if user doesn't
	 * already have one of that type.
	 * 
	 * @param userId
	 *            the owner of the phone number
	 * @param type
	 *            the type of phone number
	 * @param phone
	 *            the number itself
	 */
	public void updatePhone(Long userId, String type, String phone);
	
	/**
	 * Returns a list of hobbies for a given user.
	 * 
	 * @param userId the owner of the hobbies
	 * @return a list of hobbies (may be empty)
	 */
	public List<Hobby> getHobbies(Long userId);
	
	/**
	 * Returns a list of all users from the database
	 * 
	 * @return a list of users (may be empty)
	 */
	public List<User> getUsers();
	
}