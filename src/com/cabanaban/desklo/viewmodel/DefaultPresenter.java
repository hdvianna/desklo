package com.cabanaban.desklo.viewmodel;

import com.cabanaban.desklo.controller.Action;

public class DefaultPresenter implements Presenter {

    private MainViewModel mainViewModel;
    private MenuViewModel userMenu;
    private MenuViewModel supportMenu;    
    
    @Override
    public MainViewModel getMainViewModelInstance() {
        mainViewModel = new MainViewModel();
        mainViewModel.title = "Cabanaban Desklo - Seu gerenciador de tikets de suporte!";
        mainViewModel.menusViewModel = new MenuViewModel[2];
        mainViewModel.menusViewModel[0] = getUserMenuViewModelInstance();
        mainViewModel.menusViewModel[1] = getSupportMenuViewModelInstance();
        return mainViewModel;
    }

    @Override
    public MenuViewModel getUserMenuViewModelInstance() {
        if (userMenu == null) {
            userMenu = new MenuViewModel();
            userMenu.description = "Usuário";
            userMenu.action = Action.NOP;
            userMenu.subItems = new MenuViewModel[2];
            userMenu.subItems[0] = new MenuViewModel();
            userMenu.subItems[0].action = Action.SHOW_OPEN_TICKET;
            userMenu.subItems[0].description = "Abrir ticket";
            userMenu.subItems[0].subItems = new MenuViewModel[0];
            userMenu.subItems[1] = new MenuViewModel();
            userMenu.subItems[1].action = Action.SHOW_OWN_TICKETS;
            userMenu.subItems[1].description = "Ver meus tickets";
            userMenu.subItems[1].subItems = new MenuViewModel[0];
        }
        return userMenu;
    }

    @Override
    public MenuViewModel getSupportMenuViewModelInstance() {
        if (supportMenu == null) {
            supportMenu = new MenuViewModel();
            supportMenu.action = Action.NOP;
            supportMenu.description = "Suporte";
            supportMenu.subItems = new MenuViewModel[3];
            supportMenu.subItems[0] = new MenuViewModel();
            supportMenu.subItems[0].action = Action.SHOW_TICKET_DASHBOARD;
            supportMenu.subItems[0].description = "Dashboard";
            supportMenu.subItems[0].subItems = new MenuViewModel[0];
            supportMenu.subItems[1] = new MenuViewModel();
            supportMenu.subItems[1].action = Action.SHOW_MANAGE_TICKETS;
            supportMenu.subItems[1].description = "Gerenciar tickets";
            supportMenu.subItems[1].subItems = new MenuViewModel[0];
            supportMenu.subItems[2] = new MenuViewModel();
            supportMenu.subItems[2].action = Action.SHOW_MANAGE_USERS;
            supportMenu.subItems[2].description = "Gerenciar usuários";
            supportMenu.subItems[2].subItems = new MenuViewModel[0];
        }
        return supportMenu;
    }

}
