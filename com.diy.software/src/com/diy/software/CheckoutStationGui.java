package com.diy.software;

import com.diy.hardware.DoItYourselfStation;
import javax.swing.*;

public class CheckoutStationGui extends javax.swing.JFrame{
    JFrame frame;
//    public static void main(String[] args) {
//        new DoItYourselfStation();
//        //create gui here
//    }

        private DoItYourselfStationLogic stationLogic;



        /**
         * Creates new form checkout
         */
        public CheckoutStationGui(DoItYourselfStationLogic stationLogic) {
            initComponents();
            this.stationLogic = stationLogic;
        }


        private void initComponents() {

            checkoutPanel = new javax.swing.JPanel();
            welcomeLabelTop = new javax.swing.JLabel();
            addOwnBagsButton = new javax.swing.JButton();
            selectLanguageButton = new javax.swing.JButton();
            payButton = new javax.swing.JButton();
            jScrollPane1 = new javax.swing.JScrollPane();
            itemList = new javax.swing.JList<>();

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
        }// </editor-fold>

        private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
            var items = stationLogic.productController.getScanned().stream().map(p -> p.getDescription()).toList();
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
                    new CheckoutStationGui().setVisible(true);
                }
            });
        }

        private javax.swing.JButton addOwnBagsButton;
        private javax.swing.JPanel checkoutPanel;
        private javax.swing.JList<String> itemList;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JButton payButton;
        private javax.swing.JButton selectLanguageButton;
        private javax.swing.JLabel welcomeLabelTop;



}