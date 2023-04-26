package com.scalableservices.account.service;

import com.scalableservices.account.dto.AccountRequest;
import com.scalableservices.account.exception.CreateAccountException;
import java.util.List;

import com.scalableservices.account.dto.AccountResponse;
import com.scalableservices.account.exception.NoAccountFoundException;
import com.scalableservices.account.model.Account;

public interface AccountService {

	List<AccountResponse> getAccounts() throws NoAccountFoundException;
	List<AccountResponse> getAccountsByCustomer(Long customerId) throws NoAccountFoundException;
	List<AccountResponse> getAccountsByProduct(Long productId) throws NoAccountFoundException;

	AccountResponse getAccount(Long accountId) throws NoAccountFoundException;
	AccountResponse createAccount(AccountRequest accountRequest) throws CreateAccountException;

}
