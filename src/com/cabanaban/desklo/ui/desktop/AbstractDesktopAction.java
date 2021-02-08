
package com.cabanaban.desklo.ui.desktop;

import com.cabanaban.common.Command;

abstract public class AbstractDesktopAction implements Command {
    
    /**
     *
     */
    protected Object request;
    
    public AbstractDesktopAction(Object request) {
        updateRequest(request);
    }
    
    public final void updateRequest(Object request) {
        this.request = request;
    }
    
}
