package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;

public class AddEmployeePage extends BaseClass {
	@FindBy(id="firstName")
	public WebElement  firstName;
	@FindBy(id="middleName")
	public WebElement middleName;
	@FindBy(id="lastName")
	public WebElement lastName;
	@FindBy(id="employeeId")
    public WebElement employeeId;
    @FindBy(xpath="//div[@id='location_inputfileddiv']//input")
    public WebElement location;
    @FindBy(xpath="//div[@id='location_inputfileddiv']//ul")
    public WebElement locationList;
    @FindBy(css="a#systemUserSaveBtn")
    public WebElement saveBtn;
    @FindBy(xpath="//span[@id='pim.navbar.employeeName']")
    public WebElement empCheck;
    
    @FindBy(xpath="//label[text()='Create Login Details']")
    public WebElement LoginDetails;
    @FindBy(css="input#username")
    public WebElement userName;
    @FindBy(css="input#password")
    public WebElement password;
    @FindBy(css="input#confirmPassword")
    public WebElement confirmPass;
    @FindBy(xpath="//div[@id='status_inputfileddiv']//input")
    public WebElement status;
    @FindBy(xpath="//div[@id='status_inputfileddiv']//ul")
    public WebElement statusList;
    @FindBy(xpath="//div[@id='essRoleId_inputfileddiv']")
    public WebElement essRole;
    @FindBy(xpath="//div[@id='essRoleId_inputfileddiv']//ul")
    public WebElement essRoleList;
    @FindBy(xpath="//div[@id='supervisorRoleId_inputfileddiv']")
    public WebElement supervisorRole;
    @FindBy(xpath="//div[@id='supervisorRoleId_inputfileddiv']//ul")
    public WebElement supervisorRoleList;
    
    
    @FindBy(xpath="//form[@id='pimAddEmployeeForm']//label")
    public List <WebElement> addEmpLabels;
    
    public AddEmployeePage() {
    	PageFactory.initElements(driver, this);
    	
    }

}
