package org.example.BDD;

import PageObjects.P01_SettingsPage;
import PageObjects.P02_SystemPage;
import PageObjects.P03_DeviceDataPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class DeviceData_SD {

    P01_SettingsPage settingsPage = null ;
    P02_SystemPage systemPage = null ;
    P03_DeviceDataPage dataPage = null ;
    SoftAssert softAssert = new SoftAssert();


    @Given("User Navigates to 'About Device' page")
    public void User_Navigates_to_About_Device_page()
    {
        settingsPage = new P01_SettingsPage(TestHook.driver);
        systemPage = new P02_SystemPage(TestHook.driver);
        dataPage = new P03_DeviceDataPage(TestHook.driver);

        // 1. Scroll to find System Tab
        settingsPage.scroll_To_System();
        // 2. Tab on System Field to navigate to Device System
        settingsPage.tab_On_System();
        // 3. Tab on About Field to get Device Details
        systemPage.tab_On_About();
    }

    @When("User Tabs on Device name Tab")
    public void userTabsOnDeviceNameTab() throws InterruptedException {
        dataPage.tabDeviceName();
    }

    @Then("Device name should be {string}")
    public void deviceNameShouldBe(String Device_Name) {
        softAssert.assertEquals(dataPage.getDeviceName() , Device_Name);
    }

    @When("User Tabs on Android Version Tab")
    public void userTabsOnAndroidVersionTab() {
        dataPage.tabSwVersion();
    }

    @Then("Android Version Should be {string}")
    public void androidVersionShouldBe(String Android_Version) {
        softAssert.assertEquals(dataPage.getSoftwareVersion() , Android_Version);
    }

    @When("User Tabs on Model&Hardware Tab")
    public void userTabsOnModelHardwareTab() throws InterruptedException {
        dataPage.tabModelHardware();
    }

    @Then("Model name should be {string}")
    public void modelNameShouldBe(String Model_Name) {
        softAssert.assertEquals(dataPage.getModel() , Model_Name);
    }

    @And("Serial Number should be {string}")
    public void serialNumberShouldBe(String Serial_Number) throws InterruptedException {
        dataPage.tabModelHardware();
        softAssert.assertEquals(dataPage.getSerialNumber() , Serial_Number);
        softAssert.assertAll();
    }
}
