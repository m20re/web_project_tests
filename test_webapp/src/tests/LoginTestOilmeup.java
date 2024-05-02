package tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.time.Duration;

public class LoginTestOilmeup {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\marvi\\CSCI4830\\workspace\\workspace4830-webapp-testing-Orellana\\project_webapp_testing1\\lib\\win\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testLoginTestOilmeup() throws Exception {
	driver.manage().window().maximize();
	Thread.sleep(1500);
    driver.get(baseUrl + "chrome://newtab/");
    driver.get("http://34.27.170.212/login/");
    Thread.sleep(1000);
    driver.findElement(By.id("id_username")).click();
    Thread.sleep(700);
    driver.findElement(By.id("id_username")).clear();
    Thread.sleep(700);
    driver.findElement(By.id("id_username")).sendKeys("newPersonfr");
    Thread.sleep(700);
    driver.findElement(By.id("id_password")).clear();
    Thread.sleep(700);
    driver.findElement(By.id("id_password")).sendKeys("ThisisaPassword!");
    Thread.sleep(700);
    driver.findElement(By.cssSelector(".login-form")).submit();
    Thread.sleep(700);
    driver.get("http://34.27.170.212/catalog/accounts/profile/");
    
    // checks to see if 'cars within your budget' is there
    assertTrue("'Cars within your budget' should be present",
    		isElementPresent(By.xpath("//h2[contains(text(), 'Cars within your budget:')]"), "Cars within your budget:"));
    
    Thread.sleep(2000);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by, String text) {
	    try {
	      WebElement element = driver.findElement(by);
	      if (text != null) {
	    	  return element.isDisplayed() && element.getText().contains(text);
	      }
	      return element.isDisplayed();
	    } catch(NoSuchElementException error) {
	    	return false;
	    }
	  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
