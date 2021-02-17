package com.cabanaban.desklo.controller.responses;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.ui.desktop.MainUI;
import com.cabanaban.desklo.presentation.viewmodel.TransferTicketViewModel;

public class ShowTransferTicketResponseHandler extends AbstractResponseHandler {
    public ShowTransferTicketResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }

    @Override
    public void handle(Object response) {
        /**
         * TODO: ShowTransferTicketResponseHandler
         */
        deskloUI.showTransferTicketUI((TransferTicketViewModel) response);
    }
}
