
package com.cabanaban.desklo.controller.responses;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.viewmodel.TicketListViewModel;
import com.cabanaban.desklo.presentation.ui.desktop.MainUI;

public class ConfirmCloseTicketResponseHandler extends AbstractResponseHandler {
    
    public ConfirmCloseTicketResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }
    
        
    @Override
    public void handle(Object response) {
        deskloUI.confirmCloseTicketUI((TicketListViewModel) response);
    }
    
}
