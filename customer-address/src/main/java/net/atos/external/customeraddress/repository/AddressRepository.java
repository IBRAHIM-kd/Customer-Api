package net.atos.external.customeraddress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.atos.external.customeraddress.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}