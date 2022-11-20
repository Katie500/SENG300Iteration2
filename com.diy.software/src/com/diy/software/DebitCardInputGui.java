package com.diy.software;

import com.diy.hardware.DoItYourselfStationAR;
import com.diy.simulation.Customer;

import javax.swing.*;

public class DebitCardInputGui extends javax.swing.JFrame {

    private static DoItYourselfStationLogic stationLogic;
    private static Customer customer;
    private static DoItYourselfStationAR station;

    public DebitCardInputGui(Customer customer, DoItYourselfStationAR station, DoItYourselfStationLogic stationLogic) {
        initComponents();
        DebitCardInputGui.customer = customer;
        DebitCardInputGui.station = station;
        DebitCardInputGui.stationLogic = stationLogic;

    }


        @SuppressWarnings("unchecked")

        private void initComponents() {

            JPanel debitCardInputPanel = new JPanel();
            JLabel debitPINLabel = new JLabel();
            JPasswordField passwordPINtextbox = new JPasswordField();
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

            debitPINLabel.setText("Please Enter PIN for Debit Transactions");

            passwordPINtextbox.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    passwordPINtextboxActionPerformed(evt);
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

            javax.swing.GroupLayout debitCardInputPanelLayout = new javax.swing.GroupLayout(debitCardInputPanel);
            debitCardInputPanel.setLayout(debitCardInputPanelLayout);
            debitCardInputPanelLayout.setHorizontalGroup(
                    debitCardInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(debitCardInputPanelLayout.createSequentialGroup()
                                    .addGroup(debitCardInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(debitCardInputPanelLayout.createSequentialGroup()
                                                    .addGap(79, 79, 79)
                                                    .addComponent(debitPINLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(debitCardInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(debitCardInputPanelLayout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addComponent(passwordPINtextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, debitCardInputPanelLayout.createSequentialGroup()
                                                            .addGap(148, 148, 148)
                                                            .addGroup(debitCardInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(sevenButton)
                                                                    .addComponent(fourButton)
                                                                    .addComponent(oneButton))
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addGroup(debitCardInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addGroup(debitCardInputPanelLayout.createSequentialGroup()
                                                                            .addComponent(twoButton)
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addComponent(threeButton))
                                                                    .addGroup(debitCardInputPanelLayout.createSequentialGroup()
                                                                            .addGroup(debitCardInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                    .addComponent(eightButton)
                                                                                    .addComponent(fiveButton)
                                                                                    .addComponent(zeroButton))
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addGroup(debitCardInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                    .addComponent(sixButton)
                                                                                    .addComponent(nineButton)))))))
                                    .addContainerGap(68, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, debitCardInputPanelLayout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(cancelButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(enterButton)
                                    .addGap(30, 30, 30))
            );
            debitCardInputPanelLayout.setVerticalGroup(
                    debitCardInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(debitCardInputPanelLayout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addComponent(debitPINLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(passwordPINtextbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(debitCardInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(twoButton)
                                            .addComponent(oneButton)
                                            .addComponent(threeButton))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(debitCardInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(fourButton)
                                            .addComponent(fiveButton)
                                            .addComponent(sixButton))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(debitCardInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(eightButton)
                                            .addComponent(nineButton)
                                            .addComponent(sevenButton))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(zeroButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                    .addGroup(debitCardInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                                    .addComponent(debitCardInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addContainerGap())
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(debitCardInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
        }

        private void zeroButtonActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO: Ifeanyi connect buttons to actually do something
            //could also connect the password box to the numbers so password stuff appears
        }

        private void nineButtonActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO: Ifeanyi connect buttons to actually do something
            //could also connect the password box to the numbers so password stuff appears
        }

        private void eightButtonActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO: Ifeanyi connect buttons to actually do something
            //could also connect the password box to the numbers so password stuff appears
        }

        private void sevenButtonActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO: Ifeanyi connect buttons to actually do something
            //could also connect the password box to the numbers so password stuff appears
        }

        private void sixButtonActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO: Ifeanyi connect buttons to actually do something
            //could also connect the password box to the numbers so password stuff appears
        }

        private void fiveButtonActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO: Ifeanyi connect buttons to actually do something
            //could also connect the password box to the numbers so password stuff appears
        }

        private void fourButtonActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO: Ifeanyi connect buttons to actually do something
            //could also connect the password box to the numbers so password stuff appears
        }

        private void threeButtonActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO: Ifeanyi connect buttons to actually do something
            //could also connect the password box to the numbers so password stuff appears
        }

        private void twoButtonActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO: Ifeanyi connect buttons to actually do something
            //could also connect the password box to the numbers so password stuff appears
        }

        private void oneButtonActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO: Ifeanyi connect buttons to actually do something
            //could also connect the password box to the numbers so password stuff appears
        }


        private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {
            //TODO: Check to see if card was accepted and if correct then call the code featured below
            ConfirmationScreenGui gui = new ConfirmationScreenGui(customer, station, stationLogic);
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

        private void passwordPINtextboxActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO: connect the buttons here
        }






}
//sourced from netbeans
