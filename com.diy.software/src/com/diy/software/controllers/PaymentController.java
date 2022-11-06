package com.diy.software.controllers;

import com.diy.hardware.external.CardIssuer;
import com.diy.software.DoItYourselfStationLogic;
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
    public boolean payWithCard(long charge) {
        long holdNumber = creditIssuer.authorizeHold(cardData.getNumber(), charge);
        boolean paySuccess = creditIssuer.postTransaction(cardData.getNumber(), holdNumber, charge);
        return paySuccess;
    }
}
