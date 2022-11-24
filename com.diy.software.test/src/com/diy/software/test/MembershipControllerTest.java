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
		assertEquals(1, newMember.verifyMembership(ID));
	}
	
	
	/**
     * Tests for when the member being searched is ABSENT in the database
     * 
     */
	@Test
	public void testInvalidMember()
	{
		//No member being inserted; expect 0 because there is no member inserted
		assertNotEquals(1, newMember.verifyMembership(ID)); 
	}
	
	
	@After
	public void tearDown()
	{
		newMember = null;	
	}
	
	
	
	
	
	
	
	
}
