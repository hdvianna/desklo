
package com.cabanaban.desklo;

public class DeskloDesktop {

    public static void main(String[] args) {
        
        com.cabanaban.desklo.viewmodel.DefaultPresenter presenter = new com.cabanaban.desklo.viewmodel.DefaultPresenter ();
        com.cabanaban.desklo.viewmodel.MainViewModel mainViewModel = presenter.getMainViewModelInstance();        
        com.cabanaban.desklo.ui.desktop.MainJFrame mainFrame =  new com.cabanaban.desklo.ui.desktop.MainJFrame(mainViewModel);        
        com.cabanaban.desklo.ui.desktop.JFrameUIComponent main = new com.cabanaban.desklo.ui.desktop.JFrameUIComponent(mainFrame);
        main.display();
    }
    
}
