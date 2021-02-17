package com.cabanaban.desklo.controller.responses;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.ui.desktop.MainUI;
import com.cabanaban.desklo.presentation.viewmodel.UsersListViewModel;

public class ShowUsersListResponseHandler extends AbstractResponseHandler {
    public ShowUsersListResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }

    @Override
    public void handle(Object response) {
        /**
         * TODO: ShowUsersResponseHandler
         */
        deskloUI.showUsersUI((UsersListViewModel) response);
    }
}
