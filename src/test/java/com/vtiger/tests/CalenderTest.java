package com.vtiger.tests;

import org.testng.annotations.Test;
import com.vtiger.pages.CalenderPage;

public class CalenderTest extends BaseTests{
	
	@Test
	public void verifyCalendar_TC01()
	{	
		logger = extent.createTest("verify Calendar_TC01");
		CalenderPage cp = new CalenderPage(driver);
		cp.SelectDayOfMonth();
		cp.SelectDWeekOfMonth();
		cp.SelectMonthOfYear();
		extent.flush();		
	}	
	
	@Test
	public void verifyCreateNewAppointment_TC02()
	{	
		logger = extent.createTest("Verify Create New Appointment_TC02");
		CalenderPage cp = new CalenderPage(driver);
		cp.SelectDayOfMonth();
		cp.CreateNewAppointment("Team Meeting");
		extent.flush();		
	}

}
