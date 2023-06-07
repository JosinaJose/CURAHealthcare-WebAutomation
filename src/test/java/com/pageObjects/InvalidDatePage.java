package com.pageObjects;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;

public class InvalidDatePage extends BasePage{
	public WebDriverWait wait;
	public JavascriptExecutor js;
	

	public InvalidDatePage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath ="//input[@id=\"txt_visit_date\"]")
	@CacheLookup
	public WebElement pastDate;
	

	@FindBy(id="btn-book-appointment")
	@CacheLookup
	public WebElement bookAppointmentBtn;

	
	
	//======================Action Methods======================//
	
		public WebElement pastDateSelected() {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(pastDate));
			pastDate.sendKeys("22/01/2021");
			return pastDate;
		
		}
	
	public void clickBookAppointmentBtn() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(bookAppointmentBtn));
		bookAppointmentBtn.click();
	}

}
