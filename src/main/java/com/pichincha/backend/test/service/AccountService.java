package com.pichincha.backend.test.service;

import com.pichincha.backend.test.dto.AccountDto;
import com.pichincha.backend.test.dto.NewTransactionDto;
import com.pichincha.backend.test.dto.TransactionDto;
import com.pichincha.backend.test.log.Log;
import com.pichincha.backend.test.model.Transaction;
import com.pichincha.backend.test.repository.AccountRepository;
import com.pichincha.backend.test.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

	private final AccountRepository accountRepository;

	@Autowired
	private final TransactionRepository transactionRepository;

	private static final Log log = new Log(AccountService.class.getName());

	public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
		this.accountRepository = accountRepository;
		this.transactionRepository = transactionRepository;
	}

	public AccountDto getAccount(Long id) {
		return accountRepository.findById(id)
				.map(account -> new AccountDto(account.getNumber(), account.getType(), account.getCreationDate()))
				.orElse(null);
	}

	/**
	 * Returns a list of all transactions for a account with passed id.
	 *
	 * @param accountId id of the account
	 * @return list of transactions sorted by creation date descending - most recent
	 *         first
	 */
	public List<TransactionDto> getTransactionsForAccount(Long accountId) {
		List<TransactionDto> listTransactionDto = new ArrayList<TransactionDto>();
		try {
			if (accountRepository.findById(accountId) != null) {
				List<Transaction> listTransaction = new ArrayList<Transaction>();
				listTransaction = transactionRepository.findAll();
				
				for (Transaction transaction : listTransaction) {
					if(transaction.getAccountId()==accountId)
					{
						listTransactionDto.add(new TransactionDto(transaction.getId(), transaction.getComment(),
						transaction.getType(), transaction.getCreationDate()));
					}
					
				}
			}
		} catch (Exception e) {
			log.WriteLog("Ocurrio un error el getTransactionsForAccount");
			log.WriteLog("Log de la excepcion " + e.getMessage());
		}
		return listTransactionDto;
	}

	/**
	 * Creates a new transaction
	 *
	 * @param newTransactionDto data of new transaction
	 * @return id of the created transaction
	 * @throws IllegalArgumentException if there is no account for passed
	 *                                  newTransactionDto.accountId
	 */
	public Long addTransaction(NewTransactionDto newTransactionDto) {

		Transaction result = new Transaction();
		try {
			result = transactionRepository.save(new Transaction((long) 0, newTransactionDto.getAccountId(),
					newTransactionDto.getComment(), newTransactionDto.getType(), LocalDateTime.now()));

			log.WriteLog("Se inserto una transaccion con el " + result.getId());

		} catch (IllegalArgumentException e) {
			log.WriteLog("Ocurrio un error el AddTransaction");
			log.WriteLog("Log de la excepcion " + e.getMessage());
		}

		return result.getId();

	}

}
