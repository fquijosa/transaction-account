package com.pichincha.backend.test.rest;

import com.pichincha.backend.test.dto.AccountDto;
import com.pichincha.backend.test.dto.NewTransactionDto;
import com.pichincha.backend.test.dto.TransactionDto;
import com.pichincha.backend.test.service.AccountService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/accounts")
public class AccountController {

	private final AccountService aService;

	public AccountController(AccountService accountService) {
		this.aService = accountService;
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public AccountDto getAccount(@PathVariable Long id) {
		return aService.getAccount(id);
	}

	@PostMapping(value = "/{id}/transactions")
	@ResponseStatus(HttpStatus.OK)
	public Long addTransaction(@RequestBody NewTransactionDto newTransactionDto,@PathVariable Long id) {
		newTransactionDto.setAccountId(id);
		return aService.addTransaction(newTransactionDto);
	}

	@GetMapping(value = "/{id}/transactions")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<TransactionDto>> getTransactionsForAccount(@PathVariable Long id) {
		//List<TransactionDto> lista = new ArrayList<TransactionDto>();
		//lista.add(new TransactionDto((long) 1, "Primer comentario", "un tipo ahi ", LocalDateTime.now()));
		//lista.add(new TransactionDto((long) 2, "Segundo comentario", "un tipo ahi ", LocalDateTime.now()));
		//lista.add(new TransactionDto((long) 3, "Tercer comentario", "un tipo ahi ", LocalDateTime.now()));

		List<TransactionDto> lista = aService.getTransactionsForAccount(id);
		
		return new ResponseEntity<List<TransactionDto>>(lista,HttpStatus.OK);
	}

}
