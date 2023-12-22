package com.Rawaf.testCases;

import com.Rawaf.Pages.P001LandingPage;
import com.Rawaf.Pages.P002OtherProjects;
import com.Rawaf.Pages.P003Register;
import com.Rawaf.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.Rawaf.testBase.ReadProperties.*;

public class M003RegisterTest extends BaseTest {
    P001LandingPage landPage;
    P003Register register;
    @BeforeClass
    public void initiateObject(){
        landPage = new P001LandingPage(driver);
        register = new P003Register(driver);
    }
    @Test
    public void validateProjectsScreen(){
        landPage.navigateToRegister();
        register.checkRegisterScreen(FIRST_NAME,LAST_NAME,MOBILE);
        landPage.backToMain();

    }
}
