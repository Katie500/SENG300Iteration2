package com.diy.software.gui;

import com.diy.hardware.DoItYourselfStationAR;
import com.diy.simulation.Customer;
import com.diy.software.DoItYourselfStationLogic;
import com.diy.software.controllers.MembershipController;

import java.util.ArrayList;
import java.util.List;

public class MembershipScreenGui extends javax.swing.JFrame {

    private static DoItYourselfStationLogic stationLogic;
    private static Customer customer;
    private static DoItYourselfStationAR station;
    private ArrayList<Integer> memberPin = new ArrayList<Integer>();
    private javax.swing.JPasswordField passwordPINtextbox = new javax.swing.JPasswordField();
    private MembershipController membershipController = new MembershipController();


    public MembershipScreenGui(Customer customer, DoItYourselfStationAR station, DoItYourselfStationLogic stationLogic) {
        initComponents();
        MembershipScreenGui.customer = customer;
        MembershipScreenGui.station = station;
        MembershipScreenGui.stationLogic = stationLogic;

    }

    private String convertMembershipToString(ArrayList<Integer> list)
    {
        StringBuilder memString = new StringBuilder(list.size());
        for(Integer number: list)
        {
            memString.append(number);
        }
        return memString.toString();
    }

        @SuppressWarnings("unchecked")

