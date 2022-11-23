package com.diy.software.test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.diy.hardware.DoItYourselfStationAR;
import com.diy.hardware.external.CardIssuer;
import com.diy.software.DoItYourselfStationLogic;

public class DoItYourselfStationLogicTest {
	
		DoItYourselfStationAR station = new DoItYourselfStationAR();
		CardIssuer creditIssuer = new CardIssuer("Credit", 10);
		DoItYourselfStationLogic logic = new DoItYourselfStationLogic(station, creditIssuer);
	
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
}
