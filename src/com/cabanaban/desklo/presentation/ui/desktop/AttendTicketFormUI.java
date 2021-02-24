/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cabanaban.desklo.presentation.ui.desktop;

import com.cabanaban.desklo.Services;
import com.cabanaban.desklo.controller.Action;
import com.cabanaban.desklo.presentation.viewmodel.AttendTicketViewModel;

import java.util.HashMap;

/**
 *
 * @author henrique
 */
public class AttendTicketFormUI extends javax.swing.JPanel {
    
     private Services services;
     private AttendTicketViewModel attendTicketViewModel;
    
    /**
     * Creates new form AttendTicketFormUI
     */
    public AttendTicketFormUI(Services services) {
        super();
        this.services = services;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonOk = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        labelMessage = new javax.swing.JLabel();

        buttonOk.setText("buttonOk");
        buttonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okClick(evt);
            }
        });

        buttonCancel.setText("buttonCancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelClick(evt);
            }
        });

        labelMessage.setText("labelMessage");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancel)))
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(labelMessage)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOk)
                    .addComponent(buttonCancel))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void okClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okClick
        HashMap<String,String> request = new HashMap<>();
        request.put("ticketID", attendTicketViewModel.ticketID);
        services.getDispatcher().dispatch(attendTicketViewModel.okAction, request);

    }//GEN-LAST:event_okClick

    private void cancelClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelClick
        services.getDispatcher().dispatch(attendTicketViewModel.cancelAction, null);
    }//GEN-LAST:event_cancelClick

    public void update(AttendTicketViewModel attendTicketViewModel) {
        this.attendTicketViewModel = attendTicketViewModel;
        labelMessage.setText(attendTicketViewModel.message);
        buttonOk.setText(attendTicketViewModel.okLabel);
        buttonCancel.setText(attendTicketViewModel.canceLabel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonOk;
    private javax.swing.JLabel labelMessage;
    // End of variables declaration//GEN-END:variables
}
