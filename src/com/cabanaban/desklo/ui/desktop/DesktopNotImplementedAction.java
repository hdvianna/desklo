package com.cabanaban.desklo.ui.desktop;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.cabanaban.desklo.Services;

public class DesktopNotImplementedAction extends AbstractDesktopAction {
    
    private JFrame frame;
    
    public DesktopNotImplementedAction(Services services, Object request, JFrame frame) {
        super(services, request);
        this.frame = frame;
    }
    
    @Override
    public void execute() throws Exception{
        if (frame == null) {
            throw new Exception("Ação não implementada");
        } else {
            JOptionPane.showMessageDialog(
                    frame,
                    "Ação não implementada",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
