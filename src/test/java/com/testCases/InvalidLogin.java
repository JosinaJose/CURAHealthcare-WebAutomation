package com.testCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.Login_Page;
import com.utilities.ExcelUtil;
import com.utilities.Screen_Recordings;

public class InvalidLogin extends BaseClass {
	
	@BeforeClass
	public void curaHealthcareLogin() throws Exception {
		
		Screen_Recordings.startRecording("InvalidData_Login");
		
	}
	
	
	@Test(dataProvider = "invalidCredentials",dataProviderClass = ExcelUtil.class)
	public void invalidLogin(String Username, String Password) {
		Login_Page page = new Login_Page(driver);
		page.clickMakeAppointmentbtn();
	    page.enetrUsername(Username);
		page.enterPassword(Password);
		page.clickLoginbtn();
		SoftAssert softAssert = new SoftAssert();
		String actualErrorMsg = "Login failed! Please ensure the username and password are valid.";
		if(actualErrorMsg.equalsIgnoreCase(page.invalidcredentials())) {
			softAssert.assertTrue(true);
			System.out.println(page.invalidcredentials());
		}else {
			softAssert.assertTrue(false);
			try {
				captureScreen(driver, "BookingdropDownmenuFacility");
				
					} catch (IOException e) {

				e.printStackTrace();
					}	
			
		}
		softAssert.assertAll();
		
        
	}
	@AfterClass
	public void stopRecordings() throws Exception {
		 Screen_Recordings.stopRecording();
	}

}
