package com.Rawaf.testCases;

import com.Rawaf.Pages.P001LandingPage;
import com.Rawaf.Pages.P005ContactUs;
import com.Rawaf.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class P005Contactus_Test extends BaseTest {
P005ContactUs contactus;
    @BeforeClass
    public void initiateObject(){
        contactus = new P005ContactUs(driver);
    }
    @Test(groups = "Contact")
    public void TC_Welcome01_validateRawafLogoDisplayed() throws InterruptedException {
        contactus.ClickContactUs();
    }

}
