package com.cabanaban.desklo.controller.responses;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.ui.desktop.MainUI;
import com.cabanaban.desklo.presentation.viewmodel.EditUserViewModel;

public class ShowEditUserResponseHandler extends AbstractResponseHandler {
    public ShowEditUserResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }

    @Override
    public void handle(Object response) {
        /**
         * TODO: ShowEditUserResponseHandler
         */
        deskloUI.showEditUserUI((EditUserViewModel) response);
    }
}
