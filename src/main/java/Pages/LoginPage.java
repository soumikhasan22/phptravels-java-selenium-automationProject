package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public LoginPage(WebDriver driver, WebDriverWait wait,JavascriptExecutor js)
    {
        this.driver = driver;
        this.wait = wait;
        this.js=js;
    }

    By loginBtn = By.xpath("//a[contains(@class,'hidden') and .//span[normalize-space()='login']]");
    By email_field = By.id("email");
    By password_field = By.id("password");
    By checkBox = By.xpath("//span[contains(@class,'checkbox-icon') and normalize-space()='check']");
    By submitLogin = By.xpath("//button[@type='submit']");
    By emailVerification_Text = By.xpath("//p[contains(text(),'Please verify your email address before logging in')]");
    By emailVerification_Btn = By.xpath("//button[@class='btn btn-sm cyan']");
    By backMainPage=By.xpath("//a[.//img[@alt='PHPTARVELS']]");

    public void clickLoginBtn()
    {
        try
        {
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
            System.out.println("✅ Login button clicked successfully");
            System.out.println("✅ Successfully navigated to Login page");
        }
        catch (Exception e)
        {
            System.out.println("❌ FAILED to navigate to Login page - " + e.getMessage());
        }
    }

    public void enterLoginEmail(String email)
    {
        try
        {
            WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(email_field));
            emailField.click();
            emailField.sendKeys(email);
            System.out.println("✅ Email entered successfully: \"" + email + "\"");
        }
        catch(Exception e)
        {
            System.out.println("❌ FAILED to enter Email field - " + e.getMessage());
        }
    }

    public void enterLoginPassword(String password)
    {
        try
        {
            WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(password_field));
            passwordField.click();
            passwordField.sendKeys(password);
            System.out.println("✅ Password entered successfully");
        }
        catch(Exception e)
        {
            System.out.println("❌ FAILED to enter Password field - " + e.getMessage());
        }
    }

    public void clickCheckBox()
    {
        try
        {
            WebElement checkbox = driver.findElement(checkBox);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", checkbox);
            System.out.println("✅ Remember Me checkbox clicked successfully");
            Thread.sleep(500);
        }
        catch(Exception e)
        {
            System.out.println("❌ Failed to click Remember Me checkbox - " + e.getMessage());
        }
    }

    public void submitLoginBtn()
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(submitLogin)).click();
            System.out.println("✅ Login Button clicked successfully");

            WebElement emailTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(emailVerification_Text));
            String txt = emailTxt.getText();

            WebElement btn = driver.findElement(emailVerification_Btn);

            if(txt.contains("Please verify your email address before logging in.") && btn.isDisplayed())
            {
                btn.click();
                System.out.println("✅ Logged in successfully but email verification is required");
            }
        }
        catch(Exception e)
        {
            System.out.println("❌ FAILED to click submit button - " + e.getMessage());
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