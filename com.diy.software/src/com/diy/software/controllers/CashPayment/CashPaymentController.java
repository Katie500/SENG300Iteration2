package com.diy.software.controllers.CashPayment;

import com.diy.software.DoItYourselfStationLogic;

public class CashPaymentController {
    private DoItYourselfStationLogic stationLogic;
    private long totalPaid;
    private long totalBanknotes;
    private long totalCoins;

    public CashPaymentController(DoItYourselfStationLogic stationLogic){
        this.stationLogic = stationLogic;
    }

    public long getTotalPaid(long totalBanknotes,long totalCoins){
        totalPaid = totalBanknotes + totalCoins;
        return totalPaid;
    }

    public long payWithCash(long totalPaid) throws Exception {
        long charge = stationLogic.productController.getTotal();

        if (charge < 0){
            throw new Exception("Unable to complete transaction for the amount: $" + charge);
        } else if (totalPaid < charge){
            throw new Exception("Please add amount to complete the payment");
        }

        // Calculate change
        long change = totalPaid - charge;
        return change;
    }
}
