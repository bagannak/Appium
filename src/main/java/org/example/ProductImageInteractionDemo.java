package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ProductImageInteractionDemo {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        // Initialize the driver and launch the app
        // ...
        AndroidDriver<MobileElement> driver = null;
        driver=new LoginInteractionDemo().logIn(driver);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Identify the product image element using your locator strategy
        MobileElement productImage = (MobileElement) wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]/android.view.ViewGroup/android.widget.ImageView")));

        // Click on the product image element
        productImage.click();

        // Wait to observe the navigation
        Thread.sleep(5000);

        // Navigate back to the home screen
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        // Wait to observe the back button functionality navigation
        Thread.sleep(5000);

        driver.quit();
    }
}