package com.diy.software;

import com.diy.hardware.BarcodedProduct;
import com.diy.hardware.DoItYourselfStationAR;
import com.diy.hardware.external.CardIssuer;
import com.diy.hardware.external.ProductDatabases;
import com.diy.simulation.Customer;
import com.jimmyselectronics.necchi.Barcode;
import com.jimmyselectronics.necchi.BarcodedItem;
import com.jimmyselectronics.necchi.Numeral;
import com.jimmyselectronics.opeechee.Card;

import java.util.Calendar;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        // Setup station
    	DoItYourselfStationAR station = new DoItYourselfStationAR();
        station.scanner.plugIn();
        station.scanner.turnOn();

        // Create barcodes
        Barcode barcode1 = new Barcode(new Numeral[] { Numeral.one });
        Barcode barcode2 = new Barcode(new Numeral[] { Numeral.two, Numeral.three });
        Barcode barcode3 = new Barcode(new Numeral[] { Numeral.one, Numeral.two, Numeral.three });

        // Create barcoded items
        BarcodedItem item1 = new BarcodedItem(barcode1, 15);
        BarcodedItem item2 = new BarcodedItem(barcode2, 1);
        BarcodedItem item3 = new BarcodedItem(barcode3, 1);

        // Create barcoded products
        BarcodedProduct product1 = new BarcodedProduct(barcode1, "Food", 5, 15);
        BarcodedProduct product2 = new BarcodedProduct(barcode2, "More Food", 10, 25);
        BarcodedProduct product3 = new BarcodedProduct(barcode3, "All The Tood", 20, 35);

        // Add barcoded products to database
        ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcode1, product1);
        ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcode2, product2);
        ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcode3, product3);

        // Setup customer
        Customer customer = new Customer();
        customer.useStation(station);

        // Add items to cart
        customer.shoppingCart.add(item1);
        customer.shoppingCart.add(item2);
        customer.shoppingCart.add(item3);

        // Create cards
        Card card = new Card("Credit", "0000111122223333", "John Doe", "012", "345", true, true);

        // Add card to customer waller
        customer.wallet.cards.add(card);

        // Populate card issuer
        CardIssuer creditIssuer = new CardIssuer("Credit", 10);
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        creditIssuer.addCardData(card.number, card.cardholder, c, card.cvv, 10000);

        // Setup station logic
        DoItYourselfStationLogic stationLogic = new DoItYourselfStationLogic(station, creditIssuer);

        // Start at welcome screen
        WelcomeScreen frame = new WelcomeScreen(customer, station, stationLogic);
        frame.setVisible(true);
    }
}