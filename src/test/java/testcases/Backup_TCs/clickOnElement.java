package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppiumDriverEx;

import java.util.List;


public class clickOnElement {
    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        WebDriverWait wait = new WebDriverWait(appiumDriver, 30L);
        wait.until(ExpectedConditions.numberOfElementsToBe(MobileBy.xpath("//*[@text='Login']"), 2));

        List<MobileElement> loginTextEle = appiumDriver.findElementsByXPath("//*[@text='Login']");
        System.out.println("Number element: " + loginTextEle.size());
        MobileElement firstEle = appiumDriver.findElementByXPath("//*[@text='Login']");

        // First ele
        loginTextEle.get(0).click();

        // Second ele
        loginTextEle.get(1).click();

    }
}
