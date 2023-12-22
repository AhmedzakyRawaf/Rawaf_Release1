package com.Rawaf.testCases;

import com.Rawaf.Pages.P002AboutusPage;
import com.Rawaf.Pages.P003FAQ;
import com.Rawaf.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class P003FAQTest extends BaseTest {

    P003FAQ FAQPage;

    @BeforeClass
    public void initiateObject() {
        FAQPage = new P003FAQ(driver);
    }


}
