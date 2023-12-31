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
    private final By VerifyCTA = By.xpath("(//button[@class='flex w-[80%] mx-auto md:mx-0 items-center justify-center gap-4 md:w-[122px] h-[36px] bg-indigo-800 rounded-lg opacity-50 MainButtonUse'])[1]");
    private final By Success_Message = By.xpath("//div[@class=\"text-right text-slate-900 text-sm font-extrabold font-['Loew Next Arabic'] leading-loose\"]");
     private final By contact_us_message = By.xpath("//div[@class=\" self-stretch text-zinc-950 text-lg font-medium font-['Loew Next Arabic'] leading-loose\"]");

    private void validateEachElement(By by) {
        scrollToElement(by);
        Assert.assertTrue(assertElementDisplayed(by));
    }

    private void checkContactUsElements() {
        validateEachElement(Complains_Title);
        Assert.assertTrue(checkForLocalization(Complains_Title, "For Complaints and Suggestions", "للشكاوى والاقتراحات"));
        Assert.assertTrue(checkForLocalization(contact_us_message,"Your request will be processed and you will be contacted by the support team","سيتم معالجة طلبك والتواصل معك من خلال فريق الدعم"));
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
        insertOtc();
        validateSuccessMessage();
    }

    private void fillContactUsForm(String email, String mobile, String message, String name) {
        sendTextToInputField(email, Input_Email);
        sendTextToInputField(name, Input_Name);
        sendTextToInputField(mobile, Input_Mobile);
        sendTextToInputField(message, Input_Message);
        selectByIndexFromDropDownList(select_Category, "1");
    }
    private void insertOtc(){
        for(int i = 1 ; i < 6 ; i++){
            By input = By.xpath("(//input[@name='digit" + i + "'])[1]");
            sendTextToInputField("1",input);
        }
        clickOnElement(VerifyCTA);

    }

    private void validateSuccessMessage() {
        try {
            Assert.assertTrue(assertElementDisplayed(Success_Message));
            waitForInVisibilityOfElement(Success_Message);
        }catch (Exception e){
            e.getStackTrace();
        }
    }


}
