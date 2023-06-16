package models.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class CredentialForm {
    private AppiumDriver<MobileElement> appiumDriver;
    private final By userNameSelById = MobileBy.AccessibilityId("input-email");
    private final By passwordSelById = MobileBy.AccessibilityId("input-password");

    // Constructor
    public CredentialForm(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public MobileElement username(){
        return appiumDriver.findElement(userNameSelById);
    }
    public CredentialForm inputUsername(String userNameTxt){
        this.username().sendKeys(userNameTxt);
        // Method chaining in Page Object
        return this;
    }

    public MobileElement password(){
        return appiumDriver.findElement(passwordSelById);
    }
    public CredentialForm inputPassword(String passwordTxt){
        this.password().sendKeys(passwordTxt);
        return this;
    }
}
