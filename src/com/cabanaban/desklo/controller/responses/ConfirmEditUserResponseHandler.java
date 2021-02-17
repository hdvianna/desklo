package com.cabanaban.desklo.controller.responses;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.ui.desktop.MainUI;
import com.cabanaban.desklo.presentation.viewmodel.UsersListViewModel;

public class ConfirmEditUserResponseHandler extends AbstractResponseHandler {
    public ConfirmEditUserResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }

    @Override
    public void handle(Object response) {
        /**
         * TODO: Implement ConfirmEditUserResponseHandler
         */
        deskloUI.confirmEditUserUI((UsersListViewModel) response);
    }
}
