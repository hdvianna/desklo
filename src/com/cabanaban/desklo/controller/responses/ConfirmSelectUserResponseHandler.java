package com.cabanaban.desklo.controller.responses;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.ui.desktop.MainUI;
import com.cabanaban.desklo.presentation.viewmodel.SelectedUserResponseViewModel;

public class ConfirmSelectUserResponseHandler extends AbstractResponseHandler {
    public ConfirmSelectUserResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }

    @Override
    public void handle(Object response) {
        /**
         * TODO: Implement ConfirmSelectUserResponseHandler
         */
        deskloUI.confirmSelectUserUI((SelectedUserResponseViewModel) response);
    }
}
