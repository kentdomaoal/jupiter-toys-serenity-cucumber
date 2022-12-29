package com.planit.assessment.pages;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

public class CartPage {

    public static final Target PRICE_TEXT = Target.the("Price of {0}")
            .locatedBy("//td[contains(text(),'{0}')]/following::td[1]");
    public static final Target SUBTOTAL_TEXT = Target.the("Subtotal of {0}")
            .locatedBy("//td[contains(text(),'{0}')]/following::td[3]");
    public static final Target TOTAL_TEXT = Target.the("Total Amount")
            .locatedBy("//*[contains(@class,'total')]");

    public static Question<Float> priceOf(String productName) {
        return Question.about(productName+"'s price").answeredBy(
                actor -> ShopPage.getPriceValue(PRICE_TEXT.of(productName))
        );
    }

    public static Question<Float> subtotalOf(String productName) {
        return Question.about(productName+"'s subtotal").answeredBy(
                actor -> ShopPage.getPriceValue(SUBTOTAL_TEXT.of(productName))
        );
    }

    public static Question<Float> totalAmount() {
        return Question.about("Total Amount").answeredBy(
                actor -> ShopPage.getPriceValue(TOTAL_TEXT)
        );
    }

    public static Float sumOf(List<Double> subtotals){
        Double sum = subtotals.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        return sum.floatValue();
    }

}
