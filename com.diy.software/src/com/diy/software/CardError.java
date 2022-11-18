package com.diy.software;
import com.diy.hardware.DoItYourselfStationAR;
import com.diy.simulation.Customer;

public class CardError extends javax.swing.JFrame {

    private DoItYourselfStationLogic stationLogic;
    private Customer customer;
    private DoItYourselfStationAR station;

    public CardError(Customer customer, DoItYourselfStationAR station, DoItYourselfStationLogic stationLogic) {
        initComponents();
        this.stationLogic = stationLogic;
        this.customer = customer;
        this.station = station;
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        javax.swing.JPanel cardErrorPanel = new javax.swing.JPanel();
        javax.swing.JLabel errorLabel = new javax.swing.JLabel();
        javax.swing.JLabel cancelLabel = new javax.swing.JLabel();
        javax.swing.JButton cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        errorLabel.setText("ERROR: There was an issue with your card.");

        cancelLabel.setText("Press the \"X\" to try another card or press below to cancel transaction.");

        cancelButton.setText("Cancel Transaction");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cardErrorPanelLayout = new javax.swing.GroupLayout(cardErrorPanel);
        cardErrorPanel.setLayout(cardErrorPanelLayout);
        cardErrorPanelLayout.setHorizontalGroup(
                cardErrorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cardErrorPanelLayout.createSequentialGroup()
                                .addGroup(cardErrorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(cardErrorPanelLayout.createSequentialGroup()
                                                .addGap(73, 73, 73)
                                                .addComponent(cancelLabel))
                                        .addGroup(cardErrorPanelLayout.createSequentialGroup()
                                                .addGap(142, 142, 142)
                                                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(cardErrorPanelLayout.createSequentialGroup()
                                                .addGap(192, 192, 192)
                                                .addComponent(cancelButton)))
                                .addContainerGap(95, Short.MAX_VALUE))
        );
        cardErrorPanelLayout.setVerticalGroup(
                cardErrorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cardErrorPanelLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelLabel)
                                .addGap(36, 36, 36)
                                .addComponent(cancelButton)
                                .addContainerGap(106, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cardErrorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(cardErrorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        WelcomeScreen gui = new WelcomeScreen(customer, station, stationLogic);
        gui.setVisible(true);
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
            java.util.logging.Logger.getLogger(CardError.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CardError.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CardError.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CardError.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    // sourced from netbeans
}

