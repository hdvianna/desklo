
package com.cabanaban.desklo.controller.responses;

import com.cabanaban.desklo.presentation.viewmodel.CloseTicketViewModel;
import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.ui.desktop.MainUI;

public class ShowCloseTicketResponseHandler extends AbstractResponseHandler {

    public ShowCloseTicketResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }
    
    @Override
    public void handle(Object response) {
        deskloUI.showCloseTicketUI((CloseTicketViewModel) response);
    }
    
}
