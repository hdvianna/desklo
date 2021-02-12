package com.cabanaban.desklo.ui.desktop;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.viewmodel.TicketListViewModel;

public class TicketListResponseHandler extends AbstractResponseHandler {

    public TicketListResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }

    @Override
    public void handle(Object response) {
        mainUI.showTicketListUI((TicketListViewModel) response);
    }
    

}
