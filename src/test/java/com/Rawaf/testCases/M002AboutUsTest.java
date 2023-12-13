package com.Rawaf.testCases;

import com.Rawaf.Pages.P002AboutusPage;
import com.Rawaf.Pages.P005ContactUs;
import com.Rawaf.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class M002AboutUsTest extends BaseTest {
    P002AboutusPage AboutusPage;

    @BeforeClass
    public void initiateObject() {
        AboutusPage = new P002AboutusPage(driver);
    }

    @Test(groups = "AboutUs")
    public void TC_AboutUs03() {
        AboutusPage.checkAboutUsTab();
        AboutusPage.checkAboutUs();

    }
}