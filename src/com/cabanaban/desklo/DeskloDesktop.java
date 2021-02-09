
package com.cabanaban.desklo;

public class DeskloDesktop {

    public static void main(String[] args) {     
        com.cabanaban.desklo.viewmodel.DefaultPresenter presenter = new com.cabanaban.desklo.viewmodel.DefaultPresenter();
        com.cabanaban.desklo.ui.desktop.DesktopResponseHandlerFactory responseHandlerFactory = new com.cabanaban.desklo.ui.desktop.DesktopResponseHandlerFactory();
        com.cabanaban.desklo.controller.Controller controller = new com.cabanaban.desklo.controller.Controller(null, null, null, presenter, responseHandlerFactory);
        controller.dispatch(controller, com.cabanaban.desklo.controller.Action.SHOW_MAIN, null);
    }
    
}
