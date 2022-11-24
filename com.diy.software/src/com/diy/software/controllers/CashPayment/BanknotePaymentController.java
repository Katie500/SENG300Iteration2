package com.diy.software.controllers.CashPayment;

import com.diy.software.DoItYourselfStationLogic;
import com.unitedbankingservices.banknote.Banknote;
import com.unitedbankingservices.banknote.BanknoteValidator;
import com.unitedbankingservices.banknote.BanknoteValidatorObserver;

import java.util.Currency;

public class BanknotePaymentController implements BanknoteValidatorObserver {

    private Banknote newBanknote;

    long total;
    private DoItYourselfStationLogic stationLogic;

    public BanknotePaymentController(DoItYourselfStationLogic stationLogic){
        this.stationLogic = stationLogic;
    }

    @Override
    public void validBanknoteDetected(BanknoteValidator validator, Currency currency, long value) {
        total += value;
    }

    @Override
    public void invalidBanknoteDetected(BanknoteValidator validator) {
        newBanknote = null;
    }

    public long getTotalBanknotes(){
        return total;
    }
}
