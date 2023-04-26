package com.scalableservices.account.repository;

import com.scalableservices.account.model.Account;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByAccountNumber(Long accountNumber);
	List<Account> findByCustomerId(Long customerId);
	List<Account> findByProductId(Long productId);
	List<Account> findAccountByProductIdAndCustomerId(Long productId, Long customerId);

}