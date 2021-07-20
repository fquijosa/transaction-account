package com.pichincha.backend.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class TransactionDto {

	private final Long id;

	private final String comment;

	private final String type;

	private final LocalDateTime creationDate;

	public TransactionDto(Long id, String comment, String type, LocalDateTime creationDate) {
		super();
		this.id = id;
		this.comment = comment;
		this.type = type;
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}

	public String getComment() {
		return comment;
	}

	public String getType() {
		return type;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	
	

}
