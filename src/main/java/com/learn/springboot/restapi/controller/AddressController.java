package com.learn.springboot.restapi.controller;


import com.learn.springboot.restapi.model.Address;
import com.learn.springboot.restapi.request.AddressRequest;
import com.learn.springboot.restapi.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/create")
    public ResponseEntity<Address> saveAddress(@RequestBody AddressRequest addressRequest) {

        return new ResponseEntity<>(addressService.saveAddress(addressRequest), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Address>> getAddress() {
        return new ResponseEntity<>(addressService.fetchAddress(), HttpStatus.OK);
    }
}
