

package com.cabanaban.desklo.controller;

import com.cabanaban.desklo.Services;
import com.cabanaban.entity.Ticket;
import com.cabanaban.desklo.viewmodel.CloseTicketViewModel;
import java.util.HashMap;


public class ShowCloseTicketRequestHandler extends AbstractRequestHandler {

    public ShowCloseTicketRequestHandler(Services services) {
        super(services);
    }

    @Override
    public void handle(Object request, ResponseHandler responseHandler) {
        HashMap<String,String> requestData = (HashMap<String,String>) request;
        String ticketID = requestData.get("ticketID");
        Ticket ticket = services.getTicketsManager().getTicketByID(ticketID);
        CloseTicketViewModel closeTicketViewModel = services.getPresenter().createCloseTicketViewModel(ticket);
        responseHandler.handle(closeTicketViewModel);
    }
    
}
