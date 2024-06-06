package org.selenium.base;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.example.driver.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class MainTest {
    private String url;
    private int implicitWait;
    private String browser;

    @BeforeMethod
    public void setUp() {
        setupBrowserDriver();
        loadUrl();
    }


    private void loadUrl() {
        WebDriver driver = DriverFactory.getDriver(); // Use the driver from ThreadLocal
        driver.get(url);
    }

    private void setupBrowserDriver() {
        try (FileInputStream configFile = new FileInputStream("src/test/resources/setupsetup.properties")) {
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("urlAddress");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
            // browser to be taken from property file
            browser = config.getProperty("browser");
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (browser) {
            case "chrome":
                DriverFactory.setChromeDriver(implicitWait);
                break;
            case "firefox":
                DriverFactory.setFirefoxDriver(implicitWait);
                break;
            default:
                //  log.error("Unsupported browser type");
                throw new IllegalStateException("Unsupported browser type");
        }
    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        // Retrieve the driver for the current thread
        WebDriver driver = DriverFactory.getDriver();

        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File screenshotFile = ts.getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
            String fileName = "Screenshot_" + timestamp + ".png";
            Path path = Paths.get("./Screenshots", fileName);
            try {
                // Save the screenshot to the file system
                Files.copy(screenshotFile.toPath(), path);
                // Attach the screenshot to Allure
                Allure.addAttachment("Screenshot on Failure", "image/png", Files.newInputStream(path), ".png");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        DriverFactory.quitDriver();
    }


  /*  @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }*/
}