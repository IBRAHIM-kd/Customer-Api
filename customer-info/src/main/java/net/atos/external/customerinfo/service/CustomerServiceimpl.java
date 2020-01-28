package net.atos.external.customerinfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.external.customerinfo.exception.ResourceNotFoundException;
import net.atos.external.customerinfo.models.Customer;
import net.atos.external.customerinfo.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceimpl implements CustomerService{

	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Optional<Customer> customerDb = this.customerRepository.findById(customer.getId());
		
		if(customerDb.isPresent()) {
			Customer customerUpdate = customerDb.get();
			customerUpdate.setId(customer.getId());
			customerUpdate.setName(customer.getName());
			customerUpdate.setSurname(customer.getSurname());
			customerUpdate.setGender(customer.getGender());
			customerRepository.save(customerUpdate);
			return customerUpdate;
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + customer.getId());
		}		
	}

	@Override
	public List<Customer> getAllCustomer() {
		return this.customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(long customerId) {
		
		Optional<Customer> customerDb = this.customerRepository.findById(customerId);
		
		if(customerDb.isPresent()) {
			return customerDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + customerId);
		}
	}

	@Override
	public void deleteCustomer(long customerId) {
		Optional<Customer> customerDb = this.customerRepository.findById(customerId);
		
		if(customerDb.isPresent()) {
			this.customerRepository.delete(customerDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + customerId);
		}
		
	}

}
