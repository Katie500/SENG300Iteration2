package com.diy.software.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.junit.*;
import java.io.IOException;

import com.diy.hardware.DoItYourselfStationAR;
import com.diy.hardware.external.CardIssuer;
import com.diy.software.DoItYourselfStationLogic;
import com.diy.software.controllers.PaymentController;
import com.diy.software.exceptions.CardTransactionException;
import com.diy.software.exceptions.IssuerHoldException;
import com.jimmyselectronics.opeechee.Card;



public class PaymentControllerTest {
	DoItYourselfStationLogic stationLogic;
	CardIssuer cardIssuer;
	
	Card noChip = createCardInfo("No Chip", true, false);
	Card validCard = createCardInfo("Valid card", true, true);
	Card invalidCard = createCardInfo("Invalid Card", true, true);
	Card notInIssuer = createCardInfo("Issuer 2 Card", true, true);
	
	
	private Card createCardInfo(String kind, boolean isTap, boolean hasChip) {
		Random random = new Random();
		String cardNumber = Long.toString((long) (1000000000000000L + random.nextFloat() * 9000000000000000L));
		
		String cvv = Integer.toString(100 + random.nextInt(900));
		String pin = "1234";
		
		Card card = new Card(kind, cardNumber, kind + " Holder", cvv, pin, isTap, hasChip);
		
		return card;
	}
	
	@Before
	public void setup() {
		DoItYourselfStationAR station = new DoItYourselfStationAR();

		// Setup cards in credit issuer
		cardIssuer = new CardIssuer("Card Issuer", 3);

    	// Set card expiration to two years from now.
    	Date date = new Date();
    	Calendar c = Calendar.getInstance();   
    	c.setTimeInMillis(date.getTime());
    	c.add(Calendar.YEAR, 2);
    	
		cardIssuer.addCardData(noChip.number, noChip.cardholder, c, noChip.cvv, 10000);
		cardIssuer.addCardData(validCard.number, validCard.cardholder, c, validCard.cvv, 100000);
		cardIssuer.addCardData(invalidCard.number, invalidCard.cardholder, c, invalidCard.cvv, 10);
		
		
		// Setup stationLogic
		stationLogic = new DoItYourselfStationLogic(station, cardIssuer);
		
		stationLogic.station.plugIn();
		stationLogic.station.turnOn();
		
		stationLogic.productController.resetTotal();
		stationLogic.productController.addToTotal(100);
	}
	
	@Test
	public void testHasPower(){
		stationLogic.station.turnOn();
		stationLogic.station.cardReader.plugIn();
		assertTrue(stationLogic.station.cardReader.isPoweredUp());
		
	}
	
	@Test
	public void testNoPower(){
		stationLogic.station.turnOn();
		assertTrue(stationLogic.station.cardReader.isPoweredUp());
	}
	
	@Test
	public void testTurnedOff(){
		stationLogic.station.turnOn();
		stationLogic.station.turnOff();
		assertFalse(stationLogic.station.cardReader.isPoweredUp());
	}
	
	@Test
	public void testDisable() {
		stationLogic.station.turnOn();
		stationLogic.station.cardReader.disable();
		assertTrue(stationLogic.station.cardReader.isDisabled());
	}
	
	@Test
	public void testEnable() {
		stationLogic.station.turnOn();
		stationLogic.station.cardReader.enable();
		assertFalse(stationLogic.station.cardReader.isDisabled());
	}
	
	/*
	 * PaymentController(DoItYourselfStationLogic stationLogic, CardIssuer creditIssuer) 
	 * 
	 * Test constructor when DIYLogic parameter is null
	 * Test constructor when CardIssuer param is null
	 * 
	 * */

	
	@Test(expected = NullPointerException.class)
	public void testNullParameterConstructor1() {
		 new PaymentController(stationLogic, null);
	}

	@Test(expected = NullPointerException.class)
	public void testNullParameterConstructor2() {
		 new PaymentController(null, cardIssuer);
	}

	
	/*
	 * validateCardPayment(Card selectedCard, String pinEntered, CardReader cardReader) 
	 * 
	 * Test when the method takes any null parameter
	 * Test when the method takes a pin "" or null. IllegalArgumentException
	 * Test when the method take an invalid pin that is not null or ""
	 * Test when no card is inserted
	 * Test when the card chip reader fails
	 * Test when the card inserted has no chip
	 * Test when a card is already inserted
	 * Test when paying with a blocked card
	 * Test when the transaction is successful
	 * */
	
