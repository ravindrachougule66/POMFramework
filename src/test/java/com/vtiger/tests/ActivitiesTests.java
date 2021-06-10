package com.vtiger.tests;

import org.testng.annotations.Test;

import com.vtiger.pages.ActivitiesPage;

public class ActivitiesTests extends BaseTests{
	
	@Test (priority=0)
	public void verifyNewEvent_TC01() throws InterruptedException
	{
		logger = extent.createTest("verify New Event_TC01");
		ActivitiesPage ap = new ActivitiesPage(driver);
		ap.createNewEvent("Client Meeting");
		extent.flush();
	}
	@Test (priority=1)
	public void verifySearchActivities_TC02()
	{
		logger = extent.createTest("verify Search Activities_TC02");
		ActivitiesPage ap = new ActivitiesPage(driver);
		ap.SearchActivities("Client Meeting");
		extent.flush();
	}
	
	@Test (priority=2)
	public void DeleteActivities_TC03()
	{
		logger = extent.createTest("verify Actions On Activities_TC02");
		ActivitiesPage ap = new ActivitiesPage(driver);
		ap.DeleteActivities();
		extent.flush();
	}
	
	@Test (priority=3)
	public void verifyDuplicateOfActivity_TC04()
	{
		logger = extent.createTest("Verify Duplicate Of Activity_TC04");
		ActivitiesPage ap = new ActivitiesPage(driver);
		ap.DuplicateActivity();
		extent.flush();
	}
	

}
