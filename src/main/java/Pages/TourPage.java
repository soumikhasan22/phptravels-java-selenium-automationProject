package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TourPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public TourPage(WebDriver driver,WebDriverWait wait,JavascriptExecutor js)
    {
        this.driver=driver;
        this.wait=wait;
        this.js=js;
    }

    //ALL LOCATORS

    By tour_tab= By.xpath("//button[.//span[normalize-space()='Tours']]");
    By destination_city_searchField=By.xpath("(//input[@x-ref='destinationInput'] )[2]");
    By destination_search_allCities=By.xpath("//div[@x-show='destinationShouldShowDropdown || destinationShowNoResults']//span[@x-text='d.name || d.id']");
    By start_date_tab=By.xpath("//input[@placeholder='Start Date']");
    By current_date_value=By.xpath("(//div[@class='datepicker-days'])[8]//th[contains(@class,'switch')]");
    By future_date_select=By.xpath("(//div[@class='datepicker-days'])[8]//th[contains(@class,'next')]");
    By duration_tab=By.xpath("//span[@x-text='getDurationName']");
    By duration_options=By.xpath("//div[@class='input-dropdown-content show']//span[@x-text='duration.name']");
    By tour_type=By.xpath("//div//span[@x-text='getTourTypeName']");
    By tour_type_options=By.xpath("//div[@class='input-dropdown-content show']//span[@x-text='type.name']");
    By travellers_tab=By.xpath("//div//span[@x-text='getTravelerText']");
    By travellers_persons=By.xpath("//div[@class='input-dropdown-content p-2 show']//div[@class='text-start']");
    By adult_increment=By.xpath("(//div[@class='flex items-center gap-1'])[4]//button[.//span[text()='add']] ");
    By children_increment=By.xpath("(//div[@class='flex items-center gap-1'])[5]//button[.//span[text()='add']] ");
    By submit_tour=By.xpath("//button[@type='submit']//span[text()='Search Tours']");
    By body=By.tagName("body");
    By after_submit_verification=By.xpath("//span[@x-show='!loading']");
    By backMainPage=By.xpath("//a[.//img[@alt='PHPTARVELS']]");

    public void navigateToTour()  {
        try
        {
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(tour_tab)).click();
            System.out.println("✅ Tours tab clicked successfully");

        }
        catch (Exception e)
        {
            System.out.println("❌ Tours tab click failed: "+e.getMessage());
        }
    }

    public void selectDestination(String destination)  {
        try
        {
            WebElement destinationField=wait.until(ExpectedConditions.elementToBeClickable(destination_city_searchField));
            destinationField.sendKeys(destination);
            wait.until(ExpectedConditions.visibilityOfElementLocated(destination_search_allCities));
            List<WebElement> allSearchCities=driver.findElements(destination_search_allCities);

            boolean citySelected = false;

            for(WebElement city: allSearchCities)
            {
                String countryText = city.getText().trim();
                if(countryText.contains(destination))
                {
                    wait.until(ExpectedConditions.elementToBeClickable(city)).click();
                    citySelected = true;
                    System.out.println("✅ Destination city '" + destination + "' selected successfully");
                    break;
                }

            }
            if(!citySelected) {
                System.out.println("❌ Destination city '" + destination + "' not found");
            }


        } catch (Exception e) {
            System.out.println("❌ Destination city selection failed: "+e.getMessage());
        }
    }

    public void selectTourStartDate(int day,String month,int year)

    {

        try
        {

            String targetDate=month+" "+year;
            wait.until(ExpectedConditions.elementToBeClickable(start_date_tab)).click();

            while(!driver.findElement(current_date_value).getText().contains(targetDate))
            {
                driver.findElement(future_date_select).click();
            }

            WebElement dayClick=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                    "(//tbody)[22]//td[normalize-space()='"+day+"']")));
            dayClick.click();
            System.out.println("✅ Tour start date '" + day + " " + month + " " + year + "' selected successfully");
        } catch (Exception e) {
            System.out.println("❌ Tour start date selection failed: "+e.getMessage());
        }

    }


    public void selectTourDuration( String duration)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(duration_tab)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(duration_options));
            List<WebElement> durationOptions=driver.findElements(duration_options);

            boolean selectDuration=false;
            for(WebElement durationDay:durationOptions)
            {
                String durationTxt=durationDay.getText().trim();
                if(durationTxt.contains(duration))
                {
                    durationDay.click();
                    selectDuration=true;
                    System.out.println("✅ Tour duration '" + durationTxt + "' selected successfully");
                }
            }
            if(!selectDuration)
            {
                System.out.println("❌ Tour duration '" + duration + "' not found");
                System.out.println("Available options are:");
                for(WebElement option : durationOptions)
                {
                    System.out.println("   • " + option.getText().trim());
                }

            }

        } catch (Exception e) {
            System.out.println("❌ Tour duration selection failed: "+e.getMessage());
        }
    }

    public void selectTourType(String type)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(tour_type)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(tour_type_options));
            List<WebElement> typeOptions=driver.findElements(tour_type_options);

            boolean selectTourType=false;
            for(WebElement tourType:typeOptions)
            {
                String typeTxt=tourType.getText().trim();
                if(typeTxt.contains(type))
                {
                    js.executeScript("arguments[0].click();", tourType);
                    selectTourType=true;
                    System.out.println("✅ Tour type '" + typeTxt + "' selected successfully");
                }
            }
            if(!selectTourType)
            {
                System.out.println("❌ Tour type '" + type + "' not found");
                System.out.println("Available options are:");
                for(WebElement option : typeOptions)
                {
                    System.out.println("   • " + option.getText().trim());
                }

            }

        } catch (Exception e) {
            System.out.println("❌ Tour type selection failed: "+e.getMessage());
        }

    }



    public void selectTravellersNumber(String personType, int number) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(travellers_tab)).click();
            //wait.until(ExpectedConditions.visibilityOfElementLocated(travellers_persons));

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

                default:
                    throw new IllegalArgumentException("Invalid person type: " + personType);
            }

            int clicksNeeded = number - defaultValue;

            for (int i = 0; i < clicksNeeded; i++) {
                wait.until(ExpectedConditions.elementToBeClickable(incrementButton)).click();
            }

            System.out.println("✅ " + personType + " count set to " + number + " successfully");
            driver.findElement(body).click();

        } catch (Exception e) {
            System.out.println("❌ Travellers selection failed: " + e.getMessage());
        }
    }

    public void submitTourSearch()
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(submit_tour)).click();
            if(wait.until(ExpectedConditions.visibilityOfElementLocated(after_submit_verification)).isDisplayed())
            {
                System.out.println("✅ Tour search submitted successfully");
            }
        } catch (Exception e) {
            System.out.println("❌ Tour search submission failed: " + e.getMessage());
        }
    }


    public void backToHomepage()
    {
        try {

            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(backMainPage));

            js.executeScript("arguments[0].click();", element);

            System.out.println("After successfully search back to homepage done.");

        } catch (Exception e) {
            System.out.println("After successfully search failed to back to homepage. " + e.getMessage());
        }
    }

}