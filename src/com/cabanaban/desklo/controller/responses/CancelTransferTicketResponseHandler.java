package com.cabanaban.desklo.controller.responses;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.ui.desktop.MainUI;

public class CancelTransferTicketResponseHandler extends AbstractResponseHandler {

    public CancelTransferTicketResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }

    @Override
    public void handle(Object response) {
        /**
         * TODO: CancelTransferTicketResponseHandler
         */
        deskloUI.cancelTransferTicketUI();
    }
}
