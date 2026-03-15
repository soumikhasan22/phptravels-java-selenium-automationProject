package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CarPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public CarPage(WebDriver driver,WebDriverWait wait,JavascriptExecutor js)
    {
        this.driver=driver;
        this.wait=wait;
        this.js=js;
    }

    //ALL LOCATORS

    By car_tab= By.xpath("//span[normalize-space()='Cars']");
    By pickup_cityOrAirport_search=By.xpath("//input[@x-ref='pickupInput']");
    By pickup_cityOrAirport_searchOptions=By.xpath("//div[@x-show='pickupShouldShowDropdown']//div[@x-text='loc.display']");
    By returnLocation=By.xpath("//input[contains(@x-show,'rental')]");
    By pickUp_date=By.xpath("//input[@name='pickup_date']");
    By allDatePickers = By.xpath("//div[contains(@class,'datepicker-days')]");
    By currentDateValue=By.xpath("//div[contains(@class,'datepicker-days') and not(contains(@style,'display: none'))]//th[contains(@class,'switch')]");
    By future_date=By.xpath(".//th[contains(@class,'next')]");
    By allDays=By.xpath("//div[contains(@class,'datepicker-days')]//tbody//td");
    By pickup_time=By.xpath("//input[@name='pickup_time']");
    By hours_minutes=By.xpath("//div[contains(@class,'timepicker-header')]//div[@class='flex gap-1']");
    By hours_option=By.xpath("//div[@class='timepicker-hours']//div[contains(@class,'tp-hour')]");
    By minutes_option=By.xpath("//div[@class='timepicker-minutes']//div[contains(@class,'tp-minute')]");
    By dropOff_date=By.xpath("//input[@name='return_date']");
    By dropOff_time=By.xpath("//input[@name='return_time']");
    By body=By.tagName("body");


    By service_type_tab=By.xpath("//div[@class='input-dropdown']//span[contains(@x-text,'serviceType')]");
    By getService_type_options=By.xpath("//div[@class='input-dropdown-content show']//div[@class='font-medium']");
    By to_location=By.xpath("//input[@x-ref='dropoffInput']");
    By to_search_allCities=By.xpath("//div[@x-show='dropoffShouldShowDropdown']//div[@x-text='loc.display']");
    By driverAge=By.xpath("//span[contains(@x-text,'+ years Old')]");
    By age_options=By.xpath("//div[@class='input-dropdown-content show']//span[not(contains(@class,'text-sm'))]");
    By cars_traveller_tab=By.xpath("//span[contains(@x-text,'travellers +')]");
    By default_Passenger=By.xpath("//span[@class='w-8 text-center font-medium']");
    By increment_traveller=By.xpath("//div[@class='input-dropdown-content show']//span[normalize-space()='add']");
    By decrement_traveller=By.xpath("//div[@class='input-dropdown-content show']//span[normalize-space()='remove']");
    By submit_car=By.xpath("//button[@type='submit']//span[contains(@x-text, 'Search Cars')]");
    By submit_verification=By.xpath("//span[@x-show='!loading']");

    By backMainPage=By.xpath("//a[.//img[@alt='PHPTARVELS']]");


    public void navigateToCar() throws InterruptedException {
        try
        {
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(car_tab)).click();
            System.out.println("✅ SUCCESS: Cars tab clicked successfully");

        }
        catch (Exception e)
        {
            System.out.println("❌ ERROR: Cars tab click failed: "+e.getMessage());
        }
    }

    public void selectPickup_cityOrAirport(String cityOrAirport)  {
        try
        {
            WebElement destinationField=wait.until(ExpectedConditions.elementToBeClickable(pickup_cityOrAirport_search));
            destinationField.sendKeys(cityOrAirport);
            wait.until(ExpectedConditions.visibilityOfElementLocated(pickup_cityOrAirport_searchOptions));
            List<WebElement> allSearchCities=driver.findElements(pickup_cityOrAirport_searchOptions);

            boolean cityOrAirportSelected = false;

            for(WebElement cityOrAirport_pick: allSearchCities)
            {
                String countryText = cityOrAirport_pick.getText().trim();
                if(countryText.contains(cityOrAirport))
                {
                    wait.until(ExpectedConditions.elementToBeClickable(cityOrAirport_pick)).click();
                    cityOrAirportSelected = true;
                    System.out.println("✅ SUCCESS: Pickup Location '" + countryText + "' selected successfully for input: '" + cityOrAirport + "'");
                    break;
                }

            }
            if(!cityOrAirportSelected) {
                System.out.println("❌ ERROR: Pickup Location '" + cityOrAirport + "' not found in dropdown options");
            }
            Thread.sleep(1000);

        } catch (Exception e) {
            System.out.println("❌ ERROR: Pickup Location selection failed for '" + cityOrAirport + "': "+e.getMessage());
        }
    }

    public void selectReturn_cityOrAirport()
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(returnLocation)).click();
            System.out.println("✅ SUCCESS: Return location field clicked successfully.");
        }
        catch (Exception e)
        {
            System.out.println("❌ ERROR: Return location field cannot be clicked: "+e.getMessage());
        }
    }

    public void selectPickUpDate(int day,String month,int year)
    {
        try {

            wait.until(ExpectedConditions.elementToBeClickable(pickUp_date)).click();

            String currentDate = "";

            String targetDate = month + " " + year;

            while (true) {
                // get current month
                List<WebElement> allDates = driver.findElements(currentDateValue);

                for (WebElement date : allDates) {
                    if (date.isDisplayed()) {
                        currentDate = date.getText();
                        //System.out.println("📅 Current Month: " + currentDate);
                        break;
                    }
                }

                if (currentDate.contains(targetDate)) {
                    break;
                }

                // click next
                List<WebElement> datePickers = driver.findElements(allDatePickers);

                for (WebElement picker : datePickers) {
                    if (picker.isDisplayed()) {
                        picker.findElement(future_date).click();
                        break;
                    }
                }
            }



            List<WebElement> days = driver.findElements(allDays);

            for (WebElement dayClick : days) {

                if(dayClick.isDisplayed())
                {
                    if (dayClick.getText().equals(String.valueOf(day))) {
                        wait.until(ExpectedConditions.elementToBeClickable(dayClick)).click();
                        System.out.println("✅ SUCCESS: Pick Up Date Selected: " + day + " " + month + " " + year);
                        return;
                    }
                }
            }

            System.out.println("❌ ERROR: Day " + day + " not found for " + month + " " + year);

        }

        catch (Exception e)
        {
            System.out.println("❌ ERROR: Pick Up Date selection failed for " + day + " " + month + " " + year + ": " + e.getMessage());
        }
    }


    public void selectPickUpTime(int hour,int minute)
    {
        try
        {
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(pickup_time)).click();
            Thread.sleep(1000);
            List<WebElement> hoursMinutes=driver.findElements(hours_minutes);
            for(WebElement options:hoursMinutes)
            {
                String txt=options.getText().trim();
                if(txt.equals("Hours"))
                {
                    options.click();
                    List<WebElement> hoursOption=driver.findElements(hours_option);
                    for (WebElement hours:hoursOption)
                    {
                        if(hours.getText().equals(String.valueOf(hour)))
                        {
                            hours.click();
                        }
                    }
                }
                else if(txt.equals("Minutes"))
                {
                    options.click();
                    List<WebElement> minutesOption=driver.findElements(minutes_option);
                    for (WebElement minutes:minutesOption)
                    {
                        if(minutes.getText().equals(String.valueOf(minute)))
                        {
                            minutes.click();

                        }
                    }
                }
                else
                {
                    System.out.println("Wrong Time Selected");
                }
            }


            System.out.println("✅ Pick Up Time field click action performed, but Chrome did not open the time picker.");
            wait.until(ExpectedConditions.elementToBeClickable(body)).click();
        }
        catch (Exception e)
        {
            System.out.println("❌ Pick Up Time field cannot clicked.");
        }
    }

    public void dropOffDate(int day,String month,int year)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(dropOff_date));

            String currentDate="";
            String targetDate=month+" "+year;

            while (true)
            {
                List<WebElement> allDays=driver.findElements(currentDateValue);

                for(WebElement monthYear: allDays)
                {
                    if(monthYear.isDisplayed())
                    {
                        currentDate=monthYear.getText();
                        break;

                    }
                }

                if(currentDate.contains(targetDate))
                {
                    break;
                }

                List<WebElement> next_picker=driver.findElements(allDatePickers);
                for(WebElement next : next_picker)
                {
                    if(next.isDisplayed())
                    {
                        next.findElement(future_date).click();
                        break;
                    }
                }
            }

            List<WebElement> allDay=driver.findElements(allDays);
            for(WebElement days:allDay)
            {
                if(days.isDisplayed())
                {
                    if(days.getText().equals(String.valueOf(day)))
                    {
                        wait.until(ExpectedConditions.elementToBeClickable(days)).click();
                        System.out.println("✅ SUCCESS: Drop Off Date Selected: " + day + " " + month + " " + year);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("❌ ERROR: Drop Off Date selection failed for " + day + " " + month + " " + year + ": " + e.getMessage());
        }
    }

    public void selectDropOffTime()
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(dropOff_time)).click();
            System.out.println("✅ SUCCESS: Drop Off Time field click action performed, but Chrome did not open the time picker.");
            wait.until(ExpectedConditions.elementToBeClickable(body)).click();
        }
        catch (Exception e)
        {
            System.out.println("❌ ERROR: Drop Off Time field cannot be clicked: ");
        }
    }

    public void selectServiceType(String service) throws InterruptedException {
       try
       {
           wait.until(ExpectedConditions.elementToBeClickable(service_type_tab)).click();
           wait.until(ExpectedConditions.visibilityOfElementLocated(getService_type_options));
           List<WebElement> typeOptions=driver.findElements(getService_type_options);
           boolean serviceFound = false;
           for(WebElement option: typeOptions)
           {
               if(option.isDisplayed())
               {
                   if(option.getText().equals(service))
                   {
                       wait.until(ExpectedConditions.elementToBeClickable(option)).click();
                       serviceFound = true;
                       System.out.println("✅ SUCCESS: Service type '" + service + "' selected successfully");
                   }
               }
           }
           if (!serviceFound) {
               System.out.println("❌ ERROR: Service type '" + service + "' not found in dropdown options");
           }
       }catch (Exception e) {
           System.out.println("❌ ERROR: Failed to select service type '" + service + "': " + e.getMessage());
       }
    }

    public void selectToCity(String city) {
        try {
            WebElement toLocation = wait.until(ExpectedConditions.elementToBeClickable(to_location));
            toLocation.clear();
            toLocation.sendKeys(city);


            wait.until(ExpectedConditions.visibilityOfElementLocated(to_search_allCities));
            List<WebElement> citiesOption = driver.findElements(to_search_allCities);

            boolean selectToCity = false;

            for (WebElement option : citiesOption) {
                if (option.isDisplayed()) {
                    String countryText = option.getText().trim();
                    //System.out.println("Option found: '" + countryText + "'"); // DEBUG
                    if (countryText.toLowerCase().contains(city.toLowerCase())) {
                        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
                        selectToCity = true;
                        System.out.println("✅ SUCCESS: Dropoff Location '" + countryText + "' selected successfully for input: '" + city + "'");
                        break;
                    }
                }
            }

            if (!selectToCity) {
                System.out.println("❌ ERROR: Dropoff Location '" + city + "' not found in dropdown options");
            }

        } catch (Exception e) {
            System.out.println("❌ ERROR: Failed to select city '" + city + "': " + e.getMessage());
        }
    }

    public void selectDriverAge(String age)
    {
        try
        {
            WebElement ageTab =wait.until(ExpectedConditions.elementToBeClickable(driverAge));
            ageTab.click();
            //ageTab.sendKeys(age);
            wait.until(ExpectedConditions.visibilityOfElementLocated(age_options));
            List<WebElement> ages=driver.findElements(age_options);
            boolean selectDriverAge=false;
            for(WebElement option:ages)
            {
                if(option.isDisplayed())
                {
                    String ageTxt=option.getText().trim();
                    //System.out.println("Option found: '" + ageTxt + "'");
                    if(ageTxt.contains(age))
                    {
                        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
                        selectDriverAge=true;
                        System.out.println("✅ SUCCESS: Driver Age '" + ageTxt + "' selected successfully for input: '" + age + "'");
                        break;
                    }
                }

            }
            if (!selectDriverAge) {
                System.out.println("❌ ERROR: Driver Age '" + age + "' not found in dropdown options");
            }

        } catch (Exception e) {
            System.out.println("❌ ERROR: Failed to select Driver Age '" + age + "': " + e.getMessage());
        }
    }

    public void selectTraveller(int number)
    {
        try
        {
            if (number < 1) {
                System.out.println("❌ ERROR: Invalid number of travellers: " + number + ". Minimum allowed is 1.");
                return;
            }
            wait.until(ExpectedConditions.elementToBeClickable(cars_traveller_tab)).click();
            String defaultNum=driver.findElement(default_Passenger).getText().trim();
            int currentNum=Integer.parseInt(defaultNum);
            if(currentNum<number)
            {
                for (int i=currentNum;i<number;i++)
                {
                    wait.until(ExpectedConditions.elementToBeClickable(increment_traveller)).click();
                }
                System.out.println("✅ SUCCESS: Traveller count increased from " + currentNum + " to " + number);
            }
            else if (currentNum >number)
            {
                for (int i=currentNum;i>number;i--)
                {
                    wait.until(ExpectedConditions.elementToBeClickable(decrement_traveller)).click();
                }
                System.out.println("✅ SUCCESS: Traveller count decreased from " + currentNum + " to " + number);
            }
            else
            {
                System.out.println("✅ SUCCESS: Traveller count is already " + number + " - no adjustment needed");
            }

            driver.findElement(body).click();
            System.out.println("✅ SUCCESS: Final traveller count set to " + number);
        } catch (Exception e) {
            System.out.println("❌ ERROR: Failed to set traveller count to " + number + ": " + e.getMessage());
        }

    }

    public void selectSubmitCar()
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(submit_car)).click();
            if(wait.until(ExpectedConditions.visibilityOfElementLocated(submit_verification)).isDisplayed())
            {
                System.out.println("✅ SUCCESS: Search submitted successfully - cars search initiated");
            }

        } catch (Exception e) {
            System.out.println("❌ ERROR: Submit car search failed: "+e.getMessage());
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