package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import java.util.concurrent.TimeUnit;

public class PressGestureCoordinateDemo {

    public static void main(String[] args) throws InterruptedException {

        // Initialize your Appium driver and launch the app
        AndroidDriver<MobileElement> driver = null;
        driver=new LoginInteractionDemo().logIn(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Press on product image element using its coordinates
        MobileElement productImage = driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]/android.view.ViewGroup/android.widget.ImageView"));
        Point productImageCoordinates = productImage.getLocation();
        int productImageXCoordinate = productImageCoordinates.getX();
        int productImageYCoordinate = productImageCoordinates.getY();
        new TouchAction(driver).press(PointOption.point(productImageXCoordinate, productImageYCoordinate)).release().perform();
        Thread.sleep(5000);
        driver.quit();
    }
}