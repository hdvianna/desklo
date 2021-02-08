package com.cabanaban.entity;

public class EMail {
    private final String email;

    public EMail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return email;
    }   
    
}
