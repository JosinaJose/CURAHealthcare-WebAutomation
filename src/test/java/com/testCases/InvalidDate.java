package com.testCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.InvalidDatePage;
import com.utilities.Screen_Recordings;

public class InvalidDate extends BaseClass{
	  
	@BeforeClass
	public void curaHealthcareLogin() throws Exception {
		Screen_Recordings.startRecording("InvalidDate");
		MakeAppointmentLogin log = new MakeAppointmentLogin();
		log.curaHealthCarelogin();
	}
	
	@Test
	public void invalidDate() {
		
		InvalidDatePage date = new InvalidDatePage(driver);
		
		date.pastDateSelected();
		date.clickBookAppointmentBtn();
		SoftAssert softAssert = new SoftAssert();
		String expectedUrl ="https://katalon-demo-cura.herokuapp.com/";
		
		if(driver.getCurrentUrl().equals(expectedUrl)) {
			softAssert.assertTrue(true);
			System.out.println(driver.getCurrentUrl());
		}else {
			softAssert.assertTrue(false);
			System.out.println("Invalid Date");
			try {
				captureScreen(driver, "InvalidDate");
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