        private void initComponents() {

            javax.swing.JPanel membershipNumberPanel = new javax.swing.JPanel();
            javax.swing.JLabel membershipLabel = new javax.swing.JLabel();
            javax.swing.JButton twoButton = new javax.swing.JButton();
            javax.swing.JButton oneButton = new javax.swing.JButton();
            javax.swing.JButton threeButton = new javax.swing.JButton();
            javax.swing.JButton fourButton = new javax.swing.JButton();
            javax.swing.JButton fiveButton = new javax.swing.JButton();
            javax.swing.JButton sixButton = new javax.swing.JButton();
            javax.swing.JButton sevenButton = new javax.swing.JButton();
            javax.swing.JButton eightButton = new javax.swing.JButton();
            javax.swing.JButton nineButton = new javax.swing.JButton();
            javax.swing.JButton zeroButton = new javax.swing.JButton();
            javax.swing.JButton enterButton = new javax.swing.JButton();
            javax.swing.JButton cancelButton = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            //Create Memberships
            membershipController.insertMember("73", "John Willard", 2012, "January", 23);
            membershipController.insertMember("33", "Edwardo Saville", 2003, "December", 25);
            membershipController.insertMember("28", "Samantha Rowler", 2021, "August", 3);
            membershipController.insertMember("10", "Jerome Walker", 2009, "April", 15);

            membershipLabel.setText("Please Enter Membership Number:");

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

            javax.swing.GroupLayout membershipNumberPanelLayout = new javax.swing.GroupLayout(membershipNumberPanel);
            membershipNumberPanel.setLayout(membershipNumberPanelLayout);
            membershipNumberPanelLayout.setHorizontalGroup(
                    membershipNumberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(membershipNumberPanelLayout.createSequentialGroup()
                                    .addGroup(membershipNumberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(membershipNumberPanelLayout.createSequentialGroup()
                                                    .addGroup(membershipNumberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(membershipNumberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, membershipNumberPanelLayout.createSequentialGroup()
                                                                            .addGap(148, 148, 148)
                                                                            .addGroup(membershipNumberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                    .addComponent(sevenButton)
                                                                                    .addComponent(fourButton)
                                                                                    .addComponent(oneButton))
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addGroup(membershipNumberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                    .addGroup(membershipNumberPanelLayout.createSequentialGroup()
                                                                                            .addComponent(twoButton)
                                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                            .addComponent(threeButton))
                                                                                    .addGroup(membershipNumberPanelLayout.createSequentialGroup()
                                                                                            .addGroup(membershipNumberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                    .addComponent(eightButton)
                                                                                                    .addComponent(fiveButton)
                                                                                                    .addComponent(zeroButton))
                                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                            .addGroup(membershipNumberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                    .addComponent(sixButton)
                                                                                                    .addComponent(nineButton)))))
                                                                    .addGroup(membershipNumberPanelLayout.createSequentialGroup()
                                                                            .addContainerGap()
                                                                            .addComponent(passwordPINtextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addGroup(membershipNumberPanelLayout.createSequentialGroup()
                                                                    .addGap(93, 93, 93)
                                                                    .addComponent(membershipLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGap(0, 97, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, membershipNumberPanelLayout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(cancelButton)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(enterButton)))
                                    .addContainerGap())
            );
            membershipNumberPanelLayout.setVerticalGroup(
                    membershipNumberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(membershipNumberPanelLayout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addComponent(membershipLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(passwordPINtextbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(membershipNumberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(twoButton)
                                            .addComponent(oneButton)
                                            .addComponent(threeButton))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(membershipNumberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(fourButton)
                                            .addComponent(fiveButton)
                                            .addComponent(sixButton))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(membershipNumberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(eightButton)
                                            .addComponent(nineButton)
                                            .addComponent(sevenButton))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(zeroButton)
                                    .addGap(32, 32, 32)
                                    .addGroup(membershipNumberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(enterButton)
                                            .addComponent(cancelButton))
                                    .addContainerGap(55, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(membershipNumberPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addContainerGap())
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(membershipNumberPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
        }

        private void twoButtonActionPerformed(java.awt.event.ActionEvent evt) {
            memberPin.add(2);
            passwordPINtextbox.setText(convertMembershipToString(memberPin));
            System.out.println(convertMembershipToString(memberPin));
        }

        private void oneButtonActionPerformed(java.awt.event.ActionEvent evt) {
            memberPin.add(1);
            passwordPINtextbox.setText(convertMembershipToString(memberPin));
            System.out.println(convertMembershipToString(memberPin));
        }

        private void threeButtonActionPerformed(java.awt.event.ActionEvent evt) {
            memberPin.add(3);
            passwordPINtextbox.setText(convertMembershipToString(memberPin));
            System.out.println(convertMembershipToString(memberPin));
        }

        private void fourButtonActionPerformed(java.awt.event.ActionEvent evt) {
            memberPin.add(4);
            passwordPINtextbox.setText(convertMembershipToString(memberPin));
            System.out.println(convertMembershipToString(memberPin));
        }

        private void fiveButtonActionPerformed(java.awt.event.ActionEvent evt) {
            memberPin.add(5);
            passwordPINtextbox.setText(convertMembershipToString(memberPin));
            System.out.println(convertMembershipToString(memberPin));
        }

        private void sixButtonActionPerformed(java.awt.event.ActionEvent evt) {
            memberPin.add(6);
            passwordPINtextbox.setText(convertMembershipToString(memberPin));
            System.out.println(convertMembershipToString(memberPin));
        }

        private void sevenButtonActionPerformed(java.awt.event.ActionEvent evt) {
            memberPin.add(7);
            passwordPINtextbox.setText(convertMembershipToString(memberPin));
            System.out.println(convertMembershipToString(memberPin));
        }

        private void eightButtonActionPerformed(java.awt.event.ActionEvent evt) {
            memberPin.add(8);
            passwordPINtextbox.setText(convertMembershipToString(memberPin));
            System.out.println(convertMembershipToString(memberPin));
        }

        private void nineButtonActionPerformed(java.awt.event.ActionEvent evt) {
            memberPin.add(9);
            passwordPINtextbox.setText(convertMembershipToString(memberPin));
            System.out.println(convertMembershipToString(memberPin));
        }

        private void zeroButtonActionPerformed(java.awt.event.ActionEvent evt) {
            memberPin.add(0);
            passwordPINtextbox.setText(convertMembershipToString(memberPin));
            System.out.println(convertMembershipToString(memberPin));
        }

        private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO: store membership number someplace awesome so we can find it later
            if(membershipController.verifyMembership(convertMembershipToString(memberPin)) == 1){
                System.out.println("Valid Membership");
            }
            else{
                System.out.println("invalid Membership");
            }
            this.setVisible(false);
        }

        private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO: disregard whatever input was inputted
            memberPin.clear();
            this.setVisible(false);
        }

        private void passwordPINtextboxActionPerformed(java.awt.event.ActionEvent evt) {
            System.out.println("Change");
            // TODO: Ifeanyi connect buttons to show up here maybe (?)
        }






}
//sourced from netbeans
