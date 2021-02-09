
package com.cabanaban.desklo.controller;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.viewmodel.MainViewModel;

public class MainRequestHandler extends AbstractRequestHandler {

    public MainRequestHandler(Services services) {
        super(services);
    }    
    
    @Override
    public void handle(Object request, ResponseHandler responseHandler) {
        MainViewModel viewModel = services.getPresenter().getMainViewModelInstance();
        responseHandler.handle(viewModel);        
    }
    
}
