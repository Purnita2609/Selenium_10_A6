package computers;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericUtility.BaseClassUtility;
import genericUtility.ListenersUtility;
import objectrepository.HomePage;
@Listeners(ListenersUtility.class)
public class TC_DWS_011_Test extends BaseClassUtility {
	@Test
	public void clickOnComputers() {
		
		HomePage hp = new HomePage(driver);
		hp.getComputerslink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Computers","Computers page is not displayed");
		test.log(Status.PASS, "Computers page is displayed");
		test.log(Status.PASS, "Computers page is displayed");
		
		wutil.mouseHover(driver, hp.getComputerslink());
		hp.getDesktoplink().click();
		
		
	}

}

