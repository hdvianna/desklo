
package com.cabanaban.desklo.controller.requests;

import com.cabanaban.desklo.Services;

public class MainRequestHandler extends AbstractRequestHandler {

    public MainRequestHandler(Services services) {
        super(services);
    }    
    
    @Override
    public Object handle(Object request) {
        return services.getPresenter().getMainViewModelInstance();
    }
    
}
