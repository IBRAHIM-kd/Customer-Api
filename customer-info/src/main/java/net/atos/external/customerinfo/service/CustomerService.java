package net.atos.external.customerinfo.service;

import java.util.List;

import net.atos.external.customerinfo.models.Customer;

public interface CustomerService {
	Customer createCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	List<Customer> getAllCustomer();

	Customer getCustomerById(long customerId);

	void deleteCustomer(long id);
}
