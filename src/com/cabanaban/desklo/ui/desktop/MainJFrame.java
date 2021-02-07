package com.cabanaban.desklo.ui.desktop;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.KeyEvent;

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
    JMenu menu;
    JMenuItem menuItem;

    public MainJFrame() {
        init();
    }

    private void init() {

        desktop = new JDesktopPane();
        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the first menu.
        menu = new JMenu("A Menu");
        
        menuBar.add(menu);
        menuItem = new JMenuItem("A text-only menu item", KeyEvent.VK_T);
        
        menu.add(menuItem);

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

        SLADashBoardJFrame frame = new SLADashBoardJFrame();
        desktop.add(frame);
        frame.setVisible(true);
        setJMenuBar(menuBar);
        pack();
    }// </editor-fold>                        

}
