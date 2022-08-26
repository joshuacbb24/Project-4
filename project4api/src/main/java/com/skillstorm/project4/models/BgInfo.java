package com.skillstorm.project4.models;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BGINFO")
public class BgInfo {

	private UUID id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String birthday;
	private String gender;
	private Account account;
	
}
