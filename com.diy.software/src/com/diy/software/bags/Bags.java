package com.diy.software.bags;

public class Bags {
	private final long BAG_PRICE = 1;
	private int totalBagsSelected;
	private boolean noBags;
	
	public Bags () {
		noBags = false;
		totalBagsSelected = 0;
	}
	
	public long getBagPrice() {
		return BAG_PRICE;
	}
	
	public int getTotalBagsSelected() {
		return totalBagsSelected;
	}
	
	public void addBag() {
		totalBagsSelected = totalBagsSelected + 1;
	}
	
	public boolean ownBagsOrNot() {
		return noBags;
	}
	
	public void updateOwnBagsOrNot(boolean choice) {
		noBags = choice;
	}
	
	public boolean getOwnBagsOrNot() {
		return noBags;
	}
}
