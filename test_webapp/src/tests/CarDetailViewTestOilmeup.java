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

public class CarDetailViewTestOilmeup {
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
  public void testCarDetailViewTestOilmeup() throws Exception {
	driver.manage().window().maximize();
	Thread.sleep(3000);  
    driver.get("http://34.27.170.212/catalog/");
    Thread.sleep(1500);
    driver.findElement(By.linkText("All Cars")).click();
    Thread.sleep(1500);
    driver.findElement(By.linkText("View Details")).click();
    Thread.sleep(1500);
    
 // Checks if 'List of Cars' header is present
    assertTrue("'Back to car list' button should be present",
    		isElementPresent(By.xpath("//a[contains(text(), 'Back to car list')]"), "Back to car list"));
    
    Thread.sleep(500);
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
