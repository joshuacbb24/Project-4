package com.skillstorm.project4.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ACCOUNT")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

	@Id
	@GeneratedValue(generator = "ACCOUNT_UUID")
	@GenericGenerator(name = "ACCOUNT_UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "uuid-char")
	@Column(name = "ACCOUNT_ID")
	private UUID id;
	private String username;
	private String password;
	private String email;
	private String created;
	private String bgColor;
	private String avatar;
	private Boolean admin;
	
	
}
