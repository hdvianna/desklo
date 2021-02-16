
package com.cabanaban.desklo.presentation.ui.desktop;

import javax.swing.JFrame;

public class JFrameUIComponent implements com.cabanaban.ui.UIComponent{

    private JFrame jframe;
    
    public JFrameUIComponent(JFrame jframe) {
        this.jframe = jframe;
    }
    
    @Override
    public void display() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jframe.setVisible(true);
            }
        });
    }

    @Override
    public void hide() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jframe.setVisible(false);
            }
        });
    }

    
}
