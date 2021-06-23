package com.vtiger.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.vtiger.pages.CalenderPage;

public class CalenderTest extends BaseTest{
	
	@BeforeClass
	public void LoadData()
	{
		String path = System.getProperty("user.dir")+"/src/test/resources/TestData/vTigerTestData.xlsx";
		ls=ReadExcelDataIntoList(path, "Activities");
	}
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
	public void verifyCreateNewAppointmentfromCalender_TC02()
	{	
		logger = extent.createTest("Verify Create New Appointment from Calender_TC02");
		CalenderPage cp = new CalenderPage(driver);
		cp.SelectDayOfMonth();
		cp.CreateNewAppointment(ls.get(1).get(1));
		extent.flush();		
	}

}
