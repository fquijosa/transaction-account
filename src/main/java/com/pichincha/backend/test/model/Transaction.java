package com.pichincha.backend.test.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transaction {

	@Id
	@GeneratedValue
	private Long id;

	private Long accountId;
	
	private String comment;

	private String type;

	private LocalDateTime creationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public Transaction(Long id, Long accountId, String comment, String type, LocalDateTime creationDate) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.comment = comment;
		this.type = type;
		this.creationDate = creationDate;
	}

	public Transaction() {
		super();
	}

	
}
