package com.cabanaban.entity.exceptions;

public class InvalidNationalIDCheckDigitException extends Exception {
    public InvalidNationalIDCheckDigitException(String nationalID) {
        super("Invalid digit for the National ID " + nationalID);
    }
}
