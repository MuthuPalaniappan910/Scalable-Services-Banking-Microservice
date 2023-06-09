package com.scalableservices.account.service;

import com.scalableservices.account.dto.AccountRequest;
import com.scalableservices.account.exception.CreateAccountException;
import com.scalableservices.account.model.Account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.scalableservices.account.dto.AccountResponse;
import com.scalableservices.account.dto.CategoryResponse;
import com.scalableservices.account.exception.NoAccountFoundException;
import com.scalableservices.account.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	public static final String NO_ACCOUNT_FOUND = "No Account Found";
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<AccountResponse> getAccounts() throws NoAccountFoundException {
		
		List<AccountResponse> accountResponses = new ArrayList<>();
		List<Account> accounts = accountRepository.findAll();
		//Create rest template to establish Communication b/w MSA's
		//establishCommunication();
		return getAccountResponses(accountResponses, accounts);
	}

	private void establishCommunication() {		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
		HttpEntity<ResponseEntity<List<CategoryResponse>>> categories =
		restTemplate.exchange("http://localhost:8687/products/category",HttpMethod.GET,
		entity,ResponseEntity<List<CategoryResponse.class>>).getBody();		
	}

	private List<AccountResponse> getAccountResponses(List<AccountResponse> accountResponses,
			List<Account> accounts) throws NoAccountFoundException {
		if(accounts.isEmpty()) {
			throw new NoAccountFoundException(NO_ACCOUNT_FOUND);
		}
		accounts.forEach(account -> {
			AccountResponse accountResponse = new AccountResponse();
			accountResponse.setAccountNumber(account.getAccountNumber());
			accountResponse.setAccountId(account.getAccountId());
			accountResponse.setCustomerId(account.getCustomerId());
			accountResponse.setProductId(account.getProductId());
			accountResponses.add(accountResponse);
		});
		return accountResponses;
	}

	@Override
	public AccountResponse getAccount(Long accountNumber) throws NoAccountFoundException {
		Account account = accountRepository.findByAccountNumber(accountNumber);
		if(Objects.isNull(account)) {
			throw new NoAccountFoundException(NO_ACCOUNT_FOUND);
		}
		AccountResponse accountResponse = new AccountResponse();
		accountResponse.setAccountNumber(account.getAccountNumber());
		accountResponse.setAccountId(account.getAccountId());
		accountResponse.setCustomerId(account.getCustomerId());
		accountResponse.setProductId(account.getProductId());
		return accountResponse;
	}

	@Override
	public List<AccountResponse> getAccountsByCustomer(Long customerId) throws NoAccountFoundException {
		List<AccountResponse> accountResponses = new ArrayList<>();
		List<Account> accounts = accountRepository.findByCustomerId(customerId);
		return getAccountResponses(accountResponses, accounts);
	}

	@Override
	public List<AccountResponse> getAccountsByProduct(Long productId) throws NoAccountFoundException {
		List<AccountResponse> accountResponses = new ArrayList<>();
		List<Account> accounts = accountRepository.findByProductId(productId);
		return getAccountResponses(accountResponses, accounts);
	}

	@Override
	public AccountResponse createAccount(AccountRequest accountRequest) throws CreateAccountException {

		List<Account> dbAccount = accountRepository.findAccountByProductIdAndCustomerId(
				accountRequest.getProductId(), accountRequest.getCustomerId());
		if(!dbAccount.isEmpty()) {
			throw new CreateAccountException("Account already exists with given ProductId and CustomerId");
		}
		Account account = new Account();
		account.setAccountNumber(accountRequest.getAccountNumber());
		account.setCustomerId(accountRequest.getCustomerId());
		account.setProductId(accountRequest.getProductId());
		account = accountRepository.save(account);
		if(account == null) {
			throw new CreateAccountException("Failed to create Account");
		}
		AccountResponse accountResponse = new AccountResponse();
		accountResponse.setAccountNumber(account.getAccountNumber());
		accountResponse.setAccountId(account.getAccountId());
		accountResponse.setCustomerId(account.getCustomerId());
		accountResponse.setProductId(account.getProductId());
		return accountResponse;
	}

}
