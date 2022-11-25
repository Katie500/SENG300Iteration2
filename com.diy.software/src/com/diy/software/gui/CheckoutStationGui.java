package com.diy.software.gui;

import com.diy.hardware.BarcodedProduct;
import com.diy.hardware.DoItYourselfStationAR;
import com.diy.simulation.Customer;
import com.diy.software.DoItYourselfStationLogic;
import com.diy.software.bags.Bags;
import com.diy.software.controllers.ReceiptController;
import com.diy.software.gui.MembershipScreenGui;
import com.jimmyselectronics.Item;
import com.jimmyselectronics.OverloadException;

import ca.ucalgary.seng300.simulation.InvalidArgumentSimulationException;

import javax.swing.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;



public class CheckoutStationGui extends javax.swing.JFrame{

    private DoItYourselfStationLogic stationLogic;
    private Customer customer;
    private DoItYourselfStationAR station;
    private Bags bags;
    JPanel checkoutPanel = new JPanel();
    static JLabel welcomeLabelTop = new JLabel();
    JButton selectLanguageButton = new JButton();
    JButton payButton = new JButton();
    //scroll panel for list of products
    JScrollPane jScrollPane1 = new JScrollPane();
    //list of products
    JList<String> itemList = new JList<>();
    JButton callAttendantButton = new JButton();
    JButton scanItemButton = new JButton();
    JLabel totalLabel = new JLabel();
    JButton purchaseBagButton = new JButton();
    JToggleButton noBagsToggleButton = new JToggleButton();
    static JButton membershipLoginButton = new JButton();
    JLabel lowInkLabel = new JLabel();
    JLabel lowPaperLabel = new JLabel();
    JButton bagItemButton = new JButton();

    //Error label
    JLabel errorMessage = new JLabel();
    
    boolean signalink = false;
    boolean signalpaper= false;

    static boolean membershipConfirmed = false;

    
    

    public CheckoutStationGui(Customer customer, DoItYourselfStationAR station, DoItYourselfStationLogic stationLogic) {
        this.stationLogic = stationLogic;
        this.customer = customer;
        this.station = station;
        this.bags = new Bags();
        initCheckoutStationGui();
    }


    private void initCheckoutStationGui() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        if(!MembershipScreenGui.membershipManager.hasActiveMember())
            welcomeLabelTop.setText("Welcome to Checkout. Please scan items.");
        else {
            //changing welcome label to have member name
            welcomeLabelTop.setText("<html>Welcome, " + MembershipScreenGui.membershipManager.getActiveMemberName()
                    + "! <br/>Membership Number: " + MembershipScreenGui.membershipManager.getActivateMemberID()
                    + " <br/>Proud Member Since: " + MembershipScreenGui.membershipManager.getActiveMemberMonth() + " " + MembershipScreenGui.membershipManager.getActiveMemberDay()
                    + ", " + MembershipScreenGui.membershipManager.getActivateMemberYear());
        }

