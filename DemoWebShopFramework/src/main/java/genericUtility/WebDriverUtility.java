package genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {

	/**
	 * This Method will Maximize the window
	 * 
	 * @param driver
	 */
	public void maximize(WebDriver driver) {

		driver.manage().window().maximize();
	}

	/**
	 * This Method will Minimize the window
	 * 
	 * @param driver
	 */
	public void minimize(WebDriver driver) {

		driver.manage().window().minimize();
	}

	/**
	 * This Method will Full screen the window
	 * 
	 * @param driver
	 */
	public void fullscreen(WebDriver driver) {

		driver.manage().window().fullscreen();
	}

	/**
	 * This Method will set size of the window
	 * 
	 * @param driver
	 * @param width
	 * @param height
	 */
	public void setSize(WebDriver driver, int width, int height) {

		driver.manage().window().setSize(new Dimension(width, height));
	}

	/**
	 * This Method will get size of the window
	 * 
	 * @param driver
	 */
	public void getSize(WebDriver driver) {

		driver.manage().window().getSize();
	}

	/**
	 * This Method will set position of the window
	 * 
	 * @param driver
	 * @param width
	 * @param height
	 */
	public void setPosition(WebDriver driver, int width, int height) {

		driver.manage().window().setPosition(new Point(width, height));
	}

	/**
	 * This Method will get position of window
	 * 
	 * @param driver
	 */
	public void getPosition(WebDriver driver) {

		driver.manage().window().getPosition();
	}

	/**
	 * This method will Switch to Window and verify url
	 * 
	 * @param driver
	 * @param url
	 * @param title
	 */
	public void switchToWindows(WebDriver driver, String url) {
		Set<String> allWindowsIds = driver.getWindowHandles();

		for (String id : allWindowsIds) {
			driver.switchTo().window(id);
			if (driver.getCurrentUrl().contains(url))
				break;
		}
	}

	/**
	 * This method will switch to windows and verify title
	 * 
	 * @param title
	 * @param driver
	 */
	public void switchToWindows(String title, WebDriver driver) {
		Set<String> allWindowsIds = driver.getWindowHandles();

		for (String id : allWindowsIds) {
			driver.switchTo().window(id);
			if (driver.getTitle().contains(title))
				break;
		}
	}

	/**
	 * This Method will perform mouseHover on element
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element) {

		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * This Method will scroll to element
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollToElement(WebDriver driver, WebElement element) {

		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}

	/**
	 * This Method will scroll the web page
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scroll(WebDriver driver, int x, int y) {

		Actions act = new Actions(driver);
		act.scrollByAmount(x, y).perform();
	}

	/**
	 * This Method will click and hold operation on element
	 * 
	 * @param driver
	 * @param element
	 */
	public void clickAndHold(WebDriver driver, WebElement element) {

		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}

	/**
	 * This Method will right click on element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {

		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * This Method will double click
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element) {

		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * This method will select drop down by index
	 * 
	 * @param element
	 * @param index
	 */
	public void selectDropdown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * This Method will select drop down using value
	 * 
	 * @param element
	 * @param value
	 */
	public void selectDropdown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * This method will select drop down using visible Text
	 * 
	 * @param text
	 * @param element
	 */
	public void selectDropdown(String text, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * This method will switch to frame using index value
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method will switch to frame using name or Id
	 * 
	 * @param driver
	 * @param nameorId
	 */
	public void switchToFrame(WebDriver driver, String nameorId) {
		driver.switchTo().frame(nameorId);
	}

	/**
	 * This method will switch to frame using element address
	 * 
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method will switch to alert and perform different
	 * operations(accept,dismiss,get text,send keys.
	 * 
	 * @param driver
	 * @return
	 */
	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}

	/**
	 * This method will take screenshot of web page
	 * 
	 * @throws IOException
	 */

	public void getPicture(WebDriver driver) throws IOException {

		JavaUtility jutil = new JavaUtility();// adding time stamp

		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshots/" + jutil.getSystemTime() + ".png");
		FileHandler.copy(temp, dest);

	}
	
	public void handleDropdown(WebDriver driver , WebElement element,String value) {
		Select ele = new Select(element);
		ele.selectByValue(value);
	}

}
