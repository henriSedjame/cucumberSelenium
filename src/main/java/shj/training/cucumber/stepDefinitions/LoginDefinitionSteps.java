package shj.training.cucumber.stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDefinitionSteps implements En {

  WebDriver driver;

  public LoginDefinitionSteps() {

    Given("^user is already in login page$", () -> {
      System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.get("https://www.freecrm.com");

    });

    When("^user click on login$", () -> {
      driver.findElement(By.name("username")).sendKeys("hsedjame");
      driver.findElement(By.name("password")).sendKeys("hiphop!87");
      WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].click();", loginBtn);
    });

    Then("^system redirect to resource$", () -> {
      String pageTitle = driver.getTitle();
      Assert.assertEquals("CRMPRO", pageTitle);
    });

  }
}
