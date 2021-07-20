package com.pichincha.backend.test.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.pichincha.backend.test.repository.TransactionRepository;

@Service
public class TransactionService {

	
	private final TransactionRepository transactionRepository;

	public TransactionService(TransactionRepository TransactionRepository) {
		this.transactionRepository = TransactionRepository;
	}
}
