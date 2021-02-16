package com.cabanaban.desklo;

import com.cabanaban.desklo.repository.UserRepository;
import com.cabanaban.desklo.repository.TicketRepository;
import com.cabanaban.desklo.presentation.Presenter;
import com.cabanaban.desklo.controller.ActionDispatcher;
import com.cabanaban.desklo.domain.CurrentUserManager;
import com.cabanaban.desklo.domain.UsersManager;
import com.cabanaban.desklo.domain.TicketsManager;

public interface Services {

    public UsersManager getUsersManager();
    
    public TicketsManager getTicketsManager();
    
    public CurrentUserManager getCurrentUserManager();

    public Presenter getPresenter();

    public ActionDispatcher getDispatcher();
    

}
