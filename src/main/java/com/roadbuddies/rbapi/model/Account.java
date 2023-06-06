package com.roadbuddies.rbapi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
// @JsonIgnoreProperties({"hibernateLazyInitializer"})
// Lors de l'ajout de l'annotation au dessus, ca me retire mon erreur de proxy hibernate...(Voir dans la classe UserServiceImpl)
@Table(name = "account")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
	@NotNull(message = "Ce champs ne peut pas être vide")
	@Column(name = "firstname")
	private String firstname;
	
	@NotNull(message = "Ce champs ne peut pas être vide")
	@Column(name = "lastname")
	private String lastname;
	
	@NotNull(message = "Ce champs ne peut pas être vide")
	@Column(name = "username", unique = true)
	private String username;
	
	@NotNull(message = "Ce champs ne peut pas être vide")
	@Column(name = "email", unique = true)
	private String email;

	@NotNull(message = "Ce champs ne peut pas être vide")
	@Column(name = "password")
	private String password;
	
	@NotNull(message = "Ce champs ne peut pas être vide")
	@Column(name = "birthday")
	private Date birthday;
	
	@NotNull(message = "Ce champs ne peut pas être vide")
	@Column(name = "phone_number")
	private Integer phoneNumber;
	
    @OneToOne(mappedBy = "account_fk")
    @JsonIdentityReference(alwaysAsId = true)
    private Car car;

    @JsonIgnore
    @OneToMany(mappedBy = "account_fk")
    @JsonIdentityReference(alwaysAsId = true)
    private List<Trip> trips;

    @JsonIgnore
    @OneToMany(mappedBy = "account_fk")
    @JsonIdentityReference(alwaysAsId = true)
    private List<Booking> bookings;

    @JsonIgnore
    @OneToMany(mappedBy = "sender_fk")
    @JsonIdentityReference(alwaysAsId = true)
    private List<Message> sendMessages;

    @JsonIgnore
    @OneToMany(mappedBy = "recipient_fk")
    @JsonIdentityReference(alwaysAsId = true)
    private List<Message> receivedMessages;

    @JsonIgnore
    @OneToMany(mappedBy = "account_fk")
    @JsonIdentityReference(alwaysAsId = true)
    private List<Review> reviews;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
    		name = "account_roles",
    		joinColumns = @JoinColumn(name = "account_id"),
    		inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonIdentityReference(alwaysAsId = true)
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
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", email=" + email + ", password=" + password + ", birthday=" + birthday + ", phoneNumber="
				+ phoneNumber + ", car=" + car + ", trips=" + trips + ", bookings=" + bookings + ", sendMessages="
				+ sendMessages + ", receivedMessages=" + receivedMessages + ", reviews=" + reviews + ", roles=" + roles
				+ "]";
	}
	
	
}
