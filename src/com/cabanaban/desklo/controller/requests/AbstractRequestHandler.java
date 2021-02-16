package com.cabanaban.desklo.controller.requests;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.controller.RequestHandler;

abstract public class AbstractRequestHandler implements RequestHandler {

    protected Services services;

    public AbstractRequestHandler(Services services) {
        this.services = services;
    }

}
