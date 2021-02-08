package com.cabanaban.desklo.repository;

import com.cabanaban.desklo.domain.Status;
import com.cabanaban.desklo.domain.Ticket;
import com.cabanaban.desklo.domain.User;
import java.util.List;
import java.util.stream.Collectors;

public class FakeListTicketRepository implements TicketRepository {

    private final List<Ticket> tickets;

    public FakeListTicketRepository(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public List<Ticket> findTicketsByStatus(Status status) {
        return this.tickets
                .stream()
                .filter(ticket -> ticket.getStatus() == status)
                .collect(Collectors.toList());
    }

    @Override
    public List<Ticket> findTicketsByUser(User user) {
        return this.tickets
                .stream()
                .filter(ticket -> ticket.getUser().equals(user))
                .collect(Collectors.toList());
    }

    @Override
    public void saveTicket(Ticket ticket) {
        long count = this.tickets
                .stream()
                .filter(listTicket -> ticket.equals(listTicket))
                .count();
        if (count == 0) {
            this.tickets.add(ticket);
        }
    }

}
