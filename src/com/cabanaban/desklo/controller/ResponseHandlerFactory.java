
package com.cabanaban.desklo.controller;

import com.cabanaban.desklo.Services;

public interface ResponseHandlerFactory {
    public ResponseHandler createMainResponseHandler(Services services);
    public ResponseHandler createNotFoundResponseHandler(Services services);
    public ResponseHandler createTicketListResponseHandler(Services services);
    public ResponseHandler createShowCloseTicketResponseHandler(Services services);
}
