package com.diy.software.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.diy.hardware.BarcodedProduct;
import com.diy.hardware.DoItYourselfStationAR;
import com.diy.hardware.external.CardIssuer;
import com.diy.hardware.external.ProductDatabases;
import com.diy.simulation.Customer;
import com.diy.software.DoItYourselfStationLogic;
import com.diy.software.controllers.ProductController;
import com.jimmyselectronics.necchi.Barcode;
import com.jimmyselectronics.necchi.BarcodeScanner;
import com.jimmyselectronics.necchi.BarcodedItem;
import com.jimmyselectronics.necchi.Numeral;

public class WeightDiscrepancyTests {
	
	DoItYourselfStationAR stationAR = new DoItYourselfStationAR();
	CardIssuer cardissuer = new CardIssuer("Credit",10);
	DoItYourselfStationLogic stationLogic = new DoItYourselfStationLogic(stationAR, cardissuer);
	ProductController prodcont = new ProductController(stationLogic);
	Customer customer = new Customer();
	
	@Before
	public void setup() {
	stationLogic.station.plugIn();
	stationLogic.station.turnOn();
	stationLogic.station.scanner.plugIn();
	stationLogic.baggingArea.plugIn();
	stationLogic.baggingArea.turnOn();

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
    customer.useStation(stationAR);

    // Add items to cart
    customer.shoppingCart.add(item1);
    customer.shoppingCart.add(item2);
    customer.shoppingCart.add(item3);
    

	}
	
	

	@Test
	public void testHasPower(){
		stationLogic.station.turnOn();
		stationLogic.baggingArea.plugIn();
		assertTrue(stationLogic.baggingArea.isPoweredUp());
		
	}
	
	@Test
	public void testNoPower(){
		stationLogic.station.turnOn();
		stationLogic.baggingArea.turnOff();
		stationLogic.baggingArea.turnOn();
		assertTrue(stationLogic.baggingArea.isPoweredUp());
	}
	
	@Test
	public void testTurnedOff(){
		stationLogic.station.turnOn();
		stationLogic.baggingArea.turnOff();
		assertFalse(stationLogic.baggingArea.isPoweredUp());
	}
	
	@Test
	public void testDisable() {
		stationLogic.station.turnOn();
		stationLogic.baggingArea.disable();
		assertTrue(stationLogic.baggingArea.isDisabled());
	}
	
	@Test
	public void testEnable() {
		stationLogic.station.turnOn();
		stationLogic.baggingArea.enable();
		assertFalse(stationLogic.baggingArea.isDisabled());
	}
	
	@Test
	public void barcodeScannedTest1() {
		stationLogic.setInProgress(false); //turn logic off
		
		Barcode barcode1 = new Barcode(new Numeral[] { Numeral.one });
		BarcodeScanner scanner = new BarcodeScanner();
		BarcodedProduct product1 = new BarcodedProduct(barcode1, "Chocolate", 5, 15);
		
		prodcont.barcodeScanned(scanner, barcode1);
		
		assertFalse(stationLogic.getInProgress());
		
	}
	

	@Test
	public void barcodeScannedTest2() {
		stationLogic.setInProgress(true); //turn logic off
		
		Barcode barcode1 = new Barcode(new Numeral[] { Numeral.one });
		BarcodeScanner scanner = new BarcodeScanner();
		BarcodedProduct product1 = new BarcodedProduct(barcode1, "Chocolate", 5, 15);
		
		prodcont.barcodeScanned(scanner, barcode1);
		
		assertTrue(stationLogic.getInProgress());
		
	}
	
	@Test
	public void barcodeScannedNoKey() {
		
		Barcode barcode4 = new Barcode(new Numeral[] { Numeral.two, Numeral.two, Numeral.three, Numeral.four });
		BarcodeScanner scanner2 = new BarcodeScanner();
		//BarcodedProduct product1 = new BarcodedProduct(barcode4, "Chocolate", 5, 15);
		
		prodcont.barcodeScanned(scanner2, barcode4);
		
		assertFalse(ProductDatabases.BARCODED_PRODUCT_DATABASE.containsKey(barcode4));
		
	}
	
	@Test
	public void barcodeScanneContainsKey() {
	
		Barcode barcode5 = new Barcode(new Numeral[] { Numeral.one, Numeral.two, Numeral.three, Numeral.four });
		BarcodeScanner scanner1 = new BarcodeScanner();
		BarcodedProduct product1 = new BarcodedProduct(barcode5, "Chocolate", 5, 15);
		ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcode5, product1);
		prodcont.barcodeScanned(scanner1, barcode5);
		
