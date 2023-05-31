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
@Table(name = "review")
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
	@JoinColumn(name = "account_fk", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_account_review"))
	private Account account_fk;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "trip_fk", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_trip_review"))
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
