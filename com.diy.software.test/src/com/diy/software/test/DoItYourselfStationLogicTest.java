package com.diy.software.test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.diy.hardware.DoItYourselfStationAR;
import com.diy.hardware.external.CardIssuer;
import com.diy.software.DoItYourselfStationLogic;
import com.jimmyselectronics.OverloadException;

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
	
	@SuppressWarnings("deprecation")
	@Test
	public void testgetcurrentexpectedWeight() {
		double testweight = logic.getCurrentExpectedWeight();
		assertEquals(Weight, testweight, 1);
	}
	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void testgetCurrentWeight() throws OverloadException {
//		double testweight = logic.getCurrentWeightScale();
//		assertEquals(Weight, testweight, 1);
//	}
}
