package com.testCases;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentTest;
import com.base.BaseClass;
import com.pageObjects.ReadmissionBookingPage;
import com.utilities.Screen_Recordings;

public class ReadmissionBooking extends BaseClass {
	public ExtentTest test;

	// Pre-condition- login to the web application
	@BeforeClass
	public void curaHealthcareLogin() throws Exception {
		Screen_Recordings.startRecording("ReadmissionBooking");
		MakeAppointmentLogin log = new MakeAppointmentLogin();
		log.curaHealthCarelogin();
	}

	@Test(priority = 1)
	public void selectingFacility() {
		ReadmissionBookingPage read = new ReadmissionBookingPage(driver);
		SoftAssert softAssert = new SoftAssert();
		if (read.selectFacility().equals("Hongkong CURA Healthcare Center")) {
			softAssert.assertTrue(true);
			System.out.println("Facility is " + " " + read.selectFacility());

		} else {
			softAssert.assertTrue(false);
			try {
				captureScreen(driver, "readmissiondropDownmenuFacility");
			} catch (IOException e) {

				e.printStackTrace();

			}
		}
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void checkBoxReadmission() throws Exception  {
		// Selecting the option button
		ReadmissionBookingPage read = new ReadmissionBookingPage(driver);
		// read.selectReadnissionCheckBox();
		SoftAssert softAssert = new SoftAssert();
		if (!read.selectReadnissionCheckBox().isSelected()) {
			softAssert.assertTrue(true);
			read.selectReadnissionCheckBox().click();
			
		} else {
			softAssert.assertTrue(false);
			try {
				captureScreen(driver, "readmissiondropDownmenuFacility"); // when test case fail take screenshot
			} catch (IOException e) {

				e.printStackTrace();

			}

		}
		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void healthProgramOptionbtn() {
		// Selecting the option button
		ReadmissionBookingPage read = new ReadmissionBookingPage(driver);
		read.selectReadnissionCheckBox();
		List<WebElement> radioButtons = read.selectOptionBtn();
		SoftAssert softAssert = new SoftAssert();
		// Check if the index is within the range of the radio button list
		int index = 2;
		if (index >= 0 && index < radioButtons.size()) {
			softAssert.assertTrue(true);
			WebElement radioButton = radioButtons.get(index);
			if (!radioButton.isSelected()) {
				radioButton.click();
				System.out.println("Slectiod Health Program is:  " + " " + radioButton.getAttribute("value"));

			} else {
				softAssert.assertTrue(false);
				try {
					captureScreen(driver, "ReadmissiondropDownmenuFacility"); // when test case fail take screenshot
				} catch (IOException e) {

					e.printStackTrace();

				}

			}
		}
		softAssert.assertAll();
	}

	@Test(priority = 4)
	public void visitingDate()  {
		// Selecting valid date for visit
		ReadmissionBookingPage read = new ReadmissionBookingPage(driver);
		SoftAssert softAssert = new SoftAssert();
		String actualDate = read.selectVisitDaate();

		String expectedDate = "21/08/2023";
		if (actualDate.equals(expectedDate)) {
			softAssert.assertTrue(true);
			System.out.println("Selected date: " + actualDate);
		} else {
			softAssert.assertTrue(false);
			try {
				captureScreen(driver, "readmissionValidVisitDate");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		softAssert.assertAll();
	}

	@Test(priority = 5)
	public void sendComment() {
		ReadmissionBookingPage read = new ReadmissionBookingPage(driver);
		SoftAssert softAssert = new SoftAssert();
		String comment = read.writeComment();
		String expectedComment = "Booking and Readmission in Hongkong CURA Healthcare Center on 21/08/2023";
		if (comment.equals(expectedComment)) {
			softAssert.assertTrue(true);
			System.out.println(comment);
		} else {
			softAssert.assertTrue(false);
			try {
				captureScreen(driver, "sendingCommenrReadmission");

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		softAssert.assertAll();

	}

	@Test(priority = 6)
	public void readmissionConfirmation() {
		// Booking Confirmation -using current Url
		ReadmissionBookingPage read = new ReadmissionBookingPage(driver);
		SoftAssert softAssert = new SoftAssert();
		read.clickBookAppointmentBtn();
		String actualUrl = driver.getCurrentUrl();
		String expectUrl = "https://katalon-demo-cura.herokuapp.com/appointment.php#summary";
		if (actualUrl.equals(expectUrl)) {
			softAssert.assertTrue(true);
			System.out.println(actualUrl);
		} else {
			softAssert.assertTrue(false);
			try {
				captureScreen(driver, "readmissionConfirmation"); // when test case fail take screenshot
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
