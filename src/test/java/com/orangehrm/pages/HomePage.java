package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;

public class HomePage extends BaseClass {
	@FindBy(xpath="//li[text()='Dashboard']")
	public WebElement dashboardText;
	
	@FindBy(partialLinkText="PIM")
    public WebElement PIM;
	
    @FindBy(partialLinkText="Add Employee")
    public WebElement addEmployee;
    
    @FindBy (xpath="//*[@id=\"menu_admin_viewAdminModule\"]/a/span[2]")
    public WebElement admin;
    
    @FindBy(partialLinkText="Organization")
    public WebElement organization;
    
    @FindBy (xpath="//a[@id='menu_admin_viewLocations']")
    public WebElement locations;
    
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	

}
