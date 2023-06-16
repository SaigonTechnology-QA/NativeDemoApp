package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.AppiumDriverEx;

import java.io.File;
import java.io.IOException;

public class setValue {
    public static void main(String[] args) {
        // 1. Launch App
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        // 2. Click on Login
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        // 3. Input username
//        MobileElement userNameTxtBx = appiumDriver.findElementByAccessibilityId("input-email");
//        userNameTxtBx.sendKeys("nxthich@restmail.net");

        // POM
        LoginPage loginPage = new LoginPage(appiumDriver);
        loginPage.username().sendKeys("nxthich@restmail.net");

        // 4. Input password
//        MobileElement passwordTxtBx = appiumDriver.findElementByAccessibilityId("input-password");
//        passwordTxtBx.sendKeys("123123Aa");

        // Main Interaction methods in Page Object Model
        loginPage.inputPassword("123123Aa");

        // 5. Click on Login button
        MobileElement loginBtn = appiumDriver.findElementByAccessibilityId("button-LOGIN");
        loginBtn.click();

//        // 5.1 Method chaining in Page Object
//        loginPage.inputUsername("nxthich@gmail.com")
//                 .inputPassword("12341234Aa")
//                 .clickOnLoginBtn();

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
