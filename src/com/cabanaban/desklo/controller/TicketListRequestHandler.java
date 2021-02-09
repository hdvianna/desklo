
package com.cabanaban.desklo.controller;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.viewmodel.Presenter;
import com.cabanaban.desklo.domain.TicketsManager;
import com.cabanaban.desklo.viewmodel.TicketListViewModel;
import com.cabanaban.entity.Ticket;
import java.util.List;


public class TicketListRequestHandler extends AbstractRequestHandler {

    public TicketListRequestHandler(Services services) {
        super(services);
    }

        
    @Override
    public void handle(Object request, ResponseHandler responseHandler) {
        TicketsManager ticketsManager = services.getTicketsManager();
        List<Ticket> openTickets = ticketsManager.getOpenTickets();
        Presenter presenter = services.getPresenter();
        TicketListViewModel ticketListViewModel = presenter.createTicketListViewModel(openTickets);
        responseHandler.handle(ticketListViewModel);
    }
    
}
