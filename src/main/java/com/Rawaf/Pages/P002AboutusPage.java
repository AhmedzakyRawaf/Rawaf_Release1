package com.Rawaf.Pages;

import com.Rawaf.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class P002AboutusPage extends PageBase {

    public P002AboutusPage(WebDriver driver) {
        super(driver);
    }
    private final By Main = By.xpath("//a[normalize-space()='Home' or contains(text(),'الرئيسية')]");
    private final By About_Us = By.xpath("//a[normalize-space()='About Us' or contains(text(),'عن المنصة')]");
    private final By Projects = By.xpath("//a[normalize-space()='Projects' or contains(text(),'المشاريع')]");
    private final By FAQs = By.xpath("//a[normalize-space()='FAQs' or contains(text(),'الأسئلة الشائعة')]");
    private final By Contact_US = By.xpath("//a[normalize-space()='Contact Us' or contains(text(),'تواصل معنا')]");
    private final By Second_Logo = By.xpath("(//*[name()='svg'])[5]");
    private final By About_Rawaf_Qoute = By.xpath("//div[contains(@class, \"self-stretch text-indigo-900 text-xl font-bold font-['Loew Next Arabic'] leading-loose\")]");
    private final By About_Rawaf = By.xpath("//div[@class=\" text-indigo-800 text-2xl font-extrabold font-['Loew Next Arabic'] leading-loose\"]");
    private final By Verify_Mark = By.xpath("(//*[name()='svg'])[4]");
    private final By Mission_Title = By.xpath("//div[normalize-space()='Mission' or contains(text(),'الرسالة')]");
    private final By Mission_Body = By.xpath("//div[normalize-space()='To be the leading real estate platform in providing residential units in the Kingdom of Saudi Arabia' or contains(text(),'أن نكون المنصة العقارية الرائدة في توفير الوحدات ا')]");
    private final By Vision_Title = By.xpath("//div[normalize-space()='Vision' or contains(text(),'الرؤية')]");
    private final By Vision_Body = By.xpath("//div[normalize-space()='Providing residential solutions by offering and purchasing real estate products with ease' or contains(text(),'توفير الحلول السكنية من خلال عرض وشراء المنتجات ال')]");
    private final By HowWorks = By.xpath("//div[contains(@class,\"grow shrink basis-0 text-indigo-900 text-2xl font-bold font-['Loew Next Arabic']\")]");



    private void checkEachElement(By by){
        scrollToElement(by);
        Assert.assertTrue(assertElementDisplayed(by));
    }
    public void checkAboutScreen(){
        navigateToAboutUsScreen();
        checkEachElement(Main);
        checkEachElement(About_Us);
        checkEachElement(Projects);
        checkEachElement(FAQs);
        checkEachElement(Contact_US);
        checkEachElement(Second_Logo);
        checkEachElement(About_Rawaf_Qoute);
        Assert.assertTrue(checkForLocalization(About_Rawaf_Qoute,"Rawaf is a Saudi platform" , "رواف هي منصة سعودية تعمل على تقديم تجربة مثرية"));
        checkEachElement(About_Rawaf);
        Assert.assertTrue(checkForLocalization(About_Rawaf,"About Rawaf" , "عن رواف"));
        checkEachElement(Verify_Mark);
        checkEachElement(Mission_Title);
        checkEachElement(Mission_Body);
        Assert.assertTrue(checkForLocalization(Mission_Body,"To be the leading real estate platform in providing residential units in the Kingdom of Saudi Arabia" ,
                "أن نكون المنصة العقارية الرائدة في توفير الوحدات السكنية في المملكة العربية السعودية"));
        checkEachElement(Vision_Title);
        checkEachElement(Vision_Body);
        Assert.assertTrue(checkForLocalization(Vision_Body ,"Providing residential solutions by offering and purchasing real estate products with ease" ,
                "توفير الحلول السكنية من خلال عرض وشراء المنتجات العقارية بكل يسر وسهولة"));
        checkEachElement(HowWorks);
        Assert.assertTrue(checkForLocalization(HowWorks , "How Platform Works" , "كيف تعمل المنصة"));
    }
    private void navigateToAboutUsScreen(){
        clickOnelement(About_Us);
    }
}
