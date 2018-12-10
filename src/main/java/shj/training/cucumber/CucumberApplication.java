package shj.training.cucumber;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class CucumberApplication {


  public static void main(String[] args) {
    SpringApplication.run(CucumberApplication.class, args);

    System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.navigate().to("http://www.google.com");

    /* implicit wait*/
    implicitWait(driver, 1000L);

    /* fill search input */
    driver.findElement(By.name("q")).sendKeys("developpons en java");

    /* find search button and submit */
    driver.findElement(By.name("btnK")).submit();

    /* explicit wait */
    explicitWait(driver, "Développons en java");

    /* take a screenshot*/
    takeScreenShot(driver);


    /* find link and click */
    driver.findElement(By.partialLinkText("Développons en java")).click();
  }

  public static void explicitWait(WebDriver driver, String text){
    new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.partialLinkText(text)));
  }

  public static void implicitWait( WebDriver driver, Long time) {
    driver.manage().timeouts().implicitlyWait(time, TimeUnit.MILLISECONDS);
  }

  public static void takeScreenShot(WebDriver driver){
    File screenshot = TakesScreenshot.class.cast(driver).getScreenshotAs(OutputType.FILE);
    try {
      FileCopyUtils.copy(screenshot, new File("screenShot.jpg"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static boolean exist(WebElement element){
    try{
      return element.isDisplayed();
    }catch (NoSuchElementException e){
      return false;
    }
  }

  public static void dragAndDrop(WebDriver driver, WebElement source, WebElement target){
    Actions actions = new Actions(driver);
    actions.dragAndDrop(source, target).perform();

  }
}
