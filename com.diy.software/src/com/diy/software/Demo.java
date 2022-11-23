package com.diy.software;

import com.diy.hardware.BarcodedProduct;
import com.diy.hardware.DoItYourselfStationAR;
import com.diy.hardware.external.CardIssuer;
import com.diy.hardware.external.ProductDatabases;
import com.diy.simulation.Customer;
import com.diy.software.gui.WelcomeScreenGui;

import com.jimmyselectronics.necchi.Barcode;
//import com.jimmyselectronics.necchi.BarcodedItem;
import com.jimmyselectronics.necchi.BarcodedItem;
import com.jimmyselectronics.necchi.Numeral;
import com.jimmyselectronics.opeechee.Card;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        // Setup station
    	DoItYourselfStationAR station = new DoItYourselfStationAR();
        station.scanner.plugIn();
        station.scanner.turnOn();
        station.cardReader.plugIn();
        station.cardReader.turnOn();

        // Create barcodes
        Barcode barcode1 = new Barcode(new Numeral[] { Numeral.one });
        Barcode barcode2 = new Barcode(new Numeral[] { Numeral.two, Numeral.three });
        Barcode barcode3 = new Barcode(new Numeral[] { Numeral.one, Numeral.two, Numeral.three });

        // Create barcoded items
        BarcodedItem item1 = new BarcodedItem(barcode1, 15);
        BarcodedItem item2 = new BarcodedItem(barcode2, 1);
        BarcodedItem item3 = new BarcodedItem(barcode3, 1);

        // Create barcoded products
        BarcodedProduct product1 = new BarcodedProduct(barcode1, "Banana", 5, 15);
        BarcodedProduct product2 = new BarcodedProduct(barcode2, "Apples", 10, 25);
        BarcodedProduct product3 = new BarcodedProduct(barcode3, "Bread", 20, 35);

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

        initializeWallet(customer);

        // Populate card issuer
        CardIssuer creditIssuer = initializeCardIssuer(customer);

        // Setup station logic
        DoItYourselfStationLogic stationLogic = new DoItYourselfStationLogic(station, creditIssuer);

        // Start at welcome screen
        WelcomeScreenGui frame = new WelcomeScreenGui(customer, station, stationLogic);
        frame.setVisible(true);
    }
    
    private static void initializeWallet(Customer customer) {
    	// Create credit card
    	Card debitCard = createCardInfo("Debit Card");
    	Card creditCard = createCardInfo("Credit Card");
    	
    	// Add cards to the customer's wallet
    	customer.wallet.cards.add(debitCard);
    	customer.wallet.cards.add(creditCard);
    }
    
    private static Card createCardInfo(String kind) {
    	Random random = new Random();
		String cardNumber = Long.toString((long) (1000000000000000L + random.nextFloat() * 9000000000000000L));
		
		String cvv = Integer.toString(100 + random.nextInt(900));
		String pin = "1234";
		
		Card card = new Card(kind, cardNumber, kind + " Holder", cvv, pin, true, true);
		
		return card;
    }
    
    private static CardIssuer initializeCardIssuer(Customer customer) {
    	CardIssuer cardIssuer = new CardIssuer("Card Issuer", 10);
    	
    	// Set card expiration to two years from now.
    	Date date = new Date();
    	
    	Calendar c = Calendar.getInstance();   
    	c.setTimeInMillis(date.getTime());
    	c.add(Calendar.YEAR, 2);
    	

    	// Add cards from the customer's wallet to the card issuer.
    	List<Card> cards = customer.wallet.cards;
    	
    	for(int i = 0; i< cards.size(); i++) {
    		Card card = cards.get(i);
    		cardIssuer.addCardData(card.number, card.cardholder, c, card.cvv, 10000);
    	}
    	
    	return cardIssuer;
    }
}