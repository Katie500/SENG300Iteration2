
package com.diy.software.gui;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.jimmyselectronics.opeechee.Card;

@SuppressWarnings("serial")
public class WalletGui extends JPanel {
	private List<Card> cards;
	
	private Card selectedCard = null;
	private JButton currentCardButton = null;
	
	public WalletGui(List<Card> cards) {
		this.cards = cards;
		
        // Add label
        JLabel debitPINLabel = new JLabel();
        debitPINLabel.setText("Wallet");
        
        debitPINLabel.setHorizontalAlignment(JLabel.CENTER);
        debitPINLabel.setFont(new Font(debitPINLabel.getName(), Font.PLAIN, 20));
        
		setLayout(new GridLayout(cards.size()+1,1));
		setBackground(Color.white);
		
        add(debitPINLabel);
		
        initializeWalletGuiContents();
	}
	
    private void initializeWalletGuiContents() {
    	for (int i = 0; i < cards.size(); i++) {
    		Card card = cards.get(i);
    		String formattedCardNumber = card.number.replaceAll("(.{" + 4 + "})", "$1 ").trim();
    		
    		String cardInfo = ((card.isTapEnabled) ? "Has tap, " : "No tap, ") + ((card.hasChip) ? "has chip" : "no chip");
    		
    		// Create GUI for card
    		JButton cardButton = new JButton("<html>" + card.kind + "<br>" + formattedCardNumber + "<br>" + cardInfo + "</html>");
    		cardButton.setFont(new Font(cardButton.getName(), Font.PLAIN, 10));
    		
			cardButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(currentCardButton != null) {
						AbstractButton button = (AbstractButton) e.getSource();
						currentCardButton.setBorder(button.getBorder());
					}
					
					cardButton.setBorder(BorderFactory.createLineBorder(new Color(72, 102, 150), 5));
					
					selectedCard = card;
					currentCardButton = (JButton) e.getSource();
				}
			});
			
    		add(cardButton);
    	}
    }
    
    public void setSelectedCard(Card selectedCard) {
    	this.selectedCard = selectedCard;
    }
    
    public Card getSelectedCard() {
    	return this.selectedCard;
    }
    
    public JButton getCurrentCardButton() {
    	return this.currentCardButton;
    }
    
    public void setCurrentCardButton(JButton currentCard) {
    	this.currentCardButton = currentCard;
    }
    
    public void removeCardFromSlot() {
    	if(currentCardButton != null && selectedCard != null) {
        	currentCardButton.setBorder(new JButton().getBorder());
        	currentCardButton = null;
        	
        	selectedCard = null;
    	}
    }
}