		assertTrue(ProductDatabases.BARCODED_PRODUCT_DATABASE.containsKey(barcode5));
		
	}
	
	@Test
	public void getScannedTest() {
		
		Barcode barcode5 = new Barcode(new Numeral[] { Numeral.one, Numeral.two, Numeral.three, Numeral.four });
		BarcodeScanner scanner1 = new BarcodeScanner();
		BarcodedProduct product1 = new BarcodedProduct(barcode5, "Chocolate", 5, 15);
		ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcode5, product1);
		prodcont.barcodeScanned(scanner1, barcode5);
		List<BarcodedProduct> bdlist = prodcont.getScanned();
		assertEquals(1,bdlist.size());
	}
	
	@Test
	public void clearScannedTest() {
		
		Barcode barcode5 = new Barcode(new Numeral[] { Numeral.one, Numeral.two, Numeral.three, Numeral.four });
		BarcodeScanner scanner1 = new BarcodeScanner();
		BarcodedProduct product1 = new BarcodedProduct(barcode5, "Chocolate", 5, 15);
		ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcode5, product1);
		prodcont.barcodeScanned(scanner1, barcode5);
		List<BarcodedProduct> bdlist = prodcont.getScanned();
		prodcont.clearScanned();
		assertEquals(0,bdlist.size());
	}
	
	@Test
	public void updateNextItemTest() {
		Barcode barcode5 = new Barcode(new Numeral[] { Numeral.one, Numeral.two, Numeral.three, Numeral.four });
		BarcodeScanner scanner1 = new BarcodeScanner();
		BarcodedProduct product1 = new BarcodedProduct(barcode5, "Chocolate", 5, 15);
		ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcode5, product1);
		prodcont.barcodeScanned(scanner1, barcode5);
		prodcont.updateNextItem();
		prodcont.getCurrentIndex();
		assertEquals(prodcont.getCurrentIndex(),1);
		
	}
	
	@Test
	public void getAddToTotalTest() {
		Barcode barcode5 = new Barcode(new Numeral[] { Numeral.one, Numeral.two, Numeral.three, Numeral.four });
		BarcodeScanner scanner1 = new BarcodeScanner();
		BarcodedProduct product1 = new BarcodedProduct(barcode5, "Chocolate", 5, 15);
		ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcode5, product1);
		prodcont.barcodeScanned(scanner1, barcode5);
		long total = product1.getPrice();
		prodcont.addToTotal(total);
		assertEquals(prodcont.getTotal(),5);
		
	}
	
	@Test
	public void resetTotalTest() {
		Barcode barcode5 = new Barcode(new Numeral[] { Numeral.one, Numeral.two, Numeral.three, Numeral.four });
		BarcodeScanner scanner1 = new BarcodeScanner();
		BarcodedProduct product1 = new BarcodedProduct(barcode5, "Chocolate", 5, 15);
		ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcode5, product1);
		prodcont.barcodeScanned(scanner1, barcode5);
		long total = product1.getPrice();
		prodcont.addToTotal(total);
		prodcont.resetTotal();
		assertEquals(prodcont.getTotal(),0);
		
	}
	
	@Test
	public void subtractfromTotalTest(){
		int num = 4;
		Barcode barcode5 = new Barcode(new Numeral[] { Numeral.one, Numeral.two, Numeral.three, Numeral.four });
		BarcodeScanner scanner1 = new BarcodeScanner();
		BarcodedProduct product1 = new BarcodedProduct(barcode5, "Chocolate", 5, 15);
		ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcode5, product1);
		prodcont.barcodeScanned(scanner1, barcode5);
		long total = product1.getPrice();
		prodcont.addToTotal(total);
		prodcont.subtractFromTotal(num);
		assertEquals(1,prodcont.getTotal());
		
	}
	
	@Test
	public void weightDiscrepancy() {
        
		
        customer.selectNextItem();
        customer.scanItem();
        customer.placeItemInBaggingArea();
        
        assertFalse(stationLogic.getWeightDiscrepancy());
	}
	
	@Test
	public void weightDiscrepancy2() {
        
		
        customer.selectNextItem();
        customer.scanItem();
        customer.placeItemInBaggingArea();
        double baggedItemsWeight = stationLogic.electronicScaleListener.getBaggedItemsWeight();
        double expectedOutcome = 15;
        assertEquals(baggedItemsWeight, expectedOutcome,15.0);
	}
}
