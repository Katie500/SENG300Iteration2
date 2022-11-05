package com.diy.software.testing;

//import package com.jimmyelectronics.necchi;
//import package com.jimmyelectronics.opeechee;

import org.junit.*;
import com.jimmyselectronics.AbstractDevice;
import com.jimmyselectronics.AbstractDeviceListener;
import com.jimmyselectronics.opeechee.*;
import com.jimmyselectronics.nechi.*;

public class addItemsByScanTest {

    public BarcodedItem item1;
    public BarcodedItem item2;

    @Before
    public void setup(){
        scanner = new BarcodeScanner();
        barcode = new Barcode(new Numeral[] { Numeral.one, Numeral.one, Numeral.one, Numeral.one }); // 1111
        barcode2 = new Barcode(new Numeral[] { Numeral.one, Numeral.two, Numeral.three, Numeral.four }); // 1234
        item = new BarcodedItem(barcode, 10);
        item2 = new BarcodedItem(barcode2, 10);
    }

    @Test(expected = weightDiscrepancyException)
    public void weightDiscrepancyTest(){
        //Test to scan an item with valid baarcode, once item added to cart,
    // weight in bagging area does not correspond to expectations
    }


    @Test
    public void addedToCartTest(){
        // Successful addition of item by scan test
        // Include assert test for correct weight of bagging area after addition of scanned item
    }

    @Test
    public void notRegisteredTest(){
        // No customer session, thus scan should be ignored and not registered.
    }

    @Test
    public void scannerPowerOffTest(){
    }



}
-----------------------------------------------------------------------------------------------------------------

public class payWithCreditCardTest(){
    private CardReader reader;
    private Card card;
    private String pin;

    @Before
    public void setup(){
        pin = "1234";
        reader = new CardReader();
        card = new Card("Visa", "1234", "Tony", "333", pin, true, true);
    }

    @Test
    public void blockCardTest(){
        // Block card if wrong pin entered three times
    }

    @Test
    public void cardDeniedTest(){
        // Case where the transaction fails due to issues with the bank
    }

    @Test
    public void cardInsertTest(){
        // Test ability to read a card and its details
    }

    @Test
    public void successfulPaymentTest(){
        // transaction goes through and the amount due is decremented.
        // Maybe test for printout of receipt or formulaation of receipt
    }

    @Test
    public void cardRemovedTest(){
        // Check for any card details once card is removed.
        // Most details should not be saved typically. For security / privacy reasons
    }
}