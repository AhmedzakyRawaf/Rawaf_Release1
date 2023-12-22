package com.Rawaf.Pages;

import com.Rawaf.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P005ContactUs extends PageBase {


    private final By ContactUs_tab = By.linkText("تواصل معنا");
    private final By Name = By.xpath("//input[@name='name']");
    private final By Mobile = By.xpath("//input[@name='mobileNumber']");
    private final By Email = By.xpath("//input[@name='email']");
    private final By Suggestion = By.xpath("//option[text()='شكوى']");
    private final By Text = By.xpath("//div[contains(@class, 'Input')]//textarea[@name='content']");
    private final By Submit = By.xpath("//button[@fdprocessedid='nzc42']");
    private final By OTP1 = By.xpath(" //input[@name='digit1']");
    private final By OTP2 = By.xpath(" //input[@name='digit2']");
    private final By OTP3 = By.xpath(" //input[@name='digit3']");
    private final By OTP4 = By.xpath(" //input[@name='digit4']");
    private final By OTP5 = By.xpath(" //input[@name='digit5']");
    private final By Verify = By.xpath(" //*[@id=root]/div[1]/div[1]/main/div/div/div/div/div/form/div[3]/button[1]/div/div");

    public P005ContactUs(WebDriver driver) {
        super(driver);
    }


    public void ClickContactUs() throws InterruptedException {
        waitForVisibilityOfElement(ContactUs_tab);
        Assert.assertTrue(driver.findElement(ContactUs_tab).isDisplayed());
        clickOnelement(ContactUs_tab);
        sendKeysWithJs(Name, "Ahmed");
        sendKeysWithJs(Mobile, "0565656565");
        sendKeysWithJs(Email, "a@a.com");
        clickOnelement(Suggestion);
        sendKeysWithJs(Text, "ZakyAutomationsTest");
        Thread.sleep(10);
        clickOnelement(Submit);


/*

        waitForVisibilityOfElement(OTP1);
        sendKeysWithJs(OTP1,"1");
        sendKeysWithJs(OTP2,"1");
        sendKeysWithJs(OTP3,"1");
        sendKeysWithJs(OTP4,"1");
        sendKeysWithJs(OTP5,"1");
        clickOnelement(Verify);

*/
    }



}
