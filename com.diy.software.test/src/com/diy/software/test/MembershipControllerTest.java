package com.diy.software.test;
import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import com.diy.software.controllers.MembershipController;

public class MembershipControllerTest 
{

	MembershipController newMember;
	
	String name, monthOpened, ID;
	int yearOpened, dayOpened, status;	
	
	@Before
	public void setup()
	{	
		ID = "73";
		name = "Jerry Singer";
		monthOpened = "April";
		yearOpened = 2020;
		dayOpened = 16;
		newMember = new MembershipController();

	}
	
    /**
     * 
     * Testing if member is correctly inserted
     * 
     * @Note if membership is 1, then valid. If membership is 0, then invalid
     * 
     */
	@Test
	public void testInserttMember()
	{	
		newMember.insertMember(ID, name, yearOpened, monthOpened, dayOpened);
		assertEquals("Jerry Singer", newMember.getName(ID));
	}
	
	/**
     * Testing if member is correctly inserted (with status argument)
     * 
     */
	
	@Test
	public void testInsertMemberStatus()
	{	
		status = 1;	
		newMember.insertMember(ID, name, yearOpened, monthOpened, dayOpened, status);
		assertEquals("Jerry Singer", newMember.getName(ID));
	}
	
	
	/**
     * Tests for when the member being searched is PRESENT in the database 
     * 
     */
	@Test
	public void testValidMember()
	{		
		//New member being inserted
		newMember.insertMember(ID, name, yearOpened, monthOpened, dayOpened);
		assertTrue(newMember.verifyMembership(ID));
	}
	
	
	/**
     * Tests for when the member being searched is ABSENT in the database
     * 
     */
	@Test
	public void testInvalidMember()
	{
		ID = "22"; //checking the presence of a member that has not yet been inserted
		assertFalse(newMember.verifyMembership(ID)); 
	}
	
	/**
	 * Test for the functionality of getting the year
	 * 
	 */
	@Test
	public void testGetMonth()
	{
		newMember.insertMember(ID, name, yearOpened, monthOpened, dayOpened, status);
		assertEquals("April", newMember.getMonth(ID));
	}
	
	/**
	 * Test for the functionality of getting the year
	 * 
	 */
	@Test
	public void testGetDay()
	{		
		newMember.insertMember(ID, name, yearOpened, monthOpened, dayOpened, status);
		assertEquals(16, newMember.getDay(ID));	
	}
	
	/**
	 * Test for the functionality of getting the year
	 * 
	 */
	@Test
	public void testGetYear()
	{
		newMember.insertMember(ID, name, yearOpened, monthOpened, dayOpened, status);
		assertEquals(2020, newMember.getYear(ID));
	}	

	/**
	 * Test for the functionality of setting an active member
	 * If there is no active member then False is returned
	 */
	@Test
	public void testNullActiveMember()
	{
		newMember.unsetActiveMember();
		newMember.setActiveMember(null);
		assertFalse(newMember.hasActiveMember());		
	}
	
	
	/**
	 * Test for the functionality of setting an active member
	 * If there is an active member then True is returned
	 */
	@Test
	public void testSetActiveMember()
	{
		newMember.setActiveMember(ID);
		assertTrue(newMember.hasActiveMember());
		
	}
	
	/**
	 * Test for the functionality of checking if a member has an active membership
	 *
	 */
	@Test
	public void testNotActiveMember()
	{
		newMember.unsetActiveMember();
		assertFalse(newMember.hasActiveMember());
	}
	
	/**
	 * Test for the functionality of hasActiveMember
	 */
	@Test
	public void testIsActiveMember()
	{
		//Add a new member
		newMember.setActiveMember(ID);
		
		//Add another member
		String ID = "29";
		String name = "Simon Car";
		newMember.insertMember(ID, name, yearOpened, monthOpened, dayOpened, status);
		newMember.setActiveMember(ID);
		
		assertTrue(newMember.hasActiveMember());
		
	}
	
	/**
	 * Test for the functionality of setting an active member
	 * If there is an active member then True is returned
	 * @TODO
	 */
	@Test
	public void testIsNullActiveMember()
	{
		ID = null;
		newMember.insertMember(ID, null, 0, null, 0);
		newMember.setActiveMember(ID);
		assertTrue(newMember.hasActiveMember());
	}
	
	/**
	 * Test for the functionality of getting the name of an active member
	 */
	@Test
	public void testGetActiveMemberName()
	{
		name = "Scott Desmond";
		newMember.insertMember(ID, name, yearOpened, monthOpened, dayOpened, status);
		newMember.setActiveMember(ID);
		assertEquals("Scott Desmond", newMember.getActiveMemberName());
	}
	
	/**
	 * Test for the functionality of getting the Month of an active member
	 */
	@Test
	public void testGetActiveMemberMonth()
	{
		monthOpened = "December";
		newMember.insertMember(ID, name, yearOpened, monthOpened, dayOpened, status);
		newMember.setActiveMember(ID);
		assertEquals("December", newMember.getActiveMemberMonth());
	}
	
	/**
	 * Test for the functionality of getting the Day of an active member
	 */
	@Test
	public void testGetActiveMemberDay()
	{
		dayOpened = 31;
		newMember.insertMember(ID, name, yearOpened, monthOpened, dayOpened, status);
		newMember.setActiveMember(ID);
		assertEquals(31, newMember.getActiveMemberDay());
	}
	
	/**
	 * Test for the functionality of getting the Year of an active member
	 */
	@Test
	public void testGetActiveMemberYear()
	{
		yearOpened = 2022;
		newMember.insertMember(ID, name, yearOpened, monthOpened, dayOpened, status);
		newMember.setActiveMember(ID);
		assertEquals(2022 , newMember.getActivateMemberYear());
	}
	
	/**
	 * Test for the functionality of getting the ID of an active member
	 */
	@Test
	public void testGetActiveMemberID()
	{
		ID = "29";
		newMember.insertMember(ID, name, yearOpened, monthOpened, dayOpened, status);
		newMember.setActiveMember(ID);
		assertEquals("29", newMember.getActivateMemberID());
	}
	
	
	@After
	public void tearDown()
	{
		newMember = null;	
	}
	
	
	
	
	
	
	
	
}
