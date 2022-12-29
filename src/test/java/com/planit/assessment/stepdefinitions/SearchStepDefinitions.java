//package com.planit.assessment.stepdefinitions;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import net.serenitybdd.screenplay.Actor;
//import net.serenitybdd.screenplay.ensure.Ensure;
//import com.planit.assessment.util.NavigateTo;
//import com.planit.assessment.search.LookForInformation;
//import com.planit.assessment.search.WikipediaArticle;
//
//public class SearchStepDefinitions {
//
//    @Given("{actor} is researching things on the internet")
//    public void researchingThings(Actor actor) {
//        actor.wasAbleTo(NavigateTo.theWikipediaHomePage());
//    }
//
//    @When("{actor} looks up {string}")
//    public void searchesFor(Actor actor, String term) {
//        actor.attemptsTo(
//                LookForInformation.about(term)
//        );
//    }
//
//    @Then("{actor} should see information about {string}")
//    public void should_see_information_about(Actor actor, String term) {
//        actor.attemptsTo(
//                Ensure.that(WikipediaArticle.HEADING).hasText(term)
//        );
//    }
//}
