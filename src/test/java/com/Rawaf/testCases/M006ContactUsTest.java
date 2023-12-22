package com.Rawaf.testCases;

import com.Rawaf.Pages.P001LandingPage;
import com.Rawaf.Pages.P006ContactUs;
import com.Rawaf.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.Rawaf.testBase.ReadProperties.*;


public class M006ContactUsTest extends BaseTest {
    P006ContactUs contactUs;
    P001LandingPage landingPage;

    @BeforeClass
    public void initiateObject() {
        contactUs = new P006ContactUs(driver);
        landingPage = new P001LandingPage(driver);
    }

    @Test
    public void validateContactUsScreen() {
        landingPage.navigateToContactUs();
        contactUs.checkContactUsScreen(EMAIL, MOBILE, MESSAGE, NAME);
    }

}
