package com.cabanaban.desklo.controller;

import com.cabanaban.desklo.repository.UserRepository;
import com.cabanaban.desklo.repository.TicketRepository;
import com.cabanaban.desklo.viewmodel.Presenter;
import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.domain.DefaultSupportManager;

public class Controller implements ActionDispatcher, Services {

    private UserRepository userRepository;

    private TicketRepository ticketRepository;

    private DefaultSupportManager defaultSupportManager;

    private Presenter presenter;
    
    private ResponseHandlerFactory responseHandlerFactory;

    public Controller(UserRepository userRepository, TicketRepository ticketRepository, DefaultSupportManager defaultSupportManager, Presenter presenter, ResponseHandlerFactory responseHandlerFactory) {
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
        this.defaultSupportManager = defaultSupportManager;
        this.presenter = presenter;
        this.responseHandlerFactory = responseHandlerFactory;
    }
    
    
    @Override
    public void dispatch(Services services, Action action, Object request) {
        //SLADashBoardJFrame frame = new SLADashBoardJFrame();
        //desktop.add(frame);
        //frame.setVisible(true);
        try {
            switch (action) {
                case SHOW_MAIN -> {
                    RequestHandler mainRequestHandler = new MainRequestHandler(services);
                    mainRequestHandler.handle(request, responseHandlerFactory.createMainResponseHandler(services));
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
    public DefaultSupportManager getDefaultSupportManager() {
        return defaultSupportManager;
    }

    @Override
    public ResponseHandlerFactory getResponseHandlerFactory() {
        return responseHandlerFactory;
    }

}
