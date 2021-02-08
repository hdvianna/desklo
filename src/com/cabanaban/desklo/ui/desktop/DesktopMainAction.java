
package com.cabanaban.desklo.ui.desktop;

import com.cabanaban.desklo.viewmodel.MainViewModel;

public class DesktopMainAction extends AbstractDesktopAction {
    
    private MainJFrame mainFrame;
    private JFrameUIComponent main;
    
    public DesktopMainAction(Object request) {
        super(request);
    }
    
    @Override
    public void execute() {
        MainViewModel mainViewModel = (MainViewModel) request;
        if (mainFrame == null) {
            MainJFrame mainFrame =  new MainJFrame(mainViewModel);
            main = new JFrameUIComponent(mainFrame);
            main.display();
        }
    }
    
}
