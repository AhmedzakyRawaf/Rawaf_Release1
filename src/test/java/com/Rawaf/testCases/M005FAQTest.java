package com.Rawaf.testCases;

import com.Rawaf.Pages.P001LandingPage;
import com.Rawaf.Pages.P005FAQ;
import com.Rawaf.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class M005FAQTest extends BaseTest {

    P005FAQ FAQPage;
    P001LandingPage landingPage;

    @BeforeClass
    public void initiateObject() {
        FAQPage = new P005FAQ(driver);
        landingPage = new P001LandingPage(driver);
    }

    @Test
    public void validateFAQsScreen() {
        landingPage.navigateToFAQs();
        FAQPage.checkFAQsScreen();
        landingPage.backToMain();
    }


}
