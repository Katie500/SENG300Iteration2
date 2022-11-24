package com.diy.software.gui.cardpayment;

import com.diy.hardware.DoItYourselfStationAR;
import com.diy.simulation.Customer;

import com.diy.software.DoItYourselfStationLogic;
import com.diy.software.gui.*;

import com.jimmyselectronics.opeechee.Card;
import com.jimmyselectronics.opeechee.Card.CardData;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.awt.*;

public class CardPinpadGui extends javax.swing.JFrame {
	private JPanel mainPanel = new JPanel();
	private GridBagConstraints gbc = new GridBagConstraints();

	private JPanel pinpadPanel = new JPanel(new GridBagLayout());
	private JLabel pinpadInput = new JLabel();
	private JLabel errorMessage = new JLabel();

	private String pinEntered = "";

	public static DoItYourselfStationLogic stationLogic;
	public static Customer customer;
	public static DoItYourselfStationAR station;
	public static String cardPaymentType;
	public WalletGui walletGui;
	
	public CardPinpadGui(Customer customer, DoItYourselfStationAR station, DoItYourselfStationLogic stationLogic, String cardPaymentType) {
		// Set variables
		CardPinpadGui.customer = customer;
		CardPinpadGui.station = station;
		CardPinpadGui.stationLogic = stationLogic;
		CardPinpadGui.cardPaymentType = cardPaymentType;
		
		this.walletGui = new WalletGui(customer.wallet.cards);
		
		station.plugIn();
		station.turnOn();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		initComponents();
	}

	public void initializeWallet() {}
	
	public void initComponents() {
		mainPanel.setLayout(new GridBagLayout());

		gbc.insets = new Insets(10, 10, 0, 10);
		gbc.ipadx = 15;
		gbc.ipady = 5;

		// Add label
		JLabel debitPINLabel = new JLabel();
		debitPINLabel.setText("Please Enter PIN for " + cardPaymentType + " Transactions");
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
		gbc.insets = new Insets(0, 0, 5, 0);
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
		for (int i = 1; i <= 12; i++) {
			String buttonLabel = Integer.toString(i);

			gbc.insets = new Insets(3, 3, 3, 3);

			if (i == 10) {
				buttonLabel = "Cancel";
				gbc.insets = new Insets(10, 5, 10, 10);
				gbc.gridx = 1;
				gbc.gridy = 7;

			} else if (i == 11) {
				buttonLabel = "0";
				gbc.gridx = 4;
				gbc.gridy = 6;

			} else if (i == 12) {
				buttonLabel = "Enter";
				gbc.insets = new Insets(10, 10, 10, 5);
				gbc.gridx = 7;
				gbc.gridy = 7;

			} else if (i % 3 == 0) {
				gbc.gridx = 5;
				gbc.gridy = (int) (2 + Math.floor(i / 3));

			} else {
				gbc.gridx = 2 + i % 3;
				gbc.gridy = (int) (3 + Math.floor(i / 3));
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

			if (buttonPressed.equals("Enter")) {
				validatePayment();
				return;
			} else if (buttonPressed.equals("Cancel")) {
				newText = "";
				pinEntered = "";
				setVisible(false);
				// adding this so when we press cancel it just cancels the payment not the
				// program
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
		Card selectedCard = walletGui.getSelectedCard();

		try {
			stationLogic.paymentController.validateCardPayment(selectedCard, pinEntered, station.cardReader);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
//			e.printStackTrace();
		}
		
//		try {
//
//			station.cardReader.insert(selectedCard, pinEntered);
//			
//			boolean isSuccess = stationLogic.paymentController.payWithCard();
//			
//			if(isSuccess) {
//				// Display the confirmation screen if the payment is successful
//				ConfirmationScreenGui successGui = new ConfirmationScreenGui(customer, station, stationLogic);
//				successGui.setVisible(true);
//				setVisible(false);
//			} else {
//				// Display failed payment screen
//				PaymentErrorGui failGui = new PaymentErrorGui(customer, station, stationLogic);
//				failGui.setVisible(true);
//			}
//			
//			
//		} catch (IOException e) {
//			String exceptionMessage = e.toString();
//
//			if (exceptionMessage.contains("InvalidPINException")) {
//				// If the pin entered is invalid,display an error message.
//				errorMessage.setText("Invalid pin.");
//
//			} else if (exceptionMessage.contains("BlockedCardException")) {
//				// If the customer enters the wrong pin 3 times, the card is blocked.
//				errorMessage.setText(selectedCard.kind + " is blocked.");
//				stationLogic.paymentController.blockCard(selectedCard.number);
//			} else if (exceptionMessage.contains("ChipFailureException")) {
//				// If the chip failed.
//				errorMessage.setText("Chip failure. Reinsert the card, and enter the pin.");
//			}
//			
//			e.printStackTrace();
//		}

		walletGui.removeCardFromSlot();
		pinEntered = "";
		pinpadInput.setText("");
	}
}

//sourced from netbeans
