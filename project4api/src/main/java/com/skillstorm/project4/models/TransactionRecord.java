package com.skillstorm.project4.models;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TRANSACTION")
public class TransactionRecord {

	private UUID id;
	private long amount;
	private Account account;
	private Account submittedAccount;
}
