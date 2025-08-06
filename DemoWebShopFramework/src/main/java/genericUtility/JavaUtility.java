package genericUtility;

import java.time.LocalDateTime;
import java.util.Random;
/**
 * @author singh
 */

public class JavaUtility {
	
	/**
	 * This Method will return Current System Date and Time in String format to the caller 
	 * @return 
	 */
	
	public String getSystemTime() {
		return LocalDateTime.now().toString().replace(":", "-");
	}
	
	/**
	 * This Method will return random numbers within 1000 to the caller 
	 * @return 
	 */

	public int getRandomNumber() {
		Random ran = new Random();
		return ran.nextInt(1000);
	}

}
