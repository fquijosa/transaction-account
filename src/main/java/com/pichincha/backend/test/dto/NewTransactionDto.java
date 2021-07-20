package com.pichincha.backend.test.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewTransactionDto {

	private Long accountId;

	private String type;

	private String comment;
	
	
	
	public NewTransactionDto(Long accountId, String type, String comment) {
		super();
		this.accountId = accountId;
		this.type = type;
		this.comment = comment;
	}

	public NewTransactionDto() {
		super();
		this.accountId = (long)0;
		this.type = "";
		this.comment = "";
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
