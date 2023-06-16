package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class SwipeAction {
    private AppiumDriver<MobileElement> appiumDriver;
    private TouchAction touchAction;
    private PointOption startPoint;
    private PointOption endPoint;

    // Constructor
    public SwipeAction(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        this.touchAction = new TouchAction(this.appiumDriver);

        // Get screen sizes
        Dimension windowSize = this.appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();
        // Swipe
        this.startPoint = new PointOption().withCoordinates(screenWidth * 90 / 100, screenHeight * 2 / 3);
        this.endPoint = new PointOption().withCoordinates(screenWidth * 10 / 100, screenHeight * 2 / 3);

    }

    public void swipeRightToLeft(int times) {
        for (int initTime = 0; initTime < times; initTime++) {
            this.swipeRightToLeft();
        }
    }

    public void swipeRightToLeft() {
        this.touchAction
                .press(this.startPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(this.endPoint).release()
                .perform();
    }
    public void swipeRightToLeft(int x_start, int y_start, int x_end, int y_end) {
        PointOption startPoint = new PointOption().withCoordinates(x_start, y_start);
        PointOption endPoint = new PointOption().withCoordinates(x_end, y_end);
        this.touchAction
                .press(startPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(2)))
                .moveTo(endPoint).release()
                .perform();
    }
    public void swipeRightToLeft(int x_start, int y_start, int x_end, int y_end, int duration_in_ms) {
        PointOption startPoint = new PointOption().withCoordinates(x_start, y_start);
        PointOption endPoint = new PointOption().withCoordinates(x_end, y_end);
        this.touchAction
                .press(startPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(duration_in_ms)))
                .moveTo(endPoint).release()
                .perform();
    }
}
