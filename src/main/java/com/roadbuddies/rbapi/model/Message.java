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
@Table(name = "message")
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
	@JoinColumn(name = "sender_fk", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_message_sender"))
	private User sender_fk;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "recipient_fk", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_message_recipient"))
	private User recipient_fk;

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

	public User getSender_fk() {
		return sender_fk;
	}

	public void setSender_fk(User sender_fk) {
		this.sender_fk = sender_fk;
	}

	public User getRecipient_fk() {
		return recipient_fk;
	}

	public void setRecipient_fk(User recipient_fk) {
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
