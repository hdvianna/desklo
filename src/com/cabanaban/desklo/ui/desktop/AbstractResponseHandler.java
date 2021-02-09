package com.cabanaban.desklo.ui.desktop;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.controller.ResponseHandler;

abstract public class AbstractResponseHandler implements ResponseHandler {
    protected Services services;

    public AbstractResponseHandler(Services services) {
        this.services = services;
    }
}
