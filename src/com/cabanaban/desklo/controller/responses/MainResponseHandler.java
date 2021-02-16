
package com.cabanaban.desklo.controller.responses;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.viewmodel.MainViewModel;
import com.cabanaban.desklo.presentation.ui.desktop.JFrameUIComponent;
import com.cabanaban.desklo.presentation.ui.desktop.MainUI;

import javax.swing.*;


public class MainResponseHandler extends AbstractResponseHandler {

    
    public MainResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }
 
    
    @Override
    public void handle(Object response) {
        deskloUI.update((MainViewModel) response);
        JFrameUIComponent main = new JFrameUIComponent((JFrame) deskloUI);
        main.display();
    }
    
}
