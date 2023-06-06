package com.roadbuddies.rbapi.model;

import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;



@Entity
@Table(name = "review")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "rating")
	private Integer rating;

	@Column(columnDefinition = "LONGTEXT")
	private String content;
	
	@NotNull
	@Column(name = "date_time_review")
	private Date dateTimeReview;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "account_fk", referencedColumnName = "id")
    @JsonIdentityReference(alwaysAsId = true)
	private Account account_fk;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "trip_fk", referencedColumnName = "id")
    @JsonIdentityReference(alwaysAsId = true)
	private Trip trip_fk;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDateTimeReview() {
		return dateTimeReview;
	}

	public void setDateTimeReview(Date dateTimeReview) {
		this.dateTimeReview = dateTimeReview;
	}

	public Account getUser_fk() {
		return account_fk;
	}

	public void setUser_fk(Account account_fk) {
		this.account_fk = account_fk;
	}

	public Trip getTrip_fk() {
		return trip_fk;
	}

	public void setTrip_fk(Trip trip_fk) {
		this.trip_fk = trip_fk;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", content=" + content + ", dateTimeReview=" + dateTimeReview
				+ ", user_fk=" + account_fk + ", trip_fk=" + trip_fk + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, dateTimeReview, id, rating, trip_fk, account_fk);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		return Objects.equals(content, other.content) && Objects.equals(dateTimeReview, other.dateTimeReview)
				&& Objects.equals(id, other.id) && Objects.equals(rating, other.rating)
				&& Objects.equals(trip_fk, other.trip_fk) && Objects.equals(account_fk, other.account_fk);
	}
	
	
	

}
