
package com.diy.software.gui;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.diy.hardware.DoItYourselfStationAR;
import com.diy.software.DoItYourselfStationLogic;
import com.jimmyselectronics.opeechee.Card;

@SuppressWarnings("serial")
public class WalletGui extends JPanel {
	private List<Card> cards;
	
	private JToggleButton currentCardButton = null;
	static DoItYourselfStationLogic stationLogic;
	static DoItYourselfStationAR station;
	
	public WalletGui(List<Card> cards, DoItYourselfStationLogic stationLogic, DoItYourselfStationAR station) {
		WalletGui.stationLogic = stationLogic;
		WalletGui.station = station;
		
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
    		JToggleButton cardButton = new JToggleButton("<html>" + card.kind + "<br>" + formattedCardNumber + "<br>" + cardInfo + "</html>");
    		cardButton.setFont(new Font(cardButton.getName(), Font.PLAIN, 10));
    		
			cardButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
		            AbstractButton abstractButton = (AbstractButton)e.getSource();   
					boolean selected = abstractButton.getModel().isSelected();
			
					if(selected) {
						if(currentCardButton != null) {
							currentCardButton.setBorder(new JButton().getBorder());
							currentCardButton.setBackground(new JButton().getBackground());
							currentCardButton.getModel().setSelected(false);							
						}

						cardButton.setBorder(BorderFactory.createLineBorder(new Color(72, 102, 150), 5));
						
						stationLogic.paymentController.setSelectedCard(card);
						currentCardButton = (JToggleButton) e.getSource();
					} else {
						removeCardFromSlot();
					}
				}
			});
			
    		add(cardButton);
    	}
    }
    
    public JToggleButton getCurrentCardButton() {
    	return this.currentCardButton;
    }
    
    public void setCurrentCardButton(JToggleButton currentCard) {
    	this.currentCardButton = currentCard;
    }
    
    public void removeCardFromSlot() {
    	if(currentCardButton != null) {
    		currentCardButton.setSelected(false);
    		
        	currentCardButton.setBorder(new JButton().getBorder());
        	currentCardButton.setBackground(new JButton().getBackground());
        	currentCardButton = null;
        	
        	try {
        		station.cardReader.remove();
        	} catch (Exception e) {
        		System.out.println("Returned card to wallet.");
        	}
    	}
    }
}
