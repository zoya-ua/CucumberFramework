package com.orangehrm.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.orangehrm.utils.CommonMethods;
import com.orangehrm.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class GoogleSearchSteps extends CommonMethods {
WebDriver driver;
String url="https://www.google.com/";
@Given("I navigated to Google")
public void i_navigated_to_Google() {
	
	System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
    driver = new FirefoxDriver();
	driver.manage().window().fullscreen();
	driver.get(url);
}

@When("I type search item")
public void i_type_search_item() {
	WebElement search=driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
	CommonMethods.sendText(search, "Tesla");
}

@When("I click on google search button")
public void i_click_on_google_search_button() {
	WebElement searchBtn=driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[1]"));
	click(searchBtn);
}

@Then("I see search results are displayed")
public void i_see_search_results_are_displayed() {
	WebElement results=driver.findElement(By.cssSelector("div#resultStats"));
	boolean display=results.isDisplayed();
	Assert.assertEquals(true, display);
	driver.quit();
  
 
}


}
