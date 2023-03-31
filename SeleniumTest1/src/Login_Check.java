import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Login_Check {

  private String[] split;

  /**
   * @param args
   * @throws InterruptedException
   */
  public static void main(String[] args) throws InterruptedException {
    String name = "Pavel";

    System.setProperty(
      "webdriver.chrome.driver",
      "/Users/pavelphilipchik/Study/chromedriver_mac_arm64/chromedriver"
    );

    WebDriver driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    String password = getPassword(driver);
    driver.get("https://rahulshettyacademy.com/locatorspractice/");
    driver.findElement(By.id("inputUsername")).sendKeys(name);
    driver.findElement(By.name("inputPassword")).sendKeys(password);
    driver.findElement(By.className("signInBtn")).click();
    Thread.sleep(2000);
    System.out.println(driver.findElement(By.tagName("p")).getText());
    Assert.assertEquals(
      driver.findElement(By.tagName("p")).getText(),
      "You are successfully logged in.",
      "FAILED"
    );
    Assert.assertEquals(
      driver.findElement(By.tagName("h2")).getText(),
      "Hello " + name + ","
    );
    driver
      .findElement(By.xpath("//button[contains(text(),'Log Out')]"))
      .click();
      Thread.sleep(2000);
      driver.quit();
  }

/**
 * @param driver
 * @return 
 * @throws InterruptedException
 */
public static String getPassword(WebDriver driver) throws InterruptedException {
  driver.get("https://rahulshettyacademy.com/locatorspractice/");
  driver.findElement(By.linkText("Forgot your password?")).click();
  Thread.sleep(2000);
  driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
  String passwordText = (driver.findElement(By.cssSelector("form p")).getText());
  //Please use temporary password 'rahulshettyacademy' to Login.
  String[] passwordArray = passwordText.split("'");
  //after split
  //1st string  - "Please use temporary password " [0] index
  //2nd string - rahulshettyacademy' to Login. [1] index
  String password = passwordArray[1].split("'")[0];
  //after split
  //1st string  -  rahulshettyacademy [0] index
  //2nd string - to Login. [1] index
  return password;
}


}
