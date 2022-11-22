package com.diy.software.gui;

import com.diy.hardware.DoItYourselfStationAR;
import com.diy.simulation.Customer;
import com.diy.software.DoItYourselfStationLogic;

import javax.swing.*;

public class DebitCardSelectionGui extends javax.swing.JFrame {

    private static DoItYourselfStationLogic stationLogic;
    private static Customer customer;
    private static DoItYourselfStationAR station;

    public DebitCardSelectionGui(Customer customer, DoItYourselfStationAR station, DoItYourselfStationLogic stationLogic) {
        initComponents();
        DebitCardSelectionGui.customer = customer;
        DebitCardSelectionGui.station = station;
        DebitCardSelectionGui.stationLogic = stationLogic;

    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        JPanel debitCardSelectionPanel = new JPanel();
        JLabel debitCardInputLabel = new JLabel();
        JPasswordField debitCardtextbox = new JPasswordField();
        JButton twoButton = new JButton();
        JButton oneButton = new JButton();
        JButton threeButton = new JButton();
        JButton fourButton = new JButton();
        JButton fiveButton = new JButton();
        JButton sixButton = new JButton();
        JButton sevenButton = new JButton();
        JButton eightButton = new JButton();
        JButton nineButton = new JButton();
        JButton zeroButton = new JButton();
        JButton enterButton = new JButton();
        // Variables declaration - do not modify
        JButton cancelButton = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        debitCardInputLabel.setText("Please Enter Debit Card Number:");

        debitCardtextbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debitCardtextbox(evt);
            }
        });

        twoButton.setText("2");
        twoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twoButtonActionPerformed(evt);
            }
        });

        oneButton.setText("1");
        oneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneButtonActionPerformed(evt);
            }
        });

        threeButton.setText("3");
        threeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threeButtonActionPerformed(evt);
            }
        });

        fourButton.setText("4");
        fourButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fourButtonActionPerformed(evt);
            }
        });

        fiveButton.setText("5");
        fiveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveButtonActionPerformed(evt);
            }
        });

        sixButton.setText("6");
        sixButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sixButtonActionPerformed(evt);
            }
        });

        sevenButton.setText("7");
        sevenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sevenButtonActionPerformed(evt);
            }
        });

        eightButton.setText("8");
        eightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightButtonActionPerformed(evt);
            }
        });

        nineButton.setText("9");
        nineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nineButtonActionPerformed(evt);
            }
        });

        zeroButton.setText("0");
        zeroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroButtonActionPerformed(evt);
            }
        });

        enterButton.setText("Enter");
        enterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");

        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout debitCardSelectionPanelLayout = new javax.swing.GroupLayout(debitCardSelectionPanel);
        debitCardSelectionPanel.setLayout(debitCardSelectionPanelLayout);
        debitCardSelectionPanelLayout.setHorizontalGroup(
                debitCardSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(debitCardSelectionPanelLayout.createSequentialGroup()
                                .addGroup(debitCardSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(debitCardSelectionPanelLayout.createSequentialGroup()
                                                .addGap(79, 79, 79)
                                                .addComponent(debitCardInputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(debitCardSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(debitCardSelectionPanelLayout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(debitCardtextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, debitCardSelectionPanelLayout.createSequentialGroup()
                                                        .addGap(148, 148, 148)
                                                        .addGroup(debitCardSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(sevenButton)
                                                                .addComponent(fourButton)
                                                                .addComponent(oneButton))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(debitCardSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(debitCardSelectionPanelLayout.createSequentialGroup()
                                                                        .addComponent(twoButton)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(threeButton))
                                                                .addGroup(debitCardSelectionPanelLayout.createSequentialGroup()
                                                                        .addGroup(debitCardSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(eightButton)
                                                                                .addComponent(fiveButton)
                                                                                .addComponent(zeroButton))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(debitCardSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(sixButton)
                                                                                .addComponent(nineButton)))))))
                                .addContainerGap(68, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, debitCardSelectionPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(cancelButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(enterButton)
                                .addGap(30, 30, 30))
        );
        debitCardSelectionPanelLayout.setVerticalGroup(
                debitCardSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(debitCardSelectionPanelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(debitCardInputLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(debitCardtextbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(debitCardSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(twoButton)
                                        .addComponent(oneButton)
                                        .addComponent(threeButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(debitCardSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fourButton)
                                        .addComponent(fiveButton)
                                        .addComponent(sixButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(debitCardSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(eightButton)
                                        .addComponent(nineButton)
                                        .addComponent(sevenButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(zeroButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addGroup(debitCardSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(enterButton)
                                        .addComponent(cancelButton))
                                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(debitCardSelectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(debitCardSelectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void zeroButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Irish connect buttons to actually do something
        //could also connect the password box to the numbers so password stuff appears
    }

    private void nineButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Irish connect buttons to actually do something
        //could also connect the password box to the numbers so password stuff appears
    }

    private void eightButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Irish connect buttons to actually do something
        //could also connect the password box to the numbers so password stuff appears
    }

    private void sevenButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Irish connect buttons to actually do something
        //could also connect the password box to the numbers so password stuff appears
    }

    private void sixButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Irish connect buttons to actually do something
        //could also connect the password box to the numbers so password stuff appears
    }

    private void fiveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Irish connect buttons to actually do something
        //could also connect the password box to the numbers so password stuff appears
    }

    private void fourButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Irish connect buttons to actually do something
        //could also connect the password box to the numbers so password stuff appears
    }

    private void threeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Irish connect buttons to actually do something
        //could also connect the password box to the numbers so password stuff appears
    }

    private void twoButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Irish connect buttons to actually do something
        //could also connect the password box to the numbers so password stuff appears
    }

    private void oneButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Irish connect buttons to actually do something
        //could also connect the password box to the numbers so password stuff appears
    }


    private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO: Check to see if card was accepted and if correct then call the code featured below
        DebitCardInputGui gui = new DebitCardInputGui(customer, station, stationLogic);
        gui.setVisible(true);
        this.setVisible(false);
        /*IF cash was not correct, error message gui call is:
        PaymentErrorGui gui = new PaymentErrorGui(customer,station,stationLogic);
        gui.setVisible(true);
         */
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    private void debitCardtextbox(java.awt.event.ActionEvent evt) {
        // TODO: connect the buttons here
    }






}
//sourced from netbeans
