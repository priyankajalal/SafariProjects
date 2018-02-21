package com.sample.tests.junit;

import com.sample.framework.Configuration;
import com.sample.framework.Driver;
import com.sample.framework.ui.Control;
import com.sample.framework.ui.Edit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;

public class SampleSearchTestngTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        Driver.add(Configuration.get("browser"),cap);
        driver = Driver.current();
        driver.get(Configuration.get("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void testSampleSearch() throws InterruptedException {
        Edit editdestination = new Edit(driver,By.id("ss"));
        Thread.sleep(2000);
        Control buttonDownShevron = new Control(driver,By.xpath("//img[starts-with(@alt,'London, Greater London, United Kingdom')]"));
        Control buttonTodaysDate = new Control(driver,By.xpath("//td[contains(@class,'c2-day-s-today')]"));
        Control radioBusiness = new Control(driver,By.name("sb_travel_purpose"));
        Control buttonSubmit = new Control(driver,By.xpath("//button[@type='submit']"));

        editdestination.setText("London");
        editdestination.click();
        buttonDownShevron.click();
        buttonTodaysDate.click();
        radioBusiness.click();
        buttonSubmit.click();



//        WebElement user = driver.findElement(By.id("email"));
//        WebElement pass = driver.findElement(By.id("pass"));
//        user.sendKeys("priyanka");
//        pass.sendKeys("jkkmomoo");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();

    }
}
