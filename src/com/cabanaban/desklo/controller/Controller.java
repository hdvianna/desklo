package com.cabanaban.desklo.controller;

import com.cabanaban.desklo.repository.UserRepository;
import com.cabanaban.desklo.repository.TicketRepository;
import com.cabanaban.desklo.viewmodel.Presenter;
import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.domain.CurrentUserManager;
import com.cabanaban.desklo.domain.UsersManager;
import com.cabanaban.desklo.domain.TicketsManager;
import java.util.HashMap;
import java.util.Map;

public class Controller implements ActionDispatcher, Services {

    private final UserRepository userRepository;

    private final TicketRepository ticketRepository;

    private final CurrentUserManager currentUserManager;
    
    private final UsersManager usersManager;
    
    private final TicketsManager ticketsManager;

    private final Presenter presenter;
    
    private final Map<Action, RequestHandler> requestHandlerMap;
    private final Map<Action, ResponseHandler> responseHandlerMap;
    private RequestHandler defaultRequestHandler = null;
    private ResponseHandler defaultResponseHandler = null;

    public Controller(UserRepository userRepository, TicketRepository ticketRepository, CurrentUserManager currentUserManager, UsersManager usersManager, TicketsManager ticketsManager, Presenter presenter) {
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
        this.currentUserManager = currentUserManager;
        this.usersManager = usersManager;
        this.ticketsManager = ticketsManager;
        this.presenter = presenter;
        requestHandlerMap = new HashMap<>();
        responseHandlerMap = new HashMap<>();
    }
    
    
    @Override
    public void dispatch(Action action, Object request) {
        try {
            RequestHandler requestHandler = defaultRequestHandler;
            if (requestHandlerMap.containsKey(action)) {
                requestHandler = requestHandlerMap.get(action);
            }
            
            ResponseHandler responseHandler = defaultResponseHandler;
            if (responseHandlerMap.containsKey(action)) {
                responseHandler = responseHandlerMap.get(action);
            }
            
            Object response = requestHandler.handle(request);
            responseHandler.handle(response);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }

    }

    @Override
    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Override
    public TicketRepository getTicketRepository() {
        return ticketRepository;
    }


    @Override
    public Presenter getPresenter() {
        return presenter;
    }

    @Override
    public ActionDispatcher getDispatcher() {
        return this;
    }

    @Override
    public CurrentUserManager getCurrentUserManager() {
        return currentUserManager;
    }

    @Override
    public UsersManager getUsersManager() {
        return usersManager;
    }

    @Override
    public TicketsManager getTicketsManager() {
        return ticketsManager;
    }

    @Override
    public ActionDispatcher addAction(Action action, RequestHandler requestHandler, ResponseHandler responseHandler) {
        requestHandlerMap.put(action, requestHandler);
        responseHandlerMap.put(action, responseHandler);
        return this;
    }

    @Override
    public ActionDispatcher defaultAction(RequestHandler requestHandler, ResponseHandler responseHandler) {
        defaultRequestHandler = requestHandler;
        defaultResponseHandler = responseHandler;
        return this;
    }

}
