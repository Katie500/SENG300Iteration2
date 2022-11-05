package com.diy.software;

import com.diy.hardware.BarcodedProduct;
import com.diy.hardware.DoItYourselfStation;
import com.diy.hardware.external.ProductDatabases;
import com.diy.simulation.Customer;
import com.jimmyselectronics.necchi.Barcode;
import com.jimmyselectronics.necchi.BarcodeScanner;
import com.jimmyselectronics.necchi.BarcodedItem;
import com.jimmyselectronics.necchi.Numeral;
import com.jimmyselectronics.necchi.SampleBarcodeScannerListener;

public class Demo {
    private Barcode barcode;
    private BarcodedItem item;
    private BarcodeScanner scanner;
    private SampleBarcodeScannerListener listener1, listener2, listener3;


    public static void main(String[] args) {
        // Setup Station
        DoItYourselfStation station = new DoItYourselfStation();
        station.scanner.plugIn();
        station.scanner.turnOn();

        // Setup customer
        Customer customer = new Customer();
        customer.useStation(station);

        // Create barcodes
        Barcode barcode1 = new Barcode(new Numeral[] { Numeral.one }); // 1
        Barcode barcode2 = new Barcode(new Numeral[] { Numeral.two, Numeral.three }); // 23
        Barcode barcode3 = new Barcode(new Numeral[] { Numeral.one, Numeral.two, Numeral.three }); // 123

        // Create barcoded items
        BarcodedItem item1 = new BarcodedItem(barcode1, 1);
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

        // Add items to cart
        customer.shoppingCart.add(item1);
        customer.shoppingCart.add(item2);
        customer.shoppingCart.add(item3);

        // TODO: Finish this part
        // CheckoutStationGui frame = new CheckoutStationGui(customer,station);
        // frame.setVisible(true);
    }
}