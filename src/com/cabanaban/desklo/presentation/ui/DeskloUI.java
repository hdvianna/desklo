package com.cabanaban.desklo.presentation.ui;

import com.cabanaban.desklo.presentation.viewmodel.*;

public interface DeskloUI {
    void update(MainViewModel mainViewModel);

    void showTicketListUI(TicketListViewModel ticketListViewModel);

    void showCloseTicketUI(CloseTicketViewModel closeTicketViewModel);

    void cancelCloseTicketUI();

    void confirmCloseTicketUI(TicketListViewModel ticketListViewModel);

    void showOpenTicketUI(OpenTicketViewModel openTicketViewModel);

    void cancelOpenTicketUI();

    void confirmOpenTicketUI(TicketListViewModel ticketListViewModel);

    void showAttendTicketUI(AttendTicketViewModel attendTicketViewModel);

    void cancelAttendTicketUI();

    void confirmAttendTicketUI(TicketListViewModel ticketListViewModel);

    void showTransferTicketUI(TransferTicketViewModel transferTicketViewModel);

    void cancelTransferTicketUI();

    void confirmTransferTicketUI(TicketListViewModel ticketListViewModel);

    void showMyTicketsUI(MyTicketsViewModel myTicketsViewModel);

    void cancelMyTicketsUI();

    void showUsersUI(UsersListViewModel usersListViewModel);

    void showEditUserUI(EditUserViewModel editUserViewModel);

    void cancelEditUserUI();

    void confirmEditUserUI(UsersListViewModel usersListViewModel);

    void showNewUserUI(NewUserViewModel newUserViewModel);

    void cancelNewUserUI();

    void confirmNewUserUI(UsersListViewModel usersListViewModel);
}
