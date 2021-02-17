package com.cabanaban.desklo.controller.responses;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.ui.desktop.MainUI;
import com.cabanaban.desklo.presentation.viewmodel.SelectUserViewModel;

public class ShowSelectUserResponseHandler extends AbstractResponseHandler {
    public ShowSelectUserResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }

    @Override
    public void handle(Object response) {
        /**
         * TODO: Implement ShowSelectUserResponseHandler
         */
        deskloUI.showSelectUserUI((SelectUserViewModel) response);
    }
}
