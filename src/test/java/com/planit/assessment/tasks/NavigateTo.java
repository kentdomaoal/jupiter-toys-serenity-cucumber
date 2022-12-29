package com.planit.assessment.tasks;

import com.planit.assessment.pages.HomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.targets.Target;

public class NavigateTo {
    private static final Target LINK =
            Target.the("{0} Page link")
                    .locatedBy("//a[contains(text(),'{0}')]");

    public static Performable theJupiterToysHomePage() {
        return Task.where("{0} opens the Jupiter Toys home page",
                Open.browserOn().the(HomePage.class));
    }

    public static Performable thePage(String pageName) {
        return Task.where("{0} navigates to "+ pageName +" page",
                Click.on(LINK.of(pageName))
        );
    }
}
