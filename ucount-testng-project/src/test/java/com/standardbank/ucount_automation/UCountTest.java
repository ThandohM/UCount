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
 
        // 1. Wait and click UCount Rewards

        WebElement ucountLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("UCount Rewards")));

        ucountLink.click();
 
        // 2. Wait and click "JOIN UCOUNT / CREATE PROFILE"

        WebElement joinLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("JOIN UCOUNT / CREATE PROFILE")));

        joinLink.click();
 
        // 3. Wait for the ID input and enter data

        WebElement idInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idnumber")));

        idInput.sendKeys("123qwerty");
 
        // 4. Wait for and click the Continue button

        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(

                By.xpath("//button[contains(text(), 'Continue')]")));

        continueBtn.click();
 
        // Optionally: verify next step or error message

        System.out.println("✅ Form submitted (check response manually or assert expected result).");

    }
 
    @AfterClass

    public void teardown() {

        if (driver != null) {

            driver.quit();

        }

    }
 
    // ✅ Added main() method for direct execution

    public static void main(String[] args) throws Exception {

        UCountTest test = new UCountTest();

        test.setup();

        test.testJoinUCountFlow();

        test.teardown();

    }

}

 