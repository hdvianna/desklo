package com.cabanaban.desklo.ui.desktop;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.cabanaban.desklo.controller.ActionDispatcher;
import com.cabanaban.desklo.viewmodel.MainViewModel;
import com.cabanaban.desklo.viewmodel.MenuViewModel;


/**
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/group.html
 * https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html
 * https://docs.oracle.com/javase/tutorial/uiswing/components/internalframe.html
 * 
 * @author henrique
 */
public class MainJFrame extends javax.swing.JFrame {

    private JDesktopPane desktop;
    private JMenuBar menuBar;
    private final MainViewModel mainViewModel;
    private ActionDispatcher dispatcher;
    private static MainJFrame instance = null; 
    

    private MainJFrame(ActionDispatcher dispatcher, MainViewModel mainViewModel) {
        super(mainViewModel.title);
        this.mainViewModel = mainViewModel;
        this.dispatcher = dispatcher;
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
        appendMenuItems(menuBar, this.mainViewModel.menusViewModel, true);        
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
                        dispatcher.dispatch(menuViewModel.action, null);
                    }
                });
            }            
            parentMenu.add(menuItem);
            appendMenuItems(menuItem, menuViewModel.subItems, false); 
        }
    }
    
    public static MainJFrame getInstance(ActionDispatcher dispatcher, MainViewModel mainViewModel) {
        if (MainJFrame.instance == null) {
            MainJFrame.instance = new MainJFrame(dispatcher, mainViewModel);
        }
        return MainJFrame.instance;
    }
    
    public static MainJFrame getInstance() {
        return MainJFrame.instance;
    }

}
