package com.learn.springboot.restapi.service;

import com.learn.springboot.restapi.model.Address;
import com.learn.springboot.restapi.model.Student;
import com.learn.springboot.restapi.repository.AddressRepository;
import com.learn.springboot.restapi.request.AddressRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final StudentService studentService;


    @Autowired
    public AddressService(AddressRepository addressRepository, StudentService studentService) {
        this.addressRepository = addressRepository;
        this.studentService = studentService;
    }

    public Address saveAddress(AddressRequest addressRequest) {
        Student student = studentService.getStudent(addressRequest.getStudentId());
        return addressRepository.save(new Address(addressRequest.getStreetName(), addressRequest.getPinCode(), student));
    }

    public List<Address> fetchAddress(){
        return addressRepository.findAll();
    }
}
