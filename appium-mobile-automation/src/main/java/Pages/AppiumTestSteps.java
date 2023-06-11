package Pages;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTestSteps {

    private AppiumDriver driver;

    @Given("Selendroid APK OPEN")
    public void selendroid_APK_basariyla_yuklendi() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:appActivity", "io.selendroid.testapp.HomeScreenActivity");
        desiredCapabilities.setCapability("appium:appPackage", "io.selendroid.testapp");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
        try {
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @When("Continue button clicked")
    public void continueClick() {
        driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
    }

    @When("Selendroid info popup closed")
    public void infoPopup() {
        new TouchAction(driver).tap(PointOption.point(401, 539)).perform();
    }

    @When("Input sendkeys {string}")
    public void uygulama_basariyla_aciliyor(String string) throws InterruptedException {
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("my_text_fieldCD");
        el1.sendKeys(string);
        Thread.sleep(3000);
    }

    @When("Display Text View")
    public void displayTextView() throws InterruptedException {
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("io.selendroid.testapp:id/visibleButtonTest");
        Thread.sleep(3000);
        el2.click();
    }

    @When("Displays a Toast")
    public void displayAToast() {
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("io.selendroid.testapp:id/showToastButton");
        el1.click();
    }

    @When("Displays popup window button click")
    public void displayPopupWindow() {
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("io.selendroid.testapp:id/showPopupWindowButton");
        el1.click();
    }

    @When("Press to throw unhandled exception")
    public void pressToException() {
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("io.selendroid.testapp:id/exceptionTestButton");
        el1.click();
    }
}