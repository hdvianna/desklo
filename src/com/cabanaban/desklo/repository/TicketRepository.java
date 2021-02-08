package com.cabanaban.desklo.repository;


import com.cabanaban.desklo.domain.User;
import com.cabanaban.desklo.domain.Ticket;
import com.cabanaban.desklo.domain.Status;
import java.util.List;

public interface TicketRepository {

	public abstract List<Ticket> findTicketsByStatus(Status status);

	public abstract List<Ticket> findTicketsByUser(User user);

	public abstract void saveTicket(Ticket ticket);

}