        selectLanguageButton.setText("Select Language");
        selectLanguageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectLanguageButtonActionPerformed(evt);
            }
        });

        ReceiptController receipt = new ReceiptController();
        boolean lowink = receipt.getLowInk();
        boolean lowpaper = receipt.getLowPaper();
        
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

        bagItemButton.setVisible(false);
        
        scanItemButton.setText("Scan Item");
        scanItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanItemButtonActionPerformed(evt);
            }
        });

        totalLabel.setText("TOTAL: $" + stationLogic.productController.getTotal());

        purchaseBagButton.setText("Purchase Bag");
        purchaseBagButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseBagButtonActionPerformed(evt);
            }
        });

        noBagsToggleButton.setText("Use Own Bags");
        noBagsToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noBagsToggleButtonActionPerformed(evt);
            }
        });
        if(!MembershipScreenGui.membershipManager.hasActiveMember()){
        membershipLoginButton.setText("Membership Login");
        }
        else{
            membershipLoginButton.setText("Log out as "+MembershipScreenGui.membershipManager.getActiveMemberName());
        }
        membershipLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                membershipLoginButtonActionPerformed(evt);
        }
        });

        bagItemButton.setText("Bag Item");
        bagItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bagItemButtonActionPerformed(evt);
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
                                                        .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(checkoutPanelLayout.createSequentialGroup()
                                                                .addComponent(lowInkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lowPaperLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(noBagsToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(payButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(purchaseBagButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(selectLanguageButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(callAttendantButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(bagItemButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(scanItemButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        checkoutPanelLayout.setVerticalGroup(
                checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(checkoutPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(checkoutPanelLayout.createSequentialGroup()
                                                .addComponent(callAttendantButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(selectLanguageButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(scanItemButton))
                                        .addGroup(checkoutPanelLayout.createSequentialGroup()
                                                .addComponent(welcomeLabelTop)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 16, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(checkoutPanelLayout.createSequentialGroup()
                                                .addComponent(errorMessage)
                                                .addGap(18, 18, 18)
                                                .addComponent(totalLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(membershipLoginButton)
                                                .addGap(18, 18, 18)
                                                .addGroup(checkoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lowInkLabel)
                                                        .addComponent(lowPaperLabel)))
                                        .addGroup(checkoutPanelLayout.createSequentialGroup()
                                                .addComponent(bagItemButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(payButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(purchaseBagButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(noBagsToggleButton)))
                                .addContainerGap(19, Short.MAX_VALUE))
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
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(checkoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 18, Short.MAX_VALUE))
        );

        pack();
    }

    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {
        PaymentMethodScreenGui gui = new PaymentMethodScreenGui(customer, station, stationLogic);
        gui.setVisible(true);
        this.setVisible(false);
        //itemList.removeAllElements();
    }

    private void callAttendantButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //This is the code to call the attendant gui. It is commented out because we are not doing attendant gui right now
        //AttendantStationGui attendantGui = new AttendantStationGui(customer, station, stationLogic);
        //attendantGui.setVisible(true);
    }

    private void scanItemButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO: Add prices The idea I'm working with right now is to attatch them to the end of the name
        List<BarcodedProduct> list = new ArrayList();
        list = stationLogic.productController.getScanned();
        int currentIndex = stationLogic.productController.getCurrentIndex();
        try {
        	errorMessage.setText("");
            customer.selectNextItem();
            customer.scanItem();
            bagItemButton.setVisible(true);
            scanItemButton.setVisible(false);
            
            

            stationLogic.productController.addToTotal(list.get(currentIndex).getPrice());
            stationLogic.productController.updateNextItem();
            totalLabel.setText("TOTAL: $" + stationLogic.productController.getTotal());

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
        } catch(IndexOutOfBoundsException e) {
        	errorMessage.setText("Start Scanning Items.");
        }
    }

    private void selectLanguageButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO: add languages maybe at some point idk
    }

    private void purchaseBagButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	if (!bags.getOwnBagsOrNot()) {
	    	stationLogic.productController.addToTotal(bags.getBagPrice());
	    	bags.addBag();
    		totalLabel.setText("TOTAL: $" + stationLogic.productController.getTotal());
    	} else  {
    		errorMessage.setText("Error: Untoggle own bags");
    	}
    }
   

    private void noBagsToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	if (!bags.getOwnBagsOrNot()) {
    		bags.updateOwnBagsOrNot(true);
    		stationLogic.productController.subtractFromTotal(bags.getTotalBagsCost());
            totalLabel.setText("TOTAL: $" + stationLogic.productController.getTotal());
    	}
    	else {
    		bags.updateOwnBagsOrNot(false);
            bags.resetBags();
    	}
    }

    private void membershipLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(MembershipScreenGui.membershipManager.hasActiveMember()) {
            MembershipScreenGui.membershipManager.unsetActiveMember();
            welcomeLabelTop.setText("Welcome to Checkout. Please scan items.");
            membershipLoginButton.setText("Membership Login");
        }
        else {
            MembershipScreenGui membershipgui = new MembershipScreenGui(customer, station, stationLogic);
            membershipgui.setVisible(true);
        }
        //this.setVisible(false);

    }
    private void bagItemButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	try {
    		errorMessage.setText("");
    		customer.placeItemInBaggingArea();
    		
    		bagItemButton.setVisible(false);
            scanItemButton.setVisible(true);
    		boolean weightDiscrepancyCheck = stationLogic.getWeightDiscrepancy();
        	if (weightDiscrepancyCheck == true) {
        		errorMessage.setText("Weight Discrepancy. Call Attendant");
        	} else {
        		errorMessage.setText("");
        	}
    	}catch(NoSuchElementException e) {
    		errorMessage.setText("No Item has been scanned.");
    	}
    	
    	
    	
    	
    }
    
    public boolean getSignalInk() {
    	return signalink;
    }
    
    public boolean getSignalPaper() {
    	return signalpaper;
    }

    public void setErrorMessage(String message) {
    	errorMessage.setText(message);
    }

}



//sourced from netbeans