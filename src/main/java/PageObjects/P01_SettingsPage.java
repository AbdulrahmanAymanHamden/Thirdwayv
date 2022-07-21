package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class P01_SettingsPage extends  PageBase{

    public P01_SettingsPage(AppiumDriver driver) {
        super(driver);
    }

    public void scroll_To_System()
    {
        // 1. Locate first field of System Page
        AndroidElement network = (AndroidElement) PageBase.driver.findElement
                (By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]"));
        // 2. Wait to first field to be visible to guarantee that page has been loaded successfully
        waitForVisibility(network);
        // 3. Scroll Down to find System Tab
        scrollDown(network);
    }

    public void tab_On_System()
    {
        // 1. Locate System Field
        AndroidElement system = (AndroidElement) PageBase.driver.findElement(
                By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[9]"));
        // 2. Tab on System Tab to navigate to System of the device
        click(system);
    }


}
