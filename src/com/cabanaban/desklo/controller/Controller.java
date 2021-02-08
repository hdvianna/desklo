package com.cabanaban.desklo.controller;

import com.cabanaban.desklo.domain.Support;
import com.cabanaban.desklo.repository.UserRepository;
import com.cabanaban.desklo.repository.TicketRepository;
import com.cabanaban.desklo.viewmodel.Presenter;
import com.cabanaban.common.Command;

public class Controller {

    private UserRepository userRepository;

    private TicketRepository ticketRepository;

    private Support support;

    private Presenter presenter;

    private CommandFactory commandFactory;

    public Controller(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public void dispatch(Action action, Object request) {

        switch (action) {
            case SHOW_MAIN -> {
                Command command;
                command = commandFactory.createMainAction(request);
                command.execute();
            }
        }

    }

}
