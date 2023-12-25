package com.Rawaf.testCases;

import com.Rawaf.Pages.P001LandingPage;
import com.Rawaf.Pages.P006ContactUs;
import com.Rawaf.Pages.P007UnitsResponseChecks;
import com.Rawaf.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.Rawaf.testBase.ReadProperties.*;


public class M006ContactUsTest extends BaseTest {
    P006ContactUs contactUs;
    P001LandingPage landingPage;
    P007UnitsResponseChecks apis;

    @BeforeClass
    public void initiateObject() {
        contactUs = new P006ContactUs(driver);
        landingPage = new P001LandingPage(driver);
        apis = new P007UnitsResponseChecks();
    }

    @Test
    public void validateContactUsScreen() {
        landingPage.navigateToContactUs();
        contactUs.checkContactUsScreen(EMAIL, MOBILE, MESSAGE, NAME);
    }
    @Test
    public void tetste() {
        apis.testGetPropertyDetails("ON_HOLD","12",415);
    }

}
