package com.diy.software.controllers;

import java.util.ArrayList;
import java.util.List;

import com.diy.hardware.BarcodedProduct;
import com.diy.hardware.external.ProductDatabases;
import com.diy.software.DoItYourselfStationLogic;
import com.diy.software.gui.AttendantStationGui;
import com.jimmyselectronics.AbstractDevice;
import com.jimmyselectronics.AbstractDeviceListener;
import com.jimmyselectronics.OverloadException;
import com.jimmyselectronics.virgilio.ElectronicScale;
import com.jimmyselectronics.virgilio.ElectronicScaleListener;


public class WeightController implements ElectronicScaleListener {

	private DoItYourselfStationLogic systemReference;
	public boolean weightDiscrepancy;
	private double expectedWeight;
	private double currentWeight = 0;
    private double baggedItemsWeight = 0;

	
	public WeightController(DoItYourselfStationLogic station) {
		this.systemReference = station;
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

	@Override
	public void weightChanged(ElectronicScale scale, double weightInGrams) {
		//This updates the gui through the system with the new updated weight
		
		
		
		expectedWeight = systemReference.getCurrentExpectedWeight();
		
		baggedItemsWeight += weightInGrams;
		
		
	}

	@Override
	public void overload(ElectronicScale scale) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void outOfOverload(ElectronicScale scale) {
		// TODO Auto-generated method stub
		
	}
	

	/**
	 * Checks for weight discrepancy
	 */
	public boolean weightDiscrepancy() {
		
		if (expectedWeight < baggedItemsWeight || expectedWeight > baggedItemsWeight) {
			//systemReference.systemDisable();
			weightDiscrepancy = true;
			System.out.println("gets here");
		} else if (expectedWeight == baggedItemsWeight) {
			//If the program executes this it means no weight discrepancy
			weightDiscrepancy = false;
		}
		return weightDiscrepancy;
		
	}
	
    /**
     * Obtains the list of items scanned with this machine
     *
     * @return The total list of items scanned during the current transaction.
     */
    public double getBaggedItemsWeight() {
        return baggedItemsWeight;
    }

}
