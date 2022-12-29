package com.planit.assessment.stepdefinitions;

import com.planit.assessment.tasks.NavigateTo;
import com.planit.assessment.pages.ContactPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.PageElement;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ContactPageSteps {
    @Given("{actor} opens Jupiter Toys website")
    public void open_website(Actor actor) {
        actor.wasAbleTo(NavigateTo.theJupiterToysHomePage());
    }

    @When("{actor} navigates to {string} Page")
    public void navigates_to_page(Actor actor, String pageName) {
        actor.attemptsTo(NavigateTo.thePage(pageName));
    }

    @When("click {string} button")
    public void click_button(String buttonName) {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(Click.on(PageElement.containingText(buttonName)));
    }

    @Then("error message should appear")
    public void should_see_error_message() {
        Actor actor = OnStage.theActorInTheSpotlight();
        Target ERROR_ALERT_MESSAGE = ContactPage.ALERT_MESSAGE.of("error");
        actor.attemptsTo(
                Ensure.that(ERROR_ALERT_MESSAGE).isDisplayed(),
                Ensure.that(ERROR_ALERT_MESSAGE).text().contains(ContactPage.getErrorMessageText())
        );
    }

    @Then("error messages for mandatory fields should appear")
    public void should_see_error_messages_for_mandatory_fields() {
        Actor actor = OnStage.theActorInTheSpotlight();
        should_see_error_message_for_mandatory_field(actor, "forename");
        should_see_error_message_for_mandatory_field(actor, "email");
        should_see_error_message_for_mandatory_field(actor, "message");
    }

    public void should_see_error_message_for_mandatory_field(Actor actor, String field) {
        Target FIELD_ERROR_MESSAGE = ContactPage.FIELD_ERROR_MESSAGE.of(field);
        actor.attemptsTo(
                Ensure.that(FIELD_ERROR_MESSAGE).isDisplayed(),
                Ensure.that(FIELD_ERROR_MESSAGE)
                        .hasTextContent(ContactPage.getFieldErrorMessageText(field))
        );
    }

    @When("{actor} populate mandatory fields")
    public void populate_mandatory_fields(Actor actor, DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            actor.attemptsTo(
                    Enter.theValue(columns.get("Forename")).into(ContactPage.FIELD_WITH_LABEL.of("forename")),
                    Enter.theValue(columns.get("Email")).into(ContactPage.FIELD_WITH_LABEL.of("email")),
                    Enter.theValue(columns.get("Message")).into(ContactPage.FIELD_WITH_LABEL.of("message"))
            );
        }
    }

    @When("{actor} populate mandatory fields: {string} {string} {string}")
    public void populate_mandatory_fields_using(Actor actor, String forename, String email, String message) {
        actor.attemptsTo(
                Enter.theValue(forename).into(ContactPage.FIELD_WITH_LABEL.of("forename")),
                Enter.theValue(email).into(ContactPage.FIELD_WITH_LABEL.of("email")),
                Enter.theValue(message).into(ContactPage.FIELD_WITH_LABEL.of("message"))
        );
    }

    @Then("error message should not appear")
    public void should_not_see_error_message() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(
                Ensure.that(ContactPage.ALERT_MESSAGE.of("error")).isNotDisplayed()
        );
    }

    @Then("error messages for mandatory fields should not appear")
    public void should_not_see_error_messages_for_mandatory_fields() {
        Actor actor = OnStage.theActorInTheSpotlight();
        should_not_see_error_message_for_mandatory_field(actor, "forename");
        should_not_see_error_message_for_mandatory_field(actor, "email");
        should_not_see_error_message_for_mandatory_field(actor, "message");
    }

    public void should_not_see_error_message_for_mandatory_field(Actor actor, String field) {
        actor.attemptsTo(
                Ensure.that(ContactPage.FIELD_ERROR_MESSAGE.of(field)).isNotDisplayed()
        );
    }

    @Then("successful message should appear for {actor}: {string}")
    public void should_see_success_message(Actor actor, String forename) {
        Target SUCCESS_ALERT_MESSAGE = ContactPage.ALERT_MESSAGE.of("success");
        actor.attemptsTo(
                WaitUntil.the(SUCCESS_ALERT_MESSAGE, isVisible()).forNoMoreThan(20).seconds(),
                Ensure.that(SUCCESS_ALERT_MESSAGE).isDisplayed(),
                Ensure.that(SUCCESS_ALERT_MESSAGE).hasTextContent(ContactPage.getSuccessMessageText(forename))
        );
    }

}
