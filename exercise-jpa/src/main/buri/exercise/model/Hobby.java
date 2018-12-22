package buri.exercise.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the userhobby database table.
 * 
 * TODO: Refactor creation metadata (createdBy / createdOn) as reusable code.
 * 
 * @author bu-exercise
 */
@Entity
@Table(name = "userhobby")
@NamedQueries({
	@NamedQuery(name = "Hobby.findByUserId", query = "SELECT h FROM Hobby h where h.user.id = :userId"),
	@NamedQuery(name = "Hobby.findAll", query = "SELECT h FROM Hobby h")
})
public class Hobby implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;

	@Size(min = 1, max = 20)
	private String hobby;

	@Size(min = 1, max = 40)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date createdOn;

	/**
	 * Base no-arg constructor
	 */
	public Hobby() {
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
	public String getHobby() {
		return this.hobby;
	}

	/**
	 * Generated accessor
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	/**
	 * Generated accessor
	 */
	public String getCreatedBy() {
		return this.createdBy;
	}

	/**
	 * Generated accessor
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Generated accessor
	 */
	public Date getCreatedOn() {
		return this.createdOn;
	}

	/**
	 * Generated accessor
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
}