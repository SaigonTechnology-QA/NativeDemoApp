package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.LoginPage;
import models.pages.LoginPageWithComponents;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.AppiumDriverEx;

import java.io.File;
import java.io.IOException;

public class SetValue_Conponents {
    public static void main(String[] args) {
        // 1. Launch App
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        // 2. Click on Login
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        // 3. Input username
        // POM
        LoginPageWithComponents loginPage = new LoginPageWithComponents(appiumDriver);
        loginPage.credentialForm().inputUsername("nxthich@mailinator.com")
                 .inputPassword("12341234AaaA");

        // 5. Click on Login button
        MobileElement loginBtn = appiumDriver.findElementByAccessibilityId("button-LOGIN");
        loginBtn.click();

        // 6. Capture a screenshot
        File formScreenBase64Data = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
        String formScreenFilePath = System.getProperty("user.dir") + "/screenshot/" + "formScreen.png";
        try {
            FileUtils.copyFile(formScreenBase64Data, new File(formScreenFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
