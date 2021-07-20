package com.pichincha.backend.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class AccountDto {

	private final String number;

	private final String type;

	private final LocalDateTime creationDate;

	public AccountDto(String number, String type, LocalDateTime creationDate) {
		super();
		this.number = number;
		this.type = type;
		this.creationDate = creationDate;
	}

	public String getNumber() {
		return number;
	}

	public String getType() {
		return type;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

}
