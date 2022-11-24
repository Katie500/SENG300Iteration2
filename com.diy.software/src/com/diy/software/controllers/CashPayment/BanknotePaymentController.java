package com.diy.software.controllers.CashPayment;

import com.diy.software.DoItYourselfStationLogic;
import com.unitedbankingservices.banknote.Banknote;
import com.unitedbankingservices.banknote.BanknoteDispenserObserver;
import com.unitedbankingservices.banknote.IBanknoteDispenser;

public class BanknotePaymentController implements BanknoteDispenserObserver {

    private long banknote_value = 0;
    private DoItYourselfStationLogic stationLogic;

    public BanknotePaymentController(DoItYourselfStationLogic stationLogic){
        this.stationLogic = stationLogic;
    }

    public void billAdded(IBanknoteDispenser dispenser, Banknote banknote) {}

}
