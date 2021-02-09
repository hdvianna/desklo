
package com.cabanaban.desklo.ui.desktop;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.viewmodel.ResponseViewModel;
import javax.swing.JOptionPane;

public class NotFoundResponseHandler extends AbstractResponseHandler {

    public NotFoundResponseHandler(Services services) {
        super(services);
    }
    
    
    @Override
    public void handle(Object response) {
        ResponseViewModel responseViewModel = (ResponseViewModel) response;
        MainJFrame mainFrame =  MainJFrame.getInstance();
        JOptionPane.showMessageDialog(
                mainFrame,
                responseViewModel.response,
                Integer.toString(responseViewModel.status),
                JOptionPane.ERROR_MESSAGE
        );
    }
    
}
