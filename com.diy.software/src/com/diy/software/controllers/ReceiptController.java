package com.diy.software.controllers;
import com.jimmyselectronics.AbstractDevice;
import com.jimmyselectronics.AbstractDeviceListener;
import com.jimmyselectronics.abagnale.IReceiptPrinter;
import com.jimmyselectronics.abagnale.ReceiptPrinterListener;
import com.diy.software.controllers.*;

public class ReceiptController implements ReceiptPrinterListener{
	
    boolean lowink = false;
    boolean lowpaper = false;

	@Override
	public void enabled(AbstractDevice<? extends AbstractDeviceListener> device) {}

	@Override
	public void disabled(AbstractDevice<? extends AbstractDeviceListener> device) {}

	@Override
	public void turnedOn(AbstractDevice<? extends AbstractDeviceListener> device) {}

	@Override
	public void turnedOff(AbstractDevice<? extends AbstractDeviceListener> device) {}

	@Override
	public void outOfPaper(IReceiptPrinter printer) {}

	@Override
	public void outOfInk(IReceiptPrinter printer) {}

	@Override
	public void lowInk(IReceiptPrinter printer) {
		lowink = true;
	}

	@Override
	public void lowPaper(IReceiptPrinter printer) {
		lowpaper = true;
	}

	@Override
	public void paperAdded(IReceiptPrinter printer) {}

	@Override
	public void inkAdded(IReceiptPrinter printer) {}
	

	public boolean getLowInk() {
		return lowink;
		
	}
	
	public boolean getLowPaper() {
		return lowpaper;
	}
}
