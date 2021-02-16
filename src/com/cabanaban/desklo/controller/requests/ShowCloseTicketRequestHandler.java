package com.cabanaban.desklo.controller.requests;

import com.cabanaban.desklo.Services;
import com.cabanaban.entity.Ticket;
import java.util.HashMap;

public class ShowCloseTicketRequestHandler extends AbstractRequestHandler {

    public ShowCloseTicketRequestHandler(Services services) {
        super(services);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object handle(Object request) {
        HashMap<String, String> requestData = (HashMap<String, String>) request;
        String ticketID = requestData.get("ticketID");
        Ticket ticket = services.getTicketsManager().getTicketByID(ticketID);
        return services.getPresenter().createCloseTicketViewModel(ticket);
    }

}
