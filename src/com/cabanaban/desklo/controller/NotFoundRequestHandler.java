package com.cabanaban.desklo.controller;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.viewmodel.ResponseViewModel;

public class NotFoundRequestHandler extends AbstractRequestHandler {

    public NotFoundRequestHandler(Services services) {
        super(services);
    }    
    
    @Override
    public void handle(Object request, ResponseHandler responseHandler) {
        ResponseViewModel notFoundViewModel = services.getPresenter().getNotFoundViewModelInstance();
        responseHandler.handle(notFoundViewModel);
    }

}
