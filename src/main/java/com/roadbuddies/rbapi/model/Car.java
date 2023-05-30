package com.roadbuddies.rbapi.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "car")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String make;
	
	@NotNull
	private String model;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date year;
	
	private String license;
	
	@NotNull
	private String plate; 
	
	@NotNull
	private String color;

	@NotNull
	@OneToOne
	@JoinColumn(name = "user_fk", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_car"))
	private User user_fk;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}


	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public User getUser_fk() {
		return user_fk;
	}

	public void setUser_fk(User user_fk) {
		this.user_fk = user_fk;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}



	@Override
	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", model=" + model + ", year=" + year + ", license=" + license
				+ ", plate=" + plate + ", color=" + color + ", user_fk=" + user_fk + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, id, license, make, model, plate, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(color, other.color) && Objects.equals(id, other.id)
				&& Objects.equals(license, other.license) && Objects.equals(make, other.make)
				&& Objects.equals(model, other.model) && Objects.equals(plate, other.plate)
				&& Objects.equals(year, other.year);
	}
	
	
	
	
	
	
}
