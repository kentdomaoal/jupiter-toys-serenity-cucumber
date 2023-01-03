package com.project.example.tasks;

import com.project.example.data.Product;
import com.project.example.pages.CartPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EnsureThat {
    public static Performable subtotal_for_each_product_should_be_correct( ) {
        List<Double> subtotalList = new ArrayList<>();
        DecimalFormat formatter = new DecimalFormat("0.00");
        return Task.where("{0} ensure that subtotal for each product should be correct",
                actor -> {
                    List<Product> shoppingList = actor.recall("Shopping List");
                    for (Product product: shoppingList) {
                        Float subtotal = CartPage.subtotalOf(product.getName()).answeredBy(actor);
                        Float productPrice = CartPage.priceOf(product.getName()).answeredBy(actor);
                        Float price_multipliedBy_quantity =
                                Float.valueOf(formatter.format(productPrice * product.getQuantity()));
                        subtotalList.add(subtotal.doubleValue());

                        actor.attemptsTo(
                                Ensure.that(CartPage.subtotalOf(product.getName())).isEqualTo(price_multipliedBy_quantity)
                        );
                    }
                    actor.remember("Subtotal of each product",subtotalList);
                }
        );
    }

    public static Performable price_for_each_product_should_be_correct(){
        return Task.where("{0} ensure that price for each product should be correct",
                actor -> {
                    List<Product> shoppingList = actor.recall("Shopping List");
                    Map<String,Float> shopProductPrices = actor.recall("Shop Page Product Prices");

                    for (Product product: shoppingList) {
                        Float shopProductPrice = shopProductPrices.get(product.getName());
                        actor.attemptsTo(Ensure.that(CartPage.priceOf(product.getName())).isEqualTo(shopProductPrice));
                    }
                }
        );
    }

    public static Performable total_amount_should_be_the_sum_of_subtotals(){
        return Task.where("{0} ensure that Total Amount should be the sum of subtotals",
                actor -> {
//                    Float totalAmount = ShopPage.getPriceValue(CartPage.TOTAL_TEXT);
                    List<Double> subtotals = actor.recall("Subtotal of each product");
                    actor.attemptsTo(Ensure.that(CartPage.totalAmount()).isEqualTo(CartPage.sumOf(subtotals)));
                }
        );
    }
}
