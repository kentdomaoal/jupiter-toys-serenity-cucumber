package com.planit.assessment.stepdefinitions;

import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

public class NavigationSteps {
    @Then("current url should be {string}")
    public void currentUrlShouldBe(String url) {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(Ensure.that(TheWebPage.currentUrl()).isEqualTo(url));
    }
}
