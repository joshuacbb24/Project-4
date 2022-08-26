package com.skillstorm.project4.models;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "NOTIFICATION")
public class Notification {

	private int id;
	private String message;
	private String dateCreated;
	private Account account;
}
