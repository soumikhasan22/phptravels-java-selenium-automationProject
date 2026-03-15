package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Month;
import java.util.List;

public class VisaPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public VisaPage(WebDriver driver,WebDriverWait wait,JavascriptExecutor js)
    {
        this.driver=driver;
        this.wait=wait;
        this.js=js;
    }

    // ALL LOCATORS
    By visa_tab = By.xpath("//button[.//span[normalize-space()='Visa']]");

    //From country Locators
    By form_country = By.xpath("(//span[@x-text='getSelectedName()'][normalize-space()='Select Country'])[1]");
    By search_form_country = By.xpath("(//input[@type='text' and @placeholder='Search...'])[1]");

    //To country Locators
    By to_country = By.xpath("(//div[contains(@class,'input') and .//span[normalize-space()='Select Country']])[2]");
    By search_to_country = By.xpath("(//input[@type='text' and @placeholder='Search...'])[2]");

    //All countries List
    By all_country = By.xpath("//div[contains(@class,'input-dropdown-item ')]");

    //Visa Date Locators
    By visa_Date_tab = By.xpath("//input[@placeholder='Date']");
    By current_date_value = By.xpath("(//div[contains(@class,'datepicker-days')])[7]//th[contains(@class,'switch')]");
    By future_Date = By.xpath("(//div[contains(@class,'datepicker-days')])[7]//th[contains(@class,'next')]");
    By previous_Date = By.xpath("(//div[contains(@class,'datepicker-days')])[7]//th[contains(@class,'prev')]");
    By allDays = By.xpath("(//tbody)[19]");

    //Visa Type Locators
    By visa_type = By.xpath("//span[@x-text='getSelectedName()'][normalize-space()='Tourist Visa']");
    By visa_type_options = By.xpath("//div[@class='input-dropdown-content show']//span[@x-text='type.name']");

    //Visa Processing Speed Locators
    By visa_processing_speed = By.xpath("//span[normalize-space()='Standard']");
    By visa_processing_speed_options = By.xpath("//div[@class='input-dropdown-content show']//div[@x-text='speed.name']");

    //Traveller Locators
    By traveller = By.xpath("//span[@x-text='getTravelerText()']");
    By increment_traveller = By.xpath("//div[@class='flex items-center justify-between px-3 py-2']//button[.//span[text()='add']]");
    By body = By.tagName("body");

    //Submit Locators
    By submit_visaCheck = By.xpath("//button//span[contains(@x-text, 'Check Visa')]");
    By verify_submitText = By.xpath("//h1[contains(@class,'text-2xl')]");

    By logo_loc = By.xpath("//a[.//img[@alt='PHPTARVELS']]");
    By backMainPage=By.xpath("//a[contains(.,'Back to Search')]");


                                        //Action Methods

    public void navigateToVisa() throws InterruptedException {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(logo_loc)).click();
            Thread.sleep(1000);
            WebElement visaButton = wait.until(ExpectedConditions.elementToBeClickable(visa_tab));
            visaButton.click();
            System.out.println("✅ Visa Tab clicked Successfully.");
        }
        catch (Exception e)
        {
            System.out.println("❌ Visa Tab clicked Failed."+e.getMessage());
        }
    }

    public void selectFormCountry(String country)
    {
        try
        {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(form_country));
            dropdown.click();

            WebElement search=wait.until(ExpectedConditions.elementToBeClickable(search_form_country));
            search.sendKeys(country);
            List<WebElement> countries=driver.findElements(all_country);
            for(WebElement allCountry:countries)
            {
                String countryText = allCountry.getText().trim();
                if(countryText.contains(country))
                {
                    allCountry.click();
                }
            }
            System.out.println("✅ Visa from city '" + country + "' selected Successfully.");
        }
        catch(Exception e)
        {
            System.out.println("❌ Visa from city cannot be selected. Error: " + e.getMessage());
        }

    }


    public void selectToCountry(String country) throws InterruptedException {
        try
        {

            wait.until(ExpectedConditions.elementToBeClickable(to_country)).click();
            WebElement search=wait.until(ExpectedConditions.elementToBeClickable(search_to_country));
            search.sendKeys(country);
            List<WebElement> countries=driver.findElements(all_country);
            for(WebElement allCountry:countries)
            {
                String countryText = allCountry.getText().trim();
                if(countryText.contains(country))
                {
                    allCountry.click();
                }
            }
            System.out.println("✅ Visa to city '" + country + "' selected Successfully.");
        }
        catch (Exception e)
        {
            System.out.println("❌ Visa to city cannot be selected. Error: " + e.getMessage());
        }

    }

    public void selectVisaDate(String date) {

        try {
            String[] dateParts=date.split("-");

            String targetDay=dateParts[0];
            String targetMonth=dateParts[1];
            String targetYear=dateParts[2];

            int targetYearValue=Integer.parseInt(targetYear);
            int targetMonthValue=Integer.parseInt(targetMonth);


            wait.until(ExpectedConditions.elementToBeClickable(visa_Date_tab)).click();

            while(true)
            {
                String currentDateValue=driver.findElement(current_date_value).getText();
                String[] currentDateParts=currentDateValue.split(" ");

                int currentMonthValue=Month.valueOf(currentDateParts[0].toUpperCase()).getValue();
                int currentYearValue=Integer.parseInt(currentDateParts[1]);

                if(targetYearValue==currentYearValue && targetMonthValue==currentMonthValue)
                {
                    break;
                }
                else if(currentYearValue<targetYearValue ||
                        (currentYearValue==targetYearValue && currentMonthValue<targetMonthValue))
                {
                    wait.until(ExpectedConditions.elementToBeClickable(future_Date)).click();
                }
                else
                {
                    wait.until(ExpectedConditions.elementToBeClickable(previous_Date)).click();
                }


            }

            WebElement dayClick=wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//tbody)[19]//td[normalize-space()='" + targetDay + "']")));
            dayClick.click();
            // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("visa_Date_tab")));
            System.out.println("✅ Visa Date '" + date + "' selected Successfully.");
        }
        catch (Exception e)
        {
            System.out.println("❌ Visa Date cannot be selected. Error: " + e.getMessage());
        }

    }

    public void testVisaType(String type )  {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(visa_type)).click();
            System.out.println("✅ Visa Type Tab clicked Successfully.");
            List<WebElement> visaTypes=driver.findElements(visa_type_options);
            for(WebElement types: visaTypes)
            {
                //System.out.println(types.getText());
                if(types.getText().equals(type))
                {
                    types.click();
                }
            }

            System.out.println("✅ Visa Type Selected Successfully.");
        }
        catch (Exception e)
        {
            System.out.println("❌ Visa Type Cannot selected."+e.getMessage());
        }
    }

    public void testVisaProcessingSpeed(String duration)
    {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(visa_processing_speed)).click();
            List<WebElement> speedOptions=driver.findElements(visa_processing_speed_options);
            for(WebElement options:speedOptions)
            {
                if(options.getText().equals(duration))
                {
                    options.click();
                }
            }
            System.out.println("✅ Visa processing speed Selected Successfully.");

        }
        catch(Exception e)
        {
            System.out.println("❌ Visa processing speed cannot Selected ."+e.getMessage());
        }
    }

    public void testTravellerPerson(int number)  {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(traveller)).click();
            for(int i=1;i <number;i++)
            {
                wait.until(ExpectedConditions.elementToBeClickable(increment_traveller)).click();
            }
            driver.findElement(body).click();
            System.out.println("✅ "+number+" Traveller selected successfully.");
        }
        catch(Exception e) {
            System.out.println("❌ Traveller cannot be selected. Error: " + e.getMessage());
        }
    }

    public void testVisaCheck()
    {
        try {
            driver.findElement(submit_visaCheck).click();
            String txt=driver.findElement(verify_submitText).getText();
            if(txt.contains("Visa Application"))
            {
                System.out.println("✅ Visa check or submit done.");
            }
        }
        catch(Exception e) {
            System.out.println("❌ Visa check failed. Error: " + e.getMessage());
        }
    }



    public void backToHomepage()
    {
        try {
            driver.navigate().back();
            System.out.println("After successfully search back to homepage done.");
        } catch (Exception e) {
            System.out.println("After successfully search failed to back to homepage."+e.getMessage());
        }
    }
}