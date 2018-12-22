package buri.exercise.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import org.junit.Test;

/**
 * Unit tests for Phone
 * 
 * @author bu-exercise
 */
public class PhoneTest {

	@Test
	public void testAccessors() {
		Phone phone = new Phone();

		phone.setId(100L);
		assertEquals(Long.valueOf(100L), phone.getId());

		phone.setUser(new User());
		assertNotNull(phone.getUser());

		phone.setType("OFFICE");
		assertEquals("OFFICE", phone.getType());

		phone.setNumber("7038851000");
		assertEquals("7038851000", phone.getNumber());

		phone.setCreatedBy("me");
		assertEquals("me", phone.getCreatedBy());

		phone.setCreatedOn(Calendar.getInstance().getTime());
		assertNotNull(phone.getCreatedOn());
	}
}
