
package com.cabanaban.desklo.domain;

import com.cabanaban.desklo.repository.TicketRepository;
import com.cabanaban.desklo.repository.UserRepository;
import com.cabanaban.entity.User;

public class CurrentUserManager {
    
    private final User user;    
    private final TicketRepository ticketRepository;
    private final UserRepository userRespository;

    public CurrentUserManager(User user, TicketRepository ticketRepository, UserRepository userRespository) {
        this.user = user;
        this.ticketRepository = ticketRepository;
        this.userRespository = userRespository;
    }

    public User getUser() {
        return user;
    }
    
}
