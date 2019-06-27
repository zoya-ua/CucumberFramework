package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;

public class AddLocationPage extends BaseClass{
	@FindBy(xpath="//i[text()='add']")
	public WebElement add;
	
	@FindBy(xpath="//input[@id='name']")
	public WebElement name;
	
	//@FindBy(xpath="//*[@id='countryCode_inputfileddiv']//div//ul")
	@FindBy(css="#countryCode_inputfileddiv")
	public WebElement country;
	
	@FindBy(xpath="//*[@id=\"time_zone_inputfileddiv\"]/div/input")
	public WebElement timeZone;
	
	@FindBy(xpath="//input[@id='province']")
	public WebElement province;
	
	@FindBy(xpath="//input[@id='city']")
	public WebElement city;
	
	@FindBy(xpath="//input[@id='zipCode']")
	public WebElement zipCode;
	
	@FindBy(xpath="//input[@id='phone']")
	public WebElement phone;
	
	@FindBy(xpath="//a[text()='Save']")
	public WebElement btnSave;
	
	public AddLocationPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	

}
