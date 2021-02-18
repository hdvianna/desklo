package com.cabanaban.entity.exceptions;

public class InvalidNationaIDContentException extends Exception {

    public InvalidNationaIDContentException(String nationalID) {
        super("Invalid content for the National ID " + nationalID);
    }
}
