package com.cabanaban.desklo.controller.responses;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.ui.desktop.MainUI;
import com.cabanaban.desklo.presentation.viewmodel.NewUserViewModel;

public class ShowNewUserResponseHandler extends AbstractResponseHandler {
    public ShowNewUserResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }

    @Override
    public void handle(Object response) {
        /**
         * TODO: Implement ShowNewUserResponseHandler
         */
        deskloUI.showNewUserUI((NewUserViewModel) response);
    }
}
