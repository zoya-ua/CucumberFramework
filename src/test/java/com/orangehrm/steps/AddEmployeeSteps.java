package com.orangehrm.steps;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.orangehrm.pages.AddEmployeePage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.CommonMethods;
import com.orangehrm.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddEmployeeSteps extends CommonMethods {
	LoginPage login;
    HomePage home;
    AddEmployeePage addEmp;

@Given("I looged in into OrangeHRM")
public void i_looged_in_into_OrangeHRM() {
	login=new LoginPage();
	home=new HomePage();
	addEmp=new AddEmployeePage();
    login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));  
}
@When("I click on PIM link")
public void i_click_on_PIM_link() {
	click(home.PIM);  
}
@When("I click on Add Employee link")
public void i_click_on_Add_Employee_link() {
   click(home.addEmployee) ;
}
@When("I provide Employee details {string} and {string} and {string} and {string}")
public void i_provide_Employee_details_and_and_and(String fName, String mName, String lName, String location) {
   sendText(addEmp.firstName,fName);
   sendText(addEmp.middleName,mName);
   sendText(addEmp.lastName,lName);
   click(addEmp.location);
   selectList(addEmp.locationList, location);   
}

@When("I click on create login details")
public void i_click_on_create_login_details() {
 click(addEmp.LoginDetails);
}

@Then("I see Employee added successfully {string} and {string}")
public void i_see_Employee_added_successfully_and(String fName, String lName) {
    waitForElementBeClickable(addEmp.empCheck,20);
    String verifyText=addEmp.empCheck.getText();
    System.out.println(verifyText);
    Assert.assertEquals(verifyText, fName+" "+lName);
}	

@When("I provide all mandatory fields {string} and {string} and {string} and {string} and {string}")
public void i_provide_all_mandatory_fields_and_and_and_and(String userName, String password, String status, String essRole, String supervisor) {
	 sendText(addEmp.userName, userName); 
	   sendText(addEmp.password, password); 
	   sendText(addEmp.confirmPass, password); 
	   click(addEmp.status);
	   selectList(addEmp.statusList, status );
	   click(addEmp.essRole);
	   selectList(addEmp.essRoleList, essRole );
	   click(addEmp.supervisorRole);
	   selectList(addEmp.supervisorRoleList, supervisor  );
}
@When("I click on Save button")
public void i_click_on_Save_button() {
	 waitForElementBeClickable(addEmp.saveBtn,20);
   click(addEmp.saveBtn);
}

@Then("I see following labels")
public void i_see_following_labels(DataTable addEmpLabels) {
	System.out.println("----Printing labels from cucumber dataTable----");
	List<String> expectedLabels=addEmpLabels.asList();
	for (String label:expectedLabels) {
		System.out.println(label);
	}
	//create an empty arraylist where we store labels text
	List<String> actualLabels=new ArrayList<String>();
	//get all label elements
List <WebElement> labelList=addEmp.addEmpLabels;
for (WebElement label:labelList) {
String labeltxt=label.getText().trim();
//if text is not empty replace * band store it inside a
if(!labeltxt.isEmpty()) {
	actualLabels.add(labeltxt.replace("*", ""));
}
System.out.println(labeltxt);
}
Assert.assertEquals(actualLabels, expectedLabels);
}
}
