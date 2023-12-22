package com.Rawaf.PageBase;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitForVisibilityOfWebElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForInVisibilityOfElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
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

    public void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -500);");
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


}
