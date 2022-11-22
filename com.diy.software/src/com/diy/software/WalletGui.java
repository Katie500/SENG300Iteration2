package com.diy.software;

import java.util.Calendar;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.diy.hardware.external.CardIssuer;
import com.diy.simulation.Wallet;
import com.jimmyselectronics.opeechee.Card;

public class WalletGui extends JPanel {
	public final Wallet wallet = new Wallet();
	
	private final int NUMBER_CARDS = 2;
	
	private Card selectedCard = null;
	private CardIssuer selectedCardIssuer = null;
	
	private JButton currentCardButton = null;
	
	public WalletGui() {
        //       Add label
        JLabel debitPINLabel = new JLabel();
        debitPINLabel.setText("Wallet");
        
        debitPINLabel.setHorizontalAlignment(JLabel.CENTER);
        debitPINLabel.setFont(new Font(debitPINLabel.getName(), Font.PLAIN, 20));
        
		setLayout(new GridLayout(NUMBER_CARDS+1,1));
		setBackground(Color.white);
		
        add(debitPINLabel);
		
		initializeWalletContents();
	}
	
    private void initializeWalletContents() {
    	Random random = new Random();
    	CardIssuer cardIssuer = new CardIssuer("Card Issuer 1", 3);
    	
    	for (int i = 1; i <= NUMBER_CARDS; i++) {
    		String strI = Integer.toString(i);
    		String cardNumber = Long.toString((long) (1000000000000000L + random.nextFloat() * 9000000000000000L));
    		
    		String kind = "Debit " + strI;
    		String cvv = Integer.toString(100 + random.nextInt(900));
    		String pin = "1234";
//    		String pin = Integer.toString(1000 + random.nextInt(9000));
    		
    		Card debitCard = new Card(kind, cardNumber, "Card Holder Name", cvv, pin, true, true);
    		wallet.cards.add(debitCard);
    		
    		// Create GUI for card
    		JButton cardButton = new JButton("<html>" + kind + "<br>" + cardNumber + "</html>");
    		
			cardButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					selectedCard = debitCard;
					
					if(currentCardButton != null) {
						AbstractButton button = (AbstractButton) e.getSource();
						currentCardButton.setBorder(button.getBorder());
					}
					
					cardButton.setBorder(BorderFactory.createLineBorder(new Color(72, 102, 150), 5));
					
					selectedCard = debitCard;
					selectedCardIssuer = cardIssuer;
					currentCardButton = (JButton) e.getSource();
				}
			});
			
    		add(cardButton);
    		cardIssuer.addCardData(cardNumber, "Card Holder Name", Calendar.getInstance(), cvv, 1000);
    	}
    }
    
    public Card getSelectedCard() {
    	return this.selectedCard;
    }
    
    public CardIssuer getSelectedCardIssuer() {
    	return this.selectedCardIssuer;
    }
}
