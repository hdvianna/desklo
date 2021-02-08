
package com.cabanaban.desklo.ui.desktop;

import com.cabanaban.common.Command;
import com.cabanaban.desklo.controller.CommandFactory;
import com.cabanaban.desklo.domain.Support;
import com.cabanaban.desklo.repository.UserRepository;
import com.cabanaban.desklo.repository.TicketRepository;
import com.cabanaban.desklo.viewmodel.Presenter;

public class DesktopCommandFactory implements CommandFactory {
    
    private DesktopMainAction mainAction;
    
    @Override
    public Command createMainAction(Object request) {
        if (mainAction == null) {
            mainAction = new DesktopMainAction(request);
        }
        return mainAction;
    }
    
}
