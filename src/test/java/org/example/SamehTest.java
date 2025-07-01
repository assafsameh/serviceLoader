package org.example;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URI;

public class SamehTest {
    private RemoteWebDriver driver;

    @BeforeMethod
    public void setUp_Sameh(){
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

    @Test
    public void testMethod_Sameh(){
        System.out.println("Test Method Sameh");
    }
}
