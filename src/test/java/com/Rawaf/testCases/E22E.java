package com.Rawaf.testCases;

import com.Rawaf.Pages.*;
import com.Rawaf.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.Rawaf.testBase.ReadProperties.*;
import static com.Rawaf.testBase.ReadProperties.NAME;

public class E22E extends BaseTest {
    P001LandingPage landPage;
    P002OtherProjects projects;
    P003Register register;
    P004AboutusPage about;
    P005FAQ FAQPage;
    P006ContactUs contactUs;

    @BeforeClass
    public void initiateObject() {
        contactUs = new P006ContactUs(driver);
        landPage = new P001LandingPage(driver);
        projects = new P002OtherProjects(driver);
        register = new P003Register(driver);
        about = new P004AboutusPage(driver);
        FAQPage = new P005FAQ(driver);
    }

    @Test
    public void TC001_validateEndToEndScenario() {
        landPage.checkLandingScreen(false);
        landPage.navigateToOtherProjects();
        landPage.backToMain();
        landPage.navigateToRegister();
        register.checkRegisterScreen(FIRST_NAME, LAST_NAME, MOBILE);
        landPage.backToMain();
        about.checkAboutScreen();
        landPage.backToMain();
        landPage.navigateToFAQs();
        FAQPage.checkFAQsScreen();
        landPage.backToMain();
        landPage.navigateToContactUs();
        contactUs.checkContactUsScreen(EMAIL, MOBILE, MESSAGE, NAME);
        landPage.backToMain();
        landPage.navigateToOtherProjects();
        projects.checkProjectsScreenInterestedAndReserve(FIRST_NAME, LAST_NAME, MOBILE);
        landPage.backToMain();
    }
    @Test
    public void TC002_VAlidateAllLinks() {
        landPage.checkLandingScreen(false);
        landPage.checkAllLinksBehavior();
    }

}
