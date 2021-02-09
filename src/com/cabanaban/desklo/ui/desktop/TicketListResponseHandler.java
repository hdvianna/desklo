package com.cabanaban.desklo.ui.desktop;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.viewmodel.TicketListViewModel;

public class TicketListResponseHandler extends AbstractResponseHandler {

    public TicketListResponseHandler(Services services) {
        super(services);
    }

    @Override
    public void handle(Object response) {
        MainUI mainFrame =  MainUI.getInstance();
        mainFrame.showTicketListUI((TicketListViewModel) response);
    }
    

}
