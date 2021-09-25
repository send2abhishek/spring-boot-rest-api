package com.learn.springboot.restapi.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {

    private String streetName;
    private int pinCode;
    private int studentId;

}
