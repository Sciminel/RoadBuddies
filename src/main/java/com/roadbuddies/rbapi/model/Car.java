package com.roadbuddies.rbapi.model;

import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.ForeignKey;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;




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
	@JoinColumn(name = "account_fk", referencedColumnName = "id")
	@ForeignKey(name = "fk_account_car")
	private Account account_fk;
	
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

	public Account getUser_fk() {
		return account_fk;
	}

	public void setUser_fk(Account user_fk) {
		this.account_fk = user_fk;
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
				+ ", plate=" + plate + ", color=" + color + ", user_fk=" + account_fk + "]";
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
