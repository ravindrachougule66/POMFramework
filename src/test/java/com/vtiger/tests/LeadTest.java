package com.vtiger.tests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.vtiger.pages.LeadPage;



public class LeadTest extends BaseTest{
	
	@BeforeClass
	public void LoadData()
	{
		String path = System.getProperty("user.dir")+"/src/test/resources/TestData/vTigerTestData.xlsx";
		ls=ReadExcelDataIntoList(path, "Lead");
	}
	
	@Test (priority=0)
	public void verifyLeadwithmandatoryfields_TC01()
	{	
		logger = extent.createTest("verify Lead with mandatory fields_TC01");
		LeadPage ldp = new LeadPage(driver);
		ldp.CreateLeadwithMandatoryField(ls.get(1).get(3), ls.get(1).get(4));
		extent.flush();
	}
	
	
	@Test (priority=1)
	public void verifyLeadwithAllFields_TC02()
	{	
		logger = extent.createTest("verify Lead with All Fields_TC02");
		LeadPage ldp = new LeadPage(driver);
		ldp.CreateLeadwithAllField(ls.get(2).get(1), ls.get(2).get(2), ls.get(2).get(3), ls.get(2).get(4),ls.get(2).get(5), ls.get(2).get(6));
		ldp.AddressDescription(ls.get(2).get(7), ls.get(2).get(8), ls.get(2).get(9), ls.get(2).get(10),ls.get(2).get(11));
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
		ldp.SearchName(ls.get(3).get(2), ls.get(3).get(3));
		extent.flush();
	}

}
