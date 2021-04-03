package step_definitions;

import io.cucumber.java.en.*;
import io.cucumber.java.PendingException;
import implementation.Checkout;
import static org.junit.Assert.*;

public class CheckoutSteps {
  Checkout checkout = new Checkout();
  int bananaPrice;
  int applePrice;

  @Given("^the price of 1 \"(.*?)\" is (\\d+)c$")
  public void the_price_of_1_is_c(String name, int price) throws Throwable {
      if(name.equals("banana")) {
        bananaPrice = price;
      } else if (name.equals("apple")){
        applePrice = price;
      }
  }

  @When("^I checkout (\\d+) \"(.*?)\"$")
  public void i_checkout(int itemCount, String itemName) throws Throwable {
    if (itemName.equals("banana")) {
      checkout.add(itemCount, bananaPrice);
    } else if (itemName.equals("apple")) {
      checkout.add(itemCount, applePrice);
    }
  }
  
  @Then("^the total price should be (\\d+)c$")
  public void the_total_price_should_be_c(int total) throws Throwable {
      assertEquals(total, checkout.total());
  }
}

