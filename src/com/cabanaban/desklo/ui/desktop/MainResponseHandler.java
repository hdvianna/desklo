
package com.cabanaban.desklo.ui.desktop;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.viewmodel.MainViewModel;


public class MainResponseHandler extends AbstractResponseHandler {

    
    public MainResponseHandler(Services services, MainUI mainUI) {
        super(services, mainUI);
    }
 
    
    @Override
    public void handle(Object response) {
        mainUI.update((MainViewModel) response);
        JFrameUIComponent main = new JFrameUIComponent(mainUI);
        main.display();
    }
    
}
