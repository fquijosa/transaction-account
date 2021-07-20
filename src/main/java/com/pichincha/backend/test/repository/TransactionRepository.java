package com.pichincha.backend.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pichincha.backend.test.model.Transaction;

import antlr.collections.List;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	public List findByaccountId(Long id);
}
