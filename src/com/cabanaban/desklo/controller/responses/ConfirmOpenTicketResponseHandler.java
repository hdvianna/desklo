package com.cabanaban.desklo.controller.responses;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.ui.desktop.MainUI;
import com.cabanaban.desklo.presentation.viewmodel.TicketListViewModel;

public class ConfirmOpenTicketResponseHandler extends AbstractResponseHandler {
    public ConfirmOpenTicketResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }

    @Override
    public void handle(Object response) {
        /**
         * TODO: Implement ConfirmOpenTicketResponseHandler
         */
        deskloUI.confirmOpenTicketUI((TicketListViewModel) response);
    }
}
