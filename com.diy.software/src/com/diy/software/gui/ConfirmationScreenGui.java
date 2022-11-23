package com.diy.software.gui;

import com.diy.hardware.DoItYourselfStationAR;
import com.diy.simulation.Customer;
import com.diy.software.DoItYourselfStationLogic;

import javax.swing.*;


public class ConfirmationScreenGui extends javax.swing.JFrame {

    private static DoItYourselfStationLogic stationLogic;
    private static Customer customer;
    private static DoItYourselfStationAR station;


    public ConfirmationScreenGui(Customer customer, DoItYourselfStationAR station, DoItYourselfStationLogic stationLogic) {
        initComponents();
        ConfirmationScreenGui.customer = customer;
        ConfirmationScreenGui.station = station;
        ConfirmationScreenGui.stationLogic = stationLogic;

    }

    @SuppressWarnings("unchecked")

    private void initComponents() {


        JPanel confirmationScreenPanel = new JPanel();
        JButton printReceiptButton = new JButton();
        JButton scanMoreItemsButton = new JButton();
        JButton endSessionButton = new JButton();
        JLabel thanksForShoppingLabel = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        printReceiptButton.setText("Print Receipt");
        printReceiptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printReceiptButtonActionPerformed(evt);
            }
        });

        scanMoreItemsButton.setText("Scan More Items");
        scanMoreItemsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanMoreItemsButtonActionPerformed(evt);
            }
        });

        endSessionButton.setText("End Session");
        endSessionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endSessionButtonActionPerformed(evt);
            }
        });

        thanksForShoppingLabel.setText("Thanks For Shopping  With Us!");

        javax.swing.GroupLayout confirmationScreenPanelLayout = new javax.swing.GroupLayout(confirmationScreenPanel);
        confirmationScreenPanel.setLayout(confirmationScreenPanelLayout);
        confirmationScreenPanelLayout.setHorizontalGroup(
                confirmationScreenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(confirmationScreenPanelLayout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addGroup(confirmationScreenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(scanMoreItemsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(printReceiptButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(endSessionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, confirmationScreenPanelLayout.createSequentialGroup()
                                .addContainerGap(114, Short.MAX_VALUE)
                                .addComponent(thanksForShoppingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112))
        );
        confirmationScreenPanelLayout.setVerticalGroup(
                confirmationScreenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(confirmationScreenPanelLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(thanksForShoppingLabel)
                                .addGap(47, 47, 47)
                                .addComponent(printReceiptButton)
                                .addGap(18, 18, 18)
                                .addComponent(scanMoreItemsButton)
                                .addGap(18, 18, 18)
                                .addComponent(endSessionButton)
                                .addContainerGap(100, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(confirmationScreenPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(confirmationScreenPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void printReceiptButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO: Figure out if we need to do something here. Maybe check with hardware to see if a receipt was actually printed
        WelcomeScreenGui gui = new WelcomeScreenGui(customer, station, stationLogic);
        gui.setVisible(true);
        this.setVisible(false);
        //TODO: Figure out how to launch new clean checkout station
    }

    private void scanMoreItemsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Figure out how to clear the screen but keep membership number on file
        CheckoutStationGui gui = new CheckoutStationGui(customer, station, stationLogic);
        gui.setVisible(true);
        this.setVisible(false);
        //TODO: Figure out how to launch new clean checkout station
    }

    private void endSessionButtonActionPerformed(java.awt.event.ActionEvent evt) {
        WelcomeScreenGui gui = new WelcomeScreenGui(customer, station, stationLogic);
        gui.setVisible(true);
        this.setVisible(false);
        //TODO: Figure out how to launch new clean checkout station
    }




}

//sourced from netbeans
