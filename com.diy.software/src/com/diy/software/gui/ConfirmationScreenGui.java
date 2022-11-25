package com.diy.software.gui;

import com.diy.hardware.DoItYourselfStationAR;
import com.diy.simulation.Customer;
import com.diy.software.DoItYourselfStationLogic;
import com.diy.software.controllers.MembershipController;

import javax.swing.*;


public class ConfirmationScreenGui extends javax.swing.JFrame {

    private static DoItYourselfStationLogic stationLogic;
    private static Customer customer;
    private static DoItYourselfStationAR station;
    private static boolean bool;
    private static long total;


    public ConfirmationScreenGui(Customer customer, DoItYourselfStationAR station, DoItYourselfStationLogic stationLogic, boolean bool) {
        total = stationLogic.productController.getTotal();
    	initComponents();
        ConfirmationScreenGui.customer = customer;
        ConfirmationScreenGui.station = station;
        ConfirmationScreenGui.stationLogic = stationLogic;
        ConfirmationScreenGui.bool = bool;
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {


        JPanel confirmationScreenPanel = new JPanel();
        JButton printReceiptButton = new JButton();
        JButton scanMoreItemsButton = new JButton();
        JButton endSessionButton = new JButton();
        JLabel thanksForShoppingLabel = new JLabel();
        JLabel totalPaidLabel = new JLabel();
        JLabel changeReturnedLabel = new JLabel();


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

        if(bool){
            totalPaidLabel.setVisible(false);
            changeReturnedLabel.setVisible(false);
        }
        
        totalPaidLabel.setText("Total Paid: $" + total);

        changeReturnedLabel.setText("Change Returned: $0.0");


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
                                .addContainerGap(71, Short.MAX_VALUE)
                                .addGroup(confirmationScreenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, confirmationScreenPanelLayout.createSequentialGroup()
                                                .addComponent(totalPaidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(67, 67, 67)
                                                .addComponent(changeReturnedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(24, 24, 24))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, confirmationScreenPanelLayout.createSequentialGroup()
                                                .addComponent(thanksForShoppingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(111, 111, 111))))
        );
        confirmationScreenPanelLayout.setVerticalGroup(
                confirmationScreenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(confirmationScreenPanelLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(thanksForShoppingLabel)
                                .addGap(35, 35, 35)
                                .addComponent(printReceiptButton)
                                .addGap(18, 18, 18)
                                .addComponent(scanMoreItemsButton)
                                .addGap(18, 18, 18)
                                .addComponent(endSessionButton)
                                .addGap(30, 30, 30)
                                .addGroup(confirmationScreenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(changeReturnedLabel)
                                        .addComponent(totalPaidLabel))
                                .addContainerGap(54, Short.MAX_VALUE))
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
        WelcomeScreenGui welcomegui = new WelcomeScreenGui(customer, station, stationLogic);
        welcomegui.setVisible(true);
        this.setVisible(false);
        //TODO: Figure out how to launch new clean checkout station
    }

    private void scanMoreItemsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Figure out how to clear the screen but keep membership number on file
    	stationLogic.productController.resetTotal();
        //this changes the label of checkoutsttion to member's name
        //CheckoutStationGui.welcomeLabelTop.setText("Welcome " + MembershipController.getName(convertMembershipToString(memberPin)) + "!");
        CheckoutStationGui newcheckoutgui = new CheckoutStationGui(customer, station, stationLogic);
        newcheckoutgui.setVisible(true);
        this.setVisible(false);
        //TODO: Figure out how to launch new clean checkout station
    }

    private void endSessionButtonActionPerformed(java.awt.event.ActionEvent evt) {
        WelcomeScreenGui welcomegui2 = new WelcomeScreenGui(customer, station, stationLogic);
        welcomegui2.setVisible(true);
        this.setVisible(false);
        //make membership button visible again
        CheckoutStationGui.membershipConfirmed = (false);
        //TODO: Figure out how to launch new clean checkout station
    }




}

//sourced from netbeans
