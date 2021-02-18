
package com.cabanaban.desklo.domain;

import com.cabanaban.desklo.repository.TicketRepository;
import com.cabanaban.desklo.repository.UserRepository;
import com.cabanaban.entity.Ticket;
import com.cabanaban.entity.User;

import java.util.List;

public class CurrentUserManager {
    
    private User user;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public CurrentUserManager(User user, TicketRepository ticketRepository, UserRepository userRepository) {
        this.user = user;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    public User getUser() {
        return user;
    }

    public void switchUser(String userID) {
        user = userRepository.findUserByID(userID);
    }

    public List<Ticket> getTickets() {
        return this.ticketRepository.findTicketsByUser(user);
    }
}
