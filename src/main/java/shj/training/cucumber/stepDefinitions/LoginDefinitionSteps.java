package shj.training.cucumber.stepDefinitions;

import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import shj.training.cucumber.page.models.LoginPage;

public class LoginDefinitionSteps implements En {

  WebDriver driver;
  LoginPage loginPage;

  public LoginDefinitionSteps() {

    Before(() -> {
      System.out.println("Test begins .....");
      System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
      driver = new ChromeDriver();
      loginPage = new LoginPage(driver);
    });

    Given("^user is already in login page$", () -> {

      driver.get("https://www.freecrm.com");

    });

    And("^user enters ([^\"]*) and ([^\"]*)$", (String username, String password) -> {
      loginPage.fillCredentials(username, password);
    });

    When("^user click on login$", () -> {
      loginPage.clickLoginBtn();
    });

    Then("^system redirect to home page$", () -> {
      String pageTitle = driver.getTitle();
      Assert.assertEquals("CRMPRO", pageTitle);

    });

    After(() -> {
      System.out.println("Test ends ...");
      driver.close();
    });


  }
}
