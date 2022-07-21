package org.example.BDD;

import PageObjects.P01_SettingsPage;
import PageObjects.P02_SystemPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestHook {

    public  static AppiumDriver driver = null ;
    public TouchAction action = null ;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName" , "Android");
        caps.setCapability("automationName" , "UiAutomator2");
        caps.setCapability("platformVersion" , "9.0");
        caps.setCapability("deviceName" , "Android Emulator");
        caps.setCapability("appPackage" , "com.android.settings");
        caps.setCapability("appActivity" , ".Settings");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub") , caps);
        action = new AndroidTouchAction(driver);

    }

    @After
    public void tearDown()
    {
        if(null != driver)
        {
            driver.quit();
        }
    }
}
