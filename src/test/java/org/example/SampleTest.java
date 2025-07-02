package org.example;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URI;

public class SampleTest {
    private RemoteWebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        System.out.println("*************************** Run Before Test Method ***********************************************");
        try {
            System.out.println("Browser Name is: ");
            System.out.println(System.getenv("test_browser").toLowerCase());
            switch (System.getenv("test_browser").toLowerCase()) {
                case "firefox":
                    /*driver = new FirefoxDriver();*/
                    driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), new FirefoxOptions());
                    break;
                case "chrome":
                    /*driver = new ChromeDriver();*/
                    driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), new ChromeOptions());
                    break;
                default:
                    System.out.println("No browser defined!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(groups = {"smoke", "regression"})
    public void testMethod(){
        System.out.println("*************************** This is a sample test running***********************************************");

        System.out.println("0. Start");

        System.out.println("1. Open target page");

        Allure.step("Navigation Step!!!");
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().setSize(new Dimension(1350, 637));

        System.out.println("2. Insert username and password");

        Allure.step("2.1 Insert username >> standard_user");
        System.out.println(" 2.1 Insert username >> standard_user");
        driver.findElement(By.id("login_credentials")).click();
        driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");

        Allure.step("2.1 Insert password >> secret_sauce");
        System.out.println(" 2.1 Insert password >> secret_sauce");
        driver.findElement(By.cssSelector(".login_password")).click();
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");

        Allure.step("3. Click submit to perform login");
        System.out.println("3. Click submit to perform login");
        driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();

        Allure.step("4. Verify login has been successfully executed");
        System.out.println("4. Verify login has been successfully executed");
        System.out.println(" 4.1 Page title is 'Swag Labs'");

        Assert.assertEquals(driver.getTitle(), "Swag Labs");
        /*Assert.assertEquals(driver.getTitle(), "Wrong Labs");*/

        Allure.step("4.2 Page url contains 'inventory'");
        System.out.println(" 4.2 Page url contains 'inventory'");
        Assert.assertEquals(driver.getCurrentUrl().contains("inventory"), true);

        //Pause the execution for 2 seconds to show the logged in page
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("5. End");    }

    @AfterMethod(alwaysRun = true)
    public void runAfterTestMethod(){
        driver.quit();
        System.out.println("*************************** Run After Test Method ***********************************************");
    }
}
