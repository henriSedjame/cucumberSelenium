package shj.training.cucumber.page.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

  @FindBy(how = How.NAME, using = "username")
  WebElement usernameField;
  @FindBy(how = How.NAME, using = "password")
  WebElement passwordField;
  @FindBy(how = How.XPATH, using = "//input[@type='submit']")
  WebElement loginBtn;

  public LoginPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public void fillCredentials(String username, String password){
    usernameField.sendKeys(username);
    passwordField.sendKeys(password);
  }

  public void clickLoginBtn(){
    loginBtn.submit();
  }
}
