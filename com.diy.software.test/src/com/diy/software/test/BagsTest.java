package com.diy.software.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.diy.software.bags.Bags;

public class BagsTest {
	Bags bags;
	@Before
	public void setUpBeforeClass() {
		 bags = new Bags();
	}

	@Test
	public void bagPriceIsOne() {
		assertEquals(1,bags.getBagPrice());
	}
	@Test
	public void addOneBag() {
		bags.addBag();
		assertEquals(1,bags.getTotalBagsSelected());
	}
	@Test
	public void addFourBags() {
		bags.addBag();
		bags.addBag();
		bags.addBag();
		bags.addBag();
		assertEquals(4,bags.getTotalBagsCost());
	}
	@Test
	public void resetBags() {
		bags.addBag();
		bags.addBag();
		bags.resetBags();
		assertEquals(0,bags.getTotalBagsCost());
	}
	@Test
	public void getTotalBagsCost() {
		bags.addBag();
		bags.addBag();
		bags.addBag();
		assertEquals(3,bags.getTotalBagsCost());
	}
	@Test
	public void useOwnBags() {
		bags.updateOwnBagsOrNot(true);
		assertEquals(true,bags.getOwnBagsOrNot());
	}
}
