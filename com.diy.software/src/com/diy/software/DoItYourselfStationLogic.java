package com.diy.software;

import com.diy.hardware.DoItYourselfStationAR;
import com.diy.hardware.external.CardIssuer;
import com.diy.software.controllers.CashPayment.CashPaymentController;
import com.diy.software.controllers.PaymentController;
import com.diy.software.controllers.ProductController;
import com.diy.software.controllers.WeightController;
import com.jimmyselectronics.OverloadException;
import com.jimmyselectronics.virgilio.ElectronicScale;

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
     * The controller that tracks the inserted cashPayment
     */
    public CashPaymentController cashPaymentController;
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
    
    private boolean systemEnabled = true;
    private ElectronicScale baggingArea;
	private double scaleMaxWeight = 5000.0;
	private double scaleSensitivity = 0.5;
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

//        cashPaymentController = new CashPaymentController(this);
    
        baggingArea = new ElectronicScale(scaleMaxWeight, scaleSensitivity);
        baggingArea.plugIn();
        baggingArea.turnOn();
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

    
	public double getCurrentExpectedWeight() {
		return baggingAreaExpectedWeight;
	}
	public double getCurrentWeight() throws OverloadException {
		baggingAreaCurrentWeight = baggingArea.getCurrentWeight();
		return baggingAreaCurrentWeight;
	}
	
	
	public void weightDiscrepancy(ElectronicScale baggingArea, double currentWeight) throws OverloadException {
		//Compare current weight vs previous weight
		double expected_weight = getCurrentExpectedWeight();
		//double current_weight = baggingArea.getCurrentWeight();

		if (electronicScale.weightDiscrepancy){
			//Station to disabled scanning
//			station.scanner.disable();
//			//GUI to disable scanning and bagging
//			disableScanningAndBagging();
//			//Signal attendant to help
//			requestAttendant = true;
		}
		else{
//			station.scanner.enable();
//			enableScanningAndBagging();
		}

	}
  


}

