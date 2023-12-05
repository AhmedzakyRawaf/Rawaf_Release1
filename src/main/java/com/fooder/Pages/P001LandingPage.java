package com.fooder.Pages;

import com.fooder.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P001LandingPage extends PageBase {
    public P001LandingPage(WebDriver driver) {
        super(driver);
    }


    private final By Rawaf_Logo = By.linkText("عن المنصة");
    private final By FAQ = By.linkText("الأسئلة الشائعة");
    public void checkRawafLogo(){
        waitForVisibilityOfElement(Rawaf_Logo);
        Assert.assertTrue(driver.findElement(Rawaf_Logo).isDisplayed());
        clickOnelement(Rawaf_Logo);
    }
    public void checkFAQ(){
        waitForVisibilityOfElement(FAQ);
        Assert.assertTrue(driver.findElement(FAQ).isDisplayed());
        clickOnelement(FAQ);
    }

}



