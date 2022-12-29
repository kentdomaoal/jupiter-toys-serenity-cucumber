package com.planit.assessment.stepdefinitions;

import com.planit.assessment.tasks.EnsureThat;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

public class CartPageSteps {

    @When("{actor} validates subtotal for each product")
    public void user_validates_subtotal_for_each_product(Actor actor) {}

    @Then("subtotal for each product should be correct")
    public void subtotal_for_each_product_should_be_correct() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(EnsureThat.subtotal_for_each_product_should_be_correct());
    }

    @When("{actor} validates price for each product")
    public void user_validates_price_for_each_product(Actor actor) {}

    @Then("price for each product should be correct")
    public void price_for_each_product_should_be_correct() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(EnsureThat.price_for_each_product_should_be_correct());
    }

    @When("{actor} validates the total amount")
    public void user_validates_the_total_amount(Actor actor) {}

    @Then("total amount should be the sum of subtotals")
    public void total_amount_should_be_the_sum_of_subtotals() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(EnsureThat.total_amount_should_be_the_sum_of_subtotals());
    }
}
