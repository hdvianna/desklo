
package com.cabanaban.desklo.controller;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.Presenter;
import com.cabanaban.desklo.domain.TicketsManager;
import com.cabanaban.entity.Ticket;
import java.util.List;


public class TicketListRequestHandler extends AbstractRequestHandler {

    public TicketListRequestHandler(Services services) {
        super(services);
    }

        
    @Override
    public Object handle(Object request) {
        TicketsManager ticketsManager = services.getTicketsManager();
        List<Ticket> openTickets = ticketsManager.getOpenTickets();
        Presenter presenter = services.getPresenter();
        return presenter.createTicketListViewModel(openTickets);
    }
    
}
