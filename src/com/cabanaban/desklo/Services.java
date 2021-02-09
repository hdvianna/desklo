package com.cabanaban.desklo;

import com.cabanaban.desklo.repository.UserRepository;
import com.cabanaban.desklo.repository.TicketRepository;
import com.cabanaban.desklo.viewmodel.Presenter;
import com.cabanaban.desklo.controller.ActionDispatcher;
import com.cabanaban.desklo.domain.CurrentUserManager;
import com.cabanaban.desklo.domain.UsersManager;
import com.cabanaban.desklo.domain.TicketsManager;
import com.cabanaban.desklo.controller.ResponseHandlerFactory;

public interface Services {

    public UserRepository getUserRepository();

    public TicketRepository getTicketRepository();

    public UsersManager getUsersManager();
    
    public TicketsManager getTicketsManager();
    
    public CurrentUserManager getCurrentUserManager();

    public Presenter getPresenter();

    public ActionDispatcher getDispatcher();
    
    public ResponseHandlerFactory getResponseHandlerFactory();

}
