
package com.cabanaban.desklo.ui.desktop;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.viewmodel.MainViewModel;


public class MainResponseHandler extends AbstractResponseHandler {

    
    public MainResponseHandler(Services services) {
        super(services);
    }    
    
    
    @Override
    public void handle(Object response) {
        MainUI mainFrame =  MainUI.getInstance(services, (MainViewModel) response);
        JFrameUIComponent main = new JFrameUIComponent(mainFrame);
        main.display();
    }
    
}
