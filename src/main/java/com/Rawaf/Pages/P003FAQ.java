package com.Rawaf.Pages;

import com.Rawaf.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class P003FAQ extends PageBase {

    public P003FAQ(WebDriver driver) {
        super(driver);
    }

    private final By FAQ = By.className("w-full");
    private final By FAQTab = By.linkText("الأسئلة الشائعة");
    WebElement ulElement = driver.findElement(By.className("w-full"));

    public void FAQTab() {
        waitForVisibilityOfElement(FAQTab);
        clickOnelement(FAQTab);

    }

    public void FAQcontent() {
        waitForVisibilityOfElement(FAQ);
        WebElement ulElement = driver.findElement(By.className("w-full"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
        int numberOfLiElements = liElements.size();
        System.out.println("Number of <li> elements inside the <ul>: " + numberOfLiElements);




    }

}