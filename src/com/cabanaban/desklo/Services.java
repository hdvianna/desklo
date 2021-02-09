package com.cabanaban.desklo;

import com.cabanaban.desklo.repository.UserRepository;
import com.cabanaban.desklo.repository.TicketRepository;
import com.cabanaban.desklo.viewmodel.Presenter;
import com.cabanaban.desklo.controller.ActionDispatcher;
import com.cabanaban.desklo.domain.DefaultSupportManager;
import com.cabanaban.desklo.controller.ResponseHandlerFactory;

public interface Services {

    public UserRepository getUserRepository();

    public TicketRepository getTicketRepository();

    public DefaultSupportManager getDefaultSupportManager();

    public Presenter getPresenter();

    public ActionDispatcher getDispatcher();
    
    public ResponseHandlerFactory getResponseHandlerFactory();

}
