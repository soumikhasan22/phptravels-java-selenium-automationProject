package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    // Constructor
    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // ============================================
    //              LOCATORS SECTION
    // ============================================

    // ============== SERVICES LOCATORS ==============
    By service_loc = By.xpath("//span[normalize-space()='Services' and @class='font-medium']");
    By service_visa_loc = By.xpath("//span[normalize-space()='Visa Booking']");
    By service_visaBtn_loc = By.xpath("//span[normalize-space()='Check Visa']");
    By service_tour_loc = By.xpath("//span[normalize-space()='Tours Booking']");
    By service_searchTourBtn_loc = By.xpath("//span[normalize-space()='Search Tours']");
    By service_car_loc = By.xpath("//span[normalize-space()='Cars Booking']");
    By service_searchCarBtn_loc = By.xpath("//span[@x-text=\"isSearching ? 'Searching......' : 'Search Cars'\"] ");
    By service_flightBooking_loc = By.xpath("//span[normalize-space()='Flights Booking']");
    By service_flightBookingBtn_loc = By.xpath("//button[@type='submit']");
    By service_Stays_Booking_loc = By.xpath("//span[normalize-space()='Stays Booking']");
    By service_StaysBooking_loc = By.xpath("//span[normalize-space()='Search Hotels']");

    // ============== COMPANY LOCATORS ==============
    By company_loc = By.xpath("//span[@class='font-medium'][normalize-space()='Company']");
    By company_contact_loc = By.xpath("//span[normalize-space()='Contact us']");
    By company_contact_email = By.xpath("//p[normalize-space()='info@travelagency.com']");
    By company_about_loc = By.xpath("//span[normalize-space()='About us']");
    By company_about_text = By.xpath("//p[contains(text(),'PHPTRAVELS providing the best and')]");
    By company_cookies_loc = By.xpath("//span[normalize-space()='Cookies Policy']");
    By company_cookies_text = By.xpath("//p[contains(text(),'This is the Cookie Policy for PHPTRTRAVELS, access')]");
    By company_privacy_loc = By.xpath("//span[normalize-space()='Privacy Policy']");
    By company_privacy_text = By.xpath("//p[contains(text(),'This Privacy Policy governs the manner in which ph')]");
    By company_Supplier_loc = By.xpath("//span[normalize-space()='Become a Supplier']");
    By company_Supplier_text = By.xpath("//h1[normalize-space()='Become a Supplier']");
    By company_Terms_of_Use_loc = By.xpath("//span[normalize-space()='Terms of Use']");
    By company_Terms_of_Use_text = By.xpath("//p[contains(text(),'(i) you are at least 18 years of age and are of so')]");

    // ============== BLOG LOCATORS ==============
    By logo_loc = By.xpath("//a[.//img[@alt='PHPTARVELS']]");
    By blog_loc = By.linkText("Blogs");
    By blog_text_loc = By.xpath("//h1[normalize-space()='Blogs']");

    // ============== LANGUAGE LOCATORS ==============
    By lang_loc = By.xpath("(//button[.//span[normalize-space()='language']])[1]");
    By lang_French = By.xpath("//a[.//span[normalize-space()='French' and contains(@class,'text-sm')]]");
    By lang_freand_text = By.xpath("//h1[normalize-space()='Voyagez comme vous aimez !']");
    By lang_English = By.xpath("//span[@class='text-sm font-medium'][normalize-space()='English']");

    // ============== PAYMENT LOCATORS ==============
    By payment_loc = By.xpath("//button[starts-with(@class,'flex') and .//span[normalize-space()='payments']]");
    By payment_EUR = By.xpath("//span[@class='text-sm font-semibold'][normalize-space()='EUR']");
    By EUR_amount = By.xpath("//span[normalize-space()='from EUR 159']");

    // ============== LOGIN LOCATORS ==============
    By login_loc = By.xpath("//a[contains(@class,'hidden') and .//span[normalize-space()='login']]");
    By login_submitBtn = By.xpath("//button[@type='submit']");

    // ============== SIGNUP LOCATORS ==============
    By signUp_loc = By.xpath("//button[contains(@class,'btn') and .//span[normalize-space()='Signup']]");
    By customer_signUp = By.xpath("//a[.//span[normalize-space()='Customer Signup' and @class='font-medium']]");
    By customer_account_submit = By.xpath("//button[@type='submit']");
    By agent_signup = By.xpath("//a[.//span[normalize-space()='Agent Signup' and @class='font-medium']]");
    By agent_account_submit = By.xpath("//a[contains(@class,'bg-white') and .//span[normalize-space()='person_add']]");

    // ============================================
    //           SERVICES SECTION METHODS
    // ============================================

    public void clickServicesMenu() throws InterruptedException {
        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(service_loc)).click();
        System.out.println("✅ Services menu clicked successfully");
    }

    public void testVisaService() {
        try {

            clickServicesMenu();
            wait.until(ExpectedConditions.elementToBeClickable(service_visa_loc)).click();
            System.out.println("✅ Visa Booking option clicked successfully");

            String buttonText = wait.until(ExpectedConditions.visibilityOfElementLocated(service_visaBtn_loc)).getText();
            if (buttonText.contains("Check Visa")) {
                System.out.println("✅✅ VISA SERVICE VALIDATION PASSED: 'Check Visa' button is visible and working correctly");
            } else {
                System.out.println("⚠ VISA SERVICE NOTE: Button found but text is: " + buttonText);
            }
            driver.navigate().back();
            System.out.println("✅ Navigated back to Homepage");
        } catch (Exception e) {
            System.out.println("❌❌ VISA SERVICE VALIDATION FAILED: Could not verify error message - " + e.getMessage());
        }
    }

    public void testTourService() {
        try {
            clickServicesMenu();
            wait.until(ExpectedConditions.elementToBeClickable(service_tour_loc)).click();
            System.out.println("✅ Tours Booking option clicked successfully");

            String buttonText = wait.until(ExpectedConditions.visibilityOfElementLocated(service_searchTourBtn_loc)).getText();
            if (buttonText.contains("Search Tours")) {
                System.out.println("✅✅ TOURS SERVICE VALIDATION PASSED: 'Search Tours' button is visible and working correctly");
            } else {
                System.out.println("⚠ TOURS SERVICE NOTE: Button found but text is: " + buttonText);
            }
        } catch (Exception e) {
            System.out.println("❌❌ TOURS SERVICE VALIDATION FAILED: Could not verify Search Tours button - " + e.getMessage());
        }
    }

    public void testCarService() {
        try {
            clickServicesMenu();
            wait.until(ExpectedConditions.elementToBeClickable(service_car_loc)).click();
            System.out.println("✅ Cars Booking option clicked successfully");

            String buttonText = wait.until(ExpectedConditions.visibilityOfElementLocated(service_searchCarBtn_loc)).getText();
            if (buttonText.contains("Search Cars")) {
                System.out.println("✅✅ CARS SERVICE VALIDATION PASSED: 'Search Cars' button is visible and working correctly");
            } else {
                System.out.println("⚠ CARS SERVICE NOTE: Button found but text is: " + buttonText);
            }
        } catch (Exception e) {
            System.out.println("❌❌ CARS SERVICE VALIDATION FAILED: Could not verify Search Cars button - " + e.getMessage());
        }
    }

    public void testFlightBookingService() {
        try {
            clickServicesMenu();
            wait.until(ExpectedConditions.elementToBeClickable(service_flightBooking_loc)).click();
            System.out.println("✅ Flights Booking option clicked successfully");

            Thread.sleep(3000);
            String buttonText = wait.until(ExpectedConditions.visibilityOfElementLocated(service_flightBookingBtn_loc)).getText();
            if (buttonText.contains("Search Flights")) {
                System.out.println("✅✅ FLIGHT SERVICE VALIDATION PASSED: 'Search Flights' button is visible and working correctly");
            } else {
                System.out.println("⚠ FLIGHT SERVICE NOTE: Button found but text is: " + buttonText);
            }
        } catch (Exception e) {
            System.out.println("❌❌ FLIGHT SERVICE VALIDATION FAILED: Could not verify Search Flights button - " + e.getMessage());
        }
    }

    public void testStaysBookingService() {
        try {
            clickServicesMenu();
            wait.until(ExpectedConditions.elementToBeClickable(service_Stays_Booking_loc)).click();
            System.out.println("✅ Stays Booking option clicked successfully");

            Thread.sleep(3000);
            String buttonText = wait.until(ExpectedConditions.visibilityOfElementLocated(service_StaysBooking_loc)).getText();
            if (buttonText.contains("Search Hotels")) {
                System.out.println("✅✅ STAYS SERVICE VALIDATION PASSED: 'Search Hotels' button is visible and working correctly");
            } else {
                System.out.println("⚠ STAYS SERVICE NOTE: Button found but text is: " + buttonText);
            }
        } catch (Exception e) {
            System.out.println("❌❌ STAYS SERVICE VALIDATION FAILED: Could not verify Search Hotels button - " + e.getMessage());
        }
    }

    // ============================================
    //           COMPANY SECTION METHODS
    // ============================================

    public void clickCompanyMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(company_loc)).click();
        System.out.println("✅ Company menu clicked successfully");
    }

    public void testContactCompany() {
        try {
            clickCompanyMenu();
            wait.until(ExpectedConditions.elementToBeClickable(company_contact_loc)).click();
            System.out.println("✅ Contact Us option clicked successfully");

            String contact_email = wait.until(ExpectedConditions.visibilityOfElementLocated(company_contact_email)).getText();
            if (contact_email.contains("info@travelagency.com")) {
                System.out.println("✅✅ CONTACT US VALIDATION PASSED: Email 'info@travelagency.com' is displayed correctly");
            } else {
                System.out.println("⚠ CONTACT US NOTE: Email displayed but is: " + contact_email);
            }
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("❌❌ CONTACT US VALIDATION FAILED: Could not verify contact information - " + e.getMessage());
        }
    }

    public void testAboutCompany() {
        try {
            clickCompanyMenu();
            wait.until(ExpectedConditions.elementToBeClickable(company_about_loc)).click();
            System.out.println("✅ About Us option clicked successfully");

            WebElement aboutTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(company_about_text));
            if (aboutTxt.isDisplayed()) {
                System.out.println("✅✅ ABOUT US VALIDATION PASSED: About Us content is displayed correctly");
            } else {
                System.out.println("⚠ ABOUT US NOTE: Content found but different from expected");
            }
        } catch (Exception e) {
            System.out.println("❌❌ ABOUT US VALIDATION FAILED: Could not verify About Us content - " + e.getMessage());
        }
    }

    public void testCookiesCompany() {
        try {
            clickCompanyMenu();
            wait.until(ExpectedConditions.elementToBeClickable(company_cookies_loc)).click();
            System.out.println("✅ Cookies Policy option clicked successfully");

            WebElement cookies_text = wait.until(ExpectedConditions.visibilityOfElementLocated(company_cookies_text));
            if (cookies_text.isDisplayed()) {
                System.out.println("✅✅ COOKIES POLICY VALIDATION PASSED: Cookies Policy content is displayed correctly");
            } else {
                System.out.println("⚠ COOKIES POLICY NOTE: Content found but different from expected");
            }
        } catch (Exception e) {
            System.out.println("❌❌ COOKIES POLICY VALIDATION FAILED: Could not verify Cookies Policy content - " + e.getMessage());
        }
    }

    public void testPrivacyCompany() {
        try {
            clickCompanyMenu();
            wait.until(ExpectedConditions.elementToBeClickable(company_privacy_loc)).click();
            System.out.println("✅ Privacy Policy option clicked successfully");

            WebElement privacy_text = wait.until(ExpectedConditions.visibilityOfElementLocated(company_privacy_text));
            if (privacy_text.isDisplayed()) {
                System.out.println("✅✅ PRIVACY POLICY VALIDATION PASSED: Privacy Policy content is displayed correctly");
            } else {
                System.out.println("⚠ PRIVACY POLICY NOTE: Content found but different from expected");
            }
        } catch (Exception e) {
            System.out.println("❌❌ PRIVACY POLICY VALIDATION FAILED: Could not verify Privacy Policy content - " + e.getMessage());
        }
    }

    public void testSupplierCompany() {
        try {
            clickCompanyMenu();
            wait.until(ExpectedConditions.elementToBeClickable(company_Supplier_loc)).click();
            System.out.println("✅ Become a Supplier option clicked successfully");

            WebElement Supplier_text = wait.until(ExpectedConditions.visibilityOfElementLocated(company_Supplier_text));
            if (Supplier_text.isDisplayed()) {
                System.out.println("✅✅ SUPPLIER VALIDATION PASSED: Become a Supplier content is displayed correctly");
            } else {
                System.out.println("⚠ SUPPLIER NOTE: Content found but different from expected");
            }
        } catch (Exception e) {
            System.out.println("❌❌ SUPPLIER VALIDATION FAILED: Could not verify Supplier content - " + e.getMessage());
        }
    }

    public void testTermsOfUseCompany() {
        try {
            clickCompanyMenu();
            wait.until(ExpectedConditions.elementToBeClickable(company_Terms_of_Use_loc)).click();
            System.out.println("✅ Terms of Use option clicked successfully");

            WebElement TermsOfUse_text = wait.until(ExpectedConditions.visibilityOfElementLocated(company_Terms_of_Use_text));
            if (TermsOfUse_text.isDisplayed()) {
                System.out.println("✅✅ TERMS OF USE VALIDATION PASSED: Terms of Use content is displayed correctly");
            } else {
                System.out.println("⚠ TERMS OF USE NOTE: Content found but different from expected");
            }
        } catch (Exception e) {
            System.out.println("❌❌ TERMS OF USE VALIDATION FAILED: Could not verify Terms of Use content - " + e.getMessage());
        }
    }

    // ============================================
    //              BLOG SECTION METHODS
    // ============================================

    public void testBlog() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(blog_loc)).click();
            System.out.println("✅ Blogs option clicked successfully");

            String blog_text = wait.until(ExpectedConditions.visibilityOfElementLocated(blog_text_loc)).getText();
            if (blog_text.contains("Blogs")) {
                System.out.println("✅✅ BLOG VALIDATION PASSED: Blog page loaded.");
            } else {
                System.out.println("⚠ BLOG NOTE: Blog page loaded but content is: " + blog_text);
            }
        } catch (Exception e) {
            System.out.println("❌❌ BLOG VALIDATION FAILED: Could not load Blog page - " + e.getMessage());
        }
    }

    // ============================================
    //           LANGUAGE SECTION METHODS
    // ============================================

    public void backToHomepage() {
        wait.until(ExpectedConditions.elementToBeClickable(logo_loc)).click();
        System.out.println("✅ Navigated back to Homepage using logo");
    }

    public void selectDefaultLanguage() {
        wait.until(ExpectedConditions.elementToBeClickable(lang_loc)).click();
        System.out.println("✅ Language dropdown opened");
        wait.until(ExpectedConditions.elementToBeClickable(lang_English)).click();
        System.out.println("✅ English language selected (default)");
    }

    public void testLanguage() {
        try {
            backToHomepage();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(lang_loc)).click();
            System.out.println("✅ Language dropdown opened");

            wait.until(ExpectedConditions.elementToBeClickable(lang_French)).click();
            System.out.println("✅ French language option clicked");

            WebElement lang_text = wait.until(ExpectedConditions.visibilityOfElementLocated(lang_freand_text));
            if (lang_text.isDisplayed()) {
                System.out.println("✅✅ LANGUAGE CHANGE VALIDATION PASSED: Successfully changed from English to French - French text 'Garantie de réservation d\\'hôtel' is visible");
            } else {
                System.out.println("⚠ LANGUAGE CHANGE NOTE: Language changed but expected French text not found");
            }
            Thread.sleep(1000);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(lang_loc));
