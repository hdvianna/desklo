
package com.cabanaban.desklo.ui.desktop;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.controller.ResponseHandler;
import com.cabanaban.desklo.controller.ResponseHandlerFactory;

public class DesktopResponseHandlerFactory implements ResponseHandlerFactory {

    @Override
    public ResponseHandler createMainResponseHandler(Services services) {
        return new MainResponseHandler(services);
    }

    @Override
    public ResponseHandler createNotFoundResponseHandler(Services services) {
        return new NotFoundResponseHandler(services);
    }

    @Override
    public ResponseHandler createTicketListResponseHandler(Services services) {
        return new TicketListResponseHandler(services);
    }
    
}
