package buri.exercise.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the userrole database table.
 * 
 * @author bu-exercise
 */
@Entity
@Table(name = "userrole")
@NamedQueries({
	@NamedQuery(name = "Role.findByUserId", query = "SELECT r FROM Role r where r.user.id = :userId"),
	@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
})
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Long id;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;

	@Column(name = "rolename")
	@Size(min = 0, max = 20)
	private String name;

	/**
	 * Base no-arg constructor
	 */
	public Role() {
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
	public User getUser() {
		return this.user;
	}

	/**
	 * Generated accessor
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Generated accessor
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Generated accessor
	 */
	public void setName(String name) {
		this.name = name;
	}
}