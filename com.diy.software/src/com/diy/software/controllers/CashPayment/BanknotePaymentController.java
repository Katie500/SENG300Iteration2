package com.diy.software.controllers.CashPayment;

import com.diy.software.DoItYourselfStationLogic;
import com.unitedbankingservices.banknote.Banknote;
import com.unitedbankingservices.banknote.BanknoteDispenserObserver;
import com.unitedbankingservices.banknote.IBanknoteDispenser;

public class BanknotePaymentController implements BanknoteDispenserObserver {

    private Banknote newBanknote;
    private long banknote_value;
    private long total_banknotes;
    private DoItYourselfStationLogic stationLogic;

    public BanknotePaymentController(DoItYourselfStationLogic stationLogic, Banknote newBanknote){
        this.stationLogic = stationLogic;
        this.newBanknote = newBanknote;
        banknote_value = 0;
        total_banknotes = 0;
    }

    @Override
    public void billAdded(IBanknoteDispenser dispenser, Banknote banknote) {
        newBanknote = banknote;
    }

    @Override
    public void banknoteRemoved(IBanknoteDispenser dispenser, Banknote banknote){
        newBanknote = null;
    }

    @Override
    public void banknotesLoaded(IBanknoteDispenser dispenser, Banknote... banknotes) {
    }

    @Override
    public void banknotesUnloaded(IBanknoteDispenser dispenser, Banknote... banknotes) {
    }

    public long getTotalBanknotes(){
        banknote_value = newBanknote.getValue();
        total_banknotes += banknote_value;
        return total_banknotes;
    }
}
