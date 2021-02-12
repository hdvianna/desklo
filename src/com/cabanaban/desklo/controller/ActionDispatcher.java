
package com.cabanaban.desklo.controller;

import com.cabanaban.desklo.Services;

public interface ActionDispatcher {
    public ActionDispatcher addAction(Action action, RequestHandler requestHandler, ResponseHandler responseHandler);
    public ActionDispatcher defaultAction(RequestHandler requestHandler, ResponseHandler responseHandler);
    public void dispatch(Action action, Object request);
}
