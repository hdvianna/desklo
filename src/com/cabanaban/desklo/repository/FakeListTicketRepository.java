package com.cabanaban.desklo.repository;

import com.cabanaban.entity.Status;
import com.cabanaban.entity.Ticket;
import com.cabanaban.entity.User;
import java.util.List;
import java.util.stream.Collectors;

public class FakeListTicketRepository implements TicketRepository {

    private final List<Ticket> tickets;
    private long sequence;

    public FakeListTicketRepository(List<Ticket> tickets) {
        this.tickets = tickets;
        sequence = tickets.size();
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
            sequence++;
            ticket.setID(Long.toString(sequence));
            this.tickets.add(ticket);
        }
    }

    @Override
    public List<Ticket> findTicketsByStatusList(List<Status> statusList) {
        return this.tickets
                .stream()
                .filter(ticket -> statusList.contains(ticket.getStatus()))
                .collect(Collectors.toList());
    }

}
