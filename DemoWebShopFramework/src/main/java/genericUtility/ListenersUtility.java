package genericUtility;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenersUtility extends BaseClassUtility implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
	   test	=eReport.createTest(result.getName());
		test.log(Status.INFO,"test execution started");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Script id Failed");
		TakesScreenshot ts = (TakesScreenshot) driver;
		test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));
		
		try {
			wutil.getPicture(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
