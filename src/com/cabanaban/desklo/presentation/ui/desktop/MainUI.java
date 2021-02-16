package com.cabanaban.desklo.presentation.ui.desktop;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.presentation.ui.MainViewModelObserver;
import com.cabanaban.desklo.presentation.viewmodel.*;

/**
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/group.html
 * https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html
 * https://docs.oracle.com/javase/tutorial/uiswing/components/internalframe.html
 * 
 * @author henrique
 */
public class MainUI extends javax.swing.JFrame implements  MainViewModelObserver, com.cabanaban.desklo.presentation.ui.DeskloUI {

    private JDesktopPane desktop;
    private JMenuBar menuBar;
    private MainViewModel mainViewModel;
    private CloseTicketDialogUI closeTicketDialogUI;
    private Services services;
    private static MainUI instance = null;
    private TicketListUI ticketListUI;
    

    public MainUI(Services services) {
        super("");
        this.mainViewModel = mainViewModel;
        this.services = services;
        init();
    }

    private void init() {
        
        desktop = new JDesktopPane();        
        menuBar = createMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1024, Short.MAX_VALUE)
                        .addComponent(desktop)
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 720, Short.MAX_VALUE)
                        .addComponent(desktop)
        );
                
        
        setJMenuBar(menuBar);
        
        
        pack();
       
    }
    
    private JMenuBar createMenuBar() {
        menuBar = new JMenuBar();       
        return menuBar;
    }
    
    private void appendMenuItems(JComponent parentMenu, MenuViewModel[] menusViewModel, boolean isMenu) {
        for(MenuViewModel menuViewModel:menusViewModel) {
            JMenuItem menuItem;
            if (isMenu) {
                menuItem = new JMenu(menuViewModel.description);
            } else {
                menuItem = new JMenuItem(menuViewModel.description);
                menuItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        services.getDispatcher().dispatch(menuViewModel.action, null);
                    }
                });
            }            
            parentMenu.add(menuItem);
            appendMenuItems(menuItem, menuViewModel.subItems, false); 
        }
    }
    
    @Override
    public void update(MainViewModel mainViewModel) {
        this.mainViewModel = mainViewModel;
        appendMenuItems(menuBar, this.mainViewModel.menusViewModel, true); 
        setTitle(mainViewModel.title);
        initInternalWindows();
    }
    
    private void initInternalWindows() {
        ticketListUI = new TicketListUI(services);
        desktop.add(ticketListUI);
    }
    
    @Override
    public void showTicketListUI(TicketListViewModel ticketListViewModel) {
        ticketListUI.update(ticketListViewModel);
        ticketListUI.setVisible(true);
    } 
    
    @Override
    public void showCloseTicketUI(CloseTicketViewModel closeTicketViewModel) {
        closeTicketDialogUI = new CloseTicketDialogUI(this, true, services);
        closeTicketDialogUI.update(closeTicketViewModel);
        closeTicketDialogUI.setLocationRelativeTo(ticketListUI);
        closeTicketDialogUI.setVisible(true);
    }
    
    @Override
    public void cancelCloseTicketUI() {
        closeTicketDialogUI.dispose();
        closeTicketDialogUI = null;
    }
    
    @Override
    public void confirmCloseTicketUI(TicketListViewModel ticketListViewModel) {
        closeTicketDialogUI.dispose();
        closeTicketDialogUI = null;
        ticketListUI.update(ticketListViewModel);
    }

    @Override
    public void showOpenTicketUI(OpenTicketViewModel openTicketViewModel) {
        //TODO: Implement
    }

    @Override
    public void cancelOpenTicketUI() {
        //TODO: Implement
    }

    @Override
    public void confirmOpenTicketUI(TicketListViewModel ticketListViewModel) {
        //TODO: Implement
    }

    @Override
    public void showAttendTicketUI(AttendTicketViewModel attendTicketViewModel) {
        //TODO: Implement
    }

    @Override
    public void cancelAttendTicketUI() {
        //TODO: Implement
    }

    @Override
    public void confirmAttendTicketUI(TicketListViewModel ticketListViewModel) {
        //TODO: Implement
    }

    @Override
    public void showTransferTicketUI(TransferTicketViewModel transferTicketViewModel) {
        //TODO: Implement
    }

    @Override
    public void cancelTransferTicketUI() {
        //TODO: Implement
    }

    @Override
    public void confirmTransferTicketUI(TicketListViewModel ticketListViewModel) {
        //TODO: Implement
    }

    @Override
    public void showMyTicketsUI(MyTicketsViewModel myTicketsViewModel) {
        //TODO: Implement
    }

    @Override
    public void cancelMyTicketsUI() {
        //TODO: Implement
    }

    @Override
    public void showUsersUI(UsersListViewModel usersListViewModel) {
        //TODO: Implement
    }

    @Override
    public void showEditUserUI(EditUserViewModel editUserViewModel) {
        //TODO: Implement
    }

    @Override
    public void cancelEditUserUI() {
        //TODO: Implement
    }

    @Override
    public void confirmEditUserUI(UsersListViewModel usersListViewModel) {
        //TODO: Implement
    }

    @Override
    public void showNewUserUI(NewUserViewModel newUserViewModel) {
        //TODO: Implement
    }

    @Override
    public void cancelNewUserUI() {
        //TODO: Implement
    }

    @Override
    public void confirmNewUserUI(UsersListViewModel usersListViewModel) {
        //TODO: Implement
    }

    public static MainUI getInstance(Services services, MainViewModel mainViewModel) {
        if (MainUI.instance == null) {
            MainUI.instance = new MainUI(services);
        }
        return MainUI.instance;
    }
    
    public static MainUI getInstance() {
        return MainUI.instance;
    }

}
