
package com.cabanaban.desklo.domain;


import com.cabanaban.desklo.repository.TicketRepository;
import com.cabanaban.entity.Ticket;
import com.cabanaban.entity.Status;
import java.util.ArrayList;
import java.util.List;

public class TicketsManager {
    
    private final TicketRepository ticketRepository;

    public TicketsManager(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
     
    public void saveTicket(Ticket ticket) {
        ticketRepository.saveTicket(ticket);
    }
    
    public List<Ticket> getOpenTickets() {
        List<Status> statusList = new ArrayList<>();
        statusList.add(Status.TODO);
        statusList.add(Status.DOING);
        return ticketRepository.findTicketsByStatusList(statusList);
    }
    
    public Ticket getTicketByID(String ticketID) {
        return ticketRepository.findTicketByID(ticketID);
    }
            
}
