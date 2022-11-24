package com.diy.software.controllers;

import com.diy.hardware.BarcodedProduct;
import com.diy.hardware.external.ProductDatabases;
import com.diy.software.DoItYourselfStationLogic;
import com.jimmyselectronics.AbstractDevice;
import com.jimmyselectronics.AbstractDeviceListener;
import com.jimmyselectronics.necchi.Barcode;
import com.jimmyselectronics.necchi.BarcodeScanner;
import com.jimmyselectronics.necchi.BarcodeScannerListener;

import java.util.ArrayList;
import java.util.List;

public class ProductController implements BarcodeScannerListener {
    private DoItYourselfStationLogic stationLogic;
    public List<BarcodedProduct> scanned = new ArrayList();

    private long totalPrice;
    private int currentItem;

    /**
     * Basic constructor.
     *
     * @param stationLogic
     *            The station logic that this is part of.
     */
    public ProductController(DoItYourselfStationLogic stationLogic) {
        this.stationLogic = stationLogic;
        totalPrice = 0;
        currentItem = 0;
    }

    /**
     * Obtains the list of items scanned with this machine
     *
     * @return The total list of items scanned during the current transaction.
     */
    public List<BarcodedProduct> getScanned() {
        return scanned;
    }

    /**
     * Clears the current list of items scanned with this machine
     */
    public void clearScanned() {
        scanned.clear();
    }

    /**
     * Obtains the total value of the items scanned with this machine
     *
     * @return The total value of items scanned during the current transaction.
     */

    public void updateNextItem() {
        currentItem = currentItem + 1;
    }
    public int getCurrentIndex() {
        return currentItem;
    }
    public long getTotal() {
        return totalPrice;
    }

    public void addToTotal(long priceToAdd) {
        totalPrice = totalPrice + priceToAdd;
    }
//    public void subtractFromTotal(long priceToSub) {
//    	totalPrice = totalPrice - priceToSub;
//    }
    
    public void resetTotal() {
    	totalPrice = 0;
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
        scanned.add(product);
    }

	@Override
	public void enabled(AbstractDevice<? extends AbstractDeviceListener> device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disabled(AbstractDevice<? extends AbstractDeviceListener> device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnedOn(AbstractDevice<? extends AbstractDeviceListener> device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnedOff(AbstractDevice<? extends AbstractDeviceListener> device) {
		// TODO Auto-generated method stub
		
	}
}
