package com.cabanaban.desklo.ui.desktop;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.controller.ResponseHandler;

abstract public class AbstractResponseHandler implements ResponseHandler {
    protected Services services;
    protected MainUI mainUI;
    
    public AbstractResponseHandler(Services services, MainUI mainUI) {
        this.services = services;
        this.mainUI = mainUI;
    }
}
