package com.scalableservices.account.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.scalableservices.account.dto.AccountResponse;
import com.scalableservices.account.exception.NoAccountFoundException;
import com.scalableservices.account.model.Account;
import com.scalableservices.account.repository.AccountRepository;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {
	
	@Mock
	private AccountRepository accountRepository;
	
	@InjectMocks
	private AccountServiceImpl accountServiceImpl;
	
	@Test
	public void testGetAccounts() throws NoAccountFoundException {
		List<Account> accounts =getAccount();
		when(accountRepository.findAll()).thenReturn(accounts);
		
		List<AccountResponse> response = accountServiceImpl.getAccounts();
		
		assertNotNull(response);
	}
	
	@Test
	public void testGetAccountsByCustomer() throws NoAccountFoundException {
		List<Account> accounts =getAccount();
		when(accountRepository.findByCustomerId(1L)).thenReturn(accounts);
		
		List<AccountResponse> response = accountServiceImpl.getAccountsByCustomer(1L);
		
		assertNotNull(response);
	}

	private List<Account> getAccount() {
		List<Account> accounts = new ArrayList();
		Account account = new Account();
		account.setAccountId(1L);
		account.setAccountNumber(12345678L);
		account.setCustomerId(1L);
		account.setProductId(1L);
		accounts.add(account);
		return accounts;
	}

}
