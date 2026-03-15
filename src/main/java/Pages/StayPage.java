package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class StayPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public StayPage(WebDriver driver,WebDriverWait wait,JavascriptExecutor js)
    {
        this.driver=driver;
        this.wait=wait;
        this.js=js;
    }

    //ALL LOCATORS

    By stay_tab= By.xpath("//span[normalize-space()='Stays']");

    By destinationOrHotelTab=By.xpath("//div//input[@x-ref='destinationInput' and @placeholder='Search By City']");
    By allSearchOptions=By.xpath("//div[contains(@x-show,'destinationShouldShowDropdown')]//div[@class='flex-1 min-w-0']");

    By checkInDate=By.xpath("//input[@placeholder='Check-in Date' and @name='checkin_date']");
    By currentDate=By.xpath("//th[contains(@class,'switch')]");
    By futureDate=By.xpath("//th[contains(@class,'next')]");

    By allDays=By.xpath("//div[contains(@class,'datepicker-days')]//tbody//td");
    By checkOutDate=By.xpath("//input[@placeholder='Check-out Date' and @name='checkout_date']");

    By guestAndRoom=By.xpath("//span[@x-text='getGuestText()']");
    By roomIncrement=By.xpath("//div[contains(@class,'sticky')]//span[normalize-space()='add']");
    By adultIncrement=By.xpath("//div[contains(@class,'rounded-lg')]//div[.//*[normalize-space()='Adults']]//span[normalize-space()='add']");
    By childrenIncrement=By.xpath("//div[contains(@class,'rounded-lg')]//div[.//*[normalize-space()='Children']]//span[normalize-space()='add']");
    By childAgeField=By.xpath("//select[@x-model='room.childAges[childIndex]']");

    By nationality_field=By.xpath("//span[normalize-space()='Select Nationality']");
    By nationality_searchBox=By.xpath("//input[@placeholder='Search country...']");
    By nationality_allOptions=By.xpath("//div[@class='input-dropdown-content show']//span[@x-text='country.nicename']");
    By body=By.tagName("body");

    By submit_stay=By.xpath("//span[normalize-space()='Search Hotels']");
    By verified_txt=By.xpath("//span[@x-show='!loading']");

    By backMainPage=By.xpath("//a[.//img[@alt='PHPTARVELS']]");

    //ALL ACTIONS

    public void navigateToStays() throws InterruptedException {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(stay_tab)).click();
            System.out.println("✅ Successfully navigated to Stays tab.");

        }
        catch (Exception e)
        {
            System.out.println("❌ Failed to navigate to Stays tab. Exception: " + e.getMessage());
        }
    }


    public void selectDestinationOrHotel(String DestinationOrHotel)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(destinationOrHotelTab)).sendKeys(DestinationOrHotel);

            // Wait until options appear
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allSearchOptions));

            List<WebElement> allOptions = driver.findElements(allSearchOptions);

            for(WebElement option : allOptions)
            {
                String text = option.getText().split("\n")[0];

                if(text.contains(DestinationOrHotel))
                {
                    wait.until(ExpectedConditions.elementToBeClickable(option)).click();
                    System.out.println("✅ Destination/Hotel selected successfully - \"" + text + "\"");
                    break;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("❌ Failed to select destination/hotel \"" + DestinationOrHotel + "\". Exception: " + e.getMessage());
        }
    }

    public void selectCheckInDate(int day,String month,int year)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(checkInDate)).click();
            String targetValue=month+" "+year;
            String currentValue="";
            while (true)
            {
                List<WebElement> currentValues=driver.findElements(currentDate);
                for(WebElement values:currentValues)
                {
                    if(values.isDisplayed())
                    {
                        currentValue=values.getText();
                        break;
                    }

                }

                if(currentValue.contains(targetValue))
                {
                    break;
                }

                List<WebElement> nextDate=driver.findElements(futureDate);
                for(WebElement values:nextDate)
                {
                    if(values.isDisplayed())
                    {
                        wait.until(ExpectedConditions.elementToBeClickable(values)).click();
                        break;
                    }

                    if(currentValue.contains(targetValue))
                    {
                        break;
                    }
                }
            }

            List<WebElement> allDateOptions=driver.findElements(allDays);
            for(WebElement values:allDateOptions)
            {
                if(values.isDisplayed())
                {
                    if(values.getText().equals(String.valueOf(day)))
                    {
                        wait.until(ExpectedConditions.elementToBeClickable(values)).click();
                        System.out.println("✅ Check-in Date selected successfully - " + day + " " + month + " " + year);
                        break;
                    }
                }

            }

        }
        catch (Exception e) {
            System.out.println("❌ Check-in Date selection failed for " + day + " " + month + " " + year + ". Exception: " + e.getMessage());
        }
    }


    public void selectCheckOutDate(int day,String month,int year)
    {
        try
        {
            // wait.until(ExpectedConditions.elementToBeClickable(checkOutDate)).click();
            Thread.sleep(500);
            String targetValue=month+" "+year;
            String currentValue="";
            while (true)
            {
                List<WebElement> currentValues=driver.findElements(currentDate);
                for(WebElement values:currentValues)
                {
                    if(values.isDisplayed())
                    {
                        currentValue=values.getText();
                        break;
                    }

                }

                if(currentValue.contains(targetValue))
                {
                    break;
                }

                List<WebElement> nextDate=driver.findElements(futureDate);
                for(WebElement values:nextDate)
                {
                    if(values.isDisplayed())
                    {
                        wait.until(ExpectedConditions.elementToBeClickable(values)).click();
                        break;
                    }

                    if(currentValue.contains(targetValue))
                    {
                        break;
                    }
                }
            }

            List<WebElement> allDateOptions=driver.findElements(allDays);
            for(WebElement values:allDateOptions)
            {
                if(values.isDisplayed())
                {
                    if(values.getText().equals(String.valueOf(day)))
                    {
                        wait.until(ExpectedConditions.elementToBeClickable(values)).click();
                        System.out.println("✅ Check-out Date selected successfully - " + day + " " + month + " " + year);
                        break;
                    }
                }

            }

        }
        catch (Exception e) {
            System.out.println("❌ Check-out Date selection failed for " + day + " " + month + " " + year + ". Exception: " + e.getMessage());
        }
    }


    public void  selectGuestAndRoom(int room,int adult,int child, int[] childAges)
    {

        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(guestAndRoom)).click();
            System.out.println("✅ Guest and room dropdown opened successfully");
            for(int i=1;i<room;i++)
            {
                wait.until(ExpectedConditions.elementToBeClickable(roomIncrement)).click();

            }
            System.out.println("✅ Rooms selected - " + room + " room(s)");

            for(int j=2;j<adult;j++)
            {
                wait.until(ExpectedConditions.elementToBeClickable(adultIncrement)).click();

            }
            System.out.println("✅ Adults selected - " + adult + " adult(s)");

            for(int j=0;j<child;j++)
            {
                wait.until(ExpectedConditions.elementToBeClickable(childrenIncrement)).click();

            }
            System.out.println("✅ Children selected - " + child + " child(ren)");

            List<WebElement> childAge = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(childAgeField)
            );

            int size = childAge.size();

            for(int i = 0; i < size; i++)
            {
                Select select = new Select(childAge.get(i));

                int index = childAges[i];
                select.selectByIndex(index);

                String value = select.getOptions().get(index).getText();

                System.out.println("✅ Child " + (i + 1) + " age set to " + value + " (selected from index " + index + ")" );
            }

            wait.until(ExpectedConditions.elementToBeClickable(body)).click();
            System.out.println("✅ Guest and room configuration completed successfully");
        }
        catch (Exception e)
        {
            System.out.println("❌ Guest and room selection failed. Exception: " + e.getMessage());
        }

    }


    public void selectNationality(String country)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(nationality_field)).click();
            System.out.println("✅ Nationality dropdown opened successfully");
            wait.until(ExpectedConditions.elementToBeClickable(nationality_searchBox)).sendKeys(country);
            wait.until(ExpectedConditions.visibilityOfElementLocated(nationality_allOptions));
            List<WebElement> allCountry=driver.findElements(nationality_allOptions);
            for(WebElement options:allCountry)
            {
                if(options.isDisplayed())
                {
                    if(options.getText().contains(country))
                    {
                        wait.until(ExpectedConditions.elementToBeClickable(options)).click();
                        System.out.println("✅ Nationality selected successfully - \"" + options.getText() + "\"");
                    }
                }
            }

        }
        catch (Exception e)
        {
            System.out.println("❌ Nationality selection failed for \"" + country + "\". Exception: " + e.getMessage());
        }
    }



    public void submitStay() {
        try {

            wait.until(ExpectedConditions.elementToBeClickable(submit_stay)).click();
            System.out.println("✅ Search Hotels button clicked successfully");


            WebElement verifiedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(verified_txt));


            if (verifiedElement.isDisplayed()) {
                System.out.println("✅ Stay search submitted and verified successfully");
            } else {
                System.out.println("❌ Stay search submitted but verification element is not displayed");
            }
        } catch (Exception e) {
            System.out.println("❌ Stay search submission failed. Exception: " + e.getMessage());
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