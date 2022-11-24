package com.diy.software.gui.cardpayment;

import com.diy.hardware.DoItYourselfStationAR;
import com.diy.simulation.Customer;
import com.diy.software.DoItYourselfStationLogic;

@SuppressWarnings("serial")
public class CreditGui extends CardPinpadGui {
	public CreditGui(Customer customer, DoItYourselfStationAR station, DoItYourselfStationLogic stationLogic) {
		super(customer, station, stationLogic, "credit");
	}
}
