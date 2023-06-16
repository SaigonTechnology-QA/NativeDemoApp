package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.screenrecording.CanRecordScreen;
import models.pages.SwipePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppiumDriverEx;
import utils.AppiumServer;
import utils.SwipeAction;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class SwipeToBottom {
    public static void main(String[] args) {

        // 0. Start Appium server
        AppiumServer appiumServer = new AppiumServer();
        appiumServer.startServer();

        // 1. Init session with Appium server and Launch App
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        // Start record
//        ((CanRecordScreen) appiumDriver).startRecordingScreen();

        // 2. Click on Login
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Swipe");
        loginLabel.click();

        WebDriverWait wait = new WebDriverWait(appiumDriver, 30L);
        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElementByXPath("//android.widget.TextView[@text='Swipe horizontal']")));

        SwipeAction swipeAction = new SwipeAction(appiumDriver);
        swipeAction.swipeRightToLeft();

        SwipePage swipePage = new SwipePage(appiumDriver);
        swipePage.swipeToExtendableText();

//        // Stop recording
//        String video = ((CanRecordScreen) appiumDriver).stopRecordingScreen();
//
//        // Save video
//        byte[] decodeVideo = Base64.getMimeDecoder().decode(video);
//        try {
//            Path testVideoDir = Paths.get(System.getProperty("user.dir") + "/video/");
//            Files.createDirectories(testVideoDir);
//            Path testVideoFileLocation =
//                    Paths.get(testVideoDir.toString(), String.format("%s-%d.%s", "test", System.currentTimeMillis(), "mp4"));
//            Files.write(testVideoFileLocation, decodeVideo);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
