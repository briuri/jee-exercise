package buri.exercise.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Unit tests for Role
 * 
 * @author bu-exercise
 */
public class RoleTest {

	@Test
	public void testAccessors() {
		Role role = new Role();

		role.setId(100L);
		assertEquals(Long.valueOf(100L), role.getId());

		role.setUser(new User());
		assertNotNull(role.getUser());

		role.setName("name");
		assertEquals("name", role.getName());
	}
}
