package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPage {
    private AppiumDriver<MobileElement> appiumDriver;
    private final By userNameSelById = MobileBy.AccessibilityId("input-email");
    private final By passwordSelById = MobileBy.AccessibilityId("input-password");
    private final By loginBtnSelById = MobileBy.AccessibilityId("button-LOGIN");
    private final By loginOKBtnByXpath = MobileBy.xpath("//android.widget.Button[@text='OK']");

    // Constructor
    public LoginPage(AppiumDriver<MobileElement> appiumDriver){
        this.appiumDriver = appiumDriver;
    }
    // Getter
    public AppiumDriver<MobileElement> getAppiumDriver(){
        return appiumDriver;
    }

    public MobileElement username(){
        return appiumDriver.findElement(userNameSelById);
    }
    public LoginPage inputUsername(String userNameTxt){
        this.username().sendKeys(userNameTxt);
        // Method chaining in Page Object
        return this;
    }

    public MobileElement password(){
        return appiumDriver.findElement(passwordSelById);
    }
    public LoginPage inputPassword(String passwordTxt){
        this.password().sendKeys(passwordTxt);
        return this;
    }

    public MobileElement loginBtn(){
        return appiumDriver.findElement(loginBtnSelById);
    }
    public void clickOnLoginBtn(){
        this.loginBtn().click();
    }

    public MobileElement loginOKBtn(){
        return appiumDriver.findElement(loginOKBtnByXpath);
    }
    public void clickOnLoginOKBtn(){
        this.loginOKBtn().click();
    }
}
