package com.cabanaban.desklo.ui.desktop;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.ResponseViewModel;
import javax.swing.JOptionPane;

public class NotFoundResponseHandler extends AbstractResponseHandler {

    public NotFoundResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }

    @Override
    public void handle(Object response) {
        ResponseViewModel responseViewModel = (ResponseViewModel) response;
        JOptionPane.showMessageDialog(
                mainUI,
                responseViewModel.response,
                Integer.toString(responseViewModel.status),
                JOptionPane.ERROR_MESSAGE
        );
    }

}
