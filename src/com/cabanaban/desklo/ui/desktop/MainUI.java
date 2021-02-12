package com.cabanaban.desklo.ui.desktop;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.controller.ActionDispatcher;
import com.cabanaban.desklo.viewmodel.MainViewModel;
import com.cabanaban.desklo.viewmodel.MenuViewModel;
import com.cabanaban.desklo.viewmodel.TicketListViewModel;
import com.cabanaban.desklo.viewmodel.TicketListItemViewModel;
import com.cabanaban.desklo.viewmodel.CloseTicketViewModel;
import com.cabanaban.desklo.ui.MainViewModelObserver;

import javax.swing.JButton;
import java.awt.BorderLayout;

/**
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/group.html
 * https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html
 * https://docs.oracle.com/javase/tutorial/uiswing/components/internalframe.html
 * 
 * @author henrique
 */
public class MainUI extends javax.swing.JFrame implements  MainViewModelObserver {

    private JDesktopPane desktop;
    private JMenuBar menuBar;
    private MainViewModel mainViewModel;
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
    
    public void update(MainViewModel mainViewModel) {
        this.mainViewModel = mainViewModel;
        appendMenuItems(menuBar, this.mainViewModel.menusViewModel, true); 
        initInternalWindows();
    }
    
    private void initInternalWindows() {
        ticketListUI = new TicketListUI(services);
        desktop.add(ticketListUI);
    }
    
    public void showTicketListUI(TicketListViewModel ticketListViewModel) {
        ticketListUI.update(ticketListViewModel);
        ticketListUI.setVisible(true);
    } 
    
    public void showCloseTicketUI(CloseTicketViewModel closeTicketViewModel) {
        CloseTicketDialogUI closeTicketDialogUI = new CloseTicketDialogUI(this, true, services);
        closeTicketDialogUI.update(closeTicketViewModel);
        closeTicketDialogUI.setLocationRelativeTo(ticketListUI);
        closeTicketDialogUI.setVisible(true);
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
