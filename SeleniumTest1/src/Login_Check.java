import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Login_Check {

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

    driver.get("https://rahulshettyacademy.com/locatorspractice/");
    driver.findElement(By.id("inputUsername")).sendKeys(name);
    driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
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
}
