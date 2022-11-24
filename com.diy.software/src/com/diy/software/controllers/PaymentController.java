package com.diy.software.controllers;

import java.io.IOException;

import com.diy.hardware.external.CardIssuer;
import com.diy.software.DoItYourselfStationLogic;
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

    public boolean validateCardPayment(Card selectedCard, String pinEntered, CardReader cardReader) throws Exception {
    	boolean isSuccess;
    	
		if (selectedCard == null) {
			throw new Exception("Please select a card from the wallet.");
		} else {
			try {
				cardReader.insert(selectedCard, pinEntered);
				
				isSuccess = payWithCard();
				
				cardReader.remove();
			} catch (IOException e) {
				String exceptionMessage = e.toString();
				
				cardReader.remove();
				
				if (exceptionMessage.contains("InvalidPINException")) {
					// If the pin entered is invalid,display an error message.
					throw new Exception("Invalid pin.");
				} else if (exceptionMessage.contains("BlockedCardException")) {
					// If the customer enters the wrong pin 3 times, the card is blocked.
					creditIssuer.block(selectedCard.number);
					throw new Exception(selectedCard.kind + " is blocked.");
				} else if (exceptionMessage.contains("ChipFailureException")) {
					// If the card has a chip but the reader failed to read the card data.
					if(selectedCard.hasChip) {
						throw new Exception("Chip failure. Please reinsert the card, and enter the pin.");
					} else {
						throw new Exception("Inserted card has no chip.");
					}
				}
				
				throw e;
			}
		
		return isSuccess;
		}
	}
    
    /**
     * @return If a card transaction is successful or not
     */
    public boolean payWithCard() throws Exception {
        long charge = stationLogic.productController.getTotal();
        long holdNumber = creditIssuer.authorizeHold(cardData.getNumber(), charge);
        
        if(charge <= 0) {
        	throw new Exception("Unable to complete transaction for the amount: $" + charge);
        } else if(holdNumber < 0) {
        	throw new Exception("Unable to complete transaction");
        }
        
        boolean paySuccess = creditIssuer.postTransaction(cardData.getNumber(), holdNumber, charge);
        return paySuccess;
    }
    
    public void transactionStatus(boolean isSuccess) {
    }
    
    @Override
    public void cardInserted(CardReader reader) {
    }
    
    @Override
    public void cardRemoved(CardReader reader) {
        cardData = null;
    }

    @Override
    public void cardDataRead(CardReader reader, Card.CardData data) {
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
