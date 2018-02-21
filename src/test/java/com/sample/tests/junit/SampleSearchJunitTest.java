package com.sample.tests.junit;

import com.sample.framework.Configuration;
import com.sample.framework.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class SampleSearchJunitTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        Driver.add(Configuration.get("browser"),cap);
        driver = Driver.current();
        driver.get(Configuration.get("url"));
        driver.manage().window().maximize();
    }
    @Test
    public void testSampleSearch() throws InterruptedException {
        WebElement searchInput = driver.findElement(By.id("ss"));
        searchInput.clear();
        searchInput.sendKeys("London");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//img[starts-with(@alt,'London, Greater London, United Kingdom')]"));
        driver.findElement(By.xpath("//td[contains(@class,'c2-day-s-today')]"));
        driver.findElement(By.name("sb_travel_purpose")).click();
        driver.findElement(By.xpath("//button[@type='submit']"));


//        WebElement user = driver.findElement(By.id("email"));
//        WebElement pass = driver.findElement(By.id("pass"));
//        user.sendKeys("priyanka");
//        pass.sendKeys("jkkmomoo");
    }

    @After
    public void tearDown(){
       // driver.quit();

    }
}
