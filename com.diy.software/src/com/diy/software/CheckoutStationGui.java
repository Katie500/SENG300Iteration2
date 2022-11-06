package com.diy.software;

import com.diy.hardware.DoItYourselfStation;
import com.diy.simulation.Customer;

import javax.swing.*;

public class CheckoutStationGui extends javax.swing.JFrame{
    //JFrame frame;
//    public static void main(String[] args) {
//        new DoItYourselfStation();
//
//    }

        private DoItYourselfStationLogic stationLogic;
        private Customer customer;
        private DoItYourselfStation station;



        /**
         * Creates new form checkout
         */
        public CheckoutStationGui(Customer customer, DoItYourselfStation station, DoItYourselfStationLogic stationLogic) {
            initCheckoutStationGui();
            this.stationLogic = stationLogic;
            this.customer = customer;
            this.station = station;
        }


        private void initCheckoutStationGui() {

            JPanel checkoutPanel = new JPanel();
            JLabel welcomeLabelTop = new JLabel();
            JButton addOwnBagsButton = new JButton();
            JButton selectLanguageButton = new JButton();
            JButton payButton = new JButton();
            JScrollPane jScrollPane1 = new JScrollPane();
            JList<String> itemList = new JList<>();

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

                //NEED TO CONNECT BACK END SCANNING TO HERE
                String[] strings = { "Bananas       $2.75", "Eggs             $3.47", "Milk               $1.24", "Cheetos       $4.57", "Apples          $2.95" };
                //itemDescriptions = DoItYourselfStationLogic.getScanned().stream().map(p -> p.getDescription()).toList();
                //String[] strings = itemDescriptions;
                public int getSize() { return strings.length; }
                public String getElementAt(int i) { return strings[i]; }
            });
            jScrollPane1.setViewportView(itemList);

            javax.swing.GroupLayout checkoutPanelLayout = new javax.swing.GroupLayout(checkoutPanel);
            checkoutPanel.setLayout(checkoutPanelLayout);
            checkoutPanelLayout.setHorizontalGroup(
                    checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(checkoutPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checkoutPanelLayout.createSequentialGroup()
                                                    .addGap(0, 0, Short.MAX_VALUE)
                                                    .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
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
                                    .addComponent(addOwnBagsButton)
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
            //var items = stationLogic.productController.getScanned().stream().map(p -> p.getDescription()).toList();
            PaymentMethodScreenGui gui = new PaymentMethodScreenGui(customer, station, stationLogic);
            gui.setVisible(true);
        }

        /**
         * @param args the command line arguments
         */
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
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    DoItYourselfStation station = null;
                    Customer customer = null;
                    DoItYourselfStationLogic station1 = null;
                    new CheckoutStationGui(customer,station, station1).setVisible(true);
                }
            });
        }


}

//sourced from netbeans