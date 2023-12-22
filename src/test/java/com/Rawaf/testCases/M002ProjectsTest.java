package com.Rawaf.testCases;

import com.Rawaf.Pages.P001LandingPage;
import com.Rawaf.Pages.P002Projects;
import com.Rawaf.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class M002ProjectsTest extends BaseTest {
    P001LandingPage landPage;
    P002Projects projects;
    @BeforeClass
    public void initiateObject(){
        landPage = new P001LandingPage(driver);
        projects = new P002Projects(driver);
    }
    @Test
    public void validateProjectsScreen(){
        landPage.navigateToOtherProjects();
        projects.checkProjectsScreen();
    }
}
