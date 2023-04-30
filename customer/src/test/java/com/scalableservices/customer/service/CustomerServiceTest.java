package com.scalableservices.customer.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.scalableservices.customer.dto.CreateCustomerRequest;
import com.scalableservices.customer.model.Customer;
import com.scalableservices.customer.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
	
	@Mock
	private CustomerRepository customerRepository;
	
	@InjectMocks
	private CustomerServiceImpl customerService;
	
	@Test
	public void testCreateNewCustomer() {	
		String response = customerService.createNewCustomer(createNewCustomerRequest());
		assertEquals("Customer Saved Successfully", response);		
	}

	private CreateCustomerRequest createNewCustomerRequest() {
		CreateCustomerRequest createCustomerRequest = new CreateCustomerRequest();
		createCustomerRequest.setAge(24L);
		createCustomerRequest.setCity("Chennai");
		createCustomerRequest.setCustomerName("MSD");
		return createCustomerRequest;		
	}

}
