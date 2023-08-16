package org.example;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class LoginInteractionDemo {


    public AndroidDriver<MobileElement> logIn(AndroidDriver<MobileElement> driver) throws InterruptedException {
        LaunchDriver launchDriver = new LaunchDriver();
         driver = launchDriver.lunchDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Scroll to the end of the page (you might need to adjust the logic based on your app's behavior)
        MobileElement lastElement = driver.findElement(By.xpath("//android.view.ViewGroup[last()]"));
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"And the password for all users is:\"))");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement defaultUser = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-standard_user\"]/android.widget.TextView"));
        defaultUser.click();
        MobileElement logIn = driver.findElementByAccessibilityId("test-LOGIN");
        logIn.click();

        Thread.sleep(5000);
       return driver;
    }
}
