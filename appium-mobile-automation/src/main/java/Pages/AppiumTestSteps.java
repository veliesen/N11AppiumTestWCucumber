package Pages;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


import javax.naming.directory.SearchControls;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AppiumTestSteps {

    private AppiumDriver driver;
    private MobileElement element;
    private MobileElement el;

    @Given("N11 AndroidApp APK Open")
    public void N11_APK_SetUP() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:appActivity", "com.dmall.mfandroid.activity.base.NewSplash");
        desiredCapabilities.setCapability("appium:appPackage", "com.dmall.mfandroid");
        desiredCapabilities.setCapability("platformName", "Android");
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

    @When("Click On Login Icon On Homepage")
    public void clickOnLoginIcon() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Hesabım\"]/android.widget.FrameLayout/android.widget.ImageView")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("Click On SignIn Button")
    public void clickOnSignInButton(){
        driver.findElement(By.id("com.dmall.mfandroid:id/btn_login")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @And("Send Valid Email {string}")
    public void sendValidEmail(String string) throws InterruptedException{
        Thread.sleep(1000);
        byte[] decryptedPasswordInBytes= Base64.getDecoder().decode(string.getBytes(StandardCharsets.UTF_8)); //Decrypt The Encrypted Email
        String decryptedPassword =new String((decryptedPasswordInBytes));
        Thread.sleep(1000);
       element= (MobileElement) driver.findElement(By.id("com.dmall.mfandroid:id/loginEmailET"));
       element.sendKeys(decryptedPassword);

    }

    @And("Send Valid Password {string}")
    public void sendValidPassword(String string) throws InterruptedException{
        Thread.sleep(1000);
        byte[] decryptedPasswordInBytes= Base64.getDecoder().decode(string.getBytes(StandardCharsets.UTF_8));  //Decrypt The Encrypted Password
        String decryptedPassword =new String((decryptedPasswordInBytes));
        Thread.sleep(1000);
        element= (MobileElement) driver.findElement(By.id("com.dmall.mfandroid:id/loginPassET"));
        element.sendKeys(decryptedPassword);
    }
    @And("Click On Login Button")
    public void clickOnLoginInButton() {
        driver.findElement(By.id("com.dmall.mfandroid:id/LoginBtn")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    @And("Click On Homepage Icon")
    public void clickToNavigateHomepage() {
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Ana Sayfa\"]/android.widget.FrameLayout/android.widget.ImageView ")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    @And("Send Product Name {string}")
    public void sendProductNameSearch(String string) throws InterruptedException {
        element= (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.TextView"));
        element.click();

        Thread.sleep(3000);

        el=(MobileElement) driver.findElement(By.id("com.dmall.mfandroid:id/etSearch"));
        el.sendKeys(string);

        Thread.sleep(2000);
        Actions action=new Actions(driver);
        action.moveToElement(el).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(3000);

    }
    @And("Click On Product")
    public void clickOnProduct() throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/androidx.appcompat.widget.LinearLayoutCompat/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.ImageView")).click();
        Thread.sleep(2000);
    }

    @And("Click On Add Product Button")
    public void clickOnAddCart() throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.id("com.dmall.mfandroid:id/pdpAddToCartButton")).click();
        Thread.sleep(2000);
    }
    @And("Click On Delete Product Icon Delete From Cart")
    public void clickOnDeleteProduct() throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.id("com.dmall.mfandroid:id/firstItemView")).click();
        Thread.sleep(2000);
    }
    @And("Click On Delete And Add Product to Favorites PopUp")
    public void clickOnAddProductFavorites() throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.id("com.dmall.mfandroid:id/deleteAndAddFavoriteTv")).click();
        Thread.sleep(2000);
    }
    @And("Check Welcoming Text {string}")
    public void checkCartEmpty(String string) throws InterruptedException{
        Thread.sleep(2000);
        String expectedText=driver.findElement(By.id("com.dmall.mfandroid:id/emptyBasketTitleTv")).getText();
        Assert.assertEquals(expectedText,string);

        Thread.sleep(2000);
    }
    @And("Click On Settings Icon On Account Page To Navigate LogOut Page")
    public void clickOnSettingsIcon() throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.id("com.dmall.mfandroid:id/iv_account_settings")).click();
        Thread.sleep(2000);
    }
    @And("Click On LogOut")
    public void clickOnLogOut() throws InterruptedException{
        driver.findElement(By.id("com.dmall.mfandroid:id/accountFragmentLogOutIV")).click();
        Thread.sleep(2000);
    }
    @And("Click On Yes LogOut on PopUp")
    public void clickOnLogOutSurePopUp() throws InterruptedException{
        driver.findElement(By.id("com.dmall.mfandroid:id/customInfoDialogBtn1")).click();
        Thread.sleep(2000);
    }
    @And("Check {string} Whether LogOut Complete")
    public void checkLogOutCompletion(String string)throws InterruptedException{
        Thread.sleep(1000);
        String expectedText=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
        Assert.assertEquals(expectedText,string);
    }

}


