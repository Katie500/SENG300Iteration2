package com.diy.software.controllers;

import com.diy.software.DoItYourselfStationLogic;
import com.diy.software.gui.AttendantStationGui;
import com.jimmyselectronics.AbstractDevice;
import com.jimmyselectronics.AbstractDeviceListener;
import com.jimmyselectronics.OverloadException;
import com.jimmyselectronics.virgilio.ElectronicScale;
import com.jimmyselectronics.virgilio.ElectronicScaleListener;


public class WeightController implements ElectronicScaleListener {

	private DoItYourselfStationLogic systemReference;
	private AttendantStationGui attendantReference;
	
	public WeightController(DoItYourselfStationLogic station, AttendantStationGui attendant) {
		this.systemReference = station;
		this.attendantReference = attendant;
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
		
		double expectedWeight = systemReference.getCurrentExpectedWeight();
		double currentWeight = 0;
		currentWeight = expectedWeight + weightInGrams;
		
		if (expectedWeight < currentWeight || expectedWeight > currentWeight) {
			//Notify that there is a weight discrepancy
			systemReference.systemDisable();
			systemReference.notifyUser("Weight Discrepancy, wait for attendant.");
			//Notify attendant
			attendantReference.notifyWeightChange();
			
		} else if (expectedWeight == currentWeight) {
			//If the program executes this it means no weight discrepancy
			systemReference.enableScanningAndBagging();
			systemReference.bagItemSuccess(true);
			systemReference.updateWeightOnGUI(weightInGrams);
			systemReference.setScanStatus(false);
		}
		
	}

	@Override
	public void overload(ElectronicScale scale) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void outOfOverload(ElectronicScale scale) {
		// TODO Auto-generated method stub
		
	}

}
