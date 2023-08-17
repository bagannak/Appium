package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class PressGestureLocatorDemo {

    public static void main(String[] args) throws InterruptedException {
        // Initialize your Appium driver and launch the app
        AndroidDriver<MobileElement> driver = null;
        driver=new LoginInteractionDemo().logIn(driver);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Press on product image element using its locator
        MobileElement productImage = driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]/android.view.ViewGroup/android.widget.ImageView"));
        new TouchAction(driver).press(ElementOption.element(productImage)).release().perform();
        Thread.sleep(5000);
        driver.quit();
    }
}

