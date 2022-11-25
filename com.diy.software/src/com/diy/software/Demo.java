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
import com.unitedbankingservices.banknote.Banknote;
import com.unitedbankingservices.coin.Coin;

import ca.powerutility.PowerGrid;
import ca.powerutility.PowerSurge;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        
    	//Making sure there is no Power surge or power outage
    	PowerGrid.engageUninterruptiblePowerSource();
   
    	// Setup station
    	DoItYourselfStationAR station = new DoItYourselfStationAR();
    		
		station.plugIn();
		station.turnOn();

        station.scanner.plugIn();
        station.scanner.turnOn();
        station.cardReader.plugIn();
        station.cardReader.turnOn();
        
        // Setup electronic scale
        station.scale.plugIn();
        station.scale.turnOn();

        // Create barcodes
        Barcode barcode1 = new Barcode(new Numeral[] { Numeral.one });
        Barcode barcode2 = new Barcode(new Numeral[] { Numeral.two, Numeral.three });
        Barcode barcode3 = new Barcode(new Numeral[] { Numeral.one, Numeral.two, Numeral.three });

        // Create barcoded items
        BarcodedItem item1 = new BarcodedItem(barcode1, 15);
        BarcodedItem item2 = new BarcodedItem(barcode2, 25);
        BarcodedItem item3 = new BarcodedItem(barcode3, 35);

        // Create barcoded products
        BarcodedProduct product1 = new BarcodedProduct(barcode1, "Banana", 5, 15);
        BarcodedProduct product2 = new BarcodedProduct(barcode2, "Apples", 10, 25);
        BarcodedProduct product3 = new BarcodedProduct(barcode3, "Bread", 20, 35);

        // Add barcoded products to database
        ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcode1, product1);
        ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcode2, product2);
        ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcode3, product3);

        // Setup currency
        Currency canadianDollar = Currency.getInstance("CAD");

        // Setup Banknotes
        Banknote tenDollar = new Banknote(canadianDollar,10);
        Banknote twentyDollar = new Banknote(canadianDollar,20);
        Banknote fiftyDollar = new Banknote(canadianDollar,50);
        
        // Setup Coins
        Coin toonie = new Coin(canadianDollar,2);
        Coin loonie = new Coin(canadianDollar,1);

        // Setup customer
        Customer customer = new Customer();
        customer.useStation(station);

        // Add items to cart
        customer.shoppingCart.add(item1);
        customer.shoppingCart.add(item2);
        customer.shoppingCart.add(item3);

        initializeWallet(customer, 2, new ArrayList<Boolean>());

        // Populate card issuer
        CardIssuer creditIssuer = initializeCardIssuer(customer);

        // Setup station logic
        DoItYourselfStationLogic stationLogic = new DoItYourselfStationLogic(station, creditIssuer);

        // Start at welcome screen
        WelcomeScreenGui frame = new WelcomeScreenGui(customer, station, stationLogic);
        frame.setVisible(true);
    }
    
	static void initializeWallet(Customer customer, int n, List<Boolean> s) {
	    if(n == 0) {
	    	int customerCards = customer.wallet.cards.size() + 1;
	    	Card card = createCardInfo("Card " + customerCards, s.get(0), s.get(1));
	    	
	    	customer.wallet.cards.add(card);
	    	return;
	    }
	    
	    List<Boolean> a1 = new ArrayList<Boolean>(s);
	    List<Boolean> a2 = new ArrayList<Boolean>(s);
	    
	    a1.add(true);
	    a2.add(false);
	    
	    initializeWallet(customer, n-1, a1);
	    initializeWallet(customer, n-1, a2);
	}
    
    private static Card createCardInfo(String kind, boolean isTap, boolean hasChip) {
    	Random random = new Random();
		String cardNumber = Long.toString((long) (1000000000000000L + random.nextFloat() * 9000000000000000L));
		
		String cvv = Integer.toString(100 + random.nextInt(900));
		String pin = "1234";
		
		Card card = new Card(kind, cardNumber, kind + " Holder", cvv, pin, isTap, hasChip);
		
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