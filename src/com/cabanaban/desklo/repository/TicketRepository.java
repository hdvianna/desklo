package com.cabanaban.desklo.repository;


import com.cabanaban.entity.User;
import com.cabanaban.entity.Ticket;
import com.cabanaban.entity.Status;
import java.util.List;

public interface TicketRepository {

	public List<Ticket> findTicketsByStatus(Status status);
        
        public List<Ticket> findTicketsByStatusList(List<Status> statusList);

	public List<Ticket> findTicketsByUser(User user);
        
        public Ticket findTicketByID(String ID);

	public abstract void saveTicket(Ticket ticket);

}
