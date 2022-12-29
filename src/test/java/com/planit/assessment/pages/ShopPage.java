package com.planit.assessment.pages;

import com.planit.assessment.data.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShopPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopPage.class);

    private static final Target PRODUCT_PRICE =
            Target.the("{0} price")
                    .locatedBy("//h4[contains(text(),'{0}')]/following-sibling::p/span");

    public static final Target BUY_BUTTON =
            Target.the("{0} Buy button")
                    .locatedBy("//h4[contains(text(),'{0}')]/following-sibling::p/a");

    public static Map<String,Float> getProductPrices(List<Product> shoppingList){
        Map<String,Float> productPriceMap = new HashMap<>();

        for (Product product: shoppingList) {
            LOGGER.debug("Product: {},  Quantity: {}", product.getName(), product.getQuantity());
            LOGGER.debug("Price Value: {}", getPriceValue(PRODUCT_PRICE.of(product.getName())));
            productPriceMap.put(product.getName(),getPriceValue(PRODUCT_PRICE.of(product.getName())));
        }
        return productPriceMap;
    }

    public static Float getPriceValue(Target target){
        Actor actor = OnStage.theActorInTheSpotlight();
        String priceValueText = actor.asksFor(Text.of(target));
        return getFloatValue(priceValueText);
    }

    private static Float getFloatValue(String valueString){
        String finalValue = "";
        Pattern pattern = Pattern.compile("[+-]?\\d+(.\\d+)?");
        Matcher matcher = pattern.matcher(valueString);

        while (matcher.find()) {
            finalValue = matcher.group();
        }
        return Float.valueOf(finalValue);
    }

}
