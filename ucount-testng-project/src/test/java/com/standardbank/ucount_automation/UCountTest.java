package com.standardbank.ucount_automation;
 
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.*;
 
import java.time.Duration;
 
public class UCountTest {

    WebDriver driver;

    WebDriverWait wait;
 
    @BeforeClass

    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
 
    @Test

    public void testJoinUCountFlow() {

        driver.get("https://www.standardbank.co.za");
 
        // This Waits and clicks UCount Rewards

        WebElement ucountLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("UCount Rewards")));

        ucountLink.click();
 
        // This waits and clicks "JOIN UCOUNT / CREATE PROFILE"

        WebElement joinLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("JOIN UCOUNT / CREATE PROFILE")));

        joinLink.click();
 
        // This Waits for user to input ID data

        WebElement idInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("id-number")));

        idInput.sendKeys("123qwerty");
 
        // This waits and clicks the Continue button

        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(

                By.xpath("//button[contains(text(), 'Continue')]")));

        continueBtn.click();
  

        System.out.println("Form submitted or something");

    }
 
    @AfterClass

    public void teardown() {

        if (driver != null) {

            driver.quit();

        }

    }
 
    // Added main method for direct execution

    public static void main(String[] args) throws Exception {

        UCountTest test = new UCountTest();

        test.setup();

        test.testJoinUCountFlow();

        test.teardown();

    }

}

 
