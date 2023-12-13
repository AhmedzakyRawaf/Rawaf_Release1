package com.Rawaf.Pages;

import com.Rawaf.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P001LandingPage extends PageBase {
    public P001LandingPage(WebDriver driver) {
        super(driver);
    }


    private final By Rawaf_Logo = By.xpath("//a[@href='#' and @class='-m-1.5 p-1.5']");

    private final By Text_logo=By.xpath("//div[@class='flex items-center justify-center gap-2 text-base font-bold leading-7 text-center text-indigo-800']");
    String True_Value="منصة تعرض الوحدات و توفر لك الدفع في مكان واحد من خلال تجربة ثرية ومتكاملة";

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



