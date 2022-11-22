package com.diy.software;


import com.diy.hardware.DoItYourselfStationAR;
import com.diy.simulation.Customer;

public class AttendantStationGui extends javax.swing.JFrame {

    private DoItYourselfStationLogic stationLogic;
    private DoItYourselfStationAR station;
    private Customer customer;

    public AttendantStationGui(Customer customer, DoItYourselfStationAR station, DoItYourselfStationLogic stationLogic) {
        initComponents();
        this.stationLogic = stationLogic;
        this.customer = customer;
        this.station = station;
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        javax.swing.JTextField jTextField3 = new javax.swing.JTextField();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JPanel attendantPanel = new javax.swing.JPanel();
        javax.swing.JTextField preventStationTextbox = new javax.swing.JTextField();
        javax.swing.JButton finalizeButton = new javax.swing.JButton();
        javax.swing.JLabel preventStationLabel = new javax.swing.JLabel();
        javax.swing.JTextField permitStationTextBox = new javax.swing.JTextField();
        javax.swing.JLabel permitStationLabel = new javax.swing.JLabel();
        javax.swing.JTextField removeItemTextbox = new javax.swing.JTextField();
        javax.swing.JLabel removeItemLabel = new javax.swing.JLabel();
        javax.swing.JTextField addItemTextbox = new javax.swing.JTextField();
        // Variables declaration - do not modify
        javax.swing.JLabel addItemLabel = new javax.swing.JLabel();

        jTextField3.setText("jTextField1");

        jLabel3.setText("Permit Station:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        preventStationTextbox.setText("ex: 2");
        preventStationTextbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preventStationTextboxActionPerformed(evt);
            }
        });

        finalizeButton.setText("Finalize");
        finalizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizeButtonActionPerformed(evt);
            }
        });

        preventStationLabel.setText("Prevent Station:");

        permitStationTextBox.setText("ex: 2");

        permitStationLabel.setText("Permit Station:");

        removeItemTextbox.setText("enter item");

        removeItemLabel.setText("Remove Item:");

        addItemTextbox.setText("enter item");

        addItemLabel.setText("Add Item:");

        javax.swing.GroupLayout attendantPanelLayout = new javax.swing.GroupLayout(attendantPanel);
        attendantPanel.setLayout(attendantPanelLayout);
        attendantPanelLayout.setHorizontalGroup(
                attendantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(attendantPanelLayout.createSequentialGroup()
                                .addGroup(attendantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(attendantPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(attendantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(attendantPanelLayout.createSequentialGroup()
                                                                .addComponent(removeItemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(removeItemTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(attendantPanelLayout.createSequentialGroup()
                                                                .addComponent(addItemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(addItemTextbox))
                                                        .addGroup(attendantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, attendantPanelLayout.createSequentialGroup()
                                                                        .addComponent(preventStationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(preventStationTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, attendantPanelLayout.createSequentialGroup()
                                                                        .addComponent(permitStationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(permitStationTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(attendantPanelLayout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addComponent(finalizeButton)))
                                .addContainerGap(227, Short.MAX_VALUE))
        );
        attendantPanelLayout.setVerticalGroup(
                attendantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(attendantPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(attendantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(preventStationTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(preventStationLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(attendantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(permitStationTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(permitStationLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(attendantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(removeItemTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(removeItemLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(attendantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addItemTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addItemLabel))
                                .addGap(18, 18, 18)
                                .addComponent(finalizeButton)
                                .addContainerGap(148, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(attendantPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(attendantPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void finalizeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void preventStationTextboxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }



}

//sourced from netbeans


