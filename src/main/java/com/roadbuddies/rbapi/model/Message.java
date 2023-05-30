package com.roadbuddies.rbapi.model;

import java.util.Date;

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
}
