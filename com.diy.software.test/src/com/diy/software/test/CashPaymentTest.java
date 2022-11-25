package com.diy.software.test;

import static com.diy.software.gui.cardpayment.CardPinpadGui.stationLogic;
import static org.junit.Assert.*;

import com.diy.hardware.BarcodedProduct;
import com.diy.hardware.DoItYourselfStationAR;
import com.diy.hardware.external.CardIssuer;
import com.diy.hardware.external.ProductDatabases;
import com.diy.simulation.Customer;
import com.diy.software.DoItYourselfStationLogic;
import com.diy.software.controllers.CashPayment.BanknotePaymentController;
import com.diy.software.controllers.CashPayment.CashPaymentController;
import com.diy.software.controllers.CashPayment.CoinPaymentController;
import com.diy.software.controllers.ProductController;
import com.jimmyselectronics.necchi.Barcode;
import com.jimmyselectronics.necchi.BarcodeScanner;
import com.jimmyselectronics.necchi.BarcodedItem;
import com.jimmyselectronics.necchi.Numeral;
import com.unitedbankingservices.banknote.Banknote;
import com.unitedbankingservices.banknote.BanknoteValidator;
import com.unitedbankingservices.coin.Coin;
import org.junit.Before;
import org.junit.Test;
import java.util.Currency;

public class CashPaymentTest {
    DoItYourselfStationAR stationAR = new DoItYourselfStationAR();
    private CardIssuer cardissuer;
    DoItYourselfStationLogic stationLogic = new DoItYourselfStationLogic(stationAR, cardissuer);
    ProductController product = new ProductController(stationLogic);

    BarcodeScanner newScanner = new BarcodeScanner();

    @Before
    public void setUp(){
        stationLogic.station.plugIn();

        Barcode barcode1 = new Barcode(new Numeral[] { Numeral.one });
        Barcode barcode2 = new Barcode(new Numeral[] { Numeral.two, Numeral.three });
        Barcode barcode3 = new Barcode(new Numeral[] { Numeral.one, Numeral.two, Numeral.three });

        // Create barcoded items
        BarcodedItem item1 = new BarcodedItem(barcode1, 15);
        BarcodedItem item2 = new BarcodedItem(barcode2, 1);
        BarcodedItem item3 = new BarcodedItem(barcode3, 1);

        // Create barcoded products
        BarcodedProduct product1 = new BarcodedProduct(barcode1, "Chocolate", 5, 15);
        BarcodedProduct product2 = new BarcodedProduct(barcode2, "Grapes", 10, 25);
        BarcodedProduct product3 = new BarcodedProduct(barcode3, "Chips", 20, 35);

        // Add barcoded products to database
        ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcode1, product1);
        ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcode2, product2);
        ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcode3, product3);

        // Setup customer
        Customer customer = new Customer();
        customer.useStation(stationAR);

        // Add items to cart
        customer.shoppingCart.add(item1);
        customer.shoppingCart.add(item2);
        customer.shoppingCart.add(item3);

        stationLogic.productController.barcodeScanned(newScanner,barcode1);
        stationLogic.productController.barcodeScanned(newScanner,barcode2);
        stationLogic.productController.barcodeScanned(newScanner,barcode3);

        long total = product1.getPrice();
        System.out.println(product1.getPrice());
        stationLogic.productController.addToTotal(total);

        // Setup currency
        Currency canadianDollar = Currency.getInstance("CAD");

        // Setup Banknotes
        Banknote tenDollar = new Banknote(canadianDollar,10);
        Banknote twentyDollar = new Banknote(canadianDollar,20);
        Banknote fiftyDollar = new Banknote(canadianDollar,50);

        // Setup Coins
        Coin toonie = new Coin(canadianDollar,2);
        Coin loonie = new Coin(canadianDollar,1);
    }


    @Test
    public void testTotalBanknote1(){
        Currency canadianDollar = Currency.getInstance("CAD");
        BanknotePaymentController newBanknote = new BanknotePaymentController(stationLogic);
        newBanknote.validBanknoteDetected(null,canadianDollar,10);
        assertEquals(10,newBanknote.getTotalBanknotes());
    }

    @Test
    public void testTotalBanknote2(){
        Currency canadianDollar = Currency.getInstance("CAD");
        BanknotePaymentController newBanknote = new BanknotePaymentController(stationLogic);
        newBanknote.validBanknoteDetected(null,canadianDollar,10);
        newBanknote.validBanknoteDetected(null,canadianDollar,20);
        assertEquals(30,newBanknote.getTotalBanknotes());
    }

    @Test
    public void testTotalCoin1(){
        Currency canadianDollar = Currency.getInstance("CAD");
        CoinPaymentController newCoin = new CoinPaymentController(stationLogic);
        newCoin.validCoinDetected(null,2);
        assertEquals(2,newCoin.getTotalCoins());
    }

    @Test
    public void testTotalCoin2(){
        Currency canadianDollar = Currency.getInstance("CAD");
        CoinPaymentController newCoin = new CoinPaymentController(stationLogic);
        newCoin.validCoinDetected(null,2);
        newCoin.validCoinDetected(null,1);
        assertEquals(3,newCoin.getTotalCoins());
    }

    @Test
    public void testTotalPaid(){

        CashPaymentController newCashPayment = new CashPaymentController(stationLogic);
        BanknotePaymentController newBanknote = new BanknotePaymentController(stationLogic);
        CoinPaymentController newCoin = new CoinPaymentController(stationLogic);

        Currency canadianDollar = Currency.getInstance("CAD");
        newBanknote.validBanknoteDetected(null,canadianDollar,10);
        newCoin.validCoinDetected(null,2);

        assertEquals(12,newCashPayment.getTotalPaid(newBanknote.getTotalBanknotes(),newCoin.getTotalCoins()));

    }

    @Test
    public void testGetChange() throws Exception {
        Barcode barcode1 = new Barcode(new Numeral[] { Numeral.one });
        BarcodedProduct product1 = new BarcodedProduct(barcode1, "Chocolate", 5, 15);
        stationLogic.productController.barcodeScanned(newScanner,barcode1);
        long total = product1.getPrice();
        stationLogic.productController.addToTotal(total);

        CashPaymentController newCashPayment = new CashPaymentController(stationLogic);
        BanknotePaymentController newBanknote = new BanknotePaymentController(stationLogic);
        CoinPaymentController newCoin = new CoinPaymentController(stationLogic);

        Currency canadianDollar = Currency.getInstance("CAD");
        newBanknote.validBanknoteDetected(null,canadianDollar,10);
        newBanknote.validBanknoteDetected(null,canadianDollar,20);

        assertEquals(25,newCashPayment.payWithCash(newCashPayment.getTotalPaid(newBanknote.getTotalBanknotes(),newCoin.getTotalCoins())));



    }



}
