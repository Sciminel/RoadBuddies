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
@Table(name = "message")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "LONGTEXT")
	private String content;
	
	@NotNull
	@Column(name = "date_time_message")
	private Date dateTimeMessage;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "sender_fk", referencedColumnName = "id" )
    @JsonIdentityReference(alwaysAsId = true)
	private Account sender_fk;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "recipient_fk", referencedColumnName = "id")
    @JsonIdentityReference(alwaysAsId = true)
	private Account recipient_fk;

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

	public Date getDateTimeMessage() {
		return dateTimeMessage;
	}

	public void setDateTimeMessage(Date dateTimeMessage) {
		this.dateTimeMessage = dateTimeMessage;
	}

	public Account getSender_fk() {
		return sender_fk;
	}

	public void setSender_fk(Account sender_fk) {
		this.sender_fk = sender_fk;
	}

	public Account getRecipient_fk() {
		return recipient_fk;
	}

	public void setRecipient_fk(Account recipient_fk) {
		this.recipient_fk = recipient_fk;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", dateTimeMessage=" + dateTimeMessage + ", sender_fk="
				+ sender_fk + ", recipient_fk=" + recipient_fk + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, dateTimeMessage, id, recipient_fk, sender_fk);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		return Objects.equals(content, other.content) && Objects.equals(dateTimeMessage, other.dateTimeMessage)
				&& Objects.equals(id, other.id) && Objects.equals(recipient_fk, other.recipient_fk)
				&& Objects.equals(sender_fk, other.sender_fk);
	}
	
	
	
	
}
