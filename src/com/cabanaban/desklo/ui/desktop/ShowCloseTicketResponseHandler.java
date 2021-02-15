
package com.cabanaban.desklo.ui.desktop;

import com.cabanaban.desklo.presentation.CloseTicketViewModel;
import com.cabanaban.desklo.Services;

public class ShowCloseTicketResponseHandler extends AbstractResponseHandler {

    public ShowCloseTicketResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }
    
    @Override
    public void handle(Object response) {
        mainUI.showCloseTicketUI((CloseTicketViewModel) response);
    }
    
}
