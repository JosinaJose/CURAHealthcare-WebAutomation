package com.testCases;



import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.BaseClass;
import com.pageObjects.Login_Page;
import com.utilities.Screen_Recordings;

public class MakeAppointmentLogin extends BaseClass {
	@BeforeClass
	public void startRecording() throws Exception {
		Screen_Recordings.startRecording("Login");
	}

	@Test
	public void curaHealthCarelogin() {

		Login_Page page = new Login_Page(driver);
		page.clickMakeAppointmentbtn();
		page.enetrUsername(username1);
		page.enterPassword(password);
		page.clickLoginbtn();
		// validating the title of the current page
		SoftAssert softAssert = new SoftAssert();
		if (driver.getTitle().equalsIgnoreCase("CURA Healthcare Service")) {
			softAssert.assertTrue(true);
			logger.info("Test Passed Successfully");

		} else {
			softAssert.assertTrue(false);
			logger.error("Test Failed! Login failed!");
			try {
				captureScreen(driver, "validUsernameandPwd");
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		
		softAssert.assertAll();
		logger.info("Completed Logintest");

	}
	@AfterClass
	public void stopRecordings() throws Exception {
		 Screen_Recordings.stopRecording();
	}

}
