package com.cabanaban.desklo.controller;

import com.cabanaban.desklo.Services;

abstract public class AbstractRequestHandler implements RequestHandler {

    protected Services services;

    public AbstractRequestHandler(Services services) {
        this.services = services;
    }

}
