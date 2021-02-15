
package com.cabanaban.desklo.ui.desktop;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.TicketListViewModel;

public class ConfirmCloseTicketResponseHandler extends AbstractResponseHandler {
    
    public ConfirmCloseTicketResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }
    
        
    @Override
    public void handle(Object response) {
        mainUI.confirmCloseTicketUI((TicketListViewModel) response);
    }
    
}
