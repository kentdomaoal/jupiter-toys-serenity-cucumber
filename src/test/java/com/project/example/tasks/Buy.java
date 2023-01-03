package com.project.example.tasks;

import com.project.example.data.Product;
import com.project.example.pages.ShopPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

public class Buy {

    public static Performable theProducts() {
        return Task.where("buy products from the shopping list ",
                actor -> {
                    List<Product> shoppingList = actor.recall("Shopping List");
                    for (Product product: shoppingList) {
                        actor.attemptsTo(Buy.theProduct(product.getName(), product.getQuantity()));
                    }
                }
        );
    }

    public static Performable theProduct(String name, int quantity) {
        return Task.where("{0} buy "+name+" ("+quantity+") times",
                actor -> {
                    for (int i = 1; i <= quantity; i++) {
                        actor.attemptsTo(Click.on(ShopPage.BUY_BUTTON.of(name)));
                    }
                }
        );
    }
}
