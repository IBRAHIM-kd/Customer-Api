package net.atos.external.customeraddress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.atos.external.customeraddress.exception.ResourceNotFoundException;
import net.atos.external.customeraddress.models.Address;
import net.atos.external.customeraddress.repository.AddressRepository;

@Service
@Transactional
public class AddressServiceimpl implements AddressService{

	
	@Autowired
	private AddressRepository addressRepository;
	
	
	@Override
	public Address createAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address updateAddress(Address address) {
		Optional<Address> addressDb = this.addressRepository.findById(address.getId());
		
		if(addressDb.isPresent()) {
			Address addressUpdate = addressDb.get();
			addressUpdate.setId(address.getId());
			addressUpdate.setPhoneNo(address.getPhoneNo());
			addressUpdate.setAddress(address.getAddress());
			addressUpdate.setZipcode(address.getZipcode());
			addressRepository.save(addressUpdate);
			return addressUpdate;
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + address.getId());
		}		
	}

	@Override
	public List<Address> getAllAddress() {
		return this.addressRepository.findAll();
	}

	@Override
	public Address getAddressById(long addressId) {
		
		Optional<Address> addressDb = this.addressRepository.findById(addressId);
		
		if(addressDb.isPresent()) {
			return addressDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + addressId);
		}
	}

	@Override
	public void deleteAddress(long addressId) {
		Optional<Address> addressDb = this.addressRepository.findById(addressId);
		
		if(addressDb.isPresent()) {
			this.addressRepository.delete(addressDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + addressId);
		}
		
	}

}
