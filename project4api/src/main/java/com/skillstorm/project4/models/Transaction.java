package com.skillstorm.project4.models;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Transaction {
	
	private UUID id;
	private long ammount;
	private Set<Map<Account, Long>> fromAccount;
	private Account toAccount;

}
