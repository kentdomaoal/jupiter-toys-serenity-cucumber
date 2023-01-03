package com.project.example.tasks;

import com.opencsv.bean.CsvToBeanBuilder;
import com.project.example.data.Product;
import com.project.example.pages.ShopPage;
import com.project.example.util.ExcelReader;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetShoppingList {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopPage.class);

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

    public static Performable fromExcel(String filename, String sheet) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData = reader.getData(getFilePath(filename), sheet);

        List<Product> shoppingList = new ArrayList<>();
        return Task.where("Get the shopping list from " + filename,
                actor -> {
                    for (Map<String,String> row: testData) {
                        if(!row.get("productName").isEmpty() && !row.get("quantity").isEmpty()) {
                            String productName = row.get("productName");
                            int quantity = Integer.valueOf(row.get("quantity"));
                            LOGGER.debug("Name: {}, Quantity: {}", productName, quantity);
                            shoppingList.add(new Product(productName, quantity));
                        }
                    }
                    LOGGER.debug("ShoppingList size: {}",shoppingList.size());
                    actor.remember("Shopping List", shoppingList);
                }
        );
    }

    public static Performable fromCSV(String filename) throws FileNotFoundException {
        List<Product> shoppingList = new CsvToBeanBuilder(new FileReader(getFilePath(filename)))
                .withType(Product.class).build().parse();

        return Task.where("Get the shopping list from " + filename,
                actor -> {
                    LOGGER.debug("ShoppingList size: {}",shoppingList.size());
                    actor.remember("Shopping List", shoppingList);
                }
        );
    }

    private static String getFilePath(String filename){
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        String testdataPath =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("testdata.path");
        return System.getProperty("user.dir") + testdataPath + filename;
    }
}
