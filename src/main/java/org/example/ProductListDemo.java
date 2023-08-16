package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductListDemo {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        // Initialize the driver and launch the app
        // ...
        AndroidDriver<MobileElement> driver = null;
        driver=new LoginInteractionDemo().logIn(driver);

        // Set up an implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Use your identified locator strategy to find the product title elements
        List<MobileElement> productTitles = driver.findElements(By.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])"));
//        MobileElement lastElement = driver.findElement(By.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[4]"));
//        WebDriverWait wiat = new WebDriverWait(driver,5);
//        wiat.until(ExpectedConditions.visibilityOf(lastElement));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();", lastElement);
//        productTitles.add((MobileElement) driver.findElements(By.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])")));
        // Loop through each title element and print them to the console

//        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"© 2023 Sauce Labs. All Rights Reserved.\"))");
//        List<MobileElement> productTitles2 = driver.findElements(By.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])"));
//        productTitles.addAll(productTitles2);
//        System.out.println(productTitles);
        for(MobileElement productTitle : productTitles){
            System.out.println("The product title: " + productTitle.getText());
        }


        driver.quit();
    }
}