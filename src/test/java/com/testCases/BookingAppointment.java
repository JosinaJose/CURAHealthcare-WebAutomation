package com.testCases;

import java.io.IOException;
import java.util.List;


import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.pageObjects.BookingAppointmentPage;
import com.utilities.Screen_Recordings;
@Listeners(com.utilities.Reporting.class)

public class BookingAppointment extends BaseClass {
	
     public ExtentReports extent = new ExtentReports();
     public ExtentTest test;
	@BeforeClass
	public void curaHealthcareLogin() throws Exception {
		
		Screen_Recordings.startRecording("BookingAppoinment");
		MakeAppointmentLogin log = new MakeAppointmentLogin();
		log.curaHealthCarelogin();
		}
	
	  


	
	@Test(priority =1)
	public void bookingAppointment() throws Exception {
				
		BookingAppointmentPage book= new BookingAppointmentPage(driver);
		SoftAssert softAssert = new SoftAssert();
		// validating the drop down menu -selecting facility
		if (book.selectFacilityBooking().equals("Seoul CURA Healthcare Center")) {
			softAssert.assertTrue(true);
			System.out.println("Facility is "+" " +book.selectFacilityBooking());
			

		} else {
			softAssert.assertTrue(false);

			try {
				captureScreen(driver, "BookingdropDownmenuFacility");
				//test.addScreencastFromPath(screenshotName);
					} catch (IOException e) {

				e.printStackTrace();
				
			}
		}
		softAssert.assertAll();
		
	}
	@Test(priority=2)	
	public void radioButn() {
		BookingAppointmentPage book = new BookingAppointmentPage(driver);
		List<WebElement> radioButtons = book.selectOptionBtn();
		// Check if the index is within the range of the radio button list
		int index = 2;
		if (index >= 0 && index < radioButtons.size()) {
			WebElement radioButton = radioButtons.get(index);
			if (!radioButton.isSelected()) {
				radioButton.click();

			} else {

				try {
					captureScreen(driver, "bookingHealthcareProgramRadiobtn");

				} catch (IOException e) {

					e.printStackTrace();
				

				}
			}
		}
		
	}

	@Test(priority=3)
	public void selectingVisitDate() {
		
	    BookingAppointmentPage book = new BookingAppointmentPage(driver);

	    SoftAssert softAssert = new SoftAssert();

	    String actualDate = book.selectVisitDaate().getAttribute("value");
	    String expectedDate = "12/07/2023";

	    if (actualDate.equals(expectedDate)) {
	        softAssert.assertTrue(true);
	       
	    } else {
	        softAssert.assertTrue(false);
	        try {
	            captureScreen(driver, "bookingvalidVisitDate");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    softAssert.assertAll();
	}
	
	@Test(priority = 4)
	public void sendComment() {
		BookingAppointmentPage book = new BookingAppointmentPage(driver);
		SoftAssert softAssert = new SoftAssert();
		String comment = book.writeComment();
		String expectedComment = "Booking an appointment in Seoul CURA Healthcare Center on 12/07/2023";
		if (comment.equals(expectedComment)) {
			softAssert.assertTrue(true);
			System.out.println(comment);
		} else {
			softAssert.assertTrue(false);
			try {
				captureScreen(driver, "sendingCommentbooking");

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		softAssert.assertAll();

	}
	@Test(priority = 5)
	public void bookingConfirmation() {
		// Booking Confirmation -using current Url
		BookingAppointmentPage book = new BookingAppointmentPage(driver);
		SoftAssert softAssert = new SoftAssert();
		book.clickBookAppointmentBtn();
		String actualUrl = driver.getCurrentUrl();
		String expectUrl = "https://katalon-demo-cura.herokuapp.com/appointment.php#summary";
		if (actualUrl.equals(expectUrl)) {
			softAssert.assertTrue(true);
			System.out.println(actualUrl);
		} else {
			softAssert.assertTrue(false);
			try {
				captureScreen(driver, "bookingConfirmation"); // when test case fail take screenshot
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
