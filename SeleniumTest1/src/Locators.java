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
   */
  public static void main(String[] args) {
    System.setProperty(
      "webdriver.chrome.driver",
      "/Users/pavelphilipchik/Study/chromedriver_mac_arm64/chromedriver"
    );
    WebDriver driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3);

    driver.get("https://rahulshettyacademy.com/locatorspractice/");
    driver.findElement(By.id("inputUsername")).sendKeys("Pavel Philipchik");
    driver.findElement(By.name("inputPassword")).sendKeys("ChelTy");
    driver.findElement(By.className("signInBtn")).click();
    System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
    driver.findElement(By.linkText("Forgot your password?")).click();
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


  }
}
