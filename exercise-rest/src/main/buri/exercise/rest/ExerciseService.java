package buri.exercise.rest;

import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import buri.exercise.dao.IHobbyDao;
import buri.exercise.dao.IPhoneDao;
import buri.exercise.dao.IRoleDao;
import buri.exercise.dao.IUserDao;
import buri.exercise.model.Hobby;
import buri.exercise.model.Phone;
import buri.exercise.model.Role;
import buri.exercise.model.User;

/**
 * Implementation of the REST API interface.
 * 
 * This service uses the {entity}/{verb} style of URIs rather than strict PUT,
 * POST, GET, DELETE HTTP, because the required API method signatures don't
 * always use primary keys.
 * 
 * TODO: Update creation of child collections to be based on DB CASCADEs.
 * 
 * @author bu-exercise
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class ExerciseService implements IExerciseService {

	@EJB
	private IUserDao userDao;
	
	@EJB
	private IHobbyDao hobbyDao;
	
	@EJB
	private IPhoneDao phoneDao;

	@EJB
	private IRoleDao roleDao;
	
	@Override
	@POST
	@Path("user/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addUser(User user) {
		userDao.createOrUpdate(user);
		for (Role role : user.getRoles()) {
			role.setUser(user);
			roleDao.createOrUpdate(role);
		}
		for (Hobby hobby : user.getHobbies()) {
			hobby.setUser(user);
			hobby.setCreatedBy("restApi");
			hobby.setCreatedOn(Calendar.getInstance().getTime());
			hobbyDao.createOrUpdate(hobby);
		}
		for (Phone phone : user.getPhones()) {
			phone.setUser(user);
			phone.setCreatedBy("restApi");
			phone.setCreatedOn(Calendar.getInstance().getTime());
			phoneDao.createOrUpdate(phone);
		}		
	}

	@Override
	@POST
    @Path("phone/delete")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void deletePhone(@FormParam(value = "userId") Long userId, @FormParam(value = "type") String type) {
		User user = userDao.find(userId);
		for (Phone phone : user.getPhones()) {
			if (phone.getType().equals(type)) {
				System.out.println("Deleting phone");
				phoneDao.delete(phone);
			}
		}
	}

	@Override
	@POST
	@Path("phone/update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void updatePhone(@FormParam(value = "userId") Long userId, @FormParam(value = "type") String type, @FormParam(value = "phone") String phone) {
		System.out.println("userId=" + userId);
		User user = userDao.find(userId);
		for (Phone phoneNumber : user.getPhones()) {
			if (phoneNumber.getType().equals(type)) {
				phoneNumber.setNumber(phone);
				phoneDao.createOrUpdate(phoneNumber);
				return;
			}
		}
		// Otherwise, create a new phone number.
		Phone newPhone = new Phone();
		newPhone.setUser(user);
		newPhone.setType(type);
		newPhone.setNumber(phone);
		newPhone.setCreatedBy("restApi");
		newPhone.setCreatedOn(Calendar.getInstance().getTime());
		phoneDao.createOrUpdate(newPhone);
	}

	@Override
	@GET
	@Path("user/{userId}/hobbies")
	public List<Hobby> getHobbies(@PathParam(value = "userId") Long userId) {
		return hobbyDao.findByUserId(userId);
	}

	@Override
	@GET
	@Path("user")
	public List<User> getUsers() {
		List<User> users = userDao.findAll();
		// TODO: Workaround for Hibernate Eager Fetch bug -- because more than 1
		// child collection cannot be eagerly fetched, force the load of the
		// other collections here to ensure that they
		// can be rendered in JSON.
		for (User user : users) {
			user.getHobbies().size();
			user.getRoles().size();
		}
		return users;
	}
}
