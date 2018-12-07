import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class MyStepdefs implements En {
  public MyStepdefs() {

    Before(scenario -> {

    });

    When("^i enter <Username> and <Password>$", () -> {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
    });
  }
}
