package com.scalableservices.account.controller;

import com.scalableservices.account.dto.AccountRequest;
import com.scalableservices.account.exception.CreateAccountException;
import com.scalableservices.account.exception.NoAccountFoundException;
import com.scalableservices.account.service.AccountService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scalableservices.account.dto.AccountResponse;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	@GetMapping("/account")
	public ResponseEntity<List<AccountResponse>> getAccounts() throws NoAccountFoundException {
		return new ResponseEntity<>(accountService.getAccounts(), HttpStatus.OK);
	}

	@GetMapping("/account/{accountNumber}")
	public ResponseEntity<AccountResponse> getAccount(@PathVariable Long accountNumber) throws NoAccountFoundException {
		return new ResponseEntity<>(accountService.getAccount(accountNumber), HttpStatus.OK);
	}
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<List<AccountResponse>> getAccountsForCustomer(@PathVariable Long customerId) throws NoAccountFoundException {
		return new ResponseEntity<>(accountService.getAccountsByCustomer(customerId), HttpStatus.OK);
	}
	@GetMapping("/product/{productId}")
	public ResponseEntity<List<AccountResponse>> getAccountsForProduct(@PathVariable Long productId) throws NoAccountFoundException {
		return new ResponseEntity<>(accountService.getAccountsByProduct(productId), HttpStatus.OK);
	}
	@PostMapping("/account")
	public ResponseEntity<AccountResponse> createAccount(@RequestBody AccountRequest accountRequest)
			throws CreateAccountException {
		return new ResponseEntity<>(accountService.createAccount(accountRequest), HttpStatus.OK);
	}

}
