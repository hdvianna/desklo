package com.cabanaban.desklo.repository;


import com.cabanaban.desklo.domain.User;
import com.cabanaban.desklo.domain.Ticket;
import com.cabanaban.desklo.domain.Status;

public interface TicketRepository {

	public abstract Ticket[] findTicketsByStatus(Status status);

	public abstract Ticket[] findTicketsByUser(User user);

	public abstract void saveTicket(Ticket ticket);

}
