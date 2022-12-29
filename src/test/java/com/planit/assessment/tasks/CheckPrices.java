package com.planit.assessment.tasks;

import com.planit.assessment.data.Product;
import com.planit.assessment.pages.ShopPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.util.List;

public class CheckPrices {
    public static Performable using(List<Product> shoppingList) {
        return Task.where("Check prices of products in the shopping list ",
                actor -> {
                    actor.remember("Shop Page Product Prices", ShopPage.getProductPrices(shoppingList));
                }
        );
    }

    public static Performable ofProductsFromShoppingList() {
        return Task.where("Check prices of products in the shopping list ",
                actor -> {
                    List<Product> shoppingList = actor.recall("Shopping List");
                    actor.remember("Shop Page Product Prices", ShopPage.getProductPrices(shoppingList));
                }
        );
    }
}
