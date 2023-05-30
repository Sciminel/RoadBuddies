package com.roadbuddies.rbapi.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "LONGTEXT")
	private String content;
	
	@NotNull
	@Column(name = "booking_date")
	private Date bookingDate;
	
	@NotNull
	@Column(name = "num_of_pax")
	private Integer numOfPax;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "user_fk", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_booking"))
	private User user_fk;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "trip_fk", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_trip_booking"))
	private Trip trip_fk;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Integer getNumOfPax() {
		return numOfPax;
	}

	public void setNumOfPax(Integer numOfPax) {
		this.numOfPax = numOfPax;
	}

	public User getUser_fk() {
		return user_fk;
	}

	public void setUser_fk(User user_fk) {
		this.user_fk = user_fk;
	}

	public Trip getTrip_fk() {
		return trip_fk;
	}

	public void setTrip_fk(Trip trip_fk) {
		this.trip_fk = trip_fk;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", content=" + content + ", bookingDate=" + bookingDate + ", numOfPax=" + numOfPax
				+ ", user_fk=" + user_fk + ", trip_fk=" + trip_fk + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingDate, content, id, numOfPax, trip_fk, user_fk);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return Objects.equals(bookingDate, other.bookingDate) && Objects.equals(content, other.content)
				&& Objects.equals(id, other.id) && Objects.equals(numOfPax, other.numOfPax)
				&& Objects.equals(trip_fk, other.trip_fk) && Objects.equals(user_fk, other.user_fk);
	}
	
	
	
	
	
}
