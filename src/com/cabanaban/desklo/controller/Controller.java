package com.cabanaban.desklo.controller;

import com.cabanaban.desklo.domain.Support;
import com.cabanaban.desklo.repository.UserRepository;
import com.cabanaban.desklo.repository.TicketRepository;
import com.cabanaban.desklo.viewmodel.Presenter;
import com.cabanaban.desklo.Services;
import com.cabanaban.common.Command;

public class Controller implements ActionDispatcher, Services {

    private UserRepository userRepository;

    private TicketRepository ticketRepository;

    private Support support;

    private Presenter presenter;

    private final CommandFactory commandFactory;

    public Controller(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public void dispatch(Action action, Object request) {
        //SLADashBoardJFrame frame = new SLADashBoardJFrame();
        //desktop.add(frame);
        //frame.setVisible(true);
        try {
            switch (action) {
                case SHOW_MAIN -> {
                    Command command;
                    command = commandFactory.createMainAction(this, request);
                    command.execute();
                }
                default -> {
                    Command command;
                    command = commandFactory.createNotImplementedAction(this, request);
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
    public Support getDefaultSupport() {
        return support;
    }

    @Override
    public Presenter getPresenter() {
        return presenter;
    }

    @Override
    public ActionDispatcher getDispatcher() {
        return this;
    }

}
