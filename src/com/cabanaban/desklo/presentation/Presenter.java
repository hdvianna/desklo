package com.cabanaban.desklo.presentation;

import com.cabanaban.desklo.presentation.viewmodel.*;
import com.cabanaban.entity.Ticket;
import com.cabanaban.entity.User;

import java.util.List;

public interface Presenter {

    public MenuViewModel getUserMenuViewModelInstance();
    public MenuViewModel getSupportMenuViewModelInstance();
    public MainViewModel getMainViewModelInstance();
    public ResponseViewModel getNotFoundViewModelInstance();
    public TicketListViewModel createTicketListViewModel(List<Ticket> tickets, User user);
    public TicketListItemViewModel createTicketListItemViewModel(Ticket ticket, User user);
    public CloseTicketViewModel createCloseTicketViewModel(Ticket ticket);
    public OpenTicketViewModel createOpenTicketViewModel(Ticket ticket);
    public MyTicketsViewModel createMyTicketsViewModel(List<Ticket> tickets);
    public SelectUserViewModel createSelectUserViewModel(User user);
    public DashboardViewModel createDashboardViewModel(List<Ticket> tickets);
    public AttendTicketViewModel createAttendTicketViewModel(Ticket ticket);
    public TransferTicketViewModel createTransferTicketViewModel(Ticket ticket);
    public UsersListViewModel createUsersListViewModel(List<User> users);
    public EditUserViewModel createEditUserViewModel(User user);
    public NewUserViewModel createNewUserViewModel(User user);
    public SelectedUserResponseViewModel createSelectedUserResponseViewModel(List<Ticket> openTickets, List<Ticket> userTickets, User user);
}
