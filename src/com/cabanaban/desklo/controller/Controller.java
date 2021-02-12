package com.cabanaban.desklo.controller;

import com.cabanaban.desklo.repository.UserRepository;
import com.cabanaban.desklo.repository.TicketRepository;
import com.cabanaban.desklo.viewmodel.Presenter;
import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.domain.CurrentUserManager;
import com.cabanaban.desklo.domain.UsersManager;
import com.cabanaban.desklo.domain.TicketsManager;

public class Controller implements ActionDispatcher, Services {

    private final UserRepository userRepository;

    private final TicketRepository ticketRepository;

    private final CurrentUserManager currentUserManager;
    
    private final UsersManager usersManager;
    
    private final TicketsManager ticketsManager;

    private final Presenter presenter;
    
    private final ResponseHandlerFactory responseHandlerFactory;

    public Controller(UserRepository userRepository, TicketRepository ticketRepository, CurrentUserManager currentUserManager, UsersManager usersManager, TicketsManager ticketsManager, Presenter presenter, ResponseHandlerFactory responseHandlerFactory) {
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
        this.currentUserManager = currentUserManager;
        this.usersManager = usersManager;
        this.ticketsManager = ticketsManager;
        this.presenter = presenter;
        this.responseHandlerFactory = responseHandlerFactory;
    }
    
    
    @Override
    public void dispatch(Services services, Action action, Object request) {
        try {
            switch (action) {
                case SHOW_MAIN -> {
                    RequestHandler mainRequestHandler = new MainRequestHandler(services);
                    mainRequestHandler.handle(request, responseHandlerFactory.createMainResponseHandler(services));
                }
                case SHOW_MANAGE_TICKETS -> {
                    RequestHandler ticketListRequestHandler = new TicketListRequestHandler(services);
                    ticketListRequestHandler.handle(request, responseHandlerFactory.createTicketListResponseHandler(services));
                }
                case SHOW_CLOSE_TICKET -> {
                    RequestHandler showCloseTicketRequestHandler = new ShowCloseTicketRequestHandler(services);
                    showCloseTicketRequestHandler.handle(request, responseHandlerFactory.createShowCloseTicketResponseHandler(services));
                }
                default -> {
                    RequestHandler notFoundRequestHandler = new NotFoundRequestHandler(services);
                    notFoundRequestHandler.handle(request, responseHandlerFactory.createNotFoundResponseHandler(services));
                }
            }
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
    public ResponseHandlerFactory getResponseHandlerFactory() {
        return responseHandlerFactory;
    }

    @Override
    public UsersManager getUsersManager() {
        return usersManager;
    }

    @Override
    public TicketsManager getTicketsManager() {
        return ticketsManager;
    }

}
