package com.planit.assessment.tasks;

import com.planit.assessment.data.Product;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.util.ArrayList;
import java.util.List;

public class GetShoppingList {
    public static Performable from(String source) {
        List<Product> shoppingList = new ArrayList<>();
        return Task.where("Get the shopping list from " + source,
                actor -> {
                    shoppingList.add(new Product("Stuffed Frog",2));
                    shoppingList.add(new Product("Fluffy Bunny",5));
                    shoppingList.add(new Product("Valentine Bear",3));
                    actor.remember("Shopping List", shoppingList);
                }
        );
    }
}
