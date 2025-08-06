package books;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericUtility.BaseClassUtility;
import genericUtility.ListenersUtility;
import objectrepository.HomePage;
@Listeners(ListenersUtility.class)
public class TC_DWS_001_Test extends BaseClassUtility {
	
	@Test
	public void clickOnBooks() {
		
		HomePage hp = new HomePage(driver);
		hp.getBookslink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Books","Books page is not displayed");
		test.log(Status.PASS, "Books page is displayed");
	}

}
