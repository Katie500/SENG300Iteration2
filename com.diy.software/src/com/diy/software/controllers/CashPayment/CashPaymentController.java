package com.diy.software.controllers.CashPayment;

import com.diy.software.DoItYourselfStationLogic;

public class CashPaymentController {
    private DoItYourselfStationLogic stationLogic;
    private BanknotePaymentController banknotes;
    private CoinPaymentController coins;

    public CashPaymentController(DoItYourselfStationLogic stationLogic,BanknotePaymentController banknotes,CoinPaymentController coins){
        this.stationLogic = stationLogic;
        this.banknotes = banknotes;
        this.coins = coins;
    }

    public long payWithCash() throws Exception {

        long charge = stationLogic.productController.getTotal();
        long totalBanknotes = banknotes.getTotalBanknotes();
        long totalCoins = coins.getTotalCoins();
        long totalPaid = totalBanknotes + totalCoins;
        stationLogic.productController.subtractFromTotal(totalPaid);

        if (charge < 0){
            throw new Exception("Unable to complete transaction for the amount: $" + charge);
        } else if (totalPaid < charge){
            throw new Exception("Please add amount to complete the payment");
        }

        long change = totalPaid - charge;
        return change;
    }
}
