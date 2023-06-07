package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;

public class BookingAppointmentPage extends BasePage {
	


	public WebDriverWait wait;
	public JavascriptExecutor js;
	public Actions action;
	
	public BookingAppointmentPage(WebDriver driver) {
		super(driver);
		
	}

	

	@FindBy(id="combo_facility")
	@CacheLookup
	public WebElement facility;
	
	
	
	@FindBy(xpath="//label[@class=\"radio-inline\"]")
	@CacheLookup
	public WebElement optionbtn;
	
	@FindBy(id="txt_visit_date")
	@CacheLookup
	public WebElement datePicker;
	
	@FindBy(xpath="(//th[@class='next'][normalize-space()='»'])[1]")
	@CacheLookup
	public WebElement dateNextBtn;
	
	@FindBy(css="div[class='datepicker-days'] th[class='datepicker-switch']")
	@CacheLookup
	public WebElement monthYear;
	
	@FindBy(xpath="//td[normalize-space()='21']")
	@CacheLookup
	public WebElement desiredDate;
	
	@FindBy(id="txt_comment")
	@CacheLookup
	public WebElement comment;
	
	@FindBy(id="btn-book-appointment")
	@CacheLookup
	public WebElement bookAppointmentBtn;

	
	//=============================================Action Methods====================================//
	
	public String selectFacilityBooking() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(facility));
		Select dropdown = new Select(facility);
		dropdown.selectByIndex(2);   // selevting an item based on index
		WebElement selectedOption = dropdown.getFirstSelectedOption();
	    String selectedText = selectedOption.getText();
	    return selectedText;
	    
	}
	public List<WebElement> selectOptionBtn() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(optionbtn));
		List<WebElement> options = driver.findElements(By.tagName("input")); //List of button
		return options;
		
	}
	public WebElement selectVisitDaate() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(datePicker));
		datePicker.sendKeys("12/07/2023");
		//String date = datePicker.getAttribute("value");
	    return datePicker;
		

	}
	
	public String writeComment() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(comment));
	    comment.sendKeys("Booking an appointment in Seoul CURA Healthcare Center on 12/07/2023");
	    String actualComment = comment.getAttribute("value");
	    return actualComment;
		
	}
	public void clickBookAppointmentBtn() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(bookAppointmentBtn));
		bookAppointmentBtn.click();
	}
	
	
	
}
