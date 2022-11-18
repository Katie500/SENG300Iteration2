package com.diy.software;

import com.diy.hardware.DoItYourselfStationAR;
import com.diy.simulation.Customer;

import javax.swing.*;
import java.util.List;
import java.util.NoSuchElementException;

public class CheckoutStationGui extends javax.swing.JFrame{
        private DoItYourselfStationLogic stationLogic;
        private Customer customer;
        private DoItYourselfStationAR station;
          JPanel checkoutPanel = new JPanel();
        JLabel welcomeLabelTop = new JLabel();
        JButton addOwnBagsButton = new JButton();
        JButton selectLanguageButton = new JButton();
        JButton payButton = new JButton();
        JScrollPane jScrollPane1 = new JScrollPane();
        JList<String> itemList = new JList<>();
        JButton callAttendantButton = new JButton();
        JButton scanItemButton = new JButton();



        public CheckoutStationGui(Customer customer, DoItYourselfStationAR station, DoItYourselfStationLogic stationLogic) {
            this.stationLogic = stationLogic;
            this.customer = customer;
            this.station = station;
            initCheckoutStationGui();
        }


        private void initCheckoutStationGui() {
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            welcomeLabelTop.setText("Welcome to Checkout. Please scan items.");

            addOwnBagsButton.setText("Add Own Bags");

            selectLanguageButton.setText("Select Language");

            payButton.setText("Pay");

            payButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    payButtonActionPerformed(evt);
                }
            });

            itemList.setModel(new javax.swing.AbstractListModel<String>() {

                List<String> strings = stationLogic.productController.getScanned().stream().map(p -> p.getDescription()).toList();
                public int getSize() { return strings.size(); }
                public String getElementAt(int i) { return strings.get(i); }
            });
            jScrollPane1.setViewportView(itemList);

            callAttendantButton.setText("Call Attendant");
            callAttendantButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    callAttendantButtonActionPerformed(evt);
                }

            });

            scanItemButton.setText("Scan Item");
            scanItemButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    scanItemButtonActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout checkoutPanelLayout = new javax.swing.GroupLayout(checkoutPanel);
            checkoutPanel.setLayout(checkoutPanelLayout);
            checkoutPanelLayout.setHorizontalGroup(
                    checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(checkoutPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checkoutPanelLayout.createSequentialGroup()
                                                    .addComponent(callAttendantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                                                    .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(scanItemButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(selectLanguageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(addOwnBagsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(payButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(checkoutPanelLayout.createSequentialGroup()
                                                    .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(welcomeLabelTop, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                                            .addComponent(jScrollPane1))
                                                    .addGap(0, 149, Short.MAX_VALUE)))
                                    .addContainerGap())
            );
            checkoutPanelLayout.setVerticalGroup(
                    checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(checkoutPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(welcomeLabelTop)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                    .addComponent(payButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(selectLanguageButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(scanItemButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(addOwnBagsButton)
                                            .addComponent(callAttendantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(15, 15, 15))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(checkoutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkoutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
        }

        private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {
            PaymentMethodScreenGui gui = new PaymentMethodScreenGui(customer, station, stationLogic);
            gui.setVisible(true);
        }

        private void callAttendantButtonActionPerformed(java.awt.event.ActionEvent evt) {
            AttendantStationGui attendantGui = new AttendantStationGui(customer, station, stationLogic);
            attendantGui.setVisible(true);
        }

        private void scanItemButtonActionPerformed(java.awt.event.ActionEvent evt) {
            try {
                customer.selectNextItem();
                customer.scanItem();
                itemList.setModel(new javax.swing.AbstractListModel<String>() {

                    List<String> strings = stationLogic.productController.getScanned().stream().map(p -> p.getDescription()).toList();
                    public int getSize() { return strings.size(); }
                    public String getElementAt(int i) { return strings.get(i); }
                });
            } catch(NoSuchElementException e) {
                System.out.println("No more items in cart");
            }
        }


        public static void main(String args[]) {

            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(CheckoutStationGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(CheckoutStationGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(CheckoutStationGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(CheckoutStationGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }





        }

}

//sourced from netbeans