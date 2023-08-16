package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SauceLabsLocatorStrategyDemo {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "BagannaPixel4");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", "/Users/testvagrant/Downloads/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        caps.setCapability("appPackage", "com.swaglabsmobileapp");
        caps.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Use Accessibility ID locator
        MobileElement elementByAccessibilityId = driver.findElementByAccessibilityId("test-Username");
        System.out.println("Element By Accessibility ID: " + elementByAccessibilityId);

        // Use Class Name locator
        MobileElement elementByClassName = driver.findElementByClassName("android.widget.EditText");
        System.out.println("Element By Class Name: " + elementByClassName);

        // Use XPath locator
        MobileElement elementByXpath = driver.findElement(By.xpath("//*[@text='Username']"));
        System.out.println("Element By XPath: " + elementByXpath);

        // Use ID locator
        WebDriverWait wait = new WebDriverWait(driver, 7); // Wait for up to 20 seconds
         wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.swaglabsmobileapp:id/test-Username")));
        MobileElement elementById = driver.findElement(By.id("com.swaglabsmobileapp:id/test-Username"));
        System.out.println("Element By ID: " + elementById);

        // Use UI Automator locator
        MobileElement elementByUiAutomator = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Username\")");
        System.out.println("Element By UI Automator: " + elementByUiAutomator);

        driver.quit();
    }
}