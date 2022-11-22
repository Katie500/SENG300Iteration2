package com.diy.software.gui;

import com.diy.hardware.DoItYourselfStationAR;
import com.diy.simulation.Customer;
import com.diy.software.DoItYourselfStationLogic;


public class WelcomeScreenGui extends javax.swing.JFrame {

    private DoItYourselfStationLogic stationLogic;
    private DoItYourselfStationAR station;
    private Customer customer;

    public WelcomeScreenGui(Customer customer, DoItYourselfStationAR station, DoItYourselfStationLogic stationLogic) {
        initComponents();
        this.stationLogic = stationLogic;
        this.customer = customer;
        this.station = station;
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        javax.swing.JPanel welcomePanel = new javax.swing.JPanel();
        javax.swing.JLabel welcomeLabel = new javax.swing.JLabel();
        javax.swing.JButton welcomeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        welcomeLabel.setText("Welcome to Our Store");

        welcomeButton.setText("Press here to start scanning");
        welcomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                welcomeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout welcomePanelLayout = new javax.swing.GroupLayout(welcomePanel);
        welcomePanel.setLayout(welcomePanelLayout);
        welcomePanelLayout.setHorizontalGroup(
                welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(welcomePanelLayout.createSequentialGroup()
                                .addGroup(welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(welcomePanelLayout.createSequentialGroup()
                                                .addGap(118, 118, 118)
                                                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(welcomePanelLayout.createSequentialGroup()
                                                .addGap(90, 90, 90)
                                                .addComponent(welcomeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)))
                                .addGap(90, 90, 90))
        );
        welcomePanelLayout.setVerticalGroup(
                welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(welcomePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(welcomeLabel)
                                .addGap(98, 98, 98)
                                .addComponent(welcomeButton)
                                .addContainerGap(135, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(29, Short.MAX_VALUE)
                                .addComponent(welcomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(welcomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }

    private void welcomeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        CheckoutStationGui gui = new CheckoutStationGui(customer, station, stationLogic);
        gui.setVisible(true);
        this.setVisible(false);
    }



}
