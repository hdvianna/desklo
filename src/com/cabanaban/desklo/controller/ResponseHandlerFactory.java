
package com.cabanaban.desklo.controller;

import com.cabanaban.desklo.Services;

public interface ResponseHandlerFactory {
    public ResponseHandler createMainResponseHandler(Services services);
    public ResponseHandler createNotFoundResponseHandler(Services services);
}
