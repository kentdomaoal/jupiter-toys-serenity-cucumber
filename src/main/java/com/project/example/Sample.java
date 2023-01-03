package com.project.example;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sample {

    public static void main(String[] args) {
        System.out.println(getFloatValue("$1234.99"));
        System.out.println(getFloatValue("$99999.0050"));
        System.out.println(getFloatValue("Total: $199999.000050"));

        List<Double> subtotals = Arrays.asList(19.99, 12.99, 25.00, 100.01, 5.45);
        System.out.println(sumOf(subtotals));
    }

    private static Float getFloatValue(String productPriceText){
        String productPrice = "";
        Pattern pattern = Pattern.compile("[+-]?\\d+(.\\d+)?");
        Matcher matcher = pattern.matcher(productPriceText);

        while (matcher.find()) {
            productPrice = matcher.group();
        }
        return Float.valueOf(productPrice);
    }

    private static Float sumOf(List<Double> subtotals){
        Double sum = subtotals.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        return sum.floatValue();
    }
}
