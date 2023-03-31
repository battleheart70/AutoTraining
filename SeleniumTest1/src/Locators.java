import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 */

/**
 * @author pavelphilipchik
 *
 */
public class Locators {

  /**
   * @param args
   * @throws InterruptedException
   */
  public static void main(String[] args) throws InterruptedException {
    System.setProperty(
      "webdriver.chrome.driver",
      "/Users/pavelphilipchik/Study/chromedriver_mac_arm64/chromedriver"
    );
    WebDriver driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    driver.get("https://rahulshettyacademy.com/locatorspractice/");
    driver.findElement(By.id("inputUsername")).sendKeys("Pavel Philipchik");
    driver.findElement(By.name("inputPassword")).sendKeys("ChelTy");
    driver.findElement(By.className("signInBtn")).click();
    System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
    driver.findElement(By.linkText("Forgot your password?")).click();
    Thread.sleep(2000);
    driver
      .findElement(By.xpath("//input[@placeholder='Name']"))
      .sendKeys("MyName");
    driver
      .findElement(By.cssSelector("input[placeholder='Email']"))
      .sendKeys("testemail@gmtes.com");
    driver
      .findElement(By.xpath("//input[@type='text'][3]"))
      .sendKeys("767674854");
    driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
    System.out.println(driver.findElement(By.cssSelector("form p")).getText());
    driver
      .findElement(
        By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")
      )
      .click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Pavel");
    driver
      .findElement(By.cssSelector("input[type*='pass']"))
      .sendKeys("rahulshettyacademy"); //CssSelector with regex *= means ANY MATCH, ^= means in the beginning, $= means in the end
    driver.findElement(By.id("chkboxOne")).click();
    driver.findElement(By.xpath("//input[@value='agreeTerms']")).click();
    driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click(); //xPath regular expression
  }
}
