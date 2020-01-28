package net.atos.external.customeraddress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.atos.external.customeraddress.models.Address;
import net.atos.external.customeraddress.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@GetMapping("/address")
	public ResponseEntity<List<Address>> getAllAddress(){
		return ResponseEntity.ok().body(addressService.getAllAddress());
	}
	
	@GetMapping("/address/{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable long id){
		return ResponseEntity.ok().body(addressService.getAddressById(id));
	}
	
	@PostMapping("/address")
	public ResponseEntity<Address> createAddressr(@RequestBody Address address){
		return ResponseEntity.ok().body(this.addressService.createAddress(address));
	}
	
	@PutMapping("/address/{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable long id, @RequestBody Address address){
		address.setId(id);
		return ResponseEntity.ok().body(this.addressService.updateAddress(address));
	}

	@DeleteMapping("/address/{id}")
	public HttpStatus deleteAddress(@PathVariable long id){
		this.addressService.deleteAddress(id);
		return HttpStatus.OK;
	}
}
