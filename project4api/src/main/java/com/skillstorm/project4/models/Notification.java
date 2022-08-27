package com.skillstorm.project4.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "NOTIFICATION")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NOTIFICATION_ID")
	private int id;
	@Column(name = "MESSAGE", nullable = false, length = 50)
	private String message;
	@Column(name = "DATE_CREATED", nullable = false, length = 10)
	private String dateCreated;
	@ManyToMany
	@Column(name = "ACCOUNT_ID", nullable = false)
	private Account account;
}
