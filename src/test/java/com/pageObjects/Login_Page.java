package com.pageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;

public class Login_Page  extends BasePage{
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public Actions action;

	public Login_Page(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "btn-make-appointment")
	@CacheLookup
	public WebElement makeAppointmentbtn;
	
	
	@FindBy(id="txt-username")
	@CacheLookup
	public WebElement username;
	
	@FindBy(id="txt-password")
	@CacheLookup
	public WebElement password;
	
	@FindBy(id="btn-login")
	@CacheLookup
	public WebElement loginbtn;
	
	@FindBy(xpath="//p[@class='lead text-danger']")
	@CacheLookup
	public WebElement loginFaild;
	
	
	
	
	//=======================Action Methods=================================//
	
	
	
	public void clickMakeAppointmentbtn() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(makeAppointmentbtn));
		makeAppointmentbtn.click();
	}
	
	public void enetrUsername(String user) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(username));
	       username.sendKeys(user);
	}
	public void enterPassword(String pass) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pass);
	}
	public void clickLoginbtn() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(loginbtn));
		loginbtn.click();
	}
	public String invalidcredentials() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(loginFaild));
		String expectedError = loginFaild.getText();
		return expectedError;
	}
}
