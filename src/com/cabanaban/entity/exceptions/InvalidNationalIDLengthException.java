package com.cabanaban.entity.exceptions;

public class InvalidNationalIDLengthException extends Exception {
    public InvalidNationalIDLengthException(String nationalID) {
        super("Invalid length for the National ID " + nationalID);
    }
}
