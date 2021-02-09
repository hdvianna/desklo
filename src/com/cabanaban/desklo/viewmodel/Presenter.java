package com.cabanaban.desklo.viewmodel;

import com.cabanaban.entity.Ticket;
import java.util.List;

public interface Presenter {

    public MenuViewModel getUserMenuViewModelInstance();
    public MenuViewModel getSupportMenuViewModelInstance();
    public MainViewModel getMainViewModelInstance();
    public ResponseViewModel getNotFoundViewModelInstance();
    public TicketListViewModel createTicketListViewModel(List<Ticket> tickets);
    public TicketListItemViewModel createTicketListItemViewModel(Ticket ticket);
    
}
