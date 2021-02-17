package com.cabanaban.desklo.controller.responses;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.ui.desktop.MainUI;
import com.cabanaban.desklo.presentation.viewmodel.AttendTicketViewModel;

public class ShowAttendTicketResponseHandler extends AbstractResponseHandler {
    public ShowAttendTicketResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }

    @Override
    public void handle(Object response) {
        deskloUI.showAttendTicketUI((AttendTicketViewModel) response);
    }
}
