package com.orangehrm.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends BaseClass{


	/**
	 * This method will select a specified value from a drop down
	 * @author Syntax 
	 * @param Select element, String text
	 */
	public static void selectValueFromDD(WebElement element, String text) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		boolean isSelected=false;
		for (WebElement option : options) {
			String optionText = option.getText();
			if (optionText.equals(text)) {
				select.selectByVisibleText(text);
				System.out.println("Option with text "+text+" is selected");
				isSelected=true;
				break;
			}
		}
		if(!isSelected) {
			System.out.println("Option with text +"+text+"is not available");
		}
	}

	/**
	 * This method will select a specified value from a drop down by its index
	 * @author Syntax 
	 * @param Select element, int index
	 */
	public static void selectValueFromDD(WebElement element, int index) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		if (options.size() > index) {
			select.selectByIndex(index);
		} else {
			System.out.println("Invalid index has been passed");
		}
	}

	public static void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
/**
 * Method will accept alert
 * @throws NoAlertPresentException if alert is not present
 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}
	}
	/**
	 * Method will dismiss alert
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static void dismissAlert() {
		try {
			Alert alert=driver.switchTo().alert();
			alert.dismiss();
		}catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}
	}
	/**
	 * Method will get text of an alert
	 * @throws NoAlertPresentException if alert is not present
	 * @return String text
	 */
	public static String getAlertText() {
		
		try {
			Alert alert=driver.switchTo().alert();
			return alert.getText();
		}catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
			return null;
		}
		
	}
	/**
	 * Method that will switch control to the specified frame
	 * @param frame id or frame name
	 */
	public static void switchToFrame(String idOrName) {
		try {
			driver.switchTo().frame(idOrName);
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}
	/**
	 * Method that will switch control to the specified frame
	 * @param frame element
	 */
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}
	/**
	 * Method that will switch control to the specified frame
	 * @param frame index
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}
		/**
		 * Method that will click on a Link by linkText
		 * @param frame index
		 */
	public static void linkTextClick(String linkText) {
	driver.findElement(By.linkText(linkText)).click();	
		
	}
	
	/**
	 * Method that will check radio button or check box 
	 * finding element by xpath  and selecting by value 
	 * @param 
	*/
	
	public static void checkButtonByXpath( String xpath, String valueToSelect) {
        List<WebElement> allRadio = driver.findElements(By.xpath(xpath));
    
        for (WebElement status : allRadio) {
            if (status.isEnabled()) {
                String statusValue = status.getText();
                if (statusValue.equals(valueToSelect)) {
                    status.click();
                    break;
                }
            }
        }
    }
	/**
	 * Method that will click on a Link by linkText
	 * @param WebElement name
	 */
	public static void rightClick(WebElement name) {
		Actions action=new Actions(driver);
		action.contextClick(name).perform();
	}
	/**
	 * Method will find WebElement by cssSelector
	 * and send keyText
	 */
	public static void findByCssAndSendKeys(String cssSelector,String key) {
		WebElement element = driver.findElement(By.cssSelector(cssSelector));
				element.clear();
				element.sendKeys(key);	
	}
	
	/**
	 * Method will find WebElement by xpath
	 * and click() 
	 */
	public static void clickByXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	/**
	 * Method will find element by CssSelector ,will getText 
	 * and verify its Text with expected
	 * @param cssSelector, expectedValue
	 */
public static void verifyElementValueByCss(String cssSelector,String expectedValue) {
	WebElement element = driver.findElement(By.cssSelector(cssSelector));
	String actualValue=element.getAttribute("value");
	System.out.println(actualValue);
	if(actualValue.equalsIgnoreCase(expectedValue)) {
		System.out.println(actualValue +" is verified");
	}else {
		System.out.println(actualValue +" WRONG");
	}
}

/**
 * Method that will wait for element to be visible
 * 
 * @param WebElement element, int time
 */
public static void waitForElementBeVisible(WebElement element, int time) {
	WebDriverWait wait = new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * Method that will wait for element to be visible
 * 
 * @param WebElement element, int time
 */
public static void waitForElementBeVisible(By locator, int time) {
	WebDriverWait wait = new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}

public static void waitForElementBeClickable(WebElement element, int time) {
	WebDriverWait wait = new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}

public static void waitForElementBeClickable(By locator, int time) {
	WebDriverWait wait = new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.elementToBeClickable(locator));
}
	
	public static byte [] takeScreenshot() {
		TakesScreenshot ts=(TakesScreenshot)driver;
        byte [] screen=ts.getScreenshotAs(OutputType.BYTES);
        return screen;
       
	}
	

	public static void scrollDown(int pixels) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+pixels+")");
	}
	
	public static void scrollUp(int pixels) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-"+pixels+")");
	}
	
	public static void jsClick(WebElement element) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	public static void click(WebElement element) {
		element.click();
	}
	public static void selectList(WebElement element, String text) {

		List<WebElement> listLocations = element.findElements(By.tagName("li"));
		for (WebElement li : listLocations) {
			String liText = li.getAttribute("innerHTML");

			if (liText.contains(text)) {
				li.click();
				break;
			}
		}
	}
}



