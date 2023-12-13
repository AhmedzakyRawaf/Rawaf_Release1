package com.Rawaf.Pages;

import com.Rawaf.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class P002AboutusPage extends PageBase {


    public P002AboutusPage(WebDriver driver) {
        super(driver);
    }
    private final By AboutUs = By.xpath("//*[@id=\"root\"]/div[1]/div[1]/main/div/div/div/div[1]/div/div/div[2]/div[2]");
    private final By AboutUsTab = By.linkText("عن المنصة");


    public void checkAboutUsTab() {
        waitForVisibilityOfElement(AboutUsTab);
        clickOnelement(AboutUsTab);
    }
    public void checkAboutUs(){
        waitForVisibilityOfElement(AboutUs);
        WebElement StringTXT =driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/main/div/div/div/div[1]/div/div/div[2]/div[2]"));
        String Text =StringTXT.getText();
        clickOnelement(AboutUs);
        System.out.println(AboutUs);

}
}
