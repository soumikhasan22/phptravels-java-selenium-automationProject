package TestCases;

import Pages.*;
import base.BaseClass;
import org.testng.annotations.*;

public class TestCases extends BaseClass {



    @BeforeClass
    public void start() {
        setup();
        driver.get("https://phptravels.net/");

        System.out.println("\n=== Test Started ===\n");
    }

    @Test
    public void HomepageTest() throws InterruptedException {

        HomePage  hp = new HomePage(driver, wait);

        // Services Test
        System.out.println("\n--- Testing Services ---");
        hp.clickServicesMenu();
        hp.testVisaService();
        hp.testTourService();
        hp.testCarService();
        hp.testFlightBookingService();
        hp.testStaysBookingService();
        System.out.println("--- Services Done ---\n");

        // Company Test
        System.out.println("--- Testing Company ---");
        Thread.sleep(1000);
        hp.testContactCompany();
        Thread.sleep(1000);
        hp.testAboutCompany();
        Thread.sleep(1000);
        hp.testCookiesCompany();
        Thread.sleep(1000);
        hp.testPrivacyCompany();
        Thread.sleep(1000);
        hp.testSupplierCompany();
        Thread.sleep(1000);
        hp.testTermsOfUseCompany();
        Thread.sleep(1000);
        System.out.println("--- Company Done ---\n");

        // Other Tests
        System.out.println("--- Other Features ---");
        hp.testBlog();
        hp.testLanguage();
        hp.selectDefaultLanguage();
        hp.testPayment();
        hp.testLogin();
        Thread.sleep(2000);
        hp.testCustomerSignUp();
        hp.testAgentSignUp();
        System.out.println("--- Other Features Done ---\n");




        System.out.println("=== Homepage Test Done All ===\n");
    }

    @Test
    public void testSignUp() throws InterruptedException {

        //Customer SignUp

        System.out.println("--- Testing Customer Signup Page ---");
        CustomerSignup_Page csp=new CustomerSignup_Page(driver,wait);
        csp.navigateToCustomerSignUp();
        csp.enterName("Soumik","Hasan");
        csp.enterEmail("customer2222@gmail.com");
        csp.enterPassword("123456");
        csp.securityAnswer();
        csp.clickAgree();
        csp.submit();

        System.out.println("--- Testing Customer Signup Page  Done---\n");

        Thread.sleep(1000);

        //Agent Signup

        System.out.println("--- Testing Agent Signup Page ---");
        AgentSignUp_Page asp=new AgentSignUp_Page(driver,wait);
        asp.navigateToAgentSignUp();
        asp.enterName("Soumik","Hasan");
        asp.enterEmail("agent2222@gmail.com");
        asp.enterPassword("123456");
        asp.securityAnswer();
        asp.clickAgree();
        asp.submit();
        System.out.println("--- Testing Agent Signup Page  Done---\n");
        System.out.println("=== SignUp Test Done All ===\n");


    }

//    @Test
//    public void emailVerification()
//    {
//        emailVerificationPage ep=new emailVerificationPage(driver,wait);
//        ep.navigateEmailAccount();
//        ep.enterEmailAddress("sakibsalim1999@gmail.com");
//        ep.enterPassword("12345@Sa");
//
//    }


    @Test
    public void testLogin() throws InterruptedException {
        System.out.println("--- Testing Login Page ---");
        LoginPage lp=new LoginPage(driver,wait,js);
        lp.clickLoginBtn();
        Thread.sleep(1000);
        lp.enterLoginEmail("agent2222@gmail.com");
        lp.enterLoginPassword("123456");
        lp.clickCheckBox();
        lp.submitLoginBtn();
        Thread.sleep(1000);
       lp.backToHomepage();
        System.out.println("--- Testing Login Page Done ---\n");

    }

    @Test
    public void testVisa() throws InterruptedException {

        System.out.println("\n--- Testing Visa Page ---\n");

        VisaPage vp=new VisaPage(driver,wait,js);
        js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(1000);
        vp.navigateToVisa();
        vp.selectFormCountry("Bangladesh");
        vp.selectToCountry("Brazil");
        vp.selectVisaDate("23-08-2026");
        vp.testVisaType("Medical Visa");
        vp.testVisaProcessingSpeed("Super Rush");
        vp.testTravellerPerson(5);
        vp.testVisaCheck();
        vp.backToHomepage();
        System.out.println("\n--- Testing Visa Page Done ---\n");
    }

    @Test
    public void testTour() throws InterruptedException {

        System.out.println("\n--- Testing Tour Page ---\n");
        //js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);
        TourPage tp=new TourPage(driver,wait,js);
        tp.navigateToTour();
        tp.selectDestination("Saidpur");
        tp.selectTourStartDate(31,"August",2027);
        tp.selectTourDuration("4-7 Days");
        tp.selectTourType("Historical");
        tp.selectTravellersNumber("Adults", 5);
        tp.selectTravellersNumber("Children", 5);
        tp.submitTourSearch();
        tp.backToHomepage();



        System.out.println("\n--- Testing Tour Page Done ---\n");
    }

    @Test
    public void testCar() throws InterruptedException {

        System.out.println("\n--- Testing Car Page ---\n");
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);
        CarPage cp=new CarPage(driver,wait,js);
        cp.navigateToCar();
        cp.selectPickup_cityOrAirport("Dhaka");
        cp.selectReturn_cityOrAirport();
        cp.selectPickUpDate(25,"December",2027);
        cp.dropOffDate(22,"March",2028);
        cp.selectPickUpTime(12,20);
        cp.selectDropOffTime();
        cp.selectServiceType("Airport Transfer");
        cp.selectToCity("Dubai");
        cp.selectDriverAge("18-20 years Old");
        cp.selectTraveller(2);
        cp.selectSubmitCar();
        cp.backToHomepage();

        System.out.println("\n--- Testing Car Page Done ---\n");
    }

    @Test
    public void testFlight() throws InterruptedException {

        System.out.println("\n--- Testing Flight Page ---\n");

        js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(2000);
        FlightPage fp=new FlightPage(driver,wait,js);

        fp.navigateToFlight();
        fp.selectDeparture("Dhaka");
        fp.selectArriveT0("Brazil");
        fp.selectDepartureDate(12,"June",2027);
        fp.selectFlightType("Round Trip");
        fp.selectReturnDate(22,"December",2027);
        fp.selectFlightClass("Business");
        fp.selectTravellersNumber("Adults", 4);
        fp.selectTravellersNumber("Children", 6);
        fp.selectTravellersNumber("Infants", 2);
        fp.selectSubmitFlight();
        fp.backToHomepage();



        System.out.println("\n--- Testing Flight Page Done ---\n");
    }


    @Test
    public void testStay() throws InterruptedException {

        System.out.println("\n--- Testing Stay Page ---\n");

        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);
        StayPage sp=new StayPage(driver,wait,js);
        sp.navigateToStays();
        sp.selectDestinationOrHotel("Dhaka");
        sp.selectCheckInDate(22,"December",2026);
        sp.selectCheckOutDate(22,"December",2027);
        int[] ages = {1,2,3,5,6,3};
        sp.selectGuestAndRoom(4,4,6,ages);
        js.executeScript("window.scrollBy(0,-400)");
        sp.selectNationality("Bangladesh");
        sp.submitStay();
        sp.backToHomepage();



        System.out.println("\n--- Testing Stay Page Done ---\n");
    }



        @AfterClass
        public void close() throws InterruptedException {
            System.out.println("\n=== Test Finished ===\n");
            closeBrowser();
        }
    }