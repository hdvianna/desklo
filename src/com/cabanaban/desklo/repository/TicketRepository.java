package com.cabanaban.desklo.repository;


import com.cabanaban.entity.User;
import com.cabanaban.entity.Ticket;
import com.cabanaban.entity.Status;
import java.util.List;

public interface TicketRepository {

	public abstract List<Ticket> findTicketsByStatus(Status status);
        
        public abstract List<Ticket> findTicketsByStatusList(List<Status> statusList);

	public abstract List<Ticket> findTicketsByUser(User user);

	public abstract void saveTicket(Ticket ticket);

}
