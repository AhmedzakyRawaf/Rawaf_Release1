package com.Rawaf.testCases;

import com.Rawaf.Pages.P002AboutusPage;
import com.Rawaf.Pages.P005ContactUs;
import com.Rawaf.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class M002AboutUsTest extends BaseTest {
    P002AboutusPage about;

    @BeforeClass
    public void initiateObject() {
        about = new P002AboutusPage(driver);
    }
    @Test
    public void validateAboutScreen(){
        about.checkAboutScreen();
    }


}