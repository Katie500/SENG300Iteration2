package com.diy.software;

import com.diy.hardware.BarcodedProduct;
import com.diy.hardware.DoItYourselfStationAR;
import com.diy.hardware.external.CardIssuer;
import com.diy.hardware.external.ProductDatabases;
import com.diy.software.controllers.PaymentController;
import com.diy.software.controllers.ProductController;
import com.diy.software.controllers.WeightController;
import com.jimmyselectronics.OverloadException;
import com.jimmyselectronics.virgilio.ElectronicScale;

import java.util.List;

public class DoItYourselfStationLogic {
    /**
     * The station on which the logic is installed.
     */
    public DoItYourselfStationAR station;
    /**
     * The controller that tracks the scanned products
     */
    public ProductController productController;
    /**
     * The controller that tracks the inserted card for payment
     */
    public PaymentController paymentController;
    /**
     * Tracks if the customers session has begun
     */
    private boolean inProgress = true;
    /**
     * The controller that tracks the weight of the items
     */
    private WeightController electronicScale;

    
    //System variables
    /**
     * tracks the current weight
     */
    private double baggingAreaCurrentWeight;
    /**
     * tracks the bagging area expected weight
     */
    private double baggingAreaExpectedWeight;
    
    private ElectronicScale baggingArea;
    private static double scaleMaximumWeightConfiguration = 5000.0;
    private static double scaleSensitivityConfiguration = 0.5;
    
    /**
     * Installs an instance of the logic on the indicated station.
     *
     * @param station
     *            The station on which to install the logic.
     * @param products
     *            The list of bardcoded products in the system.
     * @param creditIssuer
     *            The credit issuer to by used for payment.
     * @return The newly installed instance.
     * @throws NullPointerException
     *             If any argument is null.
     */
    public static DoItYourselfStationLogic installOn(DoItYourselfStationAR station, CardIssuer creditIssuer) {
        return new DoItYourselfStationLogic(station, creditIssuer);
    }

    /**
     * Basic constructor.
     *
     * @param station
     *            The station on which to install the logic.
     * @param products
     *            The list of bardcoded products in the system.
     * @param creditIssuer
     *            The credit issuer to by used for payment.
     * @return The newly installed instance.
     * @throws NullPointerException
     *             If any argument is null.
     */
    public DoItYourselfStationLogic(DoItYourselfStationAR station, CardIssuer creditIssuer) {
        this.station = station;

        productController = new ProductController(this);
        station.scanner.register(productController);

        paymentController = new PaymentController(this, creditIssuer);
        station.cardReader.register(paymentController);
    }

    /**
     * Reports whether a session is currently in progress
     *
     * @return If a session is current in progress.
     */
    public boolean getInProgress() {
        return inProgress;
    }

    /**
     * Sets the session progress
     *
     * @param inProgress
     *            If there is a session in progress
     */
    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }
    
    
    /**
     * Gets current expected weight
     */

	public double getCurrentExpectedWeight() {
		try {
			baggingAreaExpectedWeight = baggingArea.getCurrentWeight();
			return baggingAreaExpectedWeight;
		}catch(OverloadException e) {
			e.printStackTrace();
		}
		return baggingAreaCurrentWeight;
	}

	public void systemDisable() {
		// TODO Auto-generated method stub
		
	}

	public void notifyUser(String string) {
		// TODO Auto-generated method stub
		
	}

	public void enableScanningAndBagging() {
		// TODO Auto-generated method stub
		
	}

	public void bagItemSuccess(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void updateWeightOnGUI(double weightInGrams) {
		// TODO Auto-generated method stub
		
	}

	public void setScanStatus(boolean b) {
		// TODO Auto-generated method stub
		
	}
}

