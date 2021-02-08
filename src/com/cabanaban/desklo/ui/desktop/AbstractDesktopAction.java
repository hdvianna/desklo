
package com.cabanaban.desklo.ui.desktop;

import com.cabanaban.common.Command;
import com.cabanaban.desklo.Services;

abstract public class AbstractDesktopAction implements Command {
    
    /**
     *
     */
    protected Services services;
    protected Object request;
    
    public AbstractDesktopAction(Services services, Object request)  {
        this.services = services;
        updateRequest(request);
    }
    
    public final void updateRequest(Object request) {
        this.request = request;
    }
    
}
