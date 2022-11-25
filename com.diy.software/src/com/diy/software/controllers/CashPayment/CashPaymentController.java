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

        // Calculate change
        long change = totalPaid - charge;
        return change;
    }
}
