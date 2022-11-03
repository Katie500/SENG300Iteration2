package com.diy.software.controllers;

import com.diy.hardware.external.ProductDatabases;
import com.diy.software.DoItYourselfStationLogic;
import com.jimmyselectronics.necchi.Barcode;
import com.jimmyselectronics.necchi.BarcodeScanner;
import com.jimmyselectronics.necchi.BarcodeScannerListener;

public class ProductController implements BarcodeScannerListener {
    private DoItYourselfStationLogic stationLogic;
    private int totalValue = 0;
    private boolean blocked = false;

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
     * Obtains the total value of the items scanned with this machine
     *
     * @return The total value of items scanned during the current transaction.
     */
    public int getTotal() {
        return totalValue;
    }

    @Override
    public void barcodeScanned(BarcodeScanner barcodeScanner, Barcode barcode)  {
        if(!ProductDatabases.BARCODED_PRODUCT_DATABASE.containsKey(barcode))
            return;

        var product = ProductDatabases.BARCODED_PRODUCT_DATABASE.get(barcode);
        totalValue += product.getPrice();
    }
}
