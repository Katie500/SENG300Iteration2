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
	public long getTotalBagsCost() {
		return totalBagsSelected * BAG_PRICE;
	}
	
	public void addBag() {
		totalBagsSelected = totalBagsSelected + 1;
	}
	public void resetBags() {
		totalBagsSelected = 0;
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
