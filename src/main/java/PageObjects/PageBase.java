package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    // Create driver to control the device
    public static AppiumDriver driver = null ;
    // Create Touch Action object for touch actions (Tab , Press , Move to , .... etc)
    public  TouchAction  action = null ;
    // Set a fixed duration for Explicit wait
    public static final long WAIT = 10 ;

    // Constructor
    public PageBase(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        this.driver = driver;
    }

    // Explicit Wait
    public void waitForVisibility(AndroidElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver , WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Clear Element's Text
    public void clearText(AndroidElement element)
    {
        element.clear();
    }

    // Enter Text into element field
    public void enterText(AndroidElement element , String text)
    {
        element.sendKeys(text);
    }

    // Click Element
    public void click(AndroidElement element)
    {
        element.click();
    }

    // Get value of Attribute
    public String  getAttribute(AndroidElement element , String attribute)
    {
        return element.getAttribute(attribute);
    }

    // Scroll Down
    public void scrollDown(AndroidElement element)
    {
        Dimension dimension = driver.manage().window().getSize();
        int startPint = (int) (dimension.getHeight()*0.8);
        int endPoint = (int) (dimension.getHeight()*0.1);

        action = new AndroidTouchAction(driver).press(PointOption.point(0,startPint))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0,endPoint))
                .release()
                .perform();
    }
}
