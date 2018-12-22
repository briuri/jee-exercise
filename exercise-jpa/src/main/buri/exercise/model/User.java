package buri.exercise.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * The persistent class for the user database table.
 * 
 * TODO: Add validation for email format.
 * 
 * @author bu-exercise
 */
@Entity
@Table(name = "user")
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@Size(min = 1, max = 40)
	private String email;

	@Size(min = 1, max = 12)
	private String username;

	@Size(min = 1, max = 20)
	private String password;

	// bi-directional many-to-one association to Role
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Role> roles;

	// bi-directional many-to-one association to Hobby
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Hobby> hobbies;

	// bi-directional many-to-one association to Phone
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Phone> phones;

	/**
	 * Base no-arg constructor
	 */
	public User() {
	}

	/**
	 * Generated accessor
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Generated accessor
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Generated accessor
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Generated accessor
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Generated accessor
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Generated accessor
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Generated accessor
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Generated accessor
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Accessor for eagerly fetched roles. Initializes if null upon access.
	 */
	public List<Role> getRoles() {
		if (this.roles == null) {
			setRoles(new ArrayList<Role>());
		}
		return this.roles;
	}

	/**
	 * Generated accessor
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/**
	 * Adds a single role to the collection.
	 * 
	 * @param role
	 *            a new role (foreign key is assigned)
	 * @return the role
	 */
	public Role addRole(Role role) {
		getRoles().add(role);
		role.setUser(this);
		return role;
	}

	/**
	 * Removes a role from the collection. Does nothing if the role is not in
	 * the collection.
	 * 
	 * @param role
	 *            the role to remove (foreign key is removed)
	 * @return the removed role
	 */
	public Role removeRole(Role role) {
		getRoles().remove(role);
		role.setUser(null);
		return role;
	}

	/**
	 * Accessor for eagerly fetched hobbies. Initializes if null upon access.
	 */
	public List<Hobby> getHobbies() {
		if (this.hobbies == null) {
			setHobbies(new ArrayList<Hobby>());
		}
		return this.hobbies;
	}

	/**
	 * Generated accessor
	 */
	public void setHobbies(List<Hobby> hobbies) {
		this.hobbies = hobbies;
	}

	/**
	 * Adds a single hobby to the collection.
	 * 
	 * @param hobby
	 *            a new hobby (foreign key is assigned)
	 * @return the hobby
	 */
	public Hobby addHobby(Hobby hobby) {
		getHobbies().add(hobby);
		hobby.setUser(this);
		return hobby;
	}

	/**
	 * Removes a hobby from the collection. Does nothing if the hobby is not in
	 * the collection.
	 * 
	 * @param hobby
	 *            the hobby to remove (foreign key is removed)
	 * @return the removed hobby
	 */
	public Hobby removeHobby(Hobby hobby) {
		getHobbies().remove(hobby);
		hobby.setUser(null);
		return hobby;
	}

	/**
	 * Accessor for eagerly fetched phones. Initializes if null upon access.
	 */
	public List<Phone> getPhones() {
		if (this.phones == null) {
			setPhones(new ArrayList<Phone>());
		}
		return this.phones;
	}

	/**
	 * Generated accessor
	 */
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	/**
	 * Adds a single phone to the collection.
	 * 
	 * @param phone
	 *            a new phone (foreign key is assigned)
	 * @return the phone
	 */
	public Phone addPhone(Phone phone) {
		getPhones().add(phone);
		phone.setUser(this);
		return phone;
	}

	/**
	 * Removes a phone from the collection. Does nothing if the phone is not in
	 * the collection.
	 * 
	 * @param phone
	 *            the phone to remove (foreign key is removed)
	 * @return the removed phone
	 */
	public Phone removePhone(Phone phone) {
		getPhones().remove(phone);
		phone.setUser(null);
		return phone;
	}
}