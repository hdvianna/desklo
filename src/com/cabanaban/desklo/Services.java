package com.cabanaban.desklo;

import com.cabanaban.desklo.repository.UserRepository;
import com.cabanaban.desklo.repository.TicketRepository;
import com.cabanaban.desklo.domain.Support;
import com.cabanaban.desklo.viewmodel.Presenter;
import com.cabanaban.desklo.controller.ActionDispatcher;

public interface Services {

    public abstract UserRepository getUserRepository();

    public abstract TicketRepository getTicketRepository();

    public abstract Support getDefaultSupport();

    public abstract Presenter getPresenter();

    public abstract ActionDispatcher getDispatcher();

}
