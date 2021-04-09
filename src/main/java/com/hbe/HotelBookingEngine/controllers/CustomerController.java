package com.hbe.HotelBookingEngine.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hbe.HotelBookingEngine.domain.Customer;
//import com.hbe.HotelBookingEngine.domain.Customer.CustomerBuilder;
import com.hbe.HotelBookingEngine.repositories.CustomerRepository;

import exceptions.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/v1")


public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value= "id") Long customerId) throws ResourceNotFoundException
	{
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow( () -> new ResourceNotFoundException("Customer not found for this id :"+ customerId));
		return ResponseEntity.ok().body(customer);
		
	}
	
	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer customer) {
		System.out.println("Creating customer : + "+customer);
		return customerRepository.save(customer);
	}
	
	@PutMapping("customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") long customerId, Customer customerDetails) throws ResourceNotFoundException
	{
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :"+ customerId));
		

		customer.setFirstName(customerDetails.getFirstName());
		customer.setLastName(customerDetails.getFirstName());
		customer.setMail(customerDetails.getMail());
		
		final Customer updatedCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updatedCustomer);
	}
	
	@DeleteMapping("/customers/{id}")
	public Map<String, Boolean> deleteCustomer(@PathVariable(value="id") long customerId) throws ResourceNotFoundException
	{
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :"+ customerId));
		
		customerRepository.delete(customer);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;
	}
	
	
	
}
