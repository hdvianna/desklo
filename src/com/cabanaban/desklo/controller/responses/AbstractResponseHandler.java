package com.cabanaban.desklo.controller.responses;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.controller.ResponseHandler;
import com.cabanaban.desklo.presentation.ui.DeskloUI;

abstract public class AbstractResponseHandler implements ResponseHandler {
    protected Services services;
    protected DeskloUI deskloUI;
    
    public AbstractResponseHandler(Services services, DeskloUI deskloUI) {
        this.services = services;
        this.deskloUI = deskloUI;
    }
}
