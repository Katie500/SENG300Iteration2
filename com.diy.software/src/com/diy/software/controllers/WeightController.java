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
	public boolean weightDiscrepancy;
	private double expectedWeight;
	private double currentWeight;
	
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
		currentWeight = expectedWeight + weightInGrams;
		
		if (expectedWeight < currentWeight || expectedWeight > currentWeight) {
			weightDiscrepancy = true;
			
		} else if (expectedWeight == currentWeight) {
			//If the program executes this it means no weight discrepancy
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
	


}
