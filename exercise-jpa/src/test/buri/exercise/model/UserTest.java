package buri.exercise.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit tests for User
 * 
 * @author bu-exercise
 */
public class UserTest {

	@Test
	public void testAccessors() {
		User user = new User();

		user.setId(100L);
		assertEquals(Long.valueOf(100L), user.getId());

		user.setEmail("a@exercise.com");
		assertEquals("a@exercise.com", user.getEmail());

		user.setUsername("a");
		assertEquals("a", user.getUsername());

		user.setPassword("!@12");
		assertEquals("!@12", user.getPassword());
	}

	@Test
	public void testRoleAccessors() {
		User user = new User();
		Role role = new Role();

		assertEquals(0, user.getRoles().size());
		user.addRole(role);
		assertEquals(1, user.getRoles().size());
		user.removeRole(role);
		assertEquals(0, user.getRoles().size());
	}

	@Test
	public void testHobbyAccessors() {
		User user = new User();
		Hobby hobby = new Hobby();

		assertEquals(0, user.getHobbies().size());
		user.addHobby(hobby);
		assertEquals(1, user.getHobbies().size());
		user.removeHobby(hobby);
		assertEquals(0, user.getHobbies().size());
	}

	@Test
	public void testPhoneAccessors() {
		User user = new User();
		Phone phone = new Phone();

		assertEquals(0, user.getPhones().size());
		user.addPhone(phone);
		assertEquals(1, user.getPhones().size());
		user.removePhone(phone);
		assertEquals(0, user.getPhones().size());
	}
}
