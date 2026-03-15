package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class emailVerificationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public emailVerificationPage(WebDriver driver,WebDriverWait wait)
    {
        this.driver=driver;
        this.wait=wait;
    }

    By emailAdd= By.xpath("//input[@type='email']");
    By clickNext=By.xpath("//span[@class='VfPpkd-vQzf8d' and normalize-space()='Next']");
    By passwordField=By.xpath("//input[@type='password']");

    public void navigateEmailAccount() {
        try {
            driver.navigate().to("https://www.gmail.com");
            System.out.println("✓ Successfully navigated to Gmail");
        } catch (Exception e) {
            System.err.println("✗ Failed to navigate to Gmail: " + e.getMessage());
        }
    }

    public void enterEmailAddress(String email) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(emailAdd)).sendKeys(email);
            System.out.println("✓ Email address entered successfully");

            try {
                wait.until(ExpectedConditions.elementToBeClickable(clickNext)).click();
                System.out.println("✓ Clicked Next button successfully");
            } catch (Exception e) {
                System.err.println("✗ Failed to click Next button: " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("✗ Unexpected error while entering email: " + e.getMessage());
        }
    }

    public void enterPassword(String password) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);
            System.out.println("✓ Password entered successfully");
            try {
                wait.until(ExpectedConditions.elementToBeClickable(clickNext)).click();
                System.out.println("✓ Clicked Next button successfully");
            } catch (Exception e) {
                System.err.println("✗ Failed to click Next button: " + e.getMessage());
            }

        }catch (Exception e) {
            System.err.println("✗ Unexpected error while entering password: " + e.getMessage());
        }
    }
}
