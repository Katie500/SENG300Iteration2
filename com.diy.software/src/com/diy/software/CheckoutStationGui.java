package com.diy.software;

import com.diy.hardware.DoItYourselfStationAR;
import com.diy.simulation.Customer;
import com.diy.software.controllers.ReceiptController;

import ca.ucalgary.seng300.simulation.InvalidArgumentSimulationException;

import javax.swing.*;

import java.awt.Color;
import java.util.List;
import java.util.NoSuchElementException;

public class CheckoutStationGui extends javax.swing.JFrame{

    private DoItYourselfStationLogic stationLogic;
    private Customer customer;
    private DoItYourselfStationAR station;
    JPanel checkoutPanel = new JPanel();
    JLabel welcomeLabelTop = new JLabel();
    JButton selectLanguageButton = new JButton();
    JButton payButton = new JButton();
    //scroll panel for list of products
    JScrollPane jScrollPane1 = new JScrollPane();
    //list of products
    JList<String> itemList = new JList<>();
    JButton callAttendantButton = new JButton();
    JButton scanItemButton = new JButton();
    JLabel totalLabel = new JLabel();
    JToggleButton purchaseBagToggleButton = new JToggleButton();
    JToggleButton noBagsToggleButton = new JToggleButton();
    JButton membershipLoginButton = new JButton();
    JLabel lowInkLabel = new JLabel();
    JLabel lowPaperLabel = new JLabel();

    //Error label
    JLabel errorMessage = new JLabel();
    
    boolean signalink = false;
    boolean signalpaper= false;
    
    

    public CheckoutStationGui(Customer customer, DoItYourselfStationAR station, DoItYourselfStationLogic stationLogic) {
        this.stationLogic = stationLogic;
        this.customer = customer;
        this.station = station;
        initCheckoutStationGui();
    }


    private void initCheckoutStationGui() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        welcomeLabelTop.setText("Welcome to Checkout. Please scan items.");

        selectLanguageButton.setText("Select Language");
        selectLanguageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectLanguageButtonActionPerformed(evt);
            }
        });

        ReceiptController receipt = new ReceiptController();
        boolean lowink = true;//receipt.getLowInk();
        boolean lowpaper = true;//receipt.getLowPaper();
        
//        boolean signalink = false;
//        boolean signalpaper= false;
        		
        if(lowink==true) {
        	lowInkLabel.setText("Caution: Low Ink");
        	signalink = true;
        }
        if(lowpaper == true) {
        	lowPaperLabel.setText("Caution: Low Paper");
        	signalpaper = true;
        }
        payButton.setText("Pay");
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });

        errorMessage.setForeground(Color.red);
        lowInkLabel.setForeground(Color.red);
        lowPaperLabel.setForeground(Color.red);

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

        totalLabel.setText("TOTAL: ");

        purchaseBagToggleButton.setText("Purchase Bag");
        purchaseBagToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseBagToggleButtonActionPerformed(evt);
            }
        });

        noBagsToggleButton.setText("No Bags");
        noBagsToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noBagsToggleButtonActionPerformed(evt);
            }
        });

        membershipLoginButton.setText("Membership Login");
        membershipLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                membershipLoginButtonActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout checkoutPanelLayout = new javax.swing.GroupLayout(checkoutPanel);
        checkoutPanel.setLayout(checkoutPanelLayout);
        checkoutPanelLayout.setHorizontalGroup(
                checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checkoutPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(welcomeLabelTop, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                                .addComponent(jScrollPane1))
                                        .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(membershipLoginButton)
                                        .addGroup(checkoutPanelLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(checkoutPanelLayout.createSequentialGroup()
                                                                .addComponent(lowInkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lowPaperLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(noBagsToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(scanItemButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(payButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(purchaseBagToggleButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(selectLanguageButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(callAttendantButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        checkoutPanelLayout.setVerticalGroup(
                checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(checkoutPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(checkoutPanelLayout.createSequentialGroup()
                                                .addComponent(welcomeLabelTop)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(errorMessage)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(totalLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(membershipLoginButton)
                                                .addGap(12, 12, 12)
                                                .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lowInkLabel)
                                                        .addComponent(lowPaperLabel))
                                                .addContainerGap())
                                        .addGroup(checkoutPanelLayout.createSequentialGroup()
                                                .addComponent(callAttendantButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(selectLanguageButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(scanItemButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(payButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(purchaseBagToggleButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(noBagsToggleButton)
                                                .addGap(20, 20, 20))))
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
        this.setVisible(false);
    }

    private void callAttendantButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //This is the code to call the attendant gui. It is commented out because we are not doing attendant gui right now
        //AttendantStationGui attendantGui = new AttendantStationGui(customer, station, stationLogic);
        //attendantGui.setVisible(true);
    }

    private void scanItemButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO: Add prices The idea I'm working with right now is to attatch them to the end of the name
        try {
            customer.selectNextItem();
            customer.scanItem();
            itemList.setModel(new javax.swing.AbstractListModel<String>() {

                //TODO: need to add prices and totals to the products and display them somehow
                List<String> strings = stationLogic.productController.getScanned().stream().map(p -> p.getDescription()).toList();
                public int getSize() { return strings.size(); }
                public String getElementAt(int i) { return strings.get(i); }
            });
        } catch(NoSuchElementException e) {
            errorMessage.setText("Error: No more items in cart");
        } catch(InvalidArgumentSimulationException e) {
            errorMessage.setText("Error: the weight has to be positive");
        }
    }

    private void selectLanguageButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO: add languages maybe at some point idk
    }

    private void purchaseBagToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Bes handles here
    }

    private void noBagsToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Liam handles here
    }

    private void membershipLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        MembershipScreenGui gui = new MembershipScreenGui(customer, station, stationLogic);
        gui.setVisible(true);

    }
    
    public boolean getSignalInk() {
    	return signalink;
    }
    
    public boolean getSignalPaper() {
    	return signalpaper;
    }


}



//sourced from netbeans