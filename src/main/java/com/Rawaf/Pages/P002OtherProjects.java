package com.Rawaf.Pages;

import com.Rawaf.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P002OtherProjects extends PageBase {
    public P002OtherProjects(WebDriver driver) {
        super(driver);
    }
    private final By Sale =By.xpath("//div[contains(text(),'Sale') or contains(text(),'للبيع')]");
    private final By Rent =By.xpath("//div[contains(text(),'Rent') or contains(text(),'إيجار')]");
    private final By Reset =By.xpath("(//div[contains(@class,'outline-none text-[#3B45B2] font-bold cursor-pointer mx-2')])[1]");
    private final By District =By.xpath("//button[normalize-space()='District' or contains(text(),'الحي')]");
    private final By Aohod =By.xpath("//li[contains(text(),'أحد')]");
    private final By Nmar =By.xpath("//li[contains(text(),'نمار')]");
    private final By Narjes =By.xpath("//li[contains(text(),'النرجس')]");
    private final By Qods =By.xpath("//li[contains(text(),'القدس')]");
    private final By Search =By.xpath("//input[@placeholder='Search ...' or contains(@placeholder,'بحث ...')]");
    private final By Message =By.xpath("(//div[@class='grid w-full grid-cols-1 gap-6 md:grid-cols-2 xl:grid-cols-3 2xl:grid-cols-3'])[1]");
    /**
     *
     *
     *
     *
     * nmar + rent =
     */
    private void checkElementsDisplayed(){
        Assert.assertTrue(assertElementDisplayed(Rent));
        Assert.assertTrue(assertElementDisplayed(Sale));
        Assert.assertTrue(assertElementDisplayed(Reset));
        Assert.assertTrue(assertElementDisplayed(District));
        Assert.assertTrue(assertElementDisplayed(Search));
        Assert.assertTrue(checkForLocalization(Reset ,"Reset Filters" ,"إعادة تعيين"));

    }
    public void checkProjectsScreen(){
        checkElementsDisplayed();
        validateFilter();
    }
    private void validateFilter(){
        clickOnElement(District);
        waitForVisibilityOfElement(Nmar);
        Assert.assertTrue(assertElementDisplayed(Narjes));
        Assert.assertTrue(assertElementDisplayed(Qods));
        clickOnElement(Aohod);
        clickOnElement(Sale);
        scrollToElement(Message);
        Assert.assertTrue(assertElementDisplayed(Message));
        Assert.assertTrue(driver.findElement(Message).getText().contains("لا توجد مشاريع حاليًا تتوافق مع البحث الذي أدخلته."));
    }
}
