package buri.exercise.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import org.junit.Test;

/**
 * Unit tests for Hobby
 * 
 * @author bu-exercise
 */
public class HobbyTest {

	@Test
	public void testAccessors() {
		Hobby hobby = new Hobby();

		hobby.setId(100L);
		assertEquals(Long.valueOf(100L), hobby.getId());

		hobby.setUser(new User());
		assertNotNull(hobby.getUser());

		hobby.setHobby("Coding");
		assertEquals("Coding", hobby.getHobby());

		hobby.setCreatedBy("me");
		assertEquals("me", hobby.getCreatedBy());

		hobby.setCreatedOn(Calendar.getInstance().getTime());
		assertNotNull(hobby.getCreatedOn());
	}
}
