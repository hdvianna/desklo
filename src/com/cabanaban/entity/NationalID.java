package com.cabanaban.entity;

public class NationalID {
    private final String nationalID;

    public NationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    @Override
    public String toString() {
        return nationalID;
    }
    
}
