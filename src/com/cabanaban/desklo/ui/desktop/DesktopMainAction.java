
package com.cabanaban.desklo.ui.desktop;

import com.cabanaban.desklo.viewmodel.MainViewModel;
import com.cabanaban.desklo.Services;

public class DesktopMainAction extends AbstractDesktopAction {
    
    private MainJFrame mainFrame;
    private JFrameUIComponent main; 
    
    public DesktopMainAction(Services services, Object request) {
        super(services, request);
    }
    
    @Override
    public void execute() {
        MainViewModel mainViewModel = (MainViewModel) request;
        if (mainFrame == null) {
            MainJFrame mainFrame =  new MainJFrame(services.getDispatcher(), mainViewModel);
            main = new JFrameUIComponent(mainFrame);
            main.display();
        }
    }
    
}
