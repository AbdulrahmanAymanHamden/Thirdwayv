package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class P02_SystemPage extends PageBase{

    // Locate System List to ensure that page has been loaded successfully
    @AndroidFindBy(id = "com.android.settings:id/list")
    AndroidElement systemList ;


    public P02_SystemPage(AppiumDriver driver) {
        super(driver);
    }

    public void tab_On_About() {
        // 1. Wait for System List to be visible
        waitForVisibility(systemList);
        // 2. Locate About field
        AndroidElement about = (AndroidElement) PageBase.driver.findElement
                (By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]"));
        //3. Tab on About
        click(about);
    }
}
