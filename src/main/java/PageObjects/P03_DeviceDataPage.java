package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class P03_DeviceDataPage extends PageBase{

    public P03_DeviceDataPage(AppiumDriver driver) {
        super(driver);
    }


    //***************************************************** Device Name **************************************************//
    // Locate Device Name text Field Using PageFactory
    @AndroidFindBy(id = "android:id/edit")
    private AndroidElement deviceName ;
    // Locate Device Data List to ensure that page has been successfully loaded
    @AndroidFindBy(id = "android:id/content")
    private AndroidElement deviceDataList;
    // Locate Ok Button
    @AndroidFindBy(id = "android:id/button1")
    private AndroidElement okButton ;
    // Locate Cancel Button
    @AndroidFindBy(id = "android:id/button2")
    private AndroidElement cancelButton ;

    public void tabDeviceName() throws InterruptedException {
         Thread.sleep(1000);
        // 1. Wait for device Data List to be visible
        waitForVisibility(deviceDataList);
        // 2. Locate Device Name Tab
        AndroidElement deviceNameTab = (AndroidElement) PageBase.driver.findElement
                (By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]"));
        // 3. Tab on Device Name Tab to get Device name
        click(deviceNameTab);
    }

    public String getDeviceName()
    {
        // 1. Get Device Name
        String name = deviceName.getText() ;
        // 2. Tab Cancel Button
        click(cancelButton);
        return name;
    }

    //************************************************* Software Version **********************************************//

    // Locate Software Version Field to check its text
    @AndroidFindBy(id = "com.android.settings:id/firmware_version_value")
    private AndroidElement swVersion ;

    public void tabSwVersion(){

        // 1. Wait for device Data List to be visible
        waitForVisibility(deviceDataList);
        // 2. Locate SW Version Tab
        AndroidElement SWVersionTab = (AndroidElement) PageBase.driver.findElement
                (By.xpath("//android.widget.LinearLayout[8]/android.widget.RelativeLayout"));

        waitForVisibility(SWVersionTab);
        // 3. Tab on SW Version Tab to get Device name
        click(SWVersionTab);
    }

    public String getSoftwareVersion() {
        // 1. Get SW Version
        String version = swVersion.getText() ;
        // 2. Tab Ok Button
        click(okButton);
        return version ;
    }

    //***************************************** Model & Serial Number ***************************************************//

    // Locate Model Name Field
    @AndroidFindBy(id = "com.android.settings:id/model_value")
    private AndroidElement Model;
    // Locate Serial Number Field
    @AndroidFindBy(id = "com.android.settings:id/serial_number_value")
    private AndroidElement serialNumber ;

    public void tabModelHardware() throws InterruptedException {
        Thread.sleep(1000);
        // 1. Wait for device Data List to be visible
        waitForVisibility(deviceDataList);
        // 1. Locate SW Version Tab
        AndroidElement ModelTab = (AndroidElement) PageBase.driver.findElement
                (By.xpath("//android.widget.LinearLayout[6]/android.widget.RelativeLayout"));
        // 2. Tab on SW Version Tab to get Device name
        click(ModelTab);
    }

    public String getModel()
    {
        // 1. Get Model Name
        String modelText = Model.getText() ;
        // 2. Tab Ok Button
        click(okButton);
        return modelText ;
    }

    public String getSerialNumber()
    {
        // 3. Get Serial Number
        String serialNumberText = serialNumber.getText();
        // 4. Tab Ok Button
        click(okButton);
        return serialNumberText ;
    }
}
