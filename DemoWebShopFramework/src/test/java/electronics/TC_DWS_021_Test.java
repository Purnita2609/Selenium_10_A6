package electronics;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericUtility.BaseClassUtility;
import genericUtility.ListenersUtility;
import objectrepository.HomePage;
@Listeners(ListenersUtility.class)
public class TC_DWS_021_Test extends BaseClassUtility {
	@Test
	public void clickOnElectronics() {
		
		HomePage hp = new HomePage(driver);
		hp.getElectronicslink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Electronics","Electronics page is not displayed");
		test.log(Status.PASS, "Electronics page is displayed");
	}


}
