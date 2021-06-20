package com.vtiger.tests;

import org.testng.annotations.Test;

import com.vtiger.pages.PotentialsPage;

public class PotentialTests extends BaseTests{
	
	public PotentialsPage pp;
	
	@Test (priority=0)
	public void verifyCreateNewPotential_TC01()
	{
		logger = extent.createTest("Verify Create New Potential_TC01");
		pp = new PotentialsPage(driver);
		pp.CreateNewPotential("CRM vtiger - 1500 units","40000","2021-06-30","New Business","Meeting Scheduled","Existing Customer","Proposal/Price Quote","60");
		extent.flush();
	}
	@Test (priority=1)
	public void verifyEditPotential_TC02()
	{
		logger = extent.createTest("Verify Edit Potential_TC02");
		pp = new PotentialsPage(driver);
		pp.EditPotential();
		extent.flush();
	}
	@Test (priority=2)
	public void verifyDuplicatePotential_TC03()
	{
		logger = extent.createTest("Verify Duplicate Potential_TC03");
		pp = new PotentialsPage(driver);
		pp.DuplicatePotential();
		extent.flush();
	}
	@Test (priority=3)
	public void verifyDeletePotential_TC04()
	{
		logger = extent.createTest("Verify Delete Potential_TC04");
		pp = new PotentialsPage(driver);
		pp.DeletePotential();
		extent.flush();
	}

}
