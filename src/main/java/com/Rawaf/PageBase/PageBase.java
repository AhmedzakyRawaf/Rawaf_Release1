package com.Rawaf.PageBase;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.URI;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageBase {
    public WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public By language = By.xpath("(//button[@class='text-white rounded-lg bg-primary-600'])[1]");


    public void clickOnElement(By by) {
        waitForVisibilityOfElement(by);
        driver.findElement(by).click();

    }

    public void waitForVisibilityOfElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitForVisibilityOfWebElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForInVisibilityOfElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public Boolean assertElementDisplayed(By by) {
        waitForVisibilityOfElement(by);
        return driver.findElement(by).isDisplayed();
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public void scrollToElement(By element) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", driver.findElement(element));
    }
    public void scrollToElementTop(By element) {
        WebElement webElement = driver.findElement(element);
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'start', inline: 'nearest'});", webElement);
    }
    public void scrollUpToElement(By element) {
        WebElement webElement = driver.findElement(element);
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'end', inline: 'nearest'});", webElement);
    }



    public void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -500);");
    }
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 3000);");
    }

    public void scrollToEndOfScreen() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public Boolean checkForLocalization(By by, String Eng, String arb) {
        scrollToElement(language);
        scrollToElement(by);
        waitForVisibilityOfElement(by);
        if (driver.findElement(language).getText().contains("EN")) {
            return driver.findElement(by).getText().contains(arb);
        } else {
            return driver.findElement(by).getText().contains(Eng);
        }


    }

    public void sendTextToInputField(String text, By by) {
        waitForVisibilityOfElement(by);
        clearInputField(by);
        driver.findElement(by).sendKeys(text);
    }

    public void clearInputField(By by) {
        driver.findElement(by).clear();
    }

    public void doubleClickOnAnElement(By by) {
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(by)).perform();
    }

    public void selectByIndexFromDropDownList(By by, String index) {
        WebElement selectElement = driver.findElement(by);
        Select select = new Select(selectElement);
        select.selectByIndex(Integer.parseInt(index));
    }
    public   void checkAllLinks() {
        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));

        for (int i = 0; i < links.size(); i++) {
            WebElement link = driver.findElements(By.tagName("a")).get(i);
            String url = link.getAttribute("href");

            try {
                // Click the link to check if it works
                link.click();
                System.out.println("Link works: " + url);
            } catch (StaleElementReferenceException e) {
                // Handle StaleElementReferenceException by finding the link again
                link = driver.findElements(By.tagName("a")).get(i);
                link.click();
                System.out.println("Link works (after stale element): " + url);
            } catch (Exception e) {
                // Handle other exceptions
                System.out.println("Link does not work: " + url);
            }

            driver.navigate().back();
        }
    }

    public  String getPAth(String URL){
           try {
               URI uri = new URI(URL);
            String path = uri.getPath();
            System.out.println("Extracted Path: " + path);
               return path;
           }catch (Exception e){
               e.getStackTrace();
               return null;
           }

    }
    public  double extractNumericValue(String input) {
        String numericString = input.replaceAll("[^\\d.]", "");

        return Double.parseDouble(numericString);
    }
    public  String extractLatestIntegerAsString(String input) {
        // Match the last sequence of digits in the URL
        String regex = "\\d+";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(input);

        // Find the matches
        String latestIntegerAsString = "";
        while (matcher.find()) {
            // Update if it's greater than the current latest integer
            latestIntegerAsString = matcher.group();
        }

        return latestIntegerAsString;
    }
    public static String generateRandomDigits(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length should be greater than 0");
        }

        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10); // Generates a random digit (0 to 9)
            stringBuilder.append(digit);
        }

        return stringBuilder.toString();
    }
    public void waitForTime(int millSec){
        try {
            Thread.sleep(millSec);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

}
