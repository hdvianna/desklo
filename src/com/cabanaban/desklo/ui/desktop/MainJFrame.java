package com.cabanaban.desklo.ui.desktop;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComponent;
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

    JDesktopPane desktop;
    JMenuBar menuBar;
    MainViewModel mainViewModel;

    public MainJFrame(MainViewModel mainViewModel) {
        super(mainViewModel.title);
        this.mainViewModel = mainViewModel;
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

        //SLADashBoardJFrame frame = new SLADashBoardJFrame();
        //desktop.add(frame);
        //frame.setVisible(true);
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
            }            
            parentMenu.add(menuItem);
            appendMenuItems(menuItem, menuViewModel.subItems, false); 
        }
    }
    
    

}
