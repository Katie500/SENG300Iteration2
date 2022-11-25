package com.diy.software.controllers.CashPayment;

import com.diy.software.DoItYourselfStationLogic;
import com.unitedbankingservices.coin.*;

public class CoinPaymentController implements CoinValidatorObserver {
    private DoItYourselfStationLogic stationLogic;
    long total;

    public CoinPaymentController(DoItYourselfStationLogic stationLogic){
        this.stationLogic = stationLogic;
    }

    @Override
    public void validCoinDetected(CoinValidator validator, long value) {
        total += value;
    }

    @Override
    public void invalidCoinDetected(CoinValidator validator) {
    }

    public long getTotalCoins(){
        return total;
    }

}
