package com.vtiger.tests;

import org.testng.annotations.Test;

import com.vtiger.pages.PotentialsPage;

public class PotentialTests extends BaseTests{
	
	@Test (priority=0)
	public void verifyCreateNewPotential_TC01()
	{
		logger = extent.createTest("Verify Create New Potential_TC01");
		PotentialsPage pp = new PotentialsPage(driver);
		pp.CreateNewPotential("CRM vtiger - 1500 units","40000","2021-06-30","New Business","Meeting Scheduled","Existing Customer","Proposal/Price Quote");
		extent.flush();
	}

}
