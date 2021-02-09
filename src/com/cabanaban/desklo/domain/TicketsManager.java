
package com.cabanaban.desklo.domain;


import com.cabanaban.desklo.repository.TicketRepository;
import com.cabanaban.entity.Ticket;

public class TicketsManager {
    
    private final TicketRepository ticketRepository;

    public TicketsManager(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
        
    public void saveTicket(Ticket ticket) {
        ticketRepository.saveTicket(ticket);
    }
}
