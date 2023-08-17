package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TapGestureDemo {
    public static void main(String[] args) throws InterruptedException {
        // Initialize the driver and launch the app
        AndroidDriver<MobileElement> driver = null;
        driver=new LoginInteractionDemo().logIn(driver);

        // Setting the implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Tap on element using locator
        MobileElement productImage = driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]/android.view.ViewGroup/android.widget.ImageView"));
        new TouchAction(driver).tap(TapOptions.tapOptions()
                        .withElement(ElementOption.element(productImage)))
                        .perform();

        // Navigate back to the home screen
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(700);
        // Add appropriate wait time here to observe the action tapping on filter button
//        MobileElement filterElementLocator = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView"));
        new TouchAction(driver).press(PointOption.point(1002,375))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .release()
                .perform();
        Thread.sleep(2000);
        new TouchAction(driver).press(PointOption.point(586,1237))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .release()
                .perform();
        Thread.sleep(700);
        //Tap on element using point And adding product to cart
        new TouchAction(driver).tap(TapOptions.tapOptions().withPosition(PointOption.point(280,1497))).perform();

        Thread.sleep(10000);
        driver.quit();
    }
}

