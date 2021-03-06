package com.qunar.jbehave.onpay.steps;

import static com.qunar.jbehave.onpay.util.VarArgConverters.asArray;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterPeopleSteps {

	private Logger logger = LoggerFactory.getLogger(RegisterPeopleSteps.class);

	@Given("a browser is on the OnPay registration page")
	public void gotoRegistrationPage() {
		logger.trace("go the OnPay registration page");
	}

	@When("filling out the registration form with <name> in the name field, <email> in the email address field, <amount> in the initial funding field an clicking on the $buttonName button")
	public void submitRegistrationForm(@Named("name") String name, // named parameters required for table data
			@Named("email") String email, @Named("amount") String amount,
			@Named("buttonName") String buttonName) {
		logger.info(
          "fill out the registration form with name={}, email={}, amount={} and click on the {} button",
          asArray(name, email, amount, buttonName));
	}

	@Then("OnPay creates an account for <name> and displays their account page")
	public void verifyAccountPageName(@Named("name") String name) {
		logger.info(
				"verify OnPay dispalys an account page with {} in the \"logged as\" field",
				name);
	}

}
