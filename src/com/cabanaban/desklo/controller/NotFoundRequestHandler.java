package com.cabanaban.desklo.controller;

import com.cabanaban.desklo.Services;

public class NotFoundRequestHandler extends AbstractRequestHandler {

    public NotFoundRequestHandler(Services services) {
        super(services);
    }    
    
    @Override
    public Object handle(Object request) {
       return services.getPresenter().getNotFoundViewModelInstance();
    }

}