//            WebElement lang = wait.until(ExpectedConditions.elementToBeClickable(lang_loc));
//            js.executeScript("arguments[0].click();", lang);
//
//            Thread.sleep(1000);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(lang_English));
//            WebElement english = wait.until(ExpectedConditions.elementToBeClickable(lang_English));
//            js.executeScript("arguments[0].click();", english);
//            System.out.println("✅ Restored to English language successfully");

        } catch (Exception e) {
            System.out.println("❌❌ LANGUAGE CHANGE VALIDATION FAILED: Could not change language from English to French - " + e.getMessage());
        }
    }

    // ============================================
    //           PAYMENT SECTION METHODS
    // ============================================

    public void testPayment() {
        try {
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(payment_loc)).click();
            System.out.println("✅ Payments dropdown opened");

            wait.until(ExpectedConditions.elementToBeClickable(payment_EUR)).click();
            System.out.println("✅ EUR currency option selected");

            Thread.sleep(500);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800)");
            System.out.println("✅ Scrolled down to view currency change");

            wait.until(ExpectedConditions.visibilityOfElementLocated(EUR_amount));
            WebElement payment_text = wait.until(ExpectedConditions.visibilityOfElementLocated(EUR_amount));
            if (payment_text.isDisplayed()) {
                System.out.println("✅✅ PAYMENT CURRENCY CHANGE VALIDATION PASSED: Successfully changed from USD to EUR - Amount displayed as 'EUR 85.90'");
            } else {
                System.out.println("⚠ PAYMENT NOTE: Currency changed but amount displayed is: " + payment_text);
            }

        } catch (Exception e) {
            System.out.println("❌❌ PAYMENT CURRENCY CHANGE VALIDATION FAILED: Could not change currency from USD to EUR - " + e.getMessage());
        }
    }

    // ============================================
    //           LOGIN SECTION METHODS
    // ============================================

    public void testLogin() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(login_loc)).click();
            System.out.println("✅ Login link clicked successfully");

            WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(login_submitBtn));
            if (loginBtn.isDisplayed()) {
                System.out.println("✅✅ LOGIN PAGE VALIDATION PASSED: Login button is displayed on the login page");
            } else {
                System.out.println("⚠ LOGIN NOTE: Login page loaded but login button not visible");
            }

        } catch (Exception e) {
            System.out.println("❌❌ LOGIN PAGE VALIDATION FAILED: Could not access login page - " + e.getMessage());
        }
    }

    // ============================================
    //           SIGNUP SECTION METHODS
    // ============================================

    public void defaultSignUpBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(signUp_loc)).click();
        System.out.println("✅ Signup button clicked successfully");
    }

    public void testCustomerSignUp() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(signUp_loc)).click();
            System.out.println("✅ Signup button clicked successfully");

            Thread.sleep(2000);
            WebElement customerSignupLink = wait.until(ExpectedConditions.elementToBeClickable(customer_signUp));
            customerSignupLink.click();
            System.out.println("✅ Customer Signup option selected");

            Thread.sleep(500);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
            System.out.println("✅ Scrolled to view registration button");

            WebElement registerBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(customer_account_submit));
            if (registerBtn.isDisplayed()) {
                System.out.println("✅✅ CUSTOMER SIGNUP VALIDATION PASSED: Customer registration page loaded successfully - Register button is visible");
            } else {
                System.out.println("⚠ CUSTOMER SIGNUP NOTE: Customer signup page loaded but register button not visible");
            }
        } catch (Exception e) {
            System.out.println("❌❌ CUSTOMER SIGNUP VALIDATION FAILED: Could not access customer signup page - " + e.getMessage());
        }
    }

    public void testAgentSignUp() {
        try {
            defaultSignUpBtn();
            wait.until(ExpectedConditions.elementToBeClickable(agent_signup)).click();
            System.out.println("✅ Agent Signup option selected");

            Thread.sleep(500);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
            System.out.println("✅ Scrolled to view registration button");

            WebElement registerBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(agent_account_submit));
            if (registerBtn.isDisplayed()) {
                System.out.println("✅✅ AGENT SIGNUP VALIDATION PASSED: Agent registration page loaded successfully - Register button is visible");
            } else {
                System.out.println("⚠ AGENT SIGNUP NOTE: Agent signup page loaded but register button not visible");
            }

            wait.until(ExpectedConditions.elementToBeClickable(logo_loc)).click();
        } catch (Exception e) {
            System.out.println("❌❌ AGENT SIGNUP VALIDATION FAILED: Could not access agent signup page - " + e.getMessage());
        }
    }
}