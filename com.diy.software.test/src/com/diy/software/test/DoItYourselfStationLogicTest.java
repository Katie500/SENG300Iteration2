package com.diy.software.test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.diy.hardware.DoItYourselfStationAR;
import com.diy.hardware.external.CardIssuer;
import com.diy.software.DoItYourselfStationLogic;
import com.jimmyselectronics.OverloadException;
import com.jimmyselectronics.necchi.Barcode;
import com.jimmyselectronics.necchi.BarcodedItem;
import com.jimmyselectronics.necchi.Numeral;

public class DoItYourselfStationLogicTest {
	
		DoItYourselfStationAR station = new DoItYourselfStationAR();
		CardIssuer creditIssuer = new CardIssuer("Credit", 10);
		DoItYourselfStationLogic logic = new DoItYourselfStationLogic(station, creditIssuer);
		double Weight = 0;
		
	@Test
	public void testgetInProgress() {
		assertTrue(logic.getInProgress());
	}
	
	@Test
	public void testsetInProgess() {
		logic.setInProgress(false);
		assertFalse(logic.getInProgress());
	}
	
	@Test
	public void testInstallOn() {
		
		DoItYourselfStationLogic logic2 = logic.installOn(station, creditIssuer);
		assertNotEquals(logic2, logic);
		
	}
	
	@Test
	public void testgetcurrentexpectedWeight() throws OverloadException {
		 Barcode barcode2 = new Barcode(new Numeral[] { Numeral.two, Numeral.three });
		 Barcode barcode3 = new Barcode(new Numeral[] { Numeral.one, Numeral.two, Numeral.three });

		BarcodedItem item1 = new BarcodedItem(barcode3, 15);
		BarcodedItem item2 = new BarcodedItem(barcode2, 1);
		logic.baggingArea.add(item2);
		logic.baggingArea.add(item1);
		double testweight = logic.baggingArea.getCurrentWeight();
		assertNotEquals(Weight, testweight);
	}
	
	@Test
	public void testgetCurrentWeight() throws OverloadException {
		Barcode barcode2 = new Barcode(new Numeral[] { Numeral.two, Numeral.three });
		 Barcode barcode3 = new Barcode(new Numeral[] { Numeral.one, Numeral.two, Numeral.three });

		BarcodedItem item1 = new BarcodedItem(barcode3, 15);
		BarcodedItem item2 = new BarcodedItem(barcode2, 1);
		logic.baggingArea.add(item2);
		logic.baggingArea.add(item1);
		
		double testweight = logic.getCurrentWeight();
		assertNotEquals(Weight, testweight);
	}
	
	@Test
	public void testgetWeightDiscrepancy() {
		boolean testweight = logic.getWeightDiscrepancy();
		assertNotNull(testweight);
	}
}
