package com.justransform.model;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User implements Principal {

	@Override
	public int hashCode() {
		return Long.valueOf(userId).hashCode();

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email_id", unique = true)
	private String emailId;

	@Column(name = "address")
	private String address;

	@Column(name = "contact")
	private String contact;

	@Column(name = "password")
	private String password;

	@Column(name = "image", columnDefinition = "LONGBLOB")
	private byte[] image;

	@Column(name = "salt")
	private String salt;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "last_loggedin_date")
	private Date lastLoggedinDate;

	
	@Column(name = "session_id")
	private String sessionId;
	
	@Column(name = "user_email_id")
	private String userEmailId;
	
	@Column(name = "active")
	boolean active;

	

	@ManyToMany
	@JoinTable(name = "USER_MANAGER", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "manager_id") })
	private List<User> managers = new ArrayList<User>();

	@ManyToMany
	@JoinTable(name = "USER_MANAGER", joinColumns = { @JoinColumn(name = "manager_id") }, inverseJoinColumns = { @JoinColumn(name = "user_id") })
	private List<User> manages = new ArrayList<User>();

	// @ManyToMany
	// @JoinTable(name = "USER_ACTION", joinColumns = @JoinColumn(name =
	// "user_id"), inverseJoinColumns = @JoinColumn(name = "action_id"))
	// private List<Action> actions = new ArrayList<Action>();

	
	@Override
	public String toString() {
		return getEmailId();
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastLoggedinDate() {
		return lastLoggedinDate;
	}

	public void setLastLoggedinDate(Date lastLoggedinDate) {
		this.lastLoggedinDate = lastLoggedinDate;
	}

	

	public List<User> getManagers() {
		return managers;
	}

	public void setManagers(List<User> managers) {
		this.managers = managers;
	}

	public List<User> getManages() {
		return manages;
	}

	public void setManages(List<User> manages) {
		this.manages = manages;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}



	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}


	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		} else {
			User user = (User) obj;
			if (this.userId == user.getUserId()) {
				return true;
			}
			if ((emailId != null) && emailId.equals(user.getEmailId())) {
				return true;
			}
		}
		return false;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
