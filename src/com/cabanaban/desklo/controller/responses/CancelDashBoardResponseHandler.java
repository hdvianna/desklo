package com.cabanaban.desklo.controller.responses;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.ui.desktop.MainUI;

public class CancelDashBoardResponseHandler extends AbstractResponseHandler {
    public CancelDashBoardResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }

    @Override
    public void handle(Object response) {
        /**
         * TODO: CancelDashBoardResponseHandler
         */
        deskloUI.cancelDashboardUI();
    }
}
