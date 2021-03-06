package com.cabanaban.desklo.controller.responses;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.ui.desktop.MainUI;
import com.cabanaban.desklo.presentation.viewmodel.OpenTicketViewModel;

public class ShowOpenTicketResponseHandler extends AbstractResponseHandler {
    public ShowOpenTicketResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }

    @Override
    public void handle(Object response) {
        /**
         * TODO: Implement ShowOpenTicketResponseHandler
         */
        deskloUI.showOpenTicketUI((OpenTicketViewModel) response);
    }
}
