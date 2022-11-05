package com.diy.software.testing;

import package com.jimmyelectronics.necchil;

import org.junit.*;
import com.jimmyselectronics.AbstractDevice;
import com.jimmyselectronics.AbstractDeviceListener;
import com.jimmyselectronics.opeechee.*;

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