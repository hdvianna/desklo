package com.cabanaban.desklo;

import java.util.LinkedList;
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
import com.cabanaban.desklo.viewmodel.DefaultPresenter;
import com.cabanaban.desklo.controller.Controller;
import com.cabanaban.desklo.controller.Action;
import com.cabanaban.desklo.controller.MainRequestHandler;
import com.cabanaban.desklo.controller.TicketListRequestHandler;
import com.cabanaban.desklo.controller.ShowCloseTicketRequestHandler;
import com.cabanaban.desklo.controller.NotFoundRequestHandler;
import com.cabanaban.desklo.ui.desktop.MainResponseHandler;
import com.cabanaban.desklo.ui.desktop.TicketListResponseHandler;
import com.cabanaban.desklo.ui.desktop.ShowCloseTicketResponseHandler;
import com.cabanaban.desklo.ui.desktop.NotFoundResponseHandler;
import com.cabanaban.desklo.ui.desktop.MainUI;
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

        User user1 = new User("Arthur Nudge", new NationalID("11111111111"), new Phone("991919191"), new EMail("arthur.nudge@example.com"), 24);
        User user2 = new User("Ron Obvious", new NationalID("22222222222"), new Phone("992929292"), new EMail("robvious@example.com"), 24);
        User user3 = new User("Eric Praline", new NationalID("11111111111"), new Phone("991919191"), new EMail("pralineric@example.com"), 24);

        Support support1 = new Support(25, "Lugi Vercotti", new NationalID("17117117133"), new Phone("981818181"), new EMail("verluigi@example.com"), 10);
        Support support2 = new Support(23, "Doug Piranha ", new NationalID("28228228244"), new Phone("982828282"), new EMail("piranha.doug@example.com"), 10);
        Support support3 = new Support(23, "Dinsdale Piranha", new NationalID("38338338355"), new Phone("983838383"), new EMail("din.piranha@example.com"), 10);

        FakeListUserRepository userRepository = new FakeListUserRepository(new LinkedList<User>());
        UsersManager usersManager = new UsersManager(userRepository);
        usersManager.saveUser(user1);
        usersManager.saveUser(user2);
        usersManager.saveUser(user3);
        usersManager.saveUser(support1);
        usersManager.saveUser(support2);
        usersManager.saveUser(support3);

        Ticket ticket1 = new Ticket(user1, "Nudge nudge.");
        Ticket ticket2 = new Ticket(user1, "Enciclopédias com páginas ausentes.");
        Ticket ticket3 = new Ticket(user2, "Não consigo atravessar o canal da mancha.");
        Ticket ticket4 = new Ticket(user3, "Bombons sem crocância suficiente.");
        Ticket ticket5 = new Ticket(user2, "Preciso de ajuda! Acho que quebrei meus dentes ao morder a catedral.");
        ticket5.setStatus(Status.DOING);

        FakeListTicketRepository ticketRespository = new FakeListTicketRepository(new LinkedList<Ticket>());
        TicketsManager ticketsManager = new TicketsManager(ticketRespository);
        ticketsManager.saveTicket(ticket1);
        ticketsManager.saveTicket(ticket2);
        ticketsManager.saveTicket(ticket3);
        ticketsManager.saveTicket(ticket4);
        ticketsManager.saveTicket(ticket4);
        ticketsManager.saveTicket(ticket5);

        CurrentUserManager currentUserManager = new CurrentUserManager(support1, ticketRespository, userRepository);

        DefaultPresenter presenter = new DefaultPresenter();     
        Controller controller = new Controller(userRepository, ticketRespository, currentUserManager, usersManager, ticketsManager, presenter);
        MainUI mainUI = new MainUI(controller);
        controller.addAction(Action.SHOW_MAIN, new MainRequestHandler(controller), new MainResponseHandler(controller, mainUI))
                .addAction(Action.SHOW_MANAGE_TICKETS, new TicketListRequestHandler(controller), new TicketListResponseHandler(controller, mainUI))
                .addAction(Action.SHOW_CLOSE_TICKET, new ShowCloseTicketRequestHandler(controller), new ShowCloseTicketResponseHandler(controller, mainUI))
                .defaultAction(new NotFoundRequestHandler(controller), new NotFoundResponseHandler(controller, mainUI))
                .dispatch(Action.SHOW_MAIN, null);
    }

}
