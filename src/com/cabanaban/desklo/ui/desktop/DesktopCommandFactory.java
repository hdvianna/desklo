
package com.cabanaban.desklo.ui.desktop;

import com.cabanaban.common.Command;
import com.cabanaban.desklo.controller.Controller;
import com.cabanaban.desklo.controller.CommandFactory;
import com.cabanaban.desklo.Services;
import javax.swing.JFrame;

public class DesktopCommandFactory implements CommandFactory {
    
    private DesktopMainAction mainAction;
    
    @Override
    public Command createMainAction(Services services, Object request) {
        if (mainAction == null) {
            mainAction = new DesktopMainAction(services, request);
        }
        return mainAction;
    }

    @Override
    public Command createNotImplementedAction(Services services, Object request) {
        JFrame frame = MainJFrame.getInstance();
        DesktopNotImplementedAction action = new DesktopNotImplementedAction(services, request, frame);
        return action;
    }
    
}
