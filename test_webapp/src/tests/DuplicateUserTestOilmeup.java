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

public class DuplicateUserTestOilmeup {
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
  public void testDuplicateUserTestOilmeup() throws Exception {
	driver.manage().window().maximize();
    driver.get("http://34.27.170.212/catalog/");
    Thread.sleep(1500);
    driver.findElement(By.linkText("Sign Up")).click();
    Thread.sleep(1500);
    driver.get("http://34.27.170.212/signup/");
    Thread.sleep(700);
    driver.findElement(By.id("id_username")).click();
    driver.findElement(By.id("id_username")).clear();
    driver.findElement(By.id("id_username")).sendKeys("newPersonPerson");
    Thread.sleep(700);
    driver.findElement(By.id("id_budget")).clear();
    driver.findElement(By.id("id_budget")).sendKeys("1000");
    Thread.sleep(700);
    driver.findElement(By.id("id_password1")).clear();
    driver.findElement(By.id("id_password1")).sendKeys("ThisisaPassword!");
    Thread.sleep(700);
    driver.findElement(By.id("id_password2")).clear();
    driver.findElement(By.id("id_password2")).sendKeys("ThisisaPassword!");
    Thread.sleep(700);
    driver.findElement(By.cssSelector(".signup-form")).submit();
    Thread.sleep(1500);
    
    // Checks if duplicate user warning is present
    assertTrue("'This username is already taken.' warning should be present",
    		isElementPresent(By.xpath("//div[@class='form-group']//div[contains(@class, 'error')][contains(text(), 'username')]"), null));
    
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
	        if (text == null) {
	            return element.isDisplayed();  // check for presence
	        }
	        return element.isDisplayed() && element.getText().contains(text);
	    } catch (NoSuchElementException e) {
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
