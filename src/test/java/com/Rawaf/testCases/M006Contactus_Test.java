package com.Rawaf.testCases;

import com.Rawaf.Pages.P006ContactUs;
import com.Rawaf.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class M006Contactus_Test extends BaseTest {
P006ContactUs contactus;
    @BeforeClass
    public void initiateObject(){
        contactus = new P006ContactUs(driver);
    }
    @Test(groups = "Contact")
    public void TC_Welcome01_validateRawafLogoDisplayed() throws InterruptedException {
        contactus.ClickContactUs();
    }

}
