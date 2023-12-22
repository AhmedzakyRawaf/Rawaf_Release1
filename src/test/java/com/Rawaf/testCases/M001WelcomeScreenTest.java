package com.Rawaf.testCases;

import com.Rawaf.Pages.P001LandingPage;
import com.Rawaf.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class M001WelcomeScreenTest extends BaseTest {
    P001LandingPage landPage;

    @BeforeClass
    public void initiateObject() {
        landPage = new P001LandingPage(driver);
    }

    @Test
    public void validateWelcomeScreen() {
        landPage.checkLandingScreen(false);
    }
}
