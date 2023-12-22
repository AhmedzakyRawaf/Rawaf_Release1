package com.Rawaf.Pages;

import com.Rawaf.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P003Register extends PageBase {
    public P003Register(WebDriver driver) {
        super(driver);
    }

    private final By Label_First_Name = By.xpath("//div[contains(text(),'First Name') or contains(text(),'اسمك الأول')]");
    private final By Label_Last_Name = By.xpath("//div[contains(text(),'Last Name') or contains(text(),'اسمك الأخير')]");
    private final By Label_Mobile = By.xpath("//div[contains(text(),'Mobile Number') or contains(text(),'الجوال')]");
    private final By Input_First_Name = By.xpath("//input[@name='firstName']");
    private final By Input_Last_Name = By.xpath("//input[@name='lastName']");
    private final By Input_Mobile = By.xpath("//input[@name='phoneNumber']");
    private final By Submit = By.xpath("//div[@type='submit']");
    private final By Error_Message = By.xpath("//p[@class='text-xs text-red-600']");

    private void checkRegisterView() {
        Assert.assertTrue(assertElementDisplayed(Label_First_Name));
        Assert.assertTrue(checkForLocalization(Label_First_Name, "First Name", "اسمك الأول"));
        Assert.assertTrue(assertElementDisplayed(Label_Last_Name));
        Assert.assertTrue(checkForLocalization(Label_Last_Name, "Last Name", "اسمك الأخير"));
        Assert.assertTrue(assertElementDisplayed(Label_Mobile));
        Assert.assertTrue(checkForLocalization(Label_Mobile, "Mobile Number", "الجوال"));
        Assert.assertTrue(assertElementDisplayed(Input_First_Name));
        Assert.assertTrue(assertElementDisplayed(Input_Last_Name));
        Assert.assertTrue(assertElementDisplayed(Input_Mobile));
        Assert.assertTrue(assertElementDisplayed(Submit));
        Assert.assertTrue(checkForLocalization(Submit, "Verify", "تحقق من الجوال"));
    }

    public void checkRegisterScreen(String firstname, String lastname, String Mobile_Number) {
        checkRegisterView();
        fillRegisterForm(firstname, lastname, Mobile_Number);
    }

    private void fillRegisterForm(String firstname, String lastname, String Mobile_Number) {
        sendTextToInputField(firstname, Input_First_Name);
        sendTextToInputField(lastname, Input_Last_Name);
        sendTextToInputField("01270020414", Input_Mobile);
        clickOnElement(Submit);
        Assert.assertTrue(assertElementDisplayed(Error_Message));
        Assert.assertTrue(checkForLocalization(Error_Message, "Invalid Number", "رقم الجوال غير صحيح"));
        sendTextToInputField(Mobile_Number, Input_Mobile);
        clickOnElement(Submit);
    }


}
