package com.Rawaf.testCases;

import com.Rawaf.Pages.P004AboutusPage;
import com.Rawaf.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class M004AboutUsTest extends BaseTest {
    P004AboutusPage about;

    @BeforeClass
    public void initiateObject() {
        about = new P004AboutusPage(driver);
    }

    @Test
    public void validateAboutScreen() {
        about.checkAboutScreen();
    }


}