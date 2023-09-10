package HomeWork;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Parabank {
	
	private ChromeDriver driver;
	private WebDriverWait wait;
	
	private static final String URL = "https://para.testar.org/parabank/index.htm";
	private static final By USERNAME_NAME = By.name("username");
	private static final By PASSWORD_NAME = By.name("password");
	
	private static final String VALID_USERNAME = "A1B2C3V4";
	private static final String VALID_PASSWORD = "123456789";
	
	private static final By LOGIN_XPATH = By.xpath("//input[@value = 'Log In']");
	
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	/*
	@After
	public void tearDown() {
		driver.quit();	
	}
	*/
	@Test
	public void userCanLogIntoHomePage() throws InterruptedException {
		openHomePage();
		Assert.assertTrue("Home page is not displayed",isHomeDisplayed());
		
		typeUsername(VALID_USERNAME);
		typePassword(VALID_PASSWORD);
		clickLogin();
		

		String loggedInMessage = getLoggedInMessage();
		Assert.assertEquals(loggedInMessage, "Welcome User!");	
	}

	
	private String getLoggedInMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	public void openHomePage() {
		driver.get(URL);
	}
	
	public boolean isHomeDisplayed() {
		boolean isDisplayed = getUrl().equalsIgnoreCase(URL);
		return isDisplayed;
	}
	private String getUrl() {
		return driver.getCurrentUrl();
	}
	public void typeCredentials(String username, String password) {		
		typeUsername(username);
		typePassword(password);
	}
	
	public void typeUsername(String username) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement userNameBox = driver.findElement(USERNAME_NAME);
		userNameBox.sendKeys(username);
	}
	public void typePassword(String password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement pinBox = driver.findElement(PASSWORD_NAME);
		pinBox.sendKeys(password);
	}
	
	public void clickLogin() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement submitButton = driver.findElement(LOGIN_XPATH);
		submitButton.click();
	}
	
	
}
