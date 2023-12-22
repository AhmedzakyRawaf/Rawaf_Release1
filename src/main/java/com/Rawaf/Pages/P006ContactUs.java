package com.Rawaf.Pages;

import com.Rawaf.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P006ContactUs extends PageBase {


    public P006ContactUs(WebDriver driver) {
        super(driver);
    }

    private final By Complains_Title = By.xpath("//body//div//h1[1]");
    private final By Label_Name = By.xpath("//div[contains(text(),'Name') or contains(text(),'الاسم')]");
    private final By Label_Mobile = By.xpath("//div[contains(text(),'Mobile Number') or contains(text(),'الجوال')]");
    private final By Label_Mail = By.xpath("//div[contains(text(),'Email') or contains(text(),'البريد الإلكتروني')]");
    private final By Label_contact_Type = By.xpath("//div[contains(text(),'Contact Type') or contains(text(),'نوع التواصل')]");
    private final By Label_Message = By.xpath("//div[contains(text(),'Contact Message') or contains(text(),'نص الرسالة')]");
    private final By Send = By.xpath("//button[normalize-space()='Send' or contains(text(),'ارسال')]");
    private final By Input_Name = By.xpath("//input[@name='name']");
    private final By Input_Mobile = By.xpath("//input[@name='mobileNumber']");
    private final By Input_Email = By.xpath("//input[@name='email']");
    private final By Input_Message = By.xpath("//textarea[@name='content']");
    private final By select_Category = By.xpath("//select[@name='categoryId']");


    private void validateEachElement(By by) {
        scrollToElement(by);
        Assert.assertTrue(assertElementDisplayed(by));
    }

    private void checkContactUsElements() {
        validateEachElement(Complains_Title);
        Assert.assertTrue(checkForLocalization(Complains_Title, "For Complaints and Suggestions", "للشكاوى والاقتراحات"));
        validateEachElement(Label_Name);
        validateEachElement(Label_Mail);
        validateEachElement(Label_Mobile);
        validateEachElement(Label_Message);
        validateEachElement(Label_contact_Type);
        validateEachElement(Send);
    }

    private void checkInputFields() {
        validateEachElement(Input_Name);
        validateEachElement(Input_Email);
        validateEachElement(Input_Message);
        validateEachElement(Input_Mobile);
        validateEachElement(select_Category);
    }

    public void checkContactUsScreen(String email, String mobile, String message, String name) {
        checkContactUsElements();
        checkInputFields();
        fillContactUsForm(email, mobile, message, name);
        clickOnElement(Send);
    }

    private void fillContactUsForm(String email, String mobile, String message, String name) {
        sendTextToInputField(email, Input_Email);
        sendTextToInputField(name, Input_Name);
        sendTextToInputField(mobile, Input_Mobile);
        sendTextToInputField(message, Input_Message);
        selectByIndexFromDropDownList(select_Category, "1");
    }


}
