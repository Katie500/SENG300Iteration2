package com.diy.software.gui;

import com.diy.hardware.DoItYourselfStationAR;
import com.diy.hardware.external.CardIssuer;
import com.diy.simulation.Customer;
import com.diy.software.DoItYourselfStationLogic;
import com.jimmyselectronics.opeechee.Card;
import com.jimmyselectronics.opeechee.Card.CardData;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.awt.*;

public class DebitCardInputGui extends javax.swing.JFrame {
	private JPanel mainPanel = new JPanel();
	private GridBagConstraints gbc = new GridBagConstraints();
	
	private JPanel pinpadPanel = new JPanel(new GridBagLayout());
	private JLabel pinpadInput = new JLabel();
	private JLabel errorMessage = new JLabel();
	
	private WalletGui walletGui = new WalletGui();
	
	private String pinEntered = "";

    private static DoItYourselfStationLogic stationLogic;
    private static Customer customer;
    private static DoItYourselfStationAR station;

    public DebitCardInputGui(Customer customer, DoItYourselfStationAR station, DoItYourselfStationLogic stationLogic) {
        // Set variables
        DebitCardInputGui.customer = customer;
        DebitCardInputGui.station = station;
        DebitCardInputGui.stationLogic = stationLogic;
        
        station.plugIn();
        station.turnOn();
        
    	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        initComponents();
    }
    
  
    private void initComponents() {
        mainPanel.setLayout(new GridBagLayout());
        
        gbc.insets = new Insets(10,10,0,10);
        gbc.ipadx = 15;
        gbc.ipady = 5;
        
        //       Add label
        JLabel debitPINLabel = new JLabel();
        debitPINLabel.setText("Please Enter PIN for Debit Transactions");
        debitPINLabel.setHorizontalAlignment(JLabel.CENTER);

        gbc.gridx = 1;
        gbc.gridy = 1;
        
        mainPanel.add(debitPINLabel, gbc);

//      Add pin pad input
        JPanel textPanel = new JPanel();
		textPanel.setPreferredSize(new Dimension(75, 25));
		textPanel.setMinimumSize(new Dimension(75, 25));
		textPanel.setMaximumSize(new Dimension(75, 25));
		textPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		textPanel.setBackground(Color.white);
		textPanel.add(pinpadInput);

		pinpadInput.setFont(new Font(pinpadInput.getName(), Font.PLAIN, 18));
		
        gbc.gridy = 2;
        mainPanel.add(textPanel, gbc);

        
//      Add error message that shows up if payment could not be validated
        gbc.insets = new Insets(0,0,5,0);
        errorMessage.setFont(new Font(errorMessage.getName(), Font.PLAIN, 10));
        errorMessage.setHorizontalAlignment(JLabel.CENTER);
        errorMessage.setText(" ");
        gbc.gridy = 3;
        mainPanel.add(errorMessage, gbc);

        
//      Add pin pad buttons
        gbc.gridy = 4;
        mainPanel.add(pinpadPanel, gbc);
        addPinpadButtons();
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridheight = 4;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(walletGui, gbc);
        
        add(mainPanel);
        pack();
    }

	private void addPinpadButtons() {
		for(int i = 1; i <= 12; i++) {
			String buttonLabel = Integer.toString(i);
			
			gbc.insets = new Insets(3, 3, 3, 3);
			
			if(i == 10) {
				buttonLabel = "Cancel";
				gbc.insets = new Insets(10,5,10,10);
				gbc.gridx = 1;
				gbc.gridy = 7;
				
			} else if(i == 11) {
				buttonLabel = "0";
				gbc.gridx = 4;
				gbc.gridy = 6;
				
			} else if(i == 12) {
				buttonLabel = "Enter";
				gbc.insets = new Insets(10,10,10,5);
				gbc.gridx = 7;
				gbc.gridy = 7;
				
			} else if(i%3 == 0) {
				gbc.gridx = 5;
				gbc.gridy = (int) (2 + Math.floor(i/3));
				
			} else {
				gbc.gridx = 2 + i%3;
				gbc.gridy = (int) (3 + Math.floor(i/3));
			}
			
			JButton b = new JButton(buttonLabel);
			b.addActionListener(pinpadListener);
			
			pinpadPanel.add(b, gbc);
		}
	}
	
	ActionListener pinpadListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonPressed = e.getActionCommand();
			String newText = pinpadInput.getText();
			
			errorMessage.setText(" ");
			
			if(buttonPressed.equals("Enter")) {
				validatePayment();
				return;
			} else if (buttonPressed.equals("Cancel")) {
				newText = "";
				pinEntered = "";
				setVisible(false);
				//adding this so when we press cancel it just cancels the payment not the program
				PaymentMethodScreenGui gui = new PaymentMethodScreenGui(customer, station, stationLogic);
				gui.setVisible(true);
			} else if (pinEntered.length() < 4) {
				pinEntered += buttonPressed;
				newText += '*';
			}
			
			pinpadInput.setText(newText);
			System.out.println(pinEntered);
		}
	};

	
	private void validatePayment() {
		CardIssuer cardIssuer = walletGui.getSelectedCardIssuer();
		Card selectedCard = walletGui.getSelectedCard();
		
		System.out.println("Card inserted: " + selectedCard.number);
		
		try {
			CardData selectedCardData = station.cardReader.insert(selectedCard, pinEntered);
			
			System.out.println("Pin input success: " + selectedCardData.getNumber());
			stationLogic.paymentController.cardDataRead(station.cardReader, selectedCardData);
		} catch (IOException e) {
			System.out.println("Failed to get card data");
			e.printStackTrace();
		}
		
		
//		if(pinEntered.length() < 4 || pinEntered != "1234") {
//			errorMessage.setText("Invalid PIN");
//			pinpadInput.setText("");
//			pinEntered = "";
//			
//		} else {
//	        //TODO: Check to see if card was accepted and if correct then call the code featured below
//	        ConfirmationScreenGui successGui = new ConfirmationScreenGui(customer, station, stationLogic);
//	        successGui.setVisible(true);
//	        setVisible(false);
//	        
//		    /*IF cash was not correct, error message gui call is:
//		    PaymentErrorGui gui = new PaymentErrorGui(customer,station,stationLogic);
//		    gui.setVisible(true);*/
//		}
	}
}

//sourced from netbeans
