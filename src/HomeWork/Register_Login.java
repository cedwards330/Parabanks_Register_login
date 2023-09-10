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

public class Register_Login {
	
	//HomePage
	private ChromeDriver driver;
	private WebDriverWait wait;
	private String URL = "https://para.testar.org/parabank/index.htm";
	private String homePageTitle = "ParaBank";
	private static final By REGISTER_XPATH = By.xpath("//a[text() = 'Register']");
	private static final By FIRST_NAME_BOX = By.id("customer.firstName");
	private static final By LAST_NAME_BOX = By.id("customer.lastName");
	private static final By ADDRESS_BOX 	= By.id("customer.address.street");
	private static final By CITY_BOX 	= By.id("customer.address.city");
	private static final By STATE_BOX = By.id("customer.address.state");
	private static final By ZIPCODE_BOX = By.id("customer.address.zipCode");
	private static final By PHONE_NUMBER_BOX = By.id("customer.phoneNumber");
	private static final By SOCIAL_INSURANCE_BOX = By.id("customer.ssn");
	private static final By USERNAME_BOX = By.id("customer.username");
	private static final By PASSWORD_BOX = By.id("customer.password");
	private static final By REPEAT_PASSWORD_BOX = By.id("repeatedPassword");
	private static final By SUBMIT_BUTTON_XPATH = By.xpath("//input[@value = 'Register']");
	
	
	//Test Data
	private static final String FIRST_NAME = "James";
	private static final String LAST_NAME = "Brown";
	private static final String TYPE_ADDRESS = "123 Sicamous Drive";
	private static final String TYPE_CITY = "Sicamous";
	private static final String TYPE_STATE = "British Columbia";
	private static final String TYPE_POSTAL = "7B2 0C9";
	private static final String TYPE_PHONE = "867-5309";
	private static final String TYPE_SSN = "123 456 789";
	private static final String TYPE_USERNAME = "james.brown@aol.com";
	private static final String TYPE_PASSWORD = "a1b2c3d5e5";
	

	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown() {
		driver.quit();	
	}
	
	@Test
	public  void registrationPage() throws InterruptedException {
		
		openHomePage();
				
		String homePageUrl = driver.getCurrentUrl();
		Assert.assertEquals(URL ,homePageUrl);
		
		String getHomePageTitle = driver.getTitle();
		Assert.assertTrue(getHomePageTitle.contains(homePageTitle));
		
		clickRegister();
		typeFirstName(FIRST_NAME);
		typeLastName(LAST_NAME);
		typeAddress(TYPE_ADDRESS);
		typeCity(TYPE_CITY);
		typeProvince(TYPE_STATE);
		typePostal(TYPE_POSTAL);
		typePhone(TYPE_PHONE);
		typeSSN(TYPE_SSN);
		typeUsername(TYPE_USERNAME);
		typePassword(TYPE_PASSWORD);
		repeatPassword(TYPE_PASSWORD);
		Thread.sleep(2000);
		submitButton();

		//assert that the registration happened successfully
		Thread.sleep(2000);
		
		
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
	
	public void clickRegister() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement submitButton = driver.findElement(REGISTER_XPATH);
		submitButton.click();
	}
	
	public void typeFirstName(String firstName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement typeFirstName = driver.findElement(FIRST_NAME_BOX);
		typeFirstName.sendKeys(firstName);
	}

	public void typeLastName(String lastName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement typeLastName = driver.findElement(LAST_NAME_BOX);
		typeLastName.sendKeys(lastName);
	}
	
	public void typeAddress(String address) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));		
		WebElement typeAddress = driver.findElement(ADDRESS_BOX);
		typeAddress.sendKeys(address);
	}
	public void typeCity(String city) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement typeCity = driver.findElement(CITY_BOX);
		typeCity.sendKeys(city);
	}
	public void typeProvince(String state) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement typeProvince = driver.findElement(STATE_BOX);
		typeProvince.sendKeys(state);
	}
	public void typePostal(String postal) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement typePostal = driver.findElement(ZIPCODE_BOX);
		typePostal.sendKeys(postal);
	}
	public void typePhone(String phone) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement typePhone = driver.findElement(PHONE_NUMBER_BOX);
		typePhone.sendKeys(phone);
	}
	public void typeSSN(String ssn) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement typeSSN = driver.findElement(SOCIAL_INSURANCE_BOX);
		typeSSN.sendKeys(ssn);
	}
	public void typeUsername(String username) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement typeUsername = driver.findElement(USERNAME_BOX);
		typeUsername.sendKeys(username);
	}
	public void typePassword(String password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement typePassword = driver.findElement(PASSWORD_BOX);
		typePassword.sendKeys(password);
	}
	public void repeatPassword(String password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement repeatPassword = driver.findElement(REPEAT_PASSWORD_BOX);
		repeatPassword.sendKeys(password);
	}

	public void submitButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement submitButton = driver.findElement(SUBMIT_BUTTON_XPATH);
		submitButton.click();
	}

}
