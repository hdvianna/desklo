package com.cabanaban.desklo.controller;

import com.cabanaban.desklo.repository.UserRepository;
import com.cabanaban.desklo.repository.TicketRepository;
import com.cabanaban.desklo.viewmodel.Presenter;
import com.cabanaban.desklo.Services;
import com.cabanaban.common.Command;
import com.cabanaban.desklo.domain.DefaultSupportManager;

public class Controller implements ActionDispatcher, Services {

    private UserRepository userRepository;

    private TicketRepository ticketRepository;

    private DefaultSupportManager defaultSupportManager;

    private Presenter presenter;

    private final CommandFactory commandFactory;

    public Controller(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    @Override
    public void dispatch(Services services, Action action, Object request) {
        //SLADashBoardJFrame frame = new SLADashBoardJFrame();
        //desktop.add(frame);
        //frame.setVisible(true);
        try {
            switch (action) {
                case SHOW_MAIN -> {
                    Command command;
                    command = commandFactory.createMainAction(services, request);
                    command.execute();
                }
                default -> {
                    Command command;
                    command = commandFactory.createNotImplementedAction(services, request);
                    command.execute();
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

}
