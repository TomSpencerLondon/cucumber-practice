package step_definitions;

import io.cucumber.java.en.*;
import io.cucumber.java.PendingException;
import implementation.Checkout;
import static org.junit.Assert.*;

public class CheckoutSteps {
  Checkout checkout = new Checkout();
  int bananaPrice;

  @Given("^the price of a \"(.*?)\" is (\\d+)c$")
  public void the_price_of_a_is_40c(String name, int price) throws Throwable {
      bananaPrice = price;
  }

  @When("^I checkout (\\d+) \"(.*?)\"$")
  public void i_checkout(int itemCount, String itemName) throws Throwable {
    checkout.add(itemCount, bananaPrice);
  }
  
  @Then("^the total price should be (\\d+)c$")
  public void the_total_price_should_be_40c(int total) throws Throwable {
      assertEquals(total, checkout.total());
  }
}

