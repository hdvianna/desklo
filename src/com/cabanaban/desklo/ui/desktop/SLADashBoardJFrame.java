
package com.cabanaban.desklo.ui.desktop;

public class SLADashBoardJFrame extends javax.swing.JInternalFrame {
    
    public SLADashBoardJFrame() {
        super("Document #", 
              true, //resizable
              true, //closable
              true, //maximizable
              true);
        init();
    }

    private void init() {
              
        setSize(300,300);

        setLocation(0, 0);
    }
}
