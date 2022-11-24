package com.diy.software.controllers.CashPayment;

import com.diy.software.DoItYourselfStationLogic;

public class CashPaymentController {
    private DoItYourselfStationLogic stationLogic;
    private BanknotePaymentController banknotePaymentController;
    private CoinPaymentController coinPaymentController;

    public CashPaymentController(DoItYourselfStationLogic stationLogic,BanknotePaymentController banknotePaymentController,CoinPaymentController coinPaymentController){
        this.stationLogic = stationLogic;
        this.banknotePaymentController = banknotePaymentController;
        this.coinPaymentController = coinPaymentController;
    }

    public long payWithCash(){
        long charge = stationLogic.productController.getTotal();
        long totalBanknotes = banknotePaymentController.getTotalBanknotes();
        long totalCoins = coinPaymentController.getTotalCoins();
        long totalPaid = totalBanknotes + totalCoins;
        long change = totalPaid - charge;
        return change;
    }
}
