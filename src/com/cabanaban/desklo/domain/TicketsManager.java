
package com.cabanaban.desklo.domain;


import com.cabanaban.desklo.repository.TicketRepository;
import com.cabanaban.entity.Support;
import com.cabanaban.entity.Ticket;
import com.cabanaban.entity.Status;

import java.util.ArrayList;
import java.util.List;

public class TicketsManager {
    
    private final TicketRepository ticketRepository;

    public TicketsManager(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
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

    public void closeTicket(Ticket ticket, int timeInMinutes, String solution) {
        ticket.close(minutesToMilliseconds(timeInMinutes), solution);
        ticketRepository.saveTicket(ticket);
    }

    public void transferTicket(Ticket ticket, int timeInMinutes, Support to) {
        ticket.transfer(to, minutesToMilliseconds(timeInMinutes));
        ticketRepository.saveTicket(ticket);
    }

    public void attendTicket(Ticket ticket, Support to) {
        ticket.attend(to);
        ticketRepository.saveTicket(ticket);
    }

    private int minutesToMilliseconds(int minutes) {
        return minutes  * 60 * 1000;
    }
}
