package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import utils.SwipeAction;

public class SwipePage {
    private AppiumDriver<MobileElement> appiumDriver;
    private final By extendableTxt = MobileBy.xpath("//android.widget.TextView[@text='EXTENDABLE']");

    // Constructor
    public SwipePage(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    // Getter
    public AppiumDriver<MobileElement> getAppiumDriver() {
        return appiumDriver;
    }

    public MobileElement extendableTxtEle() {
        try {
            return appiumDriver.findElement(extendableTxt);
        } catch (Exception e) {
            return null;
        }
    }

    public void swipeToExtendableText() {
        SwipeAction swipeAction = new SwipeAction(appiumDriver);
        int swipeTime = 0;
        boolean notSeenTheExpectedEle = true;
        while (notSeenTheExpectedEle && swipeTime < 5) {
            try {
                boolean isExpectedEleDisplayed = this.extendableTxtEle().isDisplayed();
                System.out.println("=== Element displayed: " + isExpectedEleDisplayed);
                if (isExpectedEleDisplayed)
                    notSeenTheExpectedEle = false;
            } catch (Exception e) {
                swipeAction.swipeRightToLeft();
            }
            swipeTime++;
        }
    }
}
