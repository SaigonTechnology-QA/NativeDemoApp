package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.components.CredentialForm;
import org.openqa.selenium.By;

public class LoginPageWithComponents {
    private AppiumDriver<MobileElement> appiumDriver;
    private CredentialForm credentialForm;
    // Constructor
    public LoginPageWithComponents(AppiumDriver<MobileElement> appiumDriver){
        this.appiumDriver = appiumDriver;
        credentialForm = new CredentialForm(appiumDriver);
    }

    // Getter
    public CredentialForm credentialForm(){
        return this.credentialForm;
    }
    private final By loginBtnSelById = MobileBy.AccessibilityId("button-LOGIN");

}
