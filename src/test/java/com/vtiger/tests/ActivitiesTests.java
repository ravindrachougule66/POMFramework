package com.vtiger.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vtiger.pages.ActivitiesPage;

public class ActivitiesTests extends BaseTests{
	
	public ActivitiesPage ap;
	
	@BeforeClass
	public void LoadData()
	{
		String path = System.getProperty("user.dir")+"/src/test/resources/TestData/vTigerTestData.xlsx";
		ls=ReadExcelDataIntoList(path, "Activities");
	}
	
	@Test (priority=0)
	public void verifyNewEvent_TC01() throws InterruptedException
	{
		logger = extent.createTest("verify New Event_TC01");
		ap = new ActivitiesPage(driver);
		ap.createNewEvent(ls.get(1).get(1));
		extent.flush();
	}
	@Test (priority=1)
	public void verifySearchActivities_TC02()
	{
		logger = extent.createTest("verify Search Activities_TC02");
		ap = new ActivitiesPage(driver);
		ap.SearchActivities(ls.get(1).get(1));
		extent.flush();
	}
	
	@Test (priority=2)
	public void DeleteActivities_TC03()
	{
		logger = extent.createTest("verify Delete Action On Activities_TC02");
		ap = new ActivitiesPage(driver);
		ap.DeleteActivities();
		extent.flush();
	}
	
	@Test (priority=3)
	public void verifyDuplicateOfActivity_TC04()
	{
		logger = extent.createTest("Verify Duplicate Of Activity_TC04");
		ap = new ActivitiesPage(driver);
		ap.DuplicateActivity();
		extent.flush();
	}
	
	@Test (priority=4)
	public void verifyEditActivity_TC05() throws InterruptedException
	{
		logger = extent.createTest("Verify Edit Activity_TC04");
		ap = new ActivitiesPage(driver);
		ap.EditActivity(ls.get(1).get(2), ls.get(1).get(3).trim(), ls.get(1).get(4), ls.get(1).get(5), ls.get(1).get(6));
		extent.flush();
	}
	

}
