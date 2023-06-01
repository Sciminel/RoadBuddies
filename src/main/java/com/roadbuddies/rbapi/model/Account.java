package com.roadbuddies.rbapi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
// @JsonIgnoreProperties({"hibernateLazyInitializer"})
// Lors de l'ajout de l'annotation au dessus, ca me retire mon erreur de proxy hibernate...(Voir dans la classe UserServiceImpl)
@Table(name = "account")
public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
	@NotNull
	@Column(name = "firstname")
	private String firstname;
	
	@NotNull
	@Column(name = "lastname")
	private String lastname;
	
	@NotNull
	@Column(name = "username", unique = true)
	private String username;
	
	@NotNull
	@Column(name = "email", unique = true)
	private String email;

	@JsonIgnore
	@NotNull
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Column(name = "birthday")
	private Date birthday;
	
	@NotNull
	@Column(name = "phone_number")
	private Integer phoneNumber;
	
	@JsonIgnore
    @OneToOne(mappedBy = "account_fk")
    private Car car;

    @JsonIgnore
    @OneToMany(mappedBy = "account_fk")
    private List<Trip> trips;

    @JsonIgnore
    @OneToMany(mappedBy = "account_fk")
    private List<Booking> bookings;

    @JsonIgnore
    @OneToMany(mappedBy = "sender_fk")
    private List<Message> sendMessages;

    @JsonIgnore
    @OneToMany(mappedBy = "recipient_fk")
    private List<Message> receivedMessages;

    @JsonIgnore
    @OneToMany(mappedBy = "account_fk")
    private List<Review> reviews;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
    		name = "account_roles",
    		joinColumns = @JoinColumn(name = "account_id"),
    		inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Message> getSendMessages() {
		return sendMessages;
	}

	public void setSendMessages(List<Message> sendMessages) {
		this.sendMessages = sendMessages;
	}

	public List<Message> getReceivedMessages() {
		return receivedMessages;
	}

	public void setReceivedMessages(List<Message> receivedMessages) {
		this.receivedMessages = receivedMessages;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", email=" + email + ", password=" + password + ", birthday=" + birthday + ", phoneNumber="
				+ phoneNumber + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthday, email, firstname, id, lastname, password, phoneNumber, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(birthday, other.birthday) && Objects.equals(email, other.email)
				&& Objects.equals(firstname, other.firstname) && Objects.equals(id, other.id)
				&& Objects.equals(lastname, other.lastname) && Objects.equals(password, other.password)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(username, other.username);
	}
	
	
	
	
	
}
