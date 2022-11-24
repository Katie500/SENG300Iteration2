package com.diy.software.controllers;

import java.io.IOException;

import com.diy.hardware.external.CardIssuer;
import com.diy.software.DoItYourselfStationLogic;
import com.diy.software.gui.ConfirmationScreenGui;
import com.diy.software.gui.PaymentErrorGui;
import com.jimmyselectronics.AbstractDevice;
import com.jimmyselectronics.AbstractDeviceListener;
import com.jimmyselectronics.opeechee.Card;
import com.jimmyselectronics.opeechee.CardReader;
import com.jimmyselectronics.opeechee.CardReaderListener;

public class PaymentController implements CardReaderListener {
    private DoItYourselfStationLogic stationLogic;
    private CardIssuer creditIssuer;
    private Card.CardData cardData;

    /**
     * Basic constructor.
     *
     * @param stationLogic
     *            The station logic that this is part of.
     */
    public PaymentController(DoItYourselfStationLogic stationLogic, CardIssuer creditIssuer) {
        this.stationLogic = stationLogic;
        this.creditIssuer = creditIssuer;
    }

    /**
     * @return If a card is currently inserted into the machine.
     */
    public boolean payWithCard() {
        long charge = stationLogic.productController.getTotal();
        long holdNumber = creditIssuer.authorizeHold(cardData.getNumber(), charge);
        
        boolean paySuccess = creditIssuer.postTransaction(cardData.getNumber(), holdNumber, charge);
        return paySuccess;
    }

    public void validateCardPayment(Card selectedCard, String pinEntered, CardReader cardReader) throws Exception {
		if (selectedCard == null) {
			throw new Exception("Please select a card from the wallet.");
		} else {
			try {
				cardReader.insert(selectedCard, pinEntered);
				
				boolean isSuccess = stationLogic.paymentController.payWithCard();
			} catch (IOException e) {
				String exceptionMessage = e.toString();

				if (exceptionMessage.contains("InvalidPINException")) {
					// If the pin entered is invalid,display an error message.
					throw new Exception("Invalid pin.");

				} else if (exceptionMessage.contains("BlockedCardException")) {
					// If the customer enters the wrong pin 3 times, the card is blocked.
					stationLogic.paymentController.blockCard(selectedCard.number);
					throw new Exception(selectedCard.kind + " is blocked.");
					
				} else if (exceptionMessage.contains("ChipFailureException")) {
					// If the chip failed.
					throw new Exception("Chip failure. Reinsert the card, and enter the pin.");
				}
			}
			
			cardReader.remove();
		}
	}
    
    public void blockCard(String cardNumber) {
    	creditIssuer.block(cardNumber);
    }
    
    @Override
    public void cardInserted(CardReader reader) {
    	System.out.println("Card insert listener");
    }
    
    @Override
    public void cardRemoved(CardReader reader) {
        cardData = null;
    }

    @Override
    public void cardDataRead(CardReader reader, Card.CardData data) {
    	System.out.println("data read");
        cardData = data;
    }
    
	@Override
	public void enabled(AbstractDevice<? extends AbstractDeviceListener> device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disabled(AbstractDevice<? extends AbstractDeviceListener> device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnedOn(AbstractDevice<? extends AbstractDeviceListener> device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnedOff(AbstractDevice<? extends AbstractDeviceListener> device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cardTapped(CardReader reader) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cardSwiped(CardReader reader) {
		// TODO Auto-generated method stub
		
	}
}
