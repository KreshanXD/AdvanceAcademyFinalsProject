package org.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class UsingSeleniumTest {
   /* @Test
    public void eightComponents() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String title = driver.getTitle();
        assertEquals("Web form", title);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));


        WebElement form = driver.findElement(By.id("login-modal"));
        WebElement input = form.findElement(By.xpath(".//input[@name='password']"));


        driver.findElement(By.name("password"));
        driver.findElement(By.cssSelector("[type='button']"));

        input.sendKeys("Selenium");


        WebElement message = driver.findElement(By.id("message"));
        String value = message.getText();
        assertEquals("Received!", value);

        driver.quit();

        Point location = message.getLocation();
        Dimension size = message.getSize();
        assertEquals("MyText", message.getText());
        assertTrue(message.isDisplayed());
    }


    @Test
    public void slider() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the provided URL
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        // Locate the slider using the provided selector
        WebElement slider = driver.findElement(By.cssSelector(".form-range"));

        // Create an instance of the Actions class
        Actions moveSlider = new Actions(driver);

        // Click and drag the slider by an offset
        // This example moves the slider 40 pixels to the right
        // You might need to adjust this value based on the slider's sensitivity and the desired position
        moveSlider.clickAndHold(slider).moveByOffset(40, 0).release().perform();

        // Optionally, verify the slider's new position or value if applicable

        // Close the browser
        driver.quit();

    }


    @Test
    public void dragAndDrop() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the page
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        // Locate the elements
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Perform the drag and drop action
        actions.clickAndHold(source).moveToElement(target).release().perform();

        // Alternatively, using dragAndDrop() method directly (might not work in all cases)
        // actions.dragAndDrop(source, target).perform();

        // Add any verification or cleanup code here

        // Close the browser
        driver.quit();
    }


    @Test
    public void dropDwownExample() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByVisibleText("Option 1");
        System.out.println("Selected: " + dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("Option 2");
        System.out.println("Selected: " + dropdown.getFirstSelectedOption().getText());

        driver.quit();
    }


    @Test
    public void tableExtraction() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<WebElement> emails = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
        for (WebElement email : emails) {
            System.out.println(email.getText());
        }

        driver.quit();
    }

    @Test
    public void sliderExample() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/slider/");

        driver.switchTo().frame(0); // Switch to the frame containing the slider

        WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/span"));
        Actions move = new Actions(driver);
        move.dragAndDropBy(slider, 300, 0).perform();

        // Verification code here

        driver.quit();
    }


    @Test
    public void waitVisibility() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the dynamic loading example page
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // Find and click the start button
        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']/button"));
        startButton.click();

        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 10 seconds timeout

        // Wait until the loading indicator disappears and "Hello World!" text becomes visible
        WebElement helloWorldText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));

        // Print the visible text
        System.out.println("Visible Text: " + helloWorldText.getText());

        // Close the browser
        driver.quit();
    }


    @Test
    public void pagination() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the dynamic loading example page
        driver.get("https://pagination.js.org/");

        // Find and click the start button
        WebElement demo1 = driver.findElement(By.cssSelector("#demo1"));
        List<WebElement> items = demo1.findElements(By.cssSelector(".data-container ul li"));
        List<WebElement> pagination = demo1.findElements(By.cssSelector(".paginationjs-pages ul li"));

        pagination.get(2).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.stalenessOf(items.get(0)));

        items = demo1.findElements(By.cssSelector(".data-container ul li"));
        assertTrue(items.get(0).getText().equals("11"));

        // Close the browser
        driver.quit();
    }


    //-------------------
    @Test
    public void explicitWait1() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Click the Remove button and wait for the "It's gone!" message
        driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String goneMessage = driver.findElement(By.id("message")).getText();
        System.out.println("Message after removing: " + goneMessage);

        // Click the Add button and wait for the checkbox to appear
        driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
        System.out.println("Checkbox is added back.");

    }


    @Test
    public void acceptAlertTest() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Click the button to trigger the alert
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        // Accept the alert
        driver.switchTo().alert().accept();

        System.out.println("Alert has been accepted.");
    }

    @Test
    public void dissmissAlertTest() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Click the button to trigger the confirmation dialog
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        // Dismiss the confirmation dialog
        driver.switchTo().alert().dismiss();

        // Verify the result
        String resultText = driver.findElement(By.id("result")).getText();
        System.out.println("Confirmation Result: " + resultText);
    }

    @Test
    public void sendtextAlertTest() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Click the button to trigger the prompt
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        // Send text to the prompt and accept it
        String textToSend = "Selenium Test";
        driver.switchTo().alert().sendKeys(textToSend);
        driver.switchTo().alert().accept();

        // Verify the result
        String resultText = driver.findElement(By.id("result")).getText();
        System.out.println("Prompt Result: " + resultText);

        // Assert the expected result text
        String expectedText = "You entered: " + textToSend;
        if (resultText.equals(expectedText)) {
            System.out.println("Test Passed: The expected text matches the result.");
        } else {
            System.out.println("Test Failed: The expected text does not match the result.");
        }
    }

    @Test
    public void newTabTest() {
        WebDriver driver = new ChromeDriver();

        // Step 1: Navigate to the page
        driver.get("https://the-internet.herokuapp.com/windows");

        // Step 2: Click the link to open a new window/tab
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();

        // Step 3: Switch to the new window/tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // Switches to the new tab

        // Step 4: Verify the new tab's content
        WebElement header = driver.findElement(By.tagName("h3"));
        String headerText = header.getText();
        System.out.println("New Tab Header Text: " + headerText);

        // Assuming we're checking for a specific header text
        if ("New Window".equals(headerText)) {
            System.out.println("Test Passed: Correct header text found in the new tab.");
        } else {
            System.out.println("Test Failed: Incorrect header text in the new tab.");
        }

        // Step 5: Close the new tab and switch back to the original tab
        driver.close();
        driver.switchTo().window(tabs.get(0));

        // Optional: Perform additional actions on the original tab if necessary
        // For demonstration, print the URL of the original tab
        System.out.println("Original Tab URL: " + driver.getCurrentUrl());

    }

    @Test
    public void nestedFramesTest() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.linkText("Nested Frames")).click();

        // Switch to the top frame
        driver.switchTo().frame("frame-top");

        // Now switch to the left frame within the top frame and verify the text
        driver.switchTo().frame("frame-left");
        System.out.println("Left Frame Text: " + driver.findElement(By.tagName("body")).getText());

        // You would need to switch back to the parent frame to switch to another child frame
        driver.switchTo().parentFrame(); // Back to the top frame

        // Switch to the middle frame and verify the text
        // Repeat as necessary for other frames

        // Finally, switch back to the default content
        driver.switchTo().defaultContent();

    }

    @Test
    public void editinIframeTest() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.linkText("iFrame")).click();

        // Switch to the iFrame by ID
        driver.switchTo().frame("mce_0_ifr");

        // Clear the existing content in the editable area and type new text
        WebElement editable = driver.findElement(By.id("tinymce"));
        editable.clear();
        editable.sendKeys("Testing iFrame content editing.");

        // Verify the new content or perform other actions

        // Remember to switch back when done
        driver.switchTo().defaultContent();
    }
*/
}