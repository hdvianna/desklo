package com.cabanaban.desklo.presentation;

import com.cabanaban.desklo.controller.Action;
import com.cabanaban.desklo.presentation.viewmodel.*;
import com.cabanaban.entity.Ticket;
import com.cabanaban.entity.User;

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
            userMenu.subItems[1].action = Action.SHOW_MY_TICKETS;
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
    public TicketListViewModel createTicketListViewModel(List<Ticket> tickets, User user) {
        TicketListViewModel ticketListViewModel = new TicketListViewModel();
        ticketListViewModel.actionHeaderLabel = "Ações";
        ticketListViewModel.affectUserHeaderLabel = "Usuário afetado";
        ticketListViewModel.elapsedTimeHeaderLabel = "Tempo";
        ticketListViewModel.problemHeaderLabel = "Problema";
        ticketListViewModel.supporterHeaderLabel = "Técnico";
        ticketListViewModel.title = "Tickets em atendimento";
        ticketListViewModel.ticketListItemsViewModel = tickets
               .stream()
               .map(ticket -> createTicketListItemViewModel(ticket, user))
               .collect(Collectors.toList());
        return ticketListViewModel;
    }

    @Override
    public TicketListItemViewModel createTicketListItemViewModel(Ticket ticket, User user) {
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
        ticketListItemViewModel.attendActionEnabled = user.canAttendTicket(ticket);
        ticketListItemViewModel.closeActionEnabled = user.canCloseTicket(ticket);
        ticketListItemViewModel.transferActionEnabled = user.canTransferTicket(ticket);
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

    @Override
    public OpenTicketViewModel createOpenTicketViewModel(Ticket ticket) {
        //TODO: Implement createOpenTicketViewModel
        return null;
    }

    @Override
    public MyTicketsViewModel createMyTicketsViewModel(List<Ticket> tickets) {
        //TODO: Implement createMyTicketsViewModel
        return null;
    }

    @Override
    public SelectUserViewModel createSelectUserViewModel(User user) {
        //TODO: Implement createSelectUserViewModel
        return null;
    }

    @Override
    public DashboardViewModel createDashboardViewModel(List<Ticket> tickets) {
        //TODO: Implement createDashboardViewModel
        return null;
    }

    @Override
    public AttendTicketViewModel createAttendTicketViewModel(Ticket ticket) {
        //TODO: Implement createAttendTicketViewModelv
        return null;
    }

    @Override
    public TransferTicketViewModel createTransferTicketViewModel(Ticket ticket) {
        //TODO: Implement createTransferTicketViewModel
        return null;
    }

    @Override
    public UsersListViewModel createUsersListViewModel(List<User> users) {
        //TODO: Implement createUsersListViewModel
        return null;
    }

    @Override
    public EditUserViewModel createEditUserViewModel(User user) {
        //TODO: Implement createEditUserViewModel
        return null;
    }

    @Override
    public NewUserViewModel createNewUserViewModel(User user) {
        //TODO: Implement  createNewUserViewModel
        return null;
    }
}
