package com.scalableservices.customer.service;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scalableservices.customer.dto.CreateCustomerRequest;
import com.scalableservices.customer.dto.CustomerResponse;
import com.scalableservices.customer.dto.UpdateCustomerRequest;
import com.scalableservices.customer.exception.CustomerNotFoundException;
import com.scalableservices.customer.model.Customer;
import com.scalableservices.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public String createNewCustomer(CreateCustomerRequest request) {
		Customer customer = new Customer();
		customer.setAge(request.getAge());
		customer.setCity(request.getCity());
		customer.setCustomerName(request.getCustomerName());
		customer.setProfileCreatedOn(LocalDateTime.now());
		customer.setDeleted(Boolean.FALSE);
		customer.setModifiedTime(null);
		customerRepository.save(customer);
		return "Customer Saved Successfully";
	}

	@Override
	public CustomerResponse viewProfile(Long customerId) throws CustomerNotFoundException {
		Customer customer = getCustomerDetails(customerId);
		CustomerResponse customerResponse = new CustomerResponse();
		customerResponse.setAge(customer.getAge());
		customerResponse.setCity(customer.getCity());
		customerResponse.setCustomerId(customer.getCustomerId());
		customerResponse.setDeleted(customer.getDeleted());
		customerResponse.setProfileCreatedOn(customer.getProfileCreatedOn());
		return customerResponse;		
	}	

	@Override
	public String updateProfile(Long customerId,UpdateCustomerRequest request) throws CustomerNotFoundException {
		Customer customer = getCustomerDetails(customerId);
		customer.setAge(request.getAge());
		customer.setCity(request.getCity());
		customer.setModifiedTime(LocalDateTime.now());
		customerRepository.save(customer);
		return "Customer Profile Updated Successfully";
	}

	@Override
	public String deleteProfile(Long customerId) throws CustomerNotFoundException {
		Customer customer = getCustomerDetails(customerId);
		customer.setDeleted(Boolean.TRUE);
		customer.setModifiedTime(LocalDateTime.now());
		return "Customer Profile Deleted Successfully";
	}
	
	private Customer getCustomerDetails(Long customerId) throws CustomerNotFoundException {
		Customer customer = customerRepository.findByCustomerId(customerId);
		if(Objects.isNull(customer)) {
			throw new CustomerNotFoundException("Customer Not Found");
		}
		return customer;
	}

}
