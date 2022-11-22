package com.diy.software.gui;
import com.diy.hardware.DoItYourselfStationAR;
import com.diy.simulation.Customer;
import com.diy.software.DoItYourselfStationLogic;

import java.awt.*;

public class PaymentErrorGui extends javax.swing.JFrame {

    private DoItYourselfStationLogic stationLogic;
    private Customer customer;
    private DoItYourselfStationAR station;

    public PaymentErrorGui(Customer customer, DoItYourselfStationAR station, DoItYourselfStationLogic stationLogic) {
        initComponents();
        this.stationLogic = stationLogic;
        this.customer = customer;
        this.station = station;
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        javax.swing.JPanel cardErrorPanel = new javax.swing.JPanel();
        javax.swing.JLabel errorLabel = new javax.swing.JLabel();
        javax.swing.JLabel cancelLabel = new javax.swing.JLabel();
        javax.swing.JButton cancelButton = new javax.swing.JButton();

        //This is commented so that it doesn't exit all code if you close this panel
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        errorLabel.setText("ERROR: There was an issue with your payment.");

        errorLabel.setForeground(Color.red);

        cancelLabel.setText("Press the \"X\" to try another payment method or press below to cancel transaction.");

        cancelButton.setText("Cancel Transaction");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cardErrorPanelLayout = new javax.swing.GroupLayout(cardErrorPanel);
        cardErrorPanel.setLayout(cardErrorPanelLayout);
        cardErrorPanelLayout.setHorizontalGroup(
                cardErrorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cardErrorPanelLayout.createSequentialGroup()
                                .addGroup(cardErrorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(cardErrorPanelLayout.createSequentialGroup()
                                                .addGap(73, 73, 73)
                                                .addComponent(cancelLabel))
                                        .addGroup(cardErrorPanelLayout.createSequentialGroup()
                                                .addGap(142, 142, 142)
                                                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(cardErrorPanelLayout.createSequentialGroup()
                                                .addGap(192, 192, 192)
                                                .addComponent(cancelButton)))
                                .addContainerGap(95, Short.MAX_VALUE))
        );
        cardErrorPanelLayout.setVerticalGroup(
                cardErrorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cardErrorPanelLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelLabel)
                                .addGap(36, 36, 36)
                                .addComponent(cancelButton)
                                .addContainerGap(106, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cardErrorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(cardErrorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        WelcomeScreenGui gui = new WelcomeScreenGui(customer, station, stationLogic);
        gui.setVisible(true);
        this.setVisible(false);
    }


    // sourced from netbeans
}

