package giftcard;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import genericUtility.BaseClassUtility;
import genericUtility.ListenersUtility;
import objectrepository.HomePage;
@Listeners(ListenersUtility.class)
public class TC_DWS_032_Test extends BaseClassUtility {
	@Test

	public void clickOnGiftcard() throws EncryptedDocumentException, IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		hp.getGiftcardlink().click();
		
		WebElement ele = driver.findElement(By.id("products-orderby"));
		ele.click();
		String sort = eutil.getStringDataFromExcel("Data1", 1, 1);
		wutil.selectDropdown(sort, ele);
	}

}
