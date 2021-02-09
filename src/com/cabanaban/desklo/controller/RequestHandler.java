package com.cabanaban.desklo.controller;

public interface RequestHandler {
    public void handle(Object request, ResponseHandler responseHandler);
}
