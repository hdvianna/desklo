package com.cabanaban.desklo.viewmodel;

import com.cabanaban.desklo.controller.Action;
import com.cabanaban.entity.Ticket;
import java.util.List;
import java.util.stream.Collectors;

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
            userMenu.subItems = new MenuViewModel[3];
            userMenu.subItems[0] = new MenuViewModel();
            userMenu.subItems[0].action = Action.SHOW_OPEN_TICKET;
            userMenu.subItems[0].description = "Abrir ticket";
            userMenu.subItems[0].subItems = new MenuViewModel[0];
            userMenu.subItems[1] = new MenuViewModel();
            userMenu.subItems[1].action = Action.SHOW_OWN_TICKETS;
            userMenu.subItems[1].description = "Ver meus tickets";
            userMenu.subItems[1].subItems = new MenuViewModel[0];
            userMenu.subItems[2] = new MenuViewModel();
            userMenu.subItems[2].action = Action.SHOW_SELECT_USER;
            userMenu.subItems[2].description = "Selecionar usuário";
            userMenu.subItems[2].subItems = new MenuViewModel[0];
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

    @Override
    public ResponseViewModel getNotFoundViewModelInstance() {
        ResponseViewModel responseViewModel = new ResponseViewModel();
        responseViewModel.status = 404;
        responseViewModel.response = "Funcionalidade não implementada.";
        return responseViewModel;
    }

    @Override
    public TicketListViewModel createTicketListViewModel(List<Ticket> tickets) {
        TicketListViewModel ticketListViewModel = new TicketListViewModel();
        ticketListViewModel.actionHeaderLabel = "Ações";
        ticketListViewModel.affectUserHeaderLabel = "Usuário afetado";
        ticketListViewModel.elapsedTimeHeaderLabel = "Tempo";
        ticketListViewModel.problemHeaderLabel = "Problema";
        ticketListViewModel.supporterHeaderLabel = "Técnico";
        ticketListViewModel.title = "Tickets em atendimento";
        ticketListViewModel.ticketListItemsViewModel = tickets
               .stream()
               .map(ticket -> createTicketListItemViewModel(ticket))
               .collect(Collectors.toList());
        return ticketListViewModel;
    }

    @Override
    public TicketListItemViewModel createTicketListItemViewModel(Ticket ticket) {
        TicketListItemViewModel ticketListItemViewModel =  new TicketListItemViewModel();
        ticketListItemViewModel.attendActionText = "Atender";
        ticketListItemViewModel.transferActionText = "Transferir";
        ticketListItemViewModel.closeActionText = "Fechar";
        ticketListItemViewModel.affectUserName = ticket.getUser().getName();
        ticketListItemViewModel.elapsedTimeInHours = Long.toString(ticket.getCurrentServiceTimeInHours()) + " horas";
        ticketListItemViewModel.elapsedTimeLabelColor = "#000000";
        if (ticket.isLate()) {
            ticketListItemViewModel.elapsedTimeLabelColor = "#ff0000";
        }
        ticketListItemViewModel.problemDescription = ticket.getProblem();
        if (ticket.getSupport() != null) {
            ticketListItemViewModel.supporterName = ticket.getSupport().getName();
        }        
        ticketListItemViewModel.ticketID = ticket.getID();
        ticketListItemViewModel.attendActionEnabled = ticket.canBeAttended();
        ticketListItemViewModel.closeActionEnabled = ticket.canBeClosed();
        ticketListItemViewModel.transferActionEnabled = ticket.canBeTransfered();
        ticketListItemViewModel.attendActionEnabled = ticket.canBeAttended();
        return ticketListItemViewModel;
    }

    @Override
    public CloseTicketViewModel createCloseTicketViewModel(Ticket ticket) {
        CloseTicketViewModel closeViewModel = new CloseTicketViewModel();
        closeViewModel.okLabel = "Ok";
        closeViewModel.cancelLabel = "Cancelar";
        closeViewModel.durationLabel = "Tempo de atendimento";
        closeViewModel.durationValue = "0";
        closeViewModel.ticketID = ticket.getID();
        closeViewModel.title = "Fechando ticket #" + ticket.getID();
        return closeViewModel;
    }

}
