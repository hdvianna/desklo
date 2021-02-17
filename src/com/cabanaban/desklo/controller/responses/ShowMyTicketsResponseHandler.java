package com.cabanaban.desklo.controller.responses;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.ui.desktop.MainUI;
import com.cabanaban.desklo.presentation.viewmodel.MyTicketsViewModel;

public class ShowMyTicketsResponseHandler extends AbstractResponseHandler {
    public ShowMyTicketsResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }

    @Override
    public void handle(Object response) {
        /**
         * TODO: Implement ShowMyTicketsResponseHandler
         */
        deskloUI.showMyTicketsUI((MyTicketsViewModel) response);
    }
}
