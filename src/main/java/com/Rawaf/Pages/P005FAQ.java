package com.Rawaf.Pages;

import com.Rawaf.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.internal.EclipseInterface;

public class P005FAQ extends PageBase {

    public P005FAQ(WebDriver driver) {
        super(driver);
    }

    private final By FAQ_Title = By.xpath("//h1[normalize-space()='FAQs' or contains(text(),'الأسئلة الأكثر شيوعاً')]");
    private final By First_FAQ = By.xpath("//div[contains(text(),'What are the main') or contains(text(),'ماهي أهم الخدمات التي تقدمها منصة رواف؟')]");
    private final By Second_FAQ = By.xpath("//div[normalize-space()='What are the available payment methods?' or contains(text(),'ماهي طرق الدفع المتوفرة؟')]");
    private final By Third_FAQ = By.xpath("//div[normalize-space()='Are there on-site visits to the projects?' or contains(text(),'هل يمكنني زيارة المشاريع؟')]");
    private final By Forth_FAQ = By.xpath("//div[normalize-space()='Are there other projects not shown?' or contains(text(),'هل توجد مشاريع أخرى غير المعروضة؟')]");
    private final By Fifth_FAQ = By.xpath("//div[normalize-space()='Can I resell the unit after bought it?' or contains(text(),'هل يمكنني إعادة بيع الوحدة بعد شرائها؟')]");
    private final By Sex_FAQ = By.xpath("//div[normalize-space()='Can I buy more than one property?' or contains(text(),'هل يمكنني شراء أكثر من عقار؟')]");
    private final By Seven_FAQ = By.xpath("//div[normalize-space()='Does registering interest guarantee reservation of the unit?' or contains(text(),'هل يضمن تسجيل الاهتمام حجز الوحدة؟')]");

    private void checkFAQElements() {
        validateEachElement(FAQ_Title);
        validateEachElement(First_FAQ);
        validateEachElement(Second_FAQ);
        validateEachElement(Third_FAQ);
        validateEachElement(Forth_FAQ);
        validateEachElement(Fifth_FAQ);
        validateEachElement(Sex_FAQ);
        validateEachElement(Seven_FAQ);
    }

    private void validateEachElement(By by) {
        scrollToElement(by);
        Assert.assertTrue(assertElementDisplayed(by));
    }

    public void checkFAQsScreen() {
        checkFAQElements();
        validateEachDropDown();
    }

    private void validateEachDropDown() {
        int startingIndex = 10;
        int messageIndex = 7;

        try {
            for (int i = startingIndex; i > 3; i--) {
                WebElement plusElement = driver.findElement(By.xpath("(//*[name()='svg'])[" + i + "]"));
                By messageElement = By.xpath("//li[" + messageIndex + "]/details[1]/div[1]/div[1]/p[1]");
                scrollToElement(plusElement);
                Assert.assertTrue(plusElement.isDisplayed());
                plusElement.click();
                Assert.assertTrue(assertElementDisplayed(messageElement));
                messageIndex--;
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }


}