package com.Rawaf.testCases;

import com.Rawaf.Pages.P001LandingPage;
import com.Rawaf.Pages.P002OtherProjects;
import com.Rawaf.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class M002OtherProjectsTest extends BaseTest {
    P001LandingPage landPage;
    P002OtherProjects projects;

    @BeforeClass
    public void initiateObject() {
        landPage = new P001LandingPage(driver);
        projects = new P002OtherProjects(driver);
    }

    @Test
    public void validateProjectsScreen() {
        landPage.navigateToOtherProjects();
        projects.checkProjectsScreen();
        landPage.backToMain();
    }
}
