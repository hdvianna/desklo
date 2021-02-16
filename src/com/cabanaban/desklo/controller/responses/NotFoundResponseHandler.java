package com.cabanaban.desklo.controller.responses;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.viewmodel.ResponseViewModel;
import com.cabanaban.desklo.presentation.ui.desktop.MainUI;

import javax.swing.JOptionPane;
import java.awt.*;

public class NotFoundResponseHandler extends AbstractResponseHandler {

    public NotFoundResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }

    @Override
    public void handle(Object response) {
        ResponseViewModel responseViewModel = (ResponseViewModel) response;
        JOptionPane.showMessageDialog(
                (Component) deskloUI,
                responseViewModel.response,
                Integer.toString(responseViewModel.status),
                JOptionPane.ERROR_MESSAGE
        );
    }

}
