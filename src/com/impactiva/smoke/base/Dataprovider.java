package com.impactiva.smoke.base;

import com.impactiva.smoke.lib.Generics;
import org.testng.annotations.DataProvider;

public class Dataprovider {

	@DataProvider(name = "rfidData")
	public Object[][] rfidTagsData() throws Exception {
		Object[][] obj = new Generics().getExcelData("./excels/testDataVaesoSmoke.xls", "rfidDataSheet");
		return obj;
	}


	/*@DataProvider(name = "MasterAdmin")
	public Object[][] MasterAdmin() {
		Object[][] obj = new Generics().getExcelData("./excels/testDataJHASmoke.xls", "loginDataSheet", "MasterAdmin");
		return obj;
	}
	
	@DataProvider(name = "base_Url_fetch")
	public Object[][] getBaseUrl() {
		Object[][] obj = new Generics().getExcelData("./excels/testDataJHASmoke.xls", "loginDataSheet", "base_url");
		return obj;
	}

	@DataProvider(name = "loginDataForAuthor")
	public Object[][] getLoginData() {
		Object[][] obj = new Generics().getExcelData("./excels/testDataJHASmoke.xls", "loginDataSheet", "Author_Login");
		return obj;
	}

	@DataProvider(name = "createNewJob")
	public Object[][] createNewJob() {
		Object[][] obj = new Generics().getExcelData("./excels/testDataJHASmoke.xls", "loginDataSheet", "New_job");
		return obj;
	}

	@DataProvider(name = "createNewAssessment")
	public Object[][] createNewAssessment() {
		Object[][] obj = new Generics().getExcelData("./excels/testDataJHASmoke.xls", "loginDataSheet",
				"new_Assssment");
		return obj;
	}

	@DataProvider(name = "createNewEssentialTask")
	public Object[][] createNewEssentialTask() {
		Object[][] obj = new Generics().getExcelData("./excels/testDataJHASmoke.xls", "loginDataSheet",
				"new_Essential_Task");
		return obj;
	}

	@DataProvider(name = "createNewNonEssentialTask")
	public Object[][] createNewNonEssentialTask() {
		Object[][] obj = new Generics().getExcelData("./excels/testDataJHASmoke.xls", "loginDataSheet",
				"new_Non_Essential_Task");
		return obj;
	}

	@DataProvider(name = "createHazard1")
	public Object[][] createHazard1() {
		Object[][] obj = new Generics().getExcelData("./excels/testDataJHASmoke.xls", "loginDataSheet", "Hazard1");
		return obj;
	}

	@DataProvider(name = "createHazard2")
	public Object[][] createHazard2() {
		Object[][] obj = new Generics().getExcelData("./excels/testDataJHASmoke.xls", "loginDataSheet", "Hazard2");
		return obj;
	}

	@DataProvider(name = "createHazard3")
	public Object[][] createHazard3() {
		Object[][] obj = new Generics().getExcelData("./excels/testDataJHASmoke.xls", "loginDataSheet", "Hazard3");
		return obj;
	}

	@DataProvider(name = "createControl1")
	public Object[][] createControl1() {
		Object[][] obj = new Generics().getExcelData("./excels/testDataJHASmoke.xls", "loginDataSheet", "ControlOne");
		return obj;
	}

	@DataProvider(name = "createControl2")
	public Object[][] createControl2() {
		Object[][] obj = new Generics().getExcelData("./excels/testDataJHASmoke.xls", "loginDataSheet", "ControlTwo");
		return obj;
	}

	@DataProvider(name = "createControl3")
	public Object[][] createControl3() {
		Object[][] obj = new Generics().getExcelData("./excels/testDataJHASmoke.xls", "loginDataSheet", "ControlThree");
		return obj;
	}

	@DataProvider(name = "historyCheck")
	public Object[][] historyCheck() {
		Object[][] obj = new Generics().getExcelData("./excels/testDataJHASmoke.xls", "loginDataSheet",
				"HistoryVerify");
		return obj;
	}

	@DataProvider(name = "newDescription")
	public Object[][] newDescription() {
		Object[][] obj = new Generics().getExcelData("./excels/testDataJHASmoke.xls", "loginDataSheet",
				"new_Description");
		return obj;
	}

	@DataProvider(name = "Submit_for_Review")
	public Object[][] SubmitforReview() {
		Object[][] obj = new Generics().getExcelData("./excels/testDataJHASmoke.xls", "loginDataSheet",
				"Submit_for_Review");
		return obj;
	}

	@DataProvider(name = "Note_Text")
	public Object[][] Get_Note_Text() {
		Object[][] obj = new Generics().getExcelData("./excels/testDataJHASmoke.xls", "loginDataSheet", "Note_Text");
		return obj;
	}

	@DataProvider(name = "getLoginDataAdmin")
	public Object[][] Get_Login_Data_Admin() {
		Object[][] obj = new Generics().getExcelData("./excels/testDataJHASmoke.xls", "loginDataSheet", "Admin_login");
		return obj;
	}

	@DataProvider(name = "editJob")
	public Object[][] editJob() {
		Object[][] obj = new Generics().getExcelData("./excels/testDataJHASmoke.xls", "loginDataSheet",
				"new_Description");
		return obj;
	}

	@DataProvider(name = "reAssignWork")
	public Object[][] reAssignWork() {
		Object[][] obj = new Generics().getExcelData("./excels/testDataJHASmoke.xls", "loginDataSheet",
				"Re_Assign_Work");
		return obj;
	} */

}
