package giftcard;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import genericUtility.BaseClassUtility;
import genericUtility.ListenersUtility;
import objectrepository.HomePage;
@Listeners(ListenersUtility.class)
public class TC_DWS_031_Test extends BaseClassUtility {
	@Test
	public void clickOnJewelry() {

		
		HomePage hp = new HomePage(driver);
		hp.getJewelrylink().click();

	}
}
