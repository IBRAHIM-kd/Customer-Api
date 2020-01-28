package net.atos.external.customerinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.atos.external.customerinfo.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
