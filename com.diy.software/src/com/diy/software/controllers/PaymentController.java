package com.diy.software.controllers;

import com.diy.hardware.external.CardIssuer;
import com.diy.software.DoItYourselfStationLogic;
import com.jimmyselectronics.opeechee.Card;
import com.jimmyselectronics.opeechee.CardReader;
import com.jimmyselectronics.opeechee.CardReaderListener;

public class PaymentController implements CardReaderListener {
    private DoItYourselfStationLogic stationLogic;
    private CardIssuer creditIssuer;

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
        cardInserted = true;
    }

    @Override
    public void cardRemoved(CardReader reader) {
        cardInserted = false;
    }

    /**
     * @return If a card is currently inserted into the machine.
     */
    public boolean payWithCard() {
        return true;
    }

    @Override
    public void cardDataRead(CardReader reader, Card.CardData data) {
    }
}
