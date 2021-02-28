package tr.com.getir;

import app.Calculator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;
import tr.com.getir.extensions.TestLifeCycleLogger;
import tr.com.getir.extensions.TimingExtension;

import java.net.MalformedURLException;
import java.net.URL;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(TimingExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest implements TestLifeCycleLogger{

    protected AppiumDriver driver ;
    protected Calculator calculator ;

    @BeforeAll
    public void globalSetUp(){

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","SM-M215F/DSN"); //any random value is valid but...
        cap.setCapability("udid","R58NA269Y0M");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","10");
        cap.setCapability("appPackage","com.sec.android.app.popupcalculator");
        cap.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");

        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new AppiumDriver<MobileElement>(url , cap) ;
        TestLifeCycleLogger.logger.info("App initiated...");

        calculator = new Calculator(driver);
    }

    @AfterAll
    public void globalTearDown(){
        driver.quit();
        TestLifeCycleLogger.logger.info("App terminated...");
    }



}