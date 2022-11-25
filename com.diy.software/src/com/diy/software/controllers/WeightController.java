package com.diy.software.controllers;

import java.util.ArrayList;
import java.util.List;

import com.diy.hardware.BarcodedProduct;
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
	public boolean weightDiscrepancy;
	public double expectedWeight;
	public double currentWeight;
	private List<BarcodedProduct> itemsInScale = new ArrayList();
	
	public WeightController(DoItYourselfStationLogic station, AttendantStationGui attendant) {
		this.systemReference = station;
		this.attendantReference = attendant;
		expectedWeight = 0;
		
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
//			//Notify that there is a weight discrepancy
//			systemReference.systemDisable();
//			systemReference.notifyUserGui("Weight Discrepancy, click 'Call Attendant'.");
			//Notify attendant
			attendantReference.notifyWeightChange();
			weightDiscrepancy = true;
			
		} else if (expectedWeight == currentWeight) {
//			//If the program executes this it means no weight discrepancy
//			systemReference.enableScanningAndBagging();
//			systemReference.bagItemSuccess(true);
//			systemReference.updateWeightOnGUI(weightInGrams);
//			systemReference.setScanStatus(false);
			weightDiscrepancy = false;
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
	
	public boolean getWeightDiscrepancy() {
		return weightDiscrepancy;
	}
	

}
