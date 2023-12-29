package com.Rawaf.testCases;

import com.Rawaf.Pages.P001LandingPage;
import com.Rawaf.Pages.P002OtherProjects;
import com.Rawaf.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.Rawaf.testBase.ReadProperties.*;

public class M002OtherProjectsTest extends BaseTest {
    P001LandingPage landPage;
    P002OtherProjects projects;

    @BeforeClass
    public void initiateObject() {
        landPage = new P001LandingPage(driver);
        projects = new P002OtherProjects(driver);
    }

    @Test
    public void TC_01validateProjectsScreenWithAuth() {
        landPage.navigateToOtherProjects();
        projects.checkProjectsScreenInterestedAndReserve(0,false,FIRST_NAME, LAST_NAME, MOBILE);
    }
    @Test
    public void TC_02validateProjectsScreenWithoutAuth() {
        landPage.navigateToOtherProjects();
        projects.checkProjectsScreenInterestedAndReserve(0,true,FIRST_NAME, LAST_NAME, MOBILE);
    }
//    @Test
//    public void TC_03validateProjectsScreenAfterPaymentTermination() {
//        landPage.navigateToOtherProjects();
//        projects.checkProjectsScreenInterestedAndReserve(0,true,false,FIRST_NAME, LAST_NAME, MOBILE);
//    }
    @Test
    public void TC_03CheckProjectsFilter(){
        landPage.navigateToOtherProjects();
        projects .checkProjectsAndFilter();
        landPage.backToMain();
    }

}
