package com.diy.software;

import com.diy.hardware.BarcodedProduct;
import com.diy.hardware.DoItYourselfStation;
import com.diy.hardware.external.CardIssuer;
import com.diy.hardware.external.ProductDatabases;
import com.diy.software.controllers.PaymentController;
import com.diy.software.controllers.ProductController;

import java.util.List;

public class DoItYourselfStationLogic {
    /**
     * The station on which the logic is installed.
     */
    public DoItYourselfStation station;
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
    private boolean inProgress = false;

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
    public static DoItYourselfStationLogic installOn(DoItYourselfStation station) {
        return new DoItYourselfStationLogic(station);
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
    public DoItYourselfStationLogic(DoItYourselfStation station) {
        this.station = station;

        productController = new ProductController(this);
        station.scanner.register(productController);

        paymentController = new PaymentController(this);
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
}

