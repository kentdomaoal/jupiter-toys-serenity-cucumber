package com.planit.assessment.stepdefinitions;

import com.planit.assessment.tasks.Buy;
import com.planit.assessment.tasks.CheckPrices;
import com.planit.assessment.tasks.GetShoppingList;
import com.planit.assessment.tasks.NavigateTo;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

public class ShopPageSteps {

    @When("{actor} buys products")
    public void user_buys_products(Actor actor) throws IOException, InvalidFormatException {
        actor.attemptsTo(
//                GetShoppingList.fromCSV("ShoppingList.csv")
                GetShoppingList.fromExcel("ShoppingList.xlsx","Products"),
                NavigateTo.thePage("Shop"),
                CheckPrices.ofProductsFromShoppingList(),
                Buy.theProducts()
        );
    }

}