	@Test(expected = IllegalArgumentException.class)
	public void testNoPinEntered1() throws IOException {
		stationLogic.paymentController.validateCardPayment(null, this.stationLogic.station.cardReader, "insert");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNoPinEntered2() throws IOException {
		stationLogic.paymentController.validateCardPayment("", this.stationLogic.station.cardReader, "insert");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNoPinEntered3() throws IOException {
		stationLogic.paymentController.validateCardPayment("  ", this.stationLogic.station.cardReader, "insert");
	}
	
	@Test(expected = NullPointerException.class)
	public void testNoCardInserted1() throws IOException {
		stationLogic.paymentController.validateCardPayment("1234", this.stationLogic.station.cardReader, "insert");
	}

	@Test(expected = NullPointerException.class)
	public void testNoCardInserted2() throws IOException {
		stationLogic.paymentController.setSelectedCard(null);
		stationLogic.paymentController.validateCardPayment("1234", this.stationLogic.station.cardReader, "insert");
	}
	
	@Test(expected = NullPointerException.class)
	public void testNoCardReader() throws IOException {
		stationLogic.paymentController.setSelectedCard(validCard);
		stationLogic.paymentController.validateCardPayment("1234", null, "insert");
	}
	
	@Test
	public void testValidPayment() {
		boolean isSuccess = false;
		boolean chipFailure = false;
		
		do {
			try {
				stationLogic.paymentController.setSelectedCard(validCard);
				isSuccess = stationLogic.paymentController.validateCardPayment("1234", stationLogic.station.cardReader, "insert");
			} catch(Exception e) {
				chipFailure = e.getMessage().contains("ChipFailureException");
			}
		} while (chipFailure);
		
		assertTrue(isSuccess);
	}

	@Test(expected = CardTransactionException.class)
	public void testInvalidCardPin() throws IOException {
		stationLogic.paymentController.setSelectedCard(validCard);
		stationLogic.paymentController.validateCardPayment("4321", stationLogic.station.cardReader, "insert");
	}
	
	@Test
	public void testInsertBlockedCard() {
		String exceptionMsg = "";
		
		int i = 0;
	
		while (i <= 3) {
			try {
				stationLogic.paymentController.setSelectedCard(validCard);
				stationLogic.paymentController.validateCardPayment("4321", stationLogic.station.cardReader, "insert");
			} catch (IOException e) {
				i++;
				exceptionMsg = e.getMessage();
				this.stationLogic.station.cardReader.remove();
			}
		}
		
		assertEquals(validCard.kind + " is blocked.", exceptionMsg);
	}

	@Test
	public void testInsertCardNoChip() {
		String exceptionMsg = "";
	
		try {
			stationLogic.paymentController.setSelectedCard(noChip);
			stationLogic.paymentController.validateCardPayment("1234", stationLogic.station.cardReader, "insert");
		} catch (Exception e) {
			exceptionMsg = e.getMessage();
		}
		
		assertEquals("Inserted card has no chip.", exceptionMsg);
	}

	@Test
	public void testInsertCardChipFail() {
		String exceptionMsg = "";
		
		do {
			try {
				stationLogic.paymentController.setSelectedCard(validCard);
				stationLogic.paymentController.validateCardPayment("1234", stationLogic.station.cardReader, "insert");
			} catch (Exception e) {
				exceptionMsg = e.getMessage();
			}
			
			stationLogic.station.cardReader.remove();
		} while(exceptionMsg.equals(""));

	
		assertEquals("Chip failure. Please reinsert the card, and enter the pin.", exceptionMsg);
	}
	
	@Test
	public void testInsertCardNoCharge() {
		String exceptionMsg = "";
		
		stationLogic.productController.resetTotal();
		long charge = stationLogic.productController.getTotal();
	
		do {
			try {
				stationLogic.paymentController.setSelectedCard(validCard);
				stationLogic.paymentController.validateCardPayment("1234", this.stationLogic.station.cardReader, "insert");
				this.stationLogic.station.cardReader.remove();
			} catch (Exception e) {
				if(!e.getMessage().contains("Chip failure")) {
					exceptionMsg = e.getMessage();
				}
			}
		} while(exceptionMsg.equals(""));

	
		assertEquals("Unable to complete transaction for the amount: $" + charge, exceptionMsg);
	}
	
	@Test(expected = IssuerHoldException.class)
	public void testInsertCardLowLimit() throws IOException {
		String exceptionMsg = "";
	
		do {
			try {
				stationLogic.paymentController.setSelectedCard(invalidCard);
				stationLogic.paymentController.validateCardPayment("1234", this.stationLogic.station.cardReader, "insert");
				stationLogic.station.cardReader.remove();
			} catch (Exception e) {
				if(!e.getMessage().contains("ChipFailureException")) {
					throw e;
				}
			}
		} while(exceptionMsg.equals(""));
	}
	
	@Test(expected = IssuerHoldException.class)
	public void testSwipeCardLowLimit() throws IOException {
		stationLogic.paymentController.setSelectedCard(invalidCard);
		stationLogic.paymentController.validateCardPayment("1234", this.stationLogic.station.cardReader, "swipe");
	}
	
	
	@Test
	public void testSwipeCardSuccess() throws IOException {
		stationLogic.paymentController.setSelectedCard(validCard);
		boolean success = stationLogic.paymentController.validateCardPayment("1234", this.stationLogic.station.cardReader, "swipe");
		
		assertTrue(success);
	}
	
	@Test(expected = IssuerHoldException.class)
	public void testTapCardLowLimit() throws IOException {
		stationLogic.paymentController.setSelectedCard(invalidCard);
		stationLogic.paymentController.validateCardPayment("1234", this.stationLogic.station.cardReader, "tap");
	}
	
	@Test(expected = NullPointerException.class)
	public void testTapCardNoTap() throws IOException {
		Card cardNoTap = createCardInfo("No Tap Card ", false, false);
		stationLogic.paymentController.setSelectedCard(cardNoTap);
		stationLogic.paymentController.validateCardPayment("1234", this.stationLogic.station.cardReader, "tap");
	}
	/*
	 * payWithCard() 
	 * 
	 * Test when the charge is $0. CardTransactionException
	 * Test when the charge is greater than the amount in the debit card, or limit of credit card. IssuerHoldException
	 * Test when the transaction is successful
	 * */
}
