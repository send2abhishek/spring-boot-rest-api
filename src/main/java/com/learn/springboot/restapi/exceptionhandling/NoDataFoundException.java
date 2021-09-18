package com.learn.springboot.restapi.exceptionhandling;

public class NoDataFoundException extends RuntimeException{

    public NoDataFoundException() {
        super("No data found");
    }
}
