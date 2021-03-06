package com.cabanaban.desklo;

import java.util.LinkedList;

import com.cabanaban.desklo.controller.requests.*;
import com.cabanaban.desklo.controller.responses.*;
import com.cabanaban.entity.NationalID;
import com.cabanaban.entity.Phone;
import com.cabanaban.entity.EMail;
import com.cabanaban.entity.User;
import com.cabanaban.entity.Support;
import com.cabanaban.entity.Ticket;
import com.cabanaban.entity.Status;
import com.cabanaban.desklo.repository.FakeListUserRepository;
import com.cabanaban.desklo.repository.FakeListTicketRepository;
import com.cabanaban.desklo.domain.UsersManager;
import com.cabanaban.desklo.domain.TicketsManager;
import com.cabanaban.desklo.domain.CurrentUserManager;
import com.cabanaban.desklo.presentation.DefaultPresenter;
import com.cabanaban.desklo.controller.Controller;
import com.cabanaban.desklo.controller.Action;
import com.cabanaban.desklo.controller.responses.MainResponseHandler;
import com.cabanaban.desklo.presentation.ui.desktop.MainUI;
import com.cabanaban.entity.exceptions.InvalidNationaIDContentException;
import com.cabanaban.entity.exceptions.InvalidNationalIDCheckDigitException;
import com.cabanaban.entity.exceptions.InvalidNationalIDLengthException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DeskloDesktop {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeskloDesktop.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DeskloDesktop.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DeskloDesktop.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(DeskloDesktop.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            User user1 = new User("Arthur Nudge", new NationalID("11111111111"), new Phone("991919191"), new EMail("arthur.nudge@example.com"), 24);
            User user2 = new User("Ron Obvious", new NationalID("22222222222"), new Phone("992929292"), new EMail("robvious@example.com"), 24);
            User user3 = new User("Eric Praline", new NationalID("11111111111"), new Phone("991919191"), new EMail("pralineric@example.com"), 24);

            Support support1 = new Support(25, "Lugi Vercotti", new NationalID("17117117133"), new Phone("981818181"), new EMail("verluigi@example.com"), 10);
            Support support2 = new Support(23, "Doug Piranha ", new NationalID("28228228244"), new Phone("982828282"), new EMail("piranha.doug@example.com"), 10);
            Support support3 = new Support(23, "Dinsdale Piranha", new NationalID("39339339355"), new Phone("983838383"), new EMail("din.piranha@example.com"), 10);
            FakeListUserRepository userRepository = new FakeListUserRepository(new LinkedList<User>());
            UsersManager usersManager = new UsersManager(userRepository);
            userRepository.saveUser(user1);
            userRepository.saveUser(user2);
            userRepository.saveUser(user3);
            userRepository.saveUser(support1);
            userRepository.saveUser(support2);
            userRepository.saveUser(support3);

            Ticket ticket1 = new Ticket(user1, "Nudge nudge.");
            Ticket ticket2 = new Ticket(user1, "Enciclopédias com páginas ausentes.");
            Ticket ticket3 = new Ticket(user2, "Não consigo atravessar o canal da mancha.");
            Ticket ticket4 = new Ticket(user3, "Bombons sem crocância suficiente.");
            ticket4.setStatus(Status.DOING);
            ticket4.setSupport(support1);
            Ticket ticket5 = new Ticket(user2, "Preciso de ajuda! Acho que quebrei meus dentes ao morder a catedral.");
            ticket5.setStatus(Status.DOING);
            ticket5.setSupport(support1);

            FakeListTicketRepository ticketRespository = new FakeListTicketRepository(new LinkedList<Ticket>());
            TicketsManager ticketsManager = new TicketsManager(ticketRespository);
            ticketRespository.saveTicket(ticket1);
            ticketRespository.saveTicket(ticket2);
            ticketRespository.saveTicket(ticket3);
            ticketRespository.saveTicket(ticket4);
            ticketRespository.saveTicket(ticket4);
            ticketRespository.saveTicket(ticket5);

            CurrentUserManager currentUserManager = new CurrentUserManager(support1, ticketRespository, userRepository);

            DefaultPresenter presenter = new DefaultPresenter();
            Controller controller = new Controller(currentUserManager, usersManager, ticketsManager, presenter);
            MainUI mainUI = new MainUI(controller);
            controller.addAction(Action.SHOW_MAIN, new MainRequestHandler(controller), new MainResponseHandler(controller, mainUI))
                    .addAction(Action.SHOW_MANAGE_TICKETS, new TicketListRequestHandler(controller), new TicketListResponseHandler(controller, mainUI))
                    .addAction(Action.SHOW_CLOSE_TICKET, new ShowCloseTicketRequestHandler(controller), new ShowCloseTicketResponseHandler(controller, mainUI))
                    .addAction(Action.CANCEL_CLOSE_TICKET, new CancelCloseTicketRequestHandler(controller), new CancelCloseTicketResponseHandler(controller, mainUI))
                    .addAction(Action.CLOSE_TICKET, new ConfirmCloseTicketRequestHandler(controller), new ConfirmCloseTicketResponseHandler(controller, mainUI))
//                .addAction(Action.CANCEL_OPEN_TICKET, new CancelOpenTicketRequestHandler(controller), new CancelOpenTicketResponseHandler(controller, mainUI))
//                .addAction(Action.SHOW_OPEN_TICKET, new ShowOpenTicketRequestHandler(controller), new ShowOpenTicketResponseHandler(controller, mainUI))
//                .addAction(Action.OPEN_TICKET, new ConfirmOpenTicketRequestHandler(controller), new ConfirmOpenTicketResponseHandler(controller, mainUI))
//                .addAction(Action.SHOW_MY_TICKETS, new ShowMyTicketsRequestHandler(controller), new ShowMyTicketsResponseHandler(controller, mainUI))
//                .addAction(Action.CANCEL_MY_TICKETS, new CancelMyTicketsRequestHandler(controller), new CancelMyTicketsResponseHandler(controller, mainUI))
//                .addAction(Action.SHOW_SELECT_USER, new ShowSelectUserRequestHandler(controller), new ShowSelectUserResponseHandler(controller, mainUI))
//                .addAction(Action.CANCEL_SELECT_USER, new CancelSelectUserRequestHandler(controller), new CancelSelectUserResponseHandler(controller, mainUI))
//                .addAction(Action.SELECT_USER, new ConfirmSelectUserRequestHandler(controller), new ConfirmSelectUserResponseHandler(controller, mainUI))
//                .addAction(Action.SHOW_TICKET_DASHBOARD, new ShowDashboardRequestHandler(controller), new ShowDashboardResponseHandler(controller, mainUI))
//                .addAction(Action.CANCEL_TICKET_DASHBOARD, new CancelDashBoardRequestHandler(controller), new CancelDashBoardResponseHandler(controller, mainUI))
                    .addAction(Action.SHOW_ATTEND_TICKET, new ShowAttendTicketRequestHandler(controller), new ShowAttendTicketResponseHandler(controller, mainUI))
//                .addAction(Action.CANCEL_ATTEND_TICKET, new CancelAttendTicketRequestHandler(controller), new CancelAttendTicketResponseHandler(controller, mainUI))
//                .addAction(Action.ATTEND_TICKET, new ConfirmAttendTicketRequestHandler(controller), new ConfirmAttendTicketResponseHandler(controller, mainUI))
                    .addAction(Action.SHOW_TRANSFER_TICKET, new ShowTransferTicketRequestHandler(controller), new ShowTransferTicketResponseHandler(controller, mainUI))
//                .addAction(Action.CANCEL_TRANSFER_TICKET, new CancelTransferTicketRequestHandler(controller), new CancelTransferTicketResponseHandler(controller, mainUI))
//                .addAction(Action.TRANSFER_TICKET, new ConfirmTransferTicketRequestHandler(controller), new ConfirmTransferTicketResponseHandler(controller, mainUI))
//                .addAction(Action.SHOW_MANAGE_USERS, new ShowUsersListRequestHandler(controller), new ShowUsersListResponseHandler(controller, mainUI))
//                .addAction(Action.SHOW_EDIT_USER, new ShowEditUserRequestHandler(controller), new ShowEditUserResponseHandler(controller, mainUI))
//                .addAction(Action.CANCEL_EDIT_USER, new CancelEditUserRequestHandler(controller), new CancelEditUserResponseHandler(controller, mainUI))
//                .addAction(Action.EDIT_USER, new ConfirmEditUserRequestHandler(controller), new ConfirmEditUserResponseHandler(controller, mainUI))
//                .addAction(Action.SHOW_NEW_USER, new ShowNewUserRequestHandler(controller), new ShowNewUserResponseHandler(controller, mainUI))
//                .addAction(Action.CANCEL_NEW_USER, new CancelNewUserRequestHandler(controller), new CancelNewUserResponseHandler(controller, mainUI))
//                .addAction(Action.NEW_USER, new ConfirmNewUserRequestHandler(controller), new ConfirmNewUserResponseHandler(controller, mainUI))
                    .defaultAction(new NotFoundRequestHandler(controller), new NotFoundResponseHandler(controller, mainUI))
                    .dispatch(Action.SHOW_MAIN, null);

        } catch (InvalidNationalIDLengthException e) {
            e.printStackTrace();
        } catch (InvalidNationaIDContentException e) {
            e.printStackTrace();
        } catch (InvalidNationalIDCheckDigitException e) {
            e.printStackTrace();
        }

    }

}
