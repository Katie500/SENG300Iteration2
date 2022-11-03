package com.diy.software.controllers;

import com.diy.hardware.BarcodedProduct;
import com.diy.hardware.external.ProductDatabases;
import com.diy.software.DoItYourselfStationLogic;
import com.jimmyselectronics.necchi.Barcode;
import com.jimmyselectronics.necchi.BarcodeScanner;
import com.jimmyselectronics.necchi.BarcodeScannerListener;

import java.util.ArrayList;
import java.util.List;

public class ProductController implements BarcodeScannerListener {
    private DoItYourselfStationLogic stationLogic;
    private List<BarcodedProduct> cart = new ArrayList();

    /**
     * Basic constructor.
     *
     * @param stationLogic
     *            The station logic that this is part of.
     */
    public ProductController(DoItYourselfStationLogic stationLogic) {
        this.stationLogic = stationLogic;
    }

    /**
     * Obtains the list of items scanned with this machine
     *
     * @return The total list of items scanned during the current transaction.
     */
    public List<BarcodedProduct> getCart() {
        return cart;
    }

    /**
     * Clears the current list of items scanned with this machine
     */
    public void clearCart() {
        cart.clear();
    }

    /**
     * Obtains the total value of the items scanned with this machine
     *
     * @return The total value of items scanned during the current transaction.
     */
    public long getTotal() {
        return cart.stream().mapToLong(p -> p.getPrice()).sum();
    }

    @Override
    public void barcodeScanned(BarcodeScanner barcodeScanner, Barcode barcode)  {
        // Ignore when there is no session in progress
        if(!stationLogic.getInProgress())
            return;

        // Ignore when there is no product associated with the barcode
        if(!ProductDatabases.BARCODED_PRODUCT_DATABASE.containsKey(barcode))
            return;

        // Add the product to the cart
        var product = ProductDatabases.BARCODED_PRODUCT_DATABASE.get(barcode);
        cart.add(product);
    }
}
