
package com.cabanaban.desklo;

public class DeskloDesktop {

    public static void main(String[] args) {        
        com.cabanaban.desklo.viewmodel.DefaultPresenter presenter = new com.cabanaban.desklo.viewmodel.DefaultPresenter();
        com.cabanaban.desklo.ui.desktop.DesktopCommandFactory commandFactory = new com.cabanaban.desklo.ui.desktop.DesktopCommandFactory();
        com.cabanaban.desklo.controller.Controller controller = new com.cabanaban.desklo.controller.Controller(commandFactory);
        controller.dispatch(com.cabanaban.desklo.controller.Action.SHOW_MAIN, presenter.getMainViewModelInstance());
    }
    
}
