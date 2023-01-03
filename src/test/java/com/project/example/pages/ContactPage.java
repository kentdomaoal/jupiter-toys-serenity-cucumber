package com.project.example.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.apache.commons.lang3.StringUtils;

public class ContactPage {

    private static final String ERROR_MESSAGE_TEXT = "but we won't get it unless you complete the form correctly";
    private static final String FIELD_ERROR_MESSAGE_TEXT = "<field> is required";
    private static final String SUCCESS_MESSAGE_TEXT = "Thanks <user>, we appreciate your feedback.";

    public static final Target ALERT_MESSAGE = Target.the("{0} message").locatedBy(".alert-{0}");
    public static final Target FIELD_ERROR_MESSAGE =
            Target.the("{0} error message").locatedBy("#{0}-err");
    public static final Target FIELD_WITH_LABEL =
            Target.the("{0} text-field").locatedBy("#{0}");

    public static String getErrorMessageText(){
        return ERROR_MESSAGE_TEXT;
    }

    public static String getFieldErrorMessageText(String field){
       return FIELD_ERROR_MESSAGE_TEXT.replace("<field>", StringUtils.capitalize(field));
    }

    public static String getSuccessMessageText(String forename){
        return SUCCESS_MESSAGE_TEXT.replace("<user>", StringUtils.capitalize(forename));
    }
}
