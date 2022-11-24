package com.diy.software.test;

import static org.junit.Assert.*;
import org.junit.*;

import com.diy.software.controllers.PaymentController;
import com.jimmyselectronics.opeechee.CardReader;

public class PaymentControllerTest {
	CardReader cardReader = new CardReader();
	PaymentController paymentController;
	
	
	@Before
	public void setup() {
		// Insert to card reader
		
	}
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	/*
	 * PaymentController(DoItYourselfStationLogic stationLogic, CardIssuer creditIssuer) 
	 * 
	 * Test constructor when DIYLogic parameter is null
	 * Test constructor when CardIssuer param is null
	 * 
	 * */

	/*
	 * validateCardPayment(Card selectedCard, String pinEntered, CardReader cardReader) 
	 * 
	 * Test when the method takes any null parameter
	 * Test when the method takes a pin "" or null. IllegalArgumentException
	 * Test when the method take an invalid pin that is not null or ""
	 * Test when the card chip reader fails
	 * Test when the card inserted has no chip
	 * Test when a card is already inserted
	 * Test when paying with a blocked card
	 * Test when the transaction is successful
	 * */
	
	/*
	 * payWithCard() 
	 * 
	 * Test when the charge is $0. CardTransactionException
	 * Test when the charge is greater than the amount in the debit card, or limit of credit card. IssuerHoldException
	 * Test when the transaction is successful
	 * */
}
