package com.diy.software.controllers;

import java.io.IOException;

import com.diy.hardware.external.CardIssuer;
import com.diy.software.DoItYourselfStationLogic;
import com.diy.software.exceptions.*;
import com.jimmyselectronics.AbstractDevice;
import com.jimmyselectronics.AbstractDeviceListener;
import com.jimmyselectronics.opeechee.Card;
import com.jimmyselectronics.opeechee.Card.CardData;
import com.jimmyselectronics.opeechee.CardReader;
import com.jimmyselectronics.opeechee.CardReaderListener;

public class PaymentController implements CardReaderListener {
    private DoItYourselfStationLogic stationLogic;
    private CardIssuer creditIssuer;
    private Card selectedCard;
    
    /**
     * Basic constructor.
     *
     * @param stationLogic
     *            The station logic that this is part of.
     */
    public PaymentController(DoItYourselfStationLogic stationLogic, CardIssuer creditIssuer) {
    	if(stationLogic == null)
    		throw new NullPointerException("Station logic");
    	
    	if(creditIssuer == null)
    		throw new NullPointerException("Credit issuer");
    	
        this.stationLogic = stationLogic;
        this.creditIssuer = creditIssuer;
    }

    public boolean validateCardPayment(String pinEntered, CardReader cardReader) throws IOException {
    	boolean isSuccess;

 
    	if(pinEntered == null || pinEntered.replaceAll("\\s+","").equals(""))
    		throw new IllegalArgumentException("Please enter a pin.");
    	
		if (selectedCard == null)
			throw new NullPointerException("Please select a card from the wallet.");
		
		if (cardReader == null)
			throw new NullPointerException("Card reader");
		
		try {
			cardReader.insert(selectedCard, pinEntered);
			isSuccess = payWithCard();
			
		} catch (IOException e) {
			String exceptionMessage = e.toString();
			
			// If the pin entered is invalid,display an error message.
			if (exceptionMessage.contains("InvalidPINException"))
				throw new CardTransactionException("Invalid pin.");
			
			// If the customer enters the wrong pin 3 times, the card is blocked.
			if (exceptionMessage.contains("BlockedCardException")) {
				creditIssuer.block(selectedCard.number);
				throw new CardTransactionException(selectedCard.kind + " is blocked.");
			}
			
			// If the card has no chip, or the card has a chip but the reader failed to read the card data.
			if (exceptionMessage.contains("ChipFailureException")) {
				if(selectedCard.hasChip)
					throw new ChipFailureException("Chip failure. Please reinsert the card, and enter the pin.");
				
				throw new ChipFailureException("Inserted card has no chip.");
			}
			
			throw e;
		}
		
		return isSuccess;
	}
    
    /**
     * @return If a card transaction is successful or not
     */
    public boolean payWithCard() throws IOException {
        long charge = stationLogic.productController.getTotal();
        long holdNumber = creditIssuer.authorizeHold(selectedCard.number, charge);
        
        if(charge <= 0) 
        	throw new CardTransactionException("Unable to complete transaction for the amount: $" + charge);
        
        if(holdNumber < 0)
        	throw new IssuerHoldException("Unable to complete transaction");
        
        boolean paySuccess = creditIssuer.postTransaction(selectedCard.number, holdNumber, charge);
        return paySuccess;
    }
    
    public void setSelectedCard(Card card) {
    	this.selectedCard = card;
    }

	@Override
	public void enabled(AbstractDevice<? extends AbstractDeviceListener> device) {}

	@Override
	public void disabled(AbstractDevice<? extends AbstractDeviceListener> device) {}

	@Override
	public void turnedOn(AbstractDevice<? extends AbstractDeviceListener> device) {
		System.out.println("Turned on");
	}

	@Override
	public void turnedOff(AbstractDevice<? extends AbstractDeviceListener> device) {
		System.out.println("Turned off");
	}

	@Override
	public void cardInserted(CardReader reader) {
	}

	@Override
	public void cardRemoved(CardReader reader) {
		setSelectedCard(null);
	}

	@Override
	public void cardTapped(CardReader reader) {}

	@Override
	public void cardSwiped(CardReader reader) {}

	@Override
	public void cardDataRead(CardReader reader, CardData data) {}
    
}
