package com.roadbuddies.rbapi.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "trip")
public class Trip {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "departure_city")
	private String departureCity;
	
	@NotNull
	@Column(name = "destination_city")
	private String destinationCity;
	
	@NotNull
	@Column(name = "departure_time")
	private Date departureTime;
	
	@NotNull
	@Column(name = "arrival_time")
	private Date arrivalTime;
	
	@NotNull
	@Column(name = "available_seats")
	private Integer availableSeats;
	
	@NotNull
	private Integer price;
	
	@OneToMany(mappedBy = "trip_fk")
	private List<Booking> bookings;
	
    @OneToMany(mappedBy = "trip_fk")
    private List<Review> reviews;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "user_fk", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_trip"))
	private User user_fk;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public User getUser_fk() {
		return user_fk;
	}

	public void setUser_fk(User user_fk) {
		this.user_fk = user_fk;
	}
	
	

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", departureCity=" + departureCity + ", destinationCity=" + destinationCity
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", availableSeats="
				+ availableSeats + ", price=" + price + ", user_fk=" + user_fk + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrivalTime, availableSeats, departureCity, departureTime, destinationCity, id, price,
				user_fk);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trip other = (Trip) obj;
		return Objects.equals(arrivalTime, other.arrivalTime) && Objects.equals(availableSeats, other.availableSeats)
				&& Objects.equals(departureCity, other.departureCity)
				&& Objects.equals(departureTime, other.departureTime)
				&& Objects.equals(destinationCity, other.destinationCity) && Objects.equals(id, other.id)
				&& Objects.equals(price, other.price) && Objects.equals(user_fk, other.user_fk);
	}
	
	
	
}
