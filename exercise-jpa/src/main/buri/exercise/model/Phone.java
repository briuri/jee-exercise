package buri.exercise.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the userphone database table.
 * 
 * TODO: Refactor creation metadata (createdBy / createdOn) as reusable code.
 * TODO: Make a reference table of type enumerations in database. 
 * TODO: Add validation to phone number format.
 * 
 * @author bu-exercise
 */
@Entity
@Table(name = "userphone")
@NamedQueries({
	@NamedQuery(name = "Phone.findByUserId", query = "SELECT p FROM Phone p where p.user.id = :userId"),
	@NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p")
})
public class Phone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;

	@Pattern(regexp = "^(OFFICE|HOME|MOBILE)$")
	@Size(min = 1, max = 10)
	private String type;

	@Column(name = "phoneNumber")
	@Size(min = 1, max = 10)
	private String number;

	@Size(min = 1, max = 40)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date createdOn;

	/**
	 * Base no-arg constructor
	 */
	public Phone() {
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
	public String getType() {
		return this.type;
	}

	/**
	 * Generated accessor
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Generated accessor
	 */
	public String getNumber() {
		return this.number;
	}

	/**
	 * Generated accessor
	 */
	public void setNumber(String number) {
		this.number = number;
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