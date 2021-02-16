
package com.cabanaban.desklo.controller.requests;

import com.cabanaban.desklo.Services;
import com.cabanaban.entity.Ticket;
import com.cabanaban.entity.Support;
import java.util.HashMap;
import java.util.List;

public class ConfirmCloseTicketRequestHandler extends AbstractRequestHandler {

    public ConfirmCloseTicketRequestHandler(Services services) {
        super(services);
    }

    
    @Override
    @SuppressWarnings("unchecked")
    public Object handle(Object request) {
        HashMap<String, String> requestData = (HashMap<String, String>) request;
        String ticketID = requestData.get("ticketID");
        int serviceTime = Integer.parseInt(requestData.get("serviceTime"));
        Ticket ticket = services.getTicketsManager().getTicketByID(ticketID);
        services.getTicketsManager().closeTicket(ticket, serviceTime, "");
        List<Ticket> tickets = services.getTicketsManager().getOpenTickets();
        return services.getPresenter().createTicketListViewModel(tickets, services.getCurrentUserManager().getUser());
    }
    
}
