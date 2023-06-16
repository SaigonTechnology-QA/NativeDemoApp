package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.AppiumDriverEx;
import utils.AppiumServer;

import java.io.File;
import java.io.IOException;

public class Login {

    @BeforeSuite
    public void Precondition() {
        // 0. Start Appium server
        AppiumServer appiumServer = new AppiumServer();
        appiumServer.startServer();
    }
    @Test(groups = {"smoke"}, description = "Login with correct username and password")
    public void loginWithCorrectUsernamePassword() {

        // 1. Launch App
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        // 2. Click on Login
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        // 3. Input username
        MobileElement userNameTxtBx = appiumDriver.findElementByAccessibilityId("input-email");
        userNameTxtBx.sendKeys("nxthich@restmail.net");

        // 4. Input password
        MobileElement passwordTxtBx = appiumDriver.findElementByAccessibilityId("input-password");
        passwordTxtBx.sendKeys("123123Aa");

        // 5. Click on Login button
        MobileElement loginBtn = appiumDriver.findElementByAccessibilityId("button-LOGIN");
        loginBtn.click();

        WebDriverWait wait = new WebDriverWait(appiumDriver, 30L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[@text='You are logged in!']")));

        // POM
        LoginPage loginPage = new LoginPage(appiumDriver);
        loginPage.clickOnLoginOKBtn();

        // 6. Capture a screenshot
        File formScreenBase64Data = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
        String formScreenFilePath = System.getProperty("user.dir") + "/screenshot/" + "formScreen.png";
        try {
            FileUtils.copyFile(formScreenBase64Data, new File(formScreenFilePath));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    @Test(groups = {"smoke", "regression"}, description = "Login with incorrect username")
    public void loginWithInCorrectUsername() {

        // 1. Launch App
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        // 2. Click on Login
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        // 3. Input username
        MobileElement userNameTxtBx = appiumDriver.findElementByAccessibilityId("input-email");
        userNameTxtBx.sendKeys("nxthich");

        // 4. Input password
        MobileElement passwordTxtBx = appiumDriver.findElementByAccessibilityId("input-password");
        passwordTxtBx.sendKeys("123123Aa");

        // 5. Click on Login button
        MobileElement loginBtn = appiumDriver.findElementByAccessibilityId("button-LOGIN");
        loginBtn.click();

        WebDriverWait wait = new WebDriverWait(appiumDriver, 30L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[@text='Please enter a valid email address']")));

        // 6. Capture a screenshot
        File formScreenBase64Data = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
        String formScreenFilePath = System.getProperty("user.dir") + "/screenshot/" + "formScreen.png";
        try {
            FileUtils.copyFile(formScreenBase64Data, new File(formScreenFilePath));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
