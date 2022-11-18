package com.diy.software.controllers;

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

    /**
     * @return If a card is currently inserted into the machine.
     */
    public boolean payWithCard() {
        long charge = stationLogic.productController.getTotal();
        long holdNumber = creditIssuer.authorizeHold(cardData.getNumber(), charge);
        boolean paySuccess = creditIssuer.postTransaction(cardData.getNumber(), holdNumber, charge);
        return paySuccess;
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
