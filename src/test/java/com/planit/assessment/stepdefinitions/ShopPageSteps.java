package com.planit.assessment.stepdefinitions;

import com.planit.assessment.tasks.Buy;
import com.planit.assessment.tasks.CheckPrices;
import com.planit.assessment.tasks.GetShoppingList;
import com.planit.assessment.tasks.NavigateTo;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

public class ShopPageSteps {

    @When("{actor} buys products")
    public void user_buys_products(Actor actor) {
        actor.attemptsTo(
                GetShoppingList.from("bag"),
                NavigateTo.thePage("Shop"),
                CheckPrices.ofProductsFromShoppingList(),
                Buy.theProducts()
        );
    }

}
