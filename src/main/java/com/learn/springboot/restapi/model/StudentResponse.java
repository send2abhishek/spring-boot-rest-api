package com.learn.springboot.restapi.model;


import java.util.List;

public interface StudentResponse {

    int getId();
    String getEmail();
    List<AddressResponse> getAddress();

}


