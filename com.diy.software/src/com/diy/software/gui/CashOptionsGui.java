package com.diy.software.gui;


import com.diy.hardware.DoItYourselfStationAR;
import com.diy.simulation.Customer;
import com.diy.software.DoItYourselfStationLogic;
import javax.swing.*;

public class CashOptionsGui extends javax.swing.JFrame {

    private DoItYourselfStationLogic stationLogic;
    private DoItYourselfStationAR station;
    private Customer customer;

    private boolean cashSelected;


    public CashOptionsGui(Customer customer, DoItYourselfStationAR station, DoItYourselfStationLogic stationLogic, boolean cashSelected) {
        initComponents();
        this.stationLogic = stationLogic;
        this.customer = customer;
        this.station = station;
        this.cashSelected = cashSelected;
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        javax.swing.JPanel cashOptionsPanel = new javax.swing.JPanel();
        javax.swing.JLabel insertCashLabel = new javax.swing.JLabel();
        javax.swing.JLabel bankNotesLabel = new javax.swing.JLabel();
        javax.swing.JLabel coinsLabel = new javax.swing.JLabel();
        javax.swing.JButton fiveDollaButton = new javax.swing.JButton();
        javax.swing.JButton tenDollaButton = new javax.swing.JButton();
        javax.swing.JButton twentyDollaButton = new javax.swing.JButton();
        javax.swing.JButton fiftyDollaButton = new javax.swing.JButton();
        javax.swing.JButton hunnerDollaButton = new javax.swing.JButton();
        javax.swing.JButton oneCentButton = new javax.swing.JButton();
        javax.swing.JButton fiveCentButton = new javax.swing.JButton();
        javax.swing.JButton tenCentButton = new javax.swing.JButton();
        javax.swing.JButton twentyfiveCentButton = new javax.swing.JButton();
        javax.swing.JButton oneDollaButton = new javax.swing.JButton();
        javax.swing.JButton twoDollaButton = new javax.swing.JButton();
        javax.swing.JLabel totalinsertedLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        insertCashLabel.setText("Please Insert Your Cash:");

        bankNotesLabel.setText("Bank Notes:");

        coinsLabel.setText("Coins:");

        fiveDollaButton.setText("$5");
        fiveDollaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveDollaButtonActionPerformed(evt);
            }
        });

        tenDollaButton.setText("$10");
        tenDollaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenDollaButtonActionPerformed(evt);
            }
        });

        twentyDollaButton.setText("$20");
        twentyDollaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twentyDollaButtonActionPerformed(evt);
            }
        });

        fiftyDollaButton.setText("$50");
        fiftyDollaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiftyDollaButtonActionPerformed(evt);
            }
        });

        hunnerDollaButton.setText("$100");
        hunnerDollaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hunnerDollaButtonActionPerformed(evt);
            }
        });

        oneCentButton.setText("$0.01");
        oneCentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneCentButtonActionPerformed(evt);
            }
        });

        fiveCentButton.setText("$0.05");
        fiveCentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveCentButtonActionPerformed(evt);
            }
        });

        tenCentButton.setText("$0.10");
        tenCentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenCentButtonActionPerformed(evt);
            }
        });

        twentyfiveCentButton.setText("$0.25");
        twentyfiveCentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twentyfiveCentButtonActionPerformed(evt);
            }
        });

        oneDollaButton.setText("$1");
        oneDollaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneDollaButtonActionPerformed(evt);
            }
        });

        twoDollaButton.setText("$2");
        twoDollaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twoDollaButtonActionPerformed(evt);
            }
        });

        totalinsertedLabel.setText("Total Inserted:");

        javax.swing.GroupLayout cashOptionsPanelLayout = new javax.swing.GroupLayout(cashOptionsPanel);
        cashOptionsPanel.setLayout(cashOptionsPanelLayout);
        cashOptionsPanelLayout.setHorizontalGroup(
                cashOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cashOptionsPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(insertCashLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(118, 118, 118))
                        .addGroup(cashOptionsPanelLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(cashOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(cashOptionsPanelLayout.createSequentialGroup()
                                                .addComponent(bankNotesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(coinsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cashOptionsPanelLayout.createSequentialGroup()
                                                .addGroup(cashOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(cashOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(hunnerDollaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(fiftyDollaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                                .addComponent(twentyDollaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                                .addComponent(tenDollaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                                .addComponent(fiveDollaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                                        .addComponent(totalinsertedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(94, 94, 94)
                                                .addGroup(cashOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(fiveCentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(cashOptionsPanelLayout.createSequentialGroup()
                                                                .addGroup(cashOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(oneCentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(twentyfiveCentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(tenCentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(oneDollaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(twoDollaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addGap(58, 58, 58))
        );
        cashOptionsPanelLayout.setVerticalGroup(
                cashOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cashOptionsPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(insertCashLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(cashOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(coinsLabel)
                                        .addComponent(bankNotesLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(cashOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(cashOptionsPanelLayout.createSequentialGroup()
                                                .addComponent(fiveDollaButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tenDollaButton)
                                                .addGap(12, 12, 12)
                                                .addComponent(twentyDollaButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(fiftyDollaButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(hunnerDollaButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(totalinsertedLabel))
                                        .addGroup(cashOptionsPanelLayout.createSequentialGroup()
                                                .addComponent(oneCentButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(fiveCentButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tenCentButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(twentyfiveCentButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(oneDollaButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(twoDollaButton)))
                                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cashOptionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cashOptionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();

        /*
        CONFIRMATION SCREEN CALL FOR AFTER TOTAL IS MET
        ConfirmationScreenGui gui = new ConfirmationScreenGui(customer, station, stationLogic,cashSelected);
        gui.setVisible(true);
        this.setVisible(false);

         */
    }



    private void fiveDollaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void tenDollaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void twentyDollaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void fiftyDollaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void hunnerDollaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void oneCentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void fiveCentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void tenCentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void twentyfiveCentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void oneDollaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void twoDollaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }




}

