package com.example.blog.Exceptions;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
