
package com.cabanaban.desklo.ui.desktop;

import com.cabanaban.desklo.Services;

public class CancelCloseTicketResponseHandler extends AbstractResponseHandler {
    
    public CancelCloseTicketResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }
    
        
    @Override
    public void handle(Object response) {
        mainUI.cancelCloseTicketUI();
    }
}
