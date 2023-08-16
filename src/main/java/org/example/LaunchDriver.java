package org.example;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LaunchDriver {
    public AndroidDriver<MobileElement> lunchDriver(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 6");
        caps.setCapability("udid", "emulator-5554"); // You can get it from 'adb devices' command
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", "/Users/testvagrant/Downloads/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk"); // Replace with your app's path
        caps.setCapability("appPackage", "com.swaglabsmobileapp");
        caps.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
        AndroidDriver<MobileElement> driver = null;

        try {
            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            System.out.println("The URL provided for the Appium server is not well formatted.");
            e.printStackTrace();
        }

        return  driver;

    }

    public static void main(String[] args) {
        LaunchDriver launchDriver = new LaunchDriver();
        launchDriver.lunchDriver();
    }
}