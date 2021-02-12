
package com.cabanaban.desklo.ui.desktop;
import com.cabanaban.desklo.viewmodel.CloseTicketViewModel;

import com.cabanaban.desklo.Services;

public class ShowCloseTicketResponseHandler extends AbstractResponseHandler {

    public ShowCloseTicketResponseHandler(Services services) {
        super(services);
    }    
    
    @Override
    public void handle(Object response) {
        MainUI mainFrame =  MainUI.getInstance();
        mainFrame.showCloseTicketUI((CloseTicketViewModel) response);
    }
    
}
