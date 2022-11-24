package com.diy.software.bags;

public class Bags {
	private final long BAG_PRICE = 1;
	private int totalBagsSelected;
	private boolean ownBags;
	
	public Bags () {
		ownBags = false;
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

	public void updateOwnBagsOrNot(boolean choice) {
		ownBags = choice;
	}
	public boolean getOwnBagsOrNot() {
		return ownBags;
	}
}
