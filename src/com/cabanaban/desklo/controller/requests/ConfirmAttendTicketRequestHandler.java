package com.cabanaban.desklo.controller.requests;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.viewmodel.TicketListViewModel;
import com.cabanaban.entity.Support;
import com.cabanaban.entity.Ticket;

import java.util.HashMap;
import java.util.List;

public class ConfirmAttendTicketRequestHandler extends AbstractRequestHandler {
    public ConfirmAttendTicketRequestHandler(Services services) {
        super(services);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object handle(Object request) {
        HashMap<String, String> requestData = (HashMap<String, String>) request;
        String ticketID = requestData.get("ticketID");
        Ticket ticket = services.getTicketsManager().getTicketByID(ticketID);
        Support support = (Support) services.getCurrentUserManager().getUser();
        services.getTicketsManager().attendTicket(ticket, support);
        List<Ticket> tickets = services.getTicketsManager().getOpenTickets();
        TicketListViewModel ticketListViewModel = services.getPresenter().createTicketListViewModel(tickets, support);
        return ticketListViewModel;
    }
}
