package com.vtiger.tests;


import org.testng.annotations.Test;
import com.vtiger.pages.LeadPage;


public class LeadTests extends BaseTests{
	
		
	
	@Test (priority=0)
	public void verifyLeadwithmandatoryfields_TC01()
	{	
		logger = extent.createTest("verify Lead with mandatory fields_TC01");
		LeadPage ldp = new LeadPage(driver);
		ldp.CreateLeadwithMandatoryField("Gedam", "Infosys");
		extent.flush();
	}
	
	
	@Test (priority=1)
	public void verifyLeadwithAllFields_TC02()
	{	
		logger = extent.createTest("verify Lead with All Fields_TC02");
		LeadPage ldp = new LeadPage(driver);
		ldp.CreateLeadwithAllField(1, "Pratik", "Gedam", "Infosys", "SME", "8806659233");
		ldp.AddressDescription("SB Road", "411061", "Pune", "Maharashtra", "India","Lead get from LinkedIn");
		extent.flush();
	}
	
	@Test (priority=2)
	public void verifydeleteLead_TC03()
	{	
		logger = extent.createTest("verify Delete Lead_TC03");
		LeadPage ldp = new LeadPage(driver);
		ldp.DeleteLead();
		extent.flush();
	}
	
	@Test (priority=3)
	public void verifychangeLeadStatus_TC04()
	{	
		logger = extent.createTest("verify change Lead Status_TC04");
		LeadPage ldp = new LeadPage(driver);
		ldp.ChangeStatus();
		extent.flush();
	}
	
	@Test (priority=4)
	public void verifysearchLead_TC05()
	{	
		logger = extent.createTest("verify search Lead_TC05");
		LeadPage ldp = new LeadPage(driver);
		ldp.SearchName();
		extent.flush();
	}

}
