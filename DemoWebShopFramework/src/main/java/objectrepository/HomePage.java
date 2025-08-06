package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(linkText = "Log out")
	private WebElement Logoutlink;
	
	@FindBy(partialLinkText = "BOOKS")
	private WebElement Bookslink;
	
	@FindBy(partialLinkText = "COMPUTERS")
	private WebElement Computerslink;
	
	@FindBy(partialLinkText = "ELECTRONICS")
	private WebElement Electronicslink;
	
	@FindBy(partialLinkText = "Desktops")
	private WebElement Desktoplink;
	
	@FindBy(partialLinkText = "JEWELRY")
	private WebElement Jewelrylink;
	
	@FindBy(partialLinkText = "GIFT CARDS")
	private WebElement Giftcardlink;
	
	public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}

	public WebElement getLogoutlink() {
		return Logoutlink;
	}

	public WebElement getBookslink() {
		return Bookslink;
	}

	public WebElement getComputerslink() {
		return Computerslink;
	}

	public WebElement getElectronicslink() {
		return Electronicslink;
	}

	public WebElement getDesktoplink() {
		return Desktoplink;
	}

	public WebElement getJewelrylink() {
		return Jewelrylink;
	}

	public WebElement getGiftcardlink() {
		return Giftcardlink;
	}

	
	

	
	
	

}
