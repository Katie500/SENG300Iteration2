package com.diy.software.controllers.CashPayment;

import com.diy.software.DoItYourselfStationLogic;
import com.unitedbankingservices.coin.Coin;
import com.unitedbankingservices.coin.CoinDispenserObserver;
import com.unitedbankingservices.coin.ICoinDispenser;

public class CoinPaymentController implements CoinDispenserObserver {
    private DoItYourselfStationLogic stationLogic;
    private Coin newCoin;
    private long coin_value;
    private long total_coins;

    public CoinPaymentController(DoItYourselfStationLogic stationLogic,Coin newCoin){
        this.stationLogic = stationLogic;
        this.newCoin = newCoin;
        coin_value = 0;
        total_coins = 0;
    }

    @Override
    public void coinAdded(ICoinDispenser dispenser, Coin coin) {
        newCoin = coin;
    }

    @Override
    public void coinRemoved(ICoinDispenser dispenser, Coin coin) {
        newCoin = null;
    }

    @Override
    public void coinsLoaded(ICoinDispenser dispenser, Coin... coins) {}

    @Override
    public void coinsUnloaded(ICoinDispenser dispenser, Coin... coins) {}

    public long getTotalCoins(){
        coin_value = newCoin.getValue();
        total_coins += coin_value;
        return total_coins;
    }

}
