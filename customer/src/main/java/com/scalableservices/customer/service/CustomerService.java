package com.scalableservices.customer.service;

import com.scalableservices.customer.dto.CreateCustomerRequest;
import com.scalableservices.customer.dto.CustomerResponse;
import com.scalableservices.customer.dto.UpdateCustomerRequest;
import com.scalableservices.customer.exception.CustomerNotFoundException;

public interface CustomerService {

	String createNewCustomer(CreateCustomerRequest request);

	CustomerResponse viewProfile(Long customerId)throws CustomerNotFoundException;

	String updateProfile(Long customerId,UpdateCustomerRequest request)throws CustomerNotFoundException;

	String deleteProfile(Long customerId) throws CustomerNotFoundException;

}
