package com.Rawaf.Pages;


import com.Rawaf.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class P001LandingPage extends PageBase {

    public P001LandingPage(WebDriver driver) {
        super(driver);
    }

    private final By Main = By.xpath("//a[normalize-space()='Home' or contains(text(),'الرئيسية')]");
    private final By About_Us = By.xpath("//a[normalize-space()='About Us' or contains(text(),'عن المنصة')]");
    private final By Projects = By.cssSelector("a[href='projects']");
    private final By FAQs = By.xpath("//a[normalize-space()='FAQs' or contains(text(),'الأسئلة الشائعة')]");
    private final By Contact_US = By.xpath("//a[normalize-space()='Contact Us' or contains(text(),'تواصل معنا')]");
    private final By Choose_Your_resident = By.xpath("//div[@class=\"text-4xl font-extrabold font-['loewr']\"]");
    private final By Welcome_Description = By.xpath("//div[@class='text-lg font-bold leading-loose text-center md:text-start']");
    private final By checkBox = By.xpath("//input[@type='checkbox']");
    private final By AllRadioBtn = By.xpath("//input[@value='ALL']");
    private final By RentRadioBTn = By.xpath("//input[@value='RENT']");
    private final By SaleRadioBtn = By.xpath("//input[@value='SALE']");
    private final By red_Icon = By.xpath("//div[@class='w-[8px] h-[8px] rounded-sm bg-red-500']");
    private final By How_it_Works = By.xpath("//div[contains(text(),'How platform works') or contains(text(),'كيف تعمل المنصة')]");
    private final By choose_your_unit = By.xpath("//div[contains(text(),'Choose your unit') or contains(text(),'اختر وحدتك')]");
    private final By pay_a_down_payment = By.xpath("//div[contains(text(),'Pay a down payment') or contains(text(),'ادفع العربون')]");
    private final By complete_procedure = By.xpath("//div[contains(text(),'Complete procedures and receive it') or contains(text(),'اكمل إجراءاتها واستلمها')]");
    private final By chooseLogo = By.xpath("(//*[name()='svg'][contains(@class,'w-10 h-10')])[1]");
    private final By payLogo = By.xpath("(//*[name()='svg'][@class='w-10 h-10'])[2]");
    private final By completeLogo = By.xpath("(//*[name()='svg'][@class='w-10 h-10'])[3]");
    private final By Partners = By.xpath("//div[contains(text(),'Rawaf Partners') or contains(text(),'شركاء النجاح')]");
    private final By AjlanImg = By.xpath("//img[contains(@alt,'Al Ajlan')]");
    private final By BuatImg = By.xpath("//img[@alt='Al Buat']");
    private final By SaqeefahImg = By.xpath("//img[@alt='Al Saqeefah']");
    private final By ProjectsTitle = By.xpath("//div[@class=\"grow shrink basis-0 text-[#EEEFF6] text-[28px] font-bold font-['Loew Next Arabic']\"]");
    private final By OtherProjectLink = By.xpath("//a[@class=\"text-right hidden lg:flex items-center gap-1 text-amber-400 text-[22px] font-bold font-['Loew Next Arabic'] leading-[34px]\"]");
    private final By FirstProject = By.xpath("(//img[contains(@alt,'العجلان ريڤييرا')])[1]");
    private final By SecondProject = By.xpath("(//img[contains(@alt,'دار بيات للتطوير والاستثمار العقاري')])[1]");
    private final By ThirdProject = By.xpath("(//img[contains(@alt,'دار بيات للتطوير والاستثمار العقاري')])[3]");
    private final By Register = By.xpath("//div[@class=\"text-center text-white text-base font-bold font-['Loew Next Arabic'] leading-7\"]");
private final By OtherProjectsArrow = By.linkText("بقية المشاريع");

    private void checkEachElement(By by) {
        scrollToElement(by);
        Assert.assertTrue(assertElementDisplayed(by));
    }

    public void checkLandingScreen() {
        clickOnelement(language);
        checkWelcomeSection();
        checkMapSection();
        howWorksSection();
        checkProjectsSection();
        checkOtherProjectsNavigation();
        checkPartnersSection();
        checkRegisterSection();
        checkRegisterNavigation();
    }

    private void checkWelcomeSection() {
        checkEachElement(Main);
        checkEachElement(About_Us);
        checkEachElement(Projects);
        checkEachElement(FAQs);
        checkEachElement(Contact_US);
        checkEachElement(Choose_Your_resident);
        Assert.assertTrue(checkForLocalization(Choose_Your_resident, "Empower Your Residence", "تخيَّر مسكنك"));
        checkEachElement(Welcome_Description);
        Assert.assertTrue(checkForLocalization(Welcome_Description, "A platform that displays units and offers paymen",
                "منصة تعرض الوحدات و توفر لك الدفع في مكان واحد من خلال تجربة ثرية ومتكاملة"));
    }

    private void checkMapSection() {
        checkEachElement(checkBox);
        checkEachElement(AllRadioBtn);
        checkEachElement(RentRadioBTn);
        checkEachElement(SaleRadioBtn);
        checkFilterMAp();
    }

    private void checkFilterMAp() {
        clickOnelement(checkBox);
        Assert.assertTrue(assertElementDisplayed(red_Icon));
        clickOnelement(RentRadioBTn);
        clickOnelement(SaleRadioBtn);
        clickOnelement(AllRadioBtn);
    }

    private void howWorksSection() {
        checkEachElement(How_it_Works);
        checkEachElement(choose_your_unit);
        checkEachElement(pay_a_down_payment);
        checkEachElement(complete_procedure);
        checkEachElement(chooseLogo);
        checkEachElement(payLogo);
        checkEachElement(completeLogo);

    }

    private void checkProjectsSection() {
        checkEachElement(ProjectsTitle);
        Assert.assertTrue(checkForLocalization(ProjectsTitle, "Projects", "المشاريع"));
        checkEachElement(OtherProjectLink);
        Assert.assertTrue(checkForLocalization(OtherProjectLink, "Other Projects", "بقية المشاريع"));
        checkEachElement(FirstProject);
        checkEachElement(SecondProject);
        checkEachElement(ThirdProject);
    }
    private final By ProjectsMessage = By.xpath("//div[@class=\"self-stretch text-slate-500 text-base font-medium font-['Loew Next Arabic'] leading-7\"]");
    private void checkOtherProjectsNavigation(){
        waitForVisibilityOfElement(OtherProjectLink);
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.getStackTrace();
        }
        driver.findElement(By.xpath("//a[contains(@class, 'text-right') and @href='/projects']")).click();
        Assert.assertTrue(assertElementDisplayed(ProjectsMessage));
        Assert.assertTrue(checkForLocalization(ProjectsMessage,"At Rawaf, we provide a group of real estate residential projects for selling and renting units, with",
                "نوفر في رواف مجموعة من المشاريع العقارية لبيع وإيجار الوحدات السكنية مقدمة من شبكة من المطورين العقا"));
        clickOnelement(Main);
        waitForVisibilityOfElement(Choose_Your_resident);
    }


    private void checkPartnersSection() {
        checkEachElement(Partners);
        checkEachElement(AjlanImg);
        checkEachElement(BuatImg);
        checkEachElement(SaqeefahImg);
    }

    private void checkRegisterSection() {
        checkEachElement(Register);
        Assert.assertTrue(checkForLocalization(Register, "Register Interest", "تسجيل الإهتمام"));
    }
    private final By Register_Title = By.xpath("(//h1[contains(@class,'font-extrabold text-2xl text-[#525AA4]')])[1]");
    private void checkRegisterNavigation(){
        waitForVisibilityOfElement(Register);
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.getStackTrace();
        }
        By clickable = By.xpath("//a[contains(@href, '/Interest/0/0')]");
        driver.findElement(clickable).click();
        Assert.assertTrue(assertElementDisplayed(Register_Title));
        Assert.assertTrue(checkForLocalization(Register_Title,"Register Interest","تسجيل اهتمامك"));
        clickOnelement(Main);
        waitForInVisibilityOfElement(Choose_Your_resident);
    }
}


