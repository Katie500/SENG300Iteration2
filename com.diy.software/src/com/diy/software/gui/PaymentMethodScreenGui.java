package com.diy.software.gui;

import com.diy.hardware.DoItYourselfStationAR;
import com.diy.simulation.Customer;
import com.diy.software.DoItYourselfStationLogic;
import com.diy.software.gui.cardpayment.CreditGui;
import com.diy.software.gui.cardpayment.DebitGui;

import javax.swing.*;
import java.io.IOException;


public class PaymentMethodScreenGui extends javax.swing.JFrame {


    private static DoItYourselfStationLogic stationLogic;
    private static Customer customer;
    private static DoItYourselfStationAR station;


    public PaymentMethodScreenGui(Customer customer, DoItYourselfStationAR station, DoItYourselfStationLogic stationLogic) {
        initComponents();
        PaymentMethodScreenGui.customer = customer;
        PaymentMethodScreenGui.station = station;
        PaymentMethodScreenGui.stationLogic = stationLogic;
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        JPanel payPanel = new JPanel();
        JButton cashButton = new JButton();
        JButton cryptoButton = new JButton();
        JButton creditButton = new JButton();
        JButton debitButton = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cashButton.setText("Pay With Cash");
        cashButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashButtonActionPerformed(evt);
            }
        });

        cryptoButton.setText("Pay With Crypto");
        cryptoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cryptoButtonActionPerformed(evt);
            }
        });

        creditButton.setText("Pay With Credit");
        creditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditButtonActionPerformed(evt);
            }
        });

        debitButton.setText("Pay With Debit");
        debitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout payPanelLayout = new javax.swing.GroupLayout(payPanel);
        payPanel.setLayout(payPanelLayout);
        payPanelLayout.setHorizontalGroup(
                payPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(payPanelLayout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addGroup(payPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cashButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cryptoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(creditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(debitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(110, Short.MAX_VALUE))
        );
        payPanelLayout.setVerticalGroup(
                payPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(payPanelLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(cashButton)
                                .addGap(18, 18, 18)
                                .addComponent(cryptoButton)
                                .addGap(18, 18, 18)
                                .addComponent(creditButton)
                                .addGap(18, 18, 18)
                                .addComponent(debitButton)
                                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(payPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(payPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }

    //TODO: Credit is broken for some reason
    private void creditButtonActionPerformed(java.awt.event.ActionEvent evt) {
        CreditGui gui = new CreditGui(customer, station, stationLogic);
        gui.setVisible(true);
        this.setVisible(false);
    }

    private void cashButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO: Check to see if cash was inserted and if correct then call the code featured below
        ConfirmationScreenGui gui = new ConfirmationScreenGui(customer, station, stationLogic);
        gui.setVisible(true);
        this.setVisible(false);
        /*IF cash was not correct, error message gui call is:
        PaymentErrorGui gui = new PaymentErrorGui(customer,station,stationLogic);
        gui.setVisible(true);
         */
    }

    private void debitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        DebitGui gui = new DebitGui(customer, station, stationLogic);
        gui.setVisible(true);
        this.setVisible(false);
    }
    
    private void cryptoButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO: Check to see if crypto was received and if correct then call the code featured below
        ConfirmationScreenGui gui = new ConfirmationScreenGui(customer, station, stationLogic);
        gui.setVisible(true);
        this.setVisible(false);
        /*IF crypto was not received, error message gui call is:
        PaymentErrorGui gui = new PaymentErrorGui(customer,station,stationLogic);
        gui.setVisible(true);
         */
    }





}


    //sourced from netbeans

