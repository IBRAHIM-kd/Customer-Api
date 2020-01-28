package net.atos.external.customeraddress.service;

import java.util.List;

import net.atos.external.customeraddress.models.Address;

public interface AddressService {
	Address createAddress(Address address);

	Address updateAddress(Address address);

	List<Address> getAllAddress();

	Address getAddressById(long addressId);

	void deleteAddress(long id);
}
