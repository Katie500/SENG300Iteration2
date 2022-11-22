//I'm making this a pop-up because I think it's weird to only have it as a notification on checkout. It should either be on all panels or have as a single pop-up
//Call for this program is:
//PaperLowGui gui = new PaperLowGui();
//gui.setVisible(true);



package com.diy.software.gui;

import com.diy.hardware.DoItYourselfStationAR;
import com.diy.simulation.Customer;

import javax.swing.*;
import java.awt.*;



public class PaperLowGui extends javax.swing.JFrame {


    public PaperLowGui() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        JPanel inkLowPanel = new JPanel();
        JLabel inkLowLabel = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inkLowLabel.setText("Receipt Paper LOW Please replace Ink");

        inkLowLabel.setForeground(Color.red);

        javax.swing.GroupLayout inkLowPanelLayout = new javax.swing.GroupLayout(inkLowPanel);
        inkLowPanel.setLayout(inkLowPanelLayout);
        inkLowPanelLayout.setHorizontalGroup(
                inkLowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(inkLowPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(inkLowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(22, Short.MAX_VALUE))
        );
        inkLowPanelLayout.setVerticalGroup(
                inkLowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(inkLowPanelLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(inkLowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(inkLowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(inkLowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(102, Short.MAX_VALUE))
        );

        pack();
    }
}

//sourced from netbeans
