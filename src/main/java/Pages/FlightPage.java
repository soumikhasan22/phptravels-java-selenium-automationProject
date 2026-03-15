package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public FlightPage(WebDriver driver,WebDriverWait wait,JavascriptExecutor js)
    {
        this.driver=driver;
        this.wait=wait;
        this.js=js;
    }

    //ALL LOCATORS
    By flight_tab= By.xpath("//button[@type='button']//span[text()='Flights']");

    By departure_form=By.xpath("//input[@placeholder='Departure City or Airport']");
    By departure_search_allOptions=By.xpath("//div[contains(@x-show,'fromShouldShowDropdown')]//div[@class='flex-1 min-w-0']");
    By no_airport_found=By.xpath("//div[@x-show='fromShowNoResults']//div[contains(.,'No airports found')]");
    By notFoundAirport_text=By.xpath("//div[@x-show='fromShowNoResults']//div[contains(.,'No airports found')]//p");

    By arrive_to=By.id("arrival_airport_input");
    By arrive_search_allOption=By.xpath("//div[contains(@x-show,'toShouldShowDropdown')]//div[contains(@class,'flex-1')]");
    By to_no_airport_found=By.xpath("//div[@x-show='toShowNoResults']//div[contains(.,'No airports found')]");
    By to_notFoundAirport_text=By.xpath("//div[@x-show='toShowNoResults']//div[contains(.,'No airports found')]//p");

    By departure_Date=By.xpath("//input[contains(@placeholder,'Departure Date')]");
    //By allDatePicker=By.xpath("//div[@class='datepicker-days']");
    By currentDate_value=By.xpath("//div[@class='datepicker-days']//th[contains(@class,'switch')]");
    By future_date=By.xpath("//div[@class='datepicker-days']//th[contains(@class,'next')]");
    By allDays=By.xpath("//div[@class='datepicker-days']//tbody//td");

    By flight_type=By.xpath("//span[@x-text='getSelectedName()'][normalize-space()='One Way']");
    By flight_options=By.xpath("//div[@class='input-dropdown-content show']//span[@x-text='type.name']");

    By return_date=By.xpath("//input[@placeholder='Return Date']");

    By travellers_tab=By.xpath("//span[@x-text='getPassengerText()']");
    By adult_increment=By.xpath("(//div[@class='flex items-center gap-1'])[1]//button[.//span[text()='add']] ");
    By children_increment=By.xpath("(//div[@class='flex items-center gap-1'])[2]//button[.//span[text()='add']]");
    By infants_increment=By.xpath("(//div[@class='flex items-center gap-1'])[3]//button[.//span[text()='add']]");
    By body=By.tagName("body");
    By submit_search_flight=By.xpath("//span[normalize-space()='Search Flights']");
    By verification=By.xpath("//strong[@x-show='!loading']");
    By backMainPage=By.xpath("//a[.//img[@alt='PHPTARVELS']]");



    //Action Methids

    public void navigateToFlight()
    {
        try
        {
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(flight_tab));
            WebElement  flight=wait.until(ExpectedConditions.elementToBeClickable(flight_tab));
            flight.click();

            System.out.println("✅ Flight tab opened successfully - Ready to search flights");

        } catch (Exception e) {
            System.out.println("❌ Could not open Flight tab - " + e.getMessage());
        }
    }

    public void selectDeparture(String city)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(departure_form)).sendKeys(city);


            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(departure_search_allOptions),
                    ExpectedConditions.visibilityOfElementLocated(no_airport_found)
            ));


            WebElement noResultElements = driver.findElement(no_airport_found);
            if (noResultElements.isDisplayed()) {
                WebElement noResultText = driver.findElement(notFoundAirport_text);
                String message = noResultText.getText().trim();
                System.out.println("❌ No departure airport found for '" + city + "' - " + message);
                return;
            }


            List<WebElement> departure_options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(departure_search_allOptions));

            boolean isSelected = false;
            for (WebElement formOption : departure_options)
            {
                if (formOption.isDisplayed())
                {
                    String txt = formOption.getText().trim().replace("\n", " ");

                    if (txt.contains(city))
                    {
                        wait.until(ExpectedConditions.elementToBeClickable(formOption)).click();
                        isSelected = true;
                        System.out.println("✅ Departure city selected: " + txt);
                        break;
                    }
                }
            }

            if (!isSelected) {
                System.out.println("❌ Could not find departure city: " + city);
            }

        } catch (Exception e) {
            System.out.println("❌ Failed to select departure city - " + e.getMessage());
        }
    }


    public void selectArriveT0(String city)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(arrive_to)).sendKeys(city);


            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(arrive_search_allOption),
                    ExpectedConditions.visibilityOfElementLocated(to_no_airport_found)
            ));


            WebElement noResultElements = driver.findElement(to_no_airport_found);
            if (noResultElements.isDisplayed()) {
                WebElement noResultText = driver.findElement(to_notFoundAirport_text);
                String message = noResultText.getText().trim();
                System.out.println("❌ No arrival airport found for '" + city + "' - " + message);
                return;
            }


            List<WebElement> departure_options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(arrive_search_allOption));

            boolean isSelected = false;
            for (WebElement formOption : departure_options)
            {
                if (formOption.isDisplayed())
                {
                    String txt = formOption.getText().trim().replace("\n", " ");

                    if (txt.contains(city))
                    {
                        wait.until(ExpectedConditions.elementToBeClickable(formOption)).click();
                        isSelected = true;
                        System.out.println("✅ Arrival city selected: " + txt);
                        break;
                    }
                }
            }

            if (!isSelected) {
                System.out.println("❌ Could not find arrival city: " + city);
            }

        } catch (Exception e) {
            System.out.println("❌ Failed to select arrival city - " + e.getMessage());
        }
    }

    public void selectDepartureDate(int day,String month,int year) throws InterruptedException {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(departure_Date)).click();
            String targetValue=month+" "+year;
            String currentDate="";


            while (true)
            {
                List<WebElement> allDays=driver.findElements(currentDate_value);

                for(WebElement monthYear: allDays)
                {
                    if(monthYear.isDisplayed())
                    {
                        currentDate=monthYear.getText();
                        break;

                    }
                }

                if(currentDate.contains(targetValue))
                {
                    break;
                }

                List<WebElement> next_picker=driver.findElements(future_date);
                for(WebElement next : next_picker)
                {
                    if(next.isDisplayed())
                    {
                        next.click();
                        break;
                    }
                }
            }

            List<WebElement> allDay=driver.findElements(allDays);
            boolean dateFound = false;

            for(WebElement days:allDay)
            {
                if(days.isDisplayed())
                {
                    if(days.getText().equals(String.valueOf(day)))
                    {
                        wait.until(ExpectedConditions.elementToBeClickable(days)).click();
                        System.out.println("✅ Departure date set to: " + day + " " + month + " " + year);
                        dateFound = true;
                        break;
                    }
                }
            }

            if (!dateFound) {
                System.out.println("❌ Could not select departure date: " + day + " " + month + " " + year);
            }
        }
        catch (Exception e) {
            System.out.println("❌ Failed to select departure date - " + e.getMessage());
        }
    }

    public void selectFlightType(String type)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(flight_type)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(flight_options));
            List<WebElement> options=driver.findElements(flight_options);
            boolean typeFound = false;

            for(WebElement option:options)
            {
                if(option.isDisplayed())
                {
                    if(option.getText().trim().contains(type))
                    {
                        option.click();
                        System.out.println("✅ Flight type changed to: " + type);
                        typeFound = true;
                        break;
                    }
                }
            }

            if (!typeFound) {
                System.out.println("❌ Could not find flight type: " + type);
            }

        } catch (Exception e) {
            System.out.println("❌ Failed to select flight type - " + e.getMessage());
        }
    }

    public void selectReturnDate(int day,String month,int year) throws InterruptedException {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(return_date)).click();
            String targetValue=month+" "+year;
            String currentDate="";


            while (true)
            {
                List<WebElement> allDays=driver.findElements(currentDate_value);

                for(WebElement monthYear: allDays)
                {
                    if(monthYear.isDisplayed())
                    {
                        currentDate=monthYear.getText();
                        break;

                    }
                }

                if(currentDate.contains(targetValue))
                {
                    break;
                }

                List<WebElement> next_picker=driver.findElements(future_date);
                for(WebElement next : next_picker)
                {
                    if(next.isDisplayed())
                    {
                        next.click();
                        break;
                    }
                }
            }

            List<WebElement> allDay=driver.findElements(allDays);
            boolean dateFound = false;

            for(WebElement days:allDay)
            {
                if(days.isDisplayed())
                {
                    if(days.getText().equals(String.valueOf(day)))
                    {
                        wait.until(ExpectedConditions.elementToBeClickable(days)).click();
                        System.out.println("✅ Return date set to: " + day + " " + month + " " + year);
                        dateFound = true;
                        break;
                    }
                }
            }

            if (!dateFound) {
                System.out.println("❌ Could not select return date: " + day + " " + month + " " + year);
            }
        }
        catch (Exception e) {
            System.out.println("❌ Failed to select return date - " + e.getMessage());
        }
    }

    By flightClass=By.xpath("//label[contains(.,'Flight Class')]/following-sibling::div//span[@x-text='getSelectedName()']");
    By class_options=By.xpath("//div[@class='input-dropdown-content show']//span[@x-text='cls.name']");
    public void selectFlightClass(String flight_class)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(flightClass)).click();
            List<WebElement> options=driver.findElements(class_options);
            boolean classFound = false;

            for(WebElement option: options)
            {
                if(option.isDisplayed())
                {
                    if(option.getText().trim().contains(flight_class))
                    {
                        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
                        System.out.println("✅ Flight class changed to: " + option.getText().trim());
                        classFound = true;
                        break;

                    }
                }
            }

            if (!classFound) {
                System.out.println("❌ Could not find flight class: " + flight_class);
            }
        }
        catch (Exception e)
        {
            System.out.println("❌ Failed to select flight class - " + e.getMessage());
        }
    }



    public void selectTravellersNumber(String personType, int number) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(travellers_tab)).click();

            By incrementButton;
            int defaultValue;

            switch (personType.toLowerCase()) {
                case "adults":
                    incrementButton = adult_increment;
                    defaultValue = 1;
                    break;

                case "children":
                    incrementButton = children_increment;
                    defaultValue = 0;
                    break;

                case "infants":
                    incrementButton = infants_increment;
                    defaultValue = 0;
                    break;

                default:
                    throw new IllegalArgumentException("Invalid person type: " + personType);
            }

            int clicksNeeded = number - defaultValue;

            for (int i = 0; i < clicksNeeded; i++) {
                wait.until(ExpectedConditions.elementToBeClickable(incrementButton)).click();
            }

            System.out.println("✅ " + personType + " set to " + number);
            driver.findElement(body).click();

        } catch (Exception e) {
            System.out.println("❌ Could not set " + personType + " count - " + e.getMessage());
        }
    }

    public void selectSubmitFlight()
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(submit_search_flight)).click();
            if(wait.until(ExpectedConditions.visibilityOfElementLocated(verification)).isDisplayed())
            {
                System.out.println("✅ Flight search submitted successfully - Searching for flights...");
            }

        }
        catch (Exception e) {
            System.out.println("❌ Failed to submit flight search - " + e.getMessage());
        }
    }

    public void backToHomepage()
    {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(backMainPage)).click();
            System.out.println("After successfully search back to homepage done.");
        } catch (Exception e) {
            System.out.println("After successfully search failed to back to homepage."+e.getMessage());
        }
    }
}