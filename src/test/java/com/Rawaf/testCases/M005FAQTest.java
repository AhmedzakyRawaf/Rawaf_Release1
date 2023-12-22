package com.Rawaf.testCases;

import com.Rawaf.Pages.P005FAQ;
import com.Rawaf.testBase.BaseTest;
import org.testng.annotations.BeforeClass;

public class M005FAQTest extends BaseTest {

    P005FAQ FAQPage;

    @BeforeClass
    public void initiateObject() {
        FAQPage = new P005FAQ(driver);
    }


}
