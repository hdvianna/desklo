package com.cabanaban.desklo.controller.responses;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.ui.desktop.MainUI;
import com.cabanaban.desklo.presentation.viewmodel.UsersListViewModel;

public class ConfirmNewUserResponseHandler extends AbstractResponseHandler {
    public ConfirmNewUserResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }

    @Override
    public void handle(Object response) {
        deskloUI.confirmNewUserUI((UsersListViewModel) response);
    }
}
