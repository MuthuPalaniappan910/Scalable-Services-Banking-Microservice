package com.scalableservices.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scalableservices.customer.dto.CreateCustomerRequest;
import com.scalableservices.customer.dto.CustomerResponse;
import com.scalableservices.customer.dto.UpdateCustomerRequest;
import com.scalableservices.customer.exception.CustomerNotFoundException;
import com.scalableservices.customer.service.CustomerService;

@RequestMapping("/customer")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createNewCustomer(@RequestBody CreateCustomerRequest request) {
		return new ResponseEntity<>(customerService.createNewCustomer(request), HttpStatus.OK);
	}
	
	@GetMapping("/{customerId}/viewprofile")
	public ResponseEntity<CustomerResponse> viewProfile(@PathVariable Long customerId) throws CustomerNotFoundException{
		return new ResponseEntity<>(customerService.viewProfile(customerId), HttpStatus.OK);
	}

	@PutMapping("/{customerId}/updateprofile")
	public ResponseEntity<String> updateProfile(@PathVariable Long customerId, @RequestBody UpdateCustomerRequest request) throws CustomerNotFoundException{
		return new ResponseEntity<>(customerService.updateProfile(customerId,request), HttpStatus.OK);
	}
	
	@DeleteMapping("/{customerId}/deleteprofile")
	public ResponseEntity<String> deleteProfile(@PathVariable Long customerId) throws CustomerNotFoundException{
		return new ResponseEntity<>(customerService.deleteProfile(customerId), HttpStatus.OK);
	}
}
