package com.Rawaf.Pages;

import com.Rawaf.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class P002OtherProjects extends PageBase {
    public P002OtherProjects(WebDriver driver) {
        super(driver);
    }

    P001LandingPage land;

    P003Register register;
    public List<String> unit_id = new ArrayList<>();
    public String Project_id = "";
    P007UnitsResponseChecks response;
    public int project_index = 0;


    private final By Sale = By.xpath("//div[contains(text(),'Sale') or contains(text(),'للبيع')]");
    private final By Rent = By.xpath("//div[contains(text(),'Rent') or contains(text(),'إيجار')]");
    private final By Reset = By.xpath("(//div[contains(@class,'outline-none text-[#3B45B2] font-bold cursor-pointer mx-2')])[1]");
    private final By District = By.xpath("//button[normalize-space()='District' or contains(text(),'الحي')]");
    private final By Aohod = By.xpath("//li[contains(text(),'أحد')]");
    private final By Nmar = By.xpath("//li[contains(text(),'نمار')]");
    private final By Narjes = By.xpath("//li[contains(text(),'النرجس')]");
    private final By Qods = By.xpath("//li[contains(text(),'القدس')]");
    private final By Search = By.xpath("//input[@placeholder='Search ...' or contains(@placeholder,'بحث ...')]");
    private final By Message = By.xpath("(//div[@class='grid w-full grid-cols-1 gap-6 md:grid-cols-2 xl:grid-cols-3 2xl:grid-cols-3'])[1]");
    private final By Logo = By.xpath("(//*[name()='svg'])[1]");
    private final By APARTMENT = By.xpath("//input[@value='APARTMENT']");
    private final By All_Units = By.xpath("//input[@value='ALL']");
    private final By Search_on_units = By.xpath("//div[@class=\"text-center text-white text-base font-bold font-['Loew Next Arabic'] leading-7\"]");
    private final By Select_Floor = By.xpath("(//select[@id='floor'])[2]");
    private final By Select_Building = By.xpath("(//select[@id='floor'])[1]");
    private final By First_Unit = By.xpath("//a[1]//div[1]//div[1]//div[1]//img[1]");
    private final By view = By.xpath("//button[normalize-space()='View' or contains(text(),'عرض')]");
    private final By Units = By.xpath("//div[contains(text(),'Multiple Floors') or contains(text(),'أدوار متعددة')]");
    private final By Warning_Message = By.xpath("//div[@class=\"text-center text-orange-500 text-xs font-extrabold font-['Loew Next Arabic'] leading-none\"]");
    private final By Unit_Price = By.xpath("//div[@class=\"229000 text-indigo-800 text-3xl font-bold font-['Loew Next Arabic']\"]");
    private final By Reserve_Unit = By.xpath("//div[contains(@class,\"text-white text-lg font-bold font-['Loew Next Arabic'] leading-loose\")]");
    private final By Reserve_Message = By.xpath("//div[@class=\" self-stretch text-primary-400 text-lg font-medium font-['Loew Next Arabic'] leading-loose\"]");
    private final By Down_Payment = By.xpath("//div[@class=\"000 text-yellow-600 text-xl md:text-3xl font-bold font-['Loew Next Arabic']]\"]");
    private final By Cash = By.xpath("//input[@value='CASH']");
    private final By Agree_Terms = By.xpath("//input[@name='agreeToTerms']");
    private final By mobileNumber = By.xpath("//input[@name='depositPhoneNumber']");
    private final By VerifyReserve = By.xpath("//button[normalize-space()='Verify' or contains(text(),'تحقق من الجوال')]");
    private final By Invoice_Header = By.xpath("//h5[@id='invoiceModalLabel']");
    private final By Payment_Amount = By.xpath("(//td[@class='py-0 cell-fixed text-end'])[1]");
    private final By Payment_CTA = By.xpath("//a[@id='payBtn']");
    private final By View_Invoice = By.xpath("//button[normalize-space()='View Invoice']");
    private final By Price_Into_View_Invoice = By.xpath("//td[@class='text-end']");
    private final By Close_View_Invoice = By.xpath("//img[@alt='close invoice']");
    private final By Input_Card_Name = By.xpath("//input[@id='holderName']");
    private final By Input_Card_email = By.xpath("//input[@id='customer-email']");
    private final By Input_Card_Number = By.xpath("//input[@id='number']");
    private final By Input_Card_Expiry_Month = By.xpath("//input[@id='expmonth']");
    private final By Input_Card_Expiry_Year = By.xpath("//input[@id='expyear']");
    private final By Input_Card_CVV = By.xpath("//input[@id='cvv']");
    private final By amount_into_card = By.xpath("//div[@id='pt_label_amount']");
    private final By Do_Pay = By.xpath("//button[@id='payBtn']");
    private final By Authenticate = By.xpath("//input[@value='Authenticated']");
    private final By real_estate = By.xpath("//input[@name='paymentTypeCode']");


    private void checkElementsDisplayed() {
        waitForTime(5000);
        Assert.assertTrue(assertElementDisplayed(Rent));
        Assert.assertTrue(assertElementDisplayed(Sale));
        Assert.assertTrue(assertElementDisplayed(Reset));
        Assert.assertTrue(assertElementDisplayed(District));
        Assert.assertTrue(assertElementDisplayed(Search));
        Assert.assertTrue(checkForLocalization(Reset, "Reset Filters", "إعادة تعيين"));

    }

    public void checkProjectsScreenInterestedAndReserve(int unit,  Boolean isAuth, String firstname, String lastname, String mobile) {
        String phone = "0561" + generateRandomDigits(6);
        prepareUnitBeforeReservation(unit,firstname, lastname, phone);
        response = new P007UnitsResponseChecks();
        response.testGetPropertyDetails("AVAILABLE", Project_id, Integer.parseInt(unit_id.get(unit)));
        checkReserveUnit(firstname, lastname, phone);
        terminateReserveAndBackToProjects();
        response.testGetPropertyDetails("ON_HOLD", Project_id, Integer.parseInt(unit_id.get(unit)));
        prepareUnitBeforeReservation(unit + 1,firstname, lastname, phone);
        checkReserveUnit(firstname, lastname, phone);
        checkPaymentProcess(isAuth, "test rawaf", "test@test.test", "4000000000000002", "10", "26", "123");
        if (isAuth) {
            waitForTime(5000);
            response.testGetPropertyDetails("SOLD", Project_id, Integer.parseInt(unit_id.get(unit + 1)));
        } else {
            response.testGetPropertyDetails("AVAILABLE", Project_id, Integer.parseInt(unit_id.get(unit + 1)));
        }
        response.testGetPropertyDetails("AVAILABLE", Project_id, Integer.parseInt(unit_id.get(unit)));


    }
    private void prepareUnitBeforeReservation(int unit,String firstname, String lastname, String phone){
        checkElementsDisplayed();
        checkAllForSaleProjects();
        checkUnitsScreen();
        selectUnit(unit);
        checkSelectedUnit();
        checkRegisterInterest(unit,firstname, lastname, phone);
    }
    private void terminateReserveAndBackToProjects(){
        driver.navigate().back();
        driver.get("https://beta.rawaf.ai/projects");
        waitForTime(2000);
    }

    public void checkProjectsAndFilter() {
        checkElementsDisplayed();
        validateFilter();
    }

    private void validateFilter() {
        clickOnElement(District);
        waitForVisibilityOfElement(Nmar);
        Assert.assertTrue(assertElementDisplayed(Narjes));
        Assert.assertTrue(assertElementDisplayed(Qods));
        clickOnElement(Aohod);
        clickOnElement(Sale);
        scrollToElement(Message);
        Assert.assertTrue(assertElementDisplayed(Message));
        Assert.assertTrue(driver.findElement(Message).getText().contains("لا توجد مشاريع حاليًا تتوافق مع البحث الذي أدخلته."));
    }

    private void checkAllForSaleProjects() {
        scrollDown();
        List<WebElement> elements = driver.findElements(By.xpath("(//div[contains(text(),'بدأ البيع') or contains(text(),'Buy Now')])"));

        for (int i = 0; i < elements.size(); i++) {
            waitForVisibilityOfWebElement(elements.get(i));
            scrollToElement(elements.get(i));
            scrollToElement(elements.get(4));
            waitForVisibilityOfWebElement(elements.get(4));
            WebElement parentElement = elements.get(4).findElement(By.xpath(".."));
            WebElement parentElement2 = parentElement.findElement(By.xpath(".."));
            WebElement parentElement3 = parentElement2.findElement(By.xpath(".."));
            By clickable = By.xpath("//a[contains(@class, 'relative w-[335px] max-w-full overflow-hidden') and @href='" + getPAth(parentElement3.getAttribute("href")) + "']");
            scrollToElement(clickable);
            Project_id = extractLatestIntegerAsString(getPAth(parentElement3.getAttribute("href")));
            System.out.println("=============>" + Project_id);
            waitForTime(3000);
            driver.findElement(clickable).click();

            break;
        }
    }


    private void checkUnitsScreenElements() {
        waitForTime(3000);
        Assert.assertTrue(assertElementDisplayed(Logo));
        checkEachElement(Search_on_units);
        checkEachElement(APARTMENT);
        checkEachElement(All_Units);
        checkEachElement(Select_Building);
        checkEachElement(Select_Floor);
    }

    private void checkEachElement(By by) {
        scrollToElement(by);
        Assert.assertTrue(assertElementDisplayed(by));
    }

    private void checkFilterBehavior() {
        DoFilter("0", APARTMENT);
        DoFilter("0", All_Units);

    }

    private void DoFilter(String index, By by) {
        waitForTime(2000);
        scrollToElement(APARTMENT);
        driver.findElement(by).click();
        scrollToElement(Select_Floor);
        selectByIndexFromDropDownList(Select_Floor, index);
        selectByIndexFromDropDownList(Select_Building, index);
        clickOnElement(Search_on_units);
        Assert.assertTrue(assertElementDisplayed(Logo));
    }

    private void checkUnitsScreen() {
        checkUnitsScreenElements();
        checkFilterBehavior();
    }

    private void selectUnit(int index) {
        By specific_Unit = By.xpath("//a[" + (index+1) + "]//div[1]//div[1]//div[1]//img[1]");
        waitForTime(2000);
        scrollToElement(view);
        Assert.assertTrue(assertElementDisplayed(view));
        List<WebElement> elements = driver.findElements(Units);
        System.out.println("number of units====> " + elements.size());
        for (int i = 1; i <= elements.size(); i++) {
            scrollToElementTop(By.xpath("//a[" + i + "]//div[1]//div[1]//div[1]//img[1]"));
        }
        if (index < elements.size()) {
            scrollToElementTop(specific_Unit);
            waitForTime(2000);
            driver.findElement(specific_Unit).click();
        } else {
            scrollToElement(First_Unit);
            waitForTime(2000);
            driver.findElement(First_Unit).click();
        }
        unit_id.add(extractLatestIntegerAsString(driver.getCurrentUrl()));
        System.out.println("=======>" + unit_id);
    }

    private void checkSelectedUnit() {
        Assert.assertTrue(assertElementDisplayed(Warning_Message));
        Assert.assertTrue(checkForLocalization(Warning_Message, "The final unit may vary slightly from the design shown in the images above"
                , "قد يختلف المنتج النهائي اختلاف بسيط عن التصميم الموضح في الصور أعلاه"));
        checkEachElement(Unit_Price);
        System.out.println(driver.findElement(Unit_Price).getText());
        checkEachElement(Reserve_Unit);
        Assert.assertTrue(checkForLocalization(Reserve_Unit, "Reserve Unit", "احجز الوحدة"));
    }

    private void checkRegisterInterest(int index ,String firstname, String lastname, String mobile) {
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.getStackTrace();
        }
        checkEachElement(By.xpath("//a[contains(@class, 'MainButtonUse') and @href='/Interest/" + Project_id + "/" + unit_id.get(index) + "']"));
        Assert.assertTrue(checkForLocalization(By.xpath("//a[contains(@class, 'MainButtonUse') and @href='/Interest/" + Project_id + "/" + unit_id.get(index)  + "']"), "Register interest"
                , "سجل اهتمامك للوحدة"));
        clickOnElement(By.xpath("//a[contains(@class, 'MainButtonUse') and @href='/Interest/" + Project_id + "/" + unit_id.get(index)  + "']"));
        register = new P003Register(driver);
        register.checkRegisterScreen(firstname, lastname, mobile);
        waitForTime(2000);
        scrollUpToElement(Reserve_Unit);
        Assert.assertTrue(assertElementDisplayed(Reserve_Unit));

    }

    private void checkReserveUnit(String firstname, String lastname, String mobile) {
        waitForTime(5000);
        clickOnElement(Reserve_Unit);
        Assert.assertTrue(assertElementDisplayed(Reserve_Message));
        Assert.assertTrue(checkForLocalization(Reserve_Message, "You must complete the payment process to reserve the unit", "يجب عليك إكمال عملية الدفع لحجز الوحدة"));
        checkEachElement(Down_Payment);
        String Down_Payment_Value = driver.findElement(Down_Payment).getText();
        System.out.println(Down_Payment_Value);
        fillReserveForm(firstname, lastname, mobile);
        List<WebElement> cahses = driver.findElements(Cash);
        if (cahses.isEmpty()) {
            clickOnElement(real_estate);
        } else {
            checkEachElement(Cash);
            clickOnElement(Cash);
        }
        checkEachElement(Agree_Terms);
        startReserveUnit();
        Assert.assertTrue(assertElementDisplayed(By.xpath("//p[@class='mt-2 text-xs font-medium text-red-500']")));
        Assert.assertTrue(checkForLocalization(By.xpath("//p[@class='mt-2 text-xs font-medium text-red-500']"),
                "Must agree on terms and condition", "يجب الموافقة على الشروط والأحكام"));
        clickOnElement(Agree_Terms);
        startReserveUnit();
        register.insertOtc();
    }

    private void startReserveUnit() {
        waitForTime(3000);
        checkEachElement(VerifyReserve);
        clickOnElement(VerifyReserve);
    }

    private void fillReserveForm(String firstname, String lastname, String mobile) {
        checkEachElement(register.Input_First_Name);
        sendTextToInputField(firstname, register.Input_First_Name);
        checkEachElement(register.Input_Last_Name);
        sendTextToInputField(lastname, register.Input_Last_Name);
        checkEachElement(mobileNumber);
        sendTextToInputField(mobile, mobileNumber);
    }

    private void checkFirstInvoiceScreen() {
        Assert.assertTrue(assertElementDisplayed(Invoice_Header));
        checkEachElement(Payment_Amount);
        String PaymentAmountIntoFirstInvoice = driver.findElement(Payment_Amount).getText();
        System.out.println(PaymentAmountIntoFirstInvoice);
        scrollToElement(Payment_CTA);
        clickOnElement(Payment_CTA);
        Assert.assertTrue(assertElementDisplayed(View_Invoice));
    }

    private void checkViewInvoice() {
        clickOnElement(View_Invoice);
        Assert.assertTrue(assertElementDisplayed(Price_Into_View_Invoice));
        String PriceIntoViewInvoice = driver.findElement(Price_Into_View_Invoice).getText();
        System.out.println(PriceIntoViewInvoice);
        clickOnElement(Close_View_Invoice);
        Assert.assertTrue(assertElementDisplayed(Input_Card_Name));

    }

    private void fillCardDetails(String name, String mail, String number, String month, String year, String CVV) {
        scrollToElement(Input_Card_Name);
        sendTextToInputField(name, Input_Card_Name);
        scrollToElement(Input_Card_email);
        sendTextToInputField(mail, Input_Card_email);
        scrollToElement(Input_Card_Number);
        sendTextToInputField(number, Input_Card_Number);
        scrollToElement(Input_Card_Expiry_Month);
        sendTextToInputField(month, Input_Card_Expiry_Month);
        scrollToElement(Input_Card_Expiry_Year);
        sendTextToInputField(year, Input_Card_Expiry_Year);
        scrollToElement(Input_Card_CVV);
        sendTextToInputField(CVV, Input_Card_CVV);
        scrollToElement(amount_into_card);
        String amountIntoCard = driver.findElement(amount_into_card).getText();
        System.out.println(amountIntoCard);

    }

    private void checkDoPay(Boolean isAuth) {
        scrollToElement(Do_Pay);
        clickOnElement(Do_Pay);
        if (isAuth) {
            try {
                Assert.assertTrue(assertElementDisplayed(Authenticate));
                clickOnElement(Authenticate);
            } catch (Exception e) {
                e.getStackTrace();
            }
        } else {
            try {
                Assert.assertTrue(assertElementDisplayed(By.xpath("//input[@value='Rejected']")));
                clickOnElement(By.xpath("//input[@value='Rejected']"));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    private void checkPaymentProcess(Boolean isAuth, String name, String mail, String number, String month, String year, String CVV) {
        checkFirstInvoiceScreen();
        checkViewInvoice();
        fillCardDetails(name, mail, number, month, year, CVV);
        checkDoPay(isAuth);
        Assert.assertTrue(assertElementDisplayed(language));
    }


}
