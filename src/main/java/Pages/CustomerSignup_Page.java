package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerSignup_Page {

    private WebDriver driver;
    private WebDriverWait wait;

    public CustomerSignup_Page(WebDriver driver,WebDriverWait wait)
    {
        this.driver=driver;
        this.wait=wait;
    }

    //Locators

    By signupBtn= By.xpath("//button[contains(@class,'btn') and .//span[normalize-space()='Signup']]");
    By customer_signupBtn=By.xpath("//a[.//span[normalize-space()='Customer Signup' and @class='font-medium']]");
    By firstName=By.id("first_name");
    By lastName=By.id("last_name");
    By email=By.id("email");
    By password=By.id("password");
    By con_password=By.id("confirm_password");
    By security_questions=By.xpath("//label[@for='captcha_answer']");
    By security_answerField=By.id("captcha_answer");
    By agree=By.xpath("//div[contains(@class,'checkbox-custom')]");
    By submit=By.xpath("//button[@type='submit']");
    By successMsg = By.xpath("//p[contains(text(),'Registration successful! Please check your email')]");
    By existAccountMsg = By.xpath("//p[@class='text-sm']");


    //Actions

    public void navigateToCustomerSignUp() {
        try {
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(signupBtn)).click();
            System.out.println("✓ Signup button clicked successfully");

            wait.until(ExpectedConditions.elementToBeClickable(customer_signupBtn)).click();
            System.out.println("✓ Customer Signup option selected successfully");
            System.out.println("✓ Successfully navigated to Customer Signup page");

        } catch (Exception e) {
            System.out.println("✗ FAILED to navigate to Customer Signup page - " + e.getMessage());
        }
    }

    public void enterName(String fname, String lname) {
        try {
            WebElement firstNameField = wait.until(ExpectedConditions.elementToBeClickable(firstName));
            firstNameField.sendKeys(fname);
            System.out.println("✓ First name entered successfully: \"" + fname + "\"");

            WebElement lastNameField = wait.until(ExpectedConditions.elementToBeClickable(lastName));
            lastNameField.sendKeys(lname);
            System.out.println("✓ Last name entered successfully: \"" + lname + "\"");

        } catch (Exception e) {
            System.out.println("✗ FAILED to enter name fields - " + e.getMessage());
        }
    }

    public void enterEmail(String mail) {
        try {
            WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(email));
            emailField.sendKeys(mail);
            System.out.println("✓ Email entered successfully: \"" + mail + "\"");

        } catch (Exception e) {
            System.out.println("✗ FAILED to enter email - " + e.getMessage());
        }
    }

    public void enterPassword(String pass) {
        try {
            WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(password));
            passwordField.sendKeys(pass);
            System.out.println("✓ Password entered successfully");

            WebElement con_passwordField = wait.until(ExpectedConditions.elementToBeClickable(con_password));
            con_passwordField.sendKeys(pass);
            System.out.println("✓ Confirm password entered successfully (matches password)");

        } catch (Exception e) {
            System.out.println("✗ FAILED to enter password fields - " + e.getMessage());
        }
    }


    public void securityAnswer()
    {
        try
        {
            String question=wait.until(ExpectedConditions.elementToBeClickable(security_questions)).getText().toLowerCase();
            //System.out.println("Security Question : "+question);

            String[] words=question.split(" ");
            int firstNumber=0;
            int secondNumber=0;
            int count=0;

            for(String word :words)
            {
                int number=convertWordToNumber(word);
                if(number != -1)
                {
                    if(count==0)
                    {
                        firstNumber=number;
                    }
                    else if(count==1)
                    {
                        secondNumber=number;
                    }
                    count++;
                }
            }

            int answer=0;

            if (question.contains("+") || question.contains("plus")) {
                answer = firstNumber + secondNumber;
            } else if (question.contains("-") || question.contains("minus")) {
                answer = firstNumber - secondNumber;
            } else if (question.contains("×") || question.contains("x") || question.contains("*") ||
                    question.contains("times") || question.contains("multiplied")) {
                answer = firstNumber * secondNumber;
            }
            else if (question.contains("divide") || question.contains("/")) {
                if (secondNumber != 0) {
                    answer = firstNumber / secondNumber;
                } else {
                    System.out.println("Cannot divide by zero!");
                }
            }
            else {
                System.out.println("✗ No mathematical operation found in the question!");
            }

            WebElement securityAnswerField=wait.until(ExpectedConditions.elementToBeClickable(security_answerField));
            securityAnswerField.sendKeys(String.valueOf(answer));
            System.out.println("✓ Security Answer entered successfully.answer is: "+answer);
        }
        catch(Exception e)
        {
            System.out.println("✗ FAILED to enter Security Answer fields - " + e.getMessage());
        }


    }

    public int convertWordToNumber(String word)
    {
        if(word.equals("-"))
        {
            return -1;
        }

        String cleanWord=word.replaceAll("[^a-zA-Z0-9-]","").toLowerCase();

        if(cleanWord.contains("-"))
        {
            String[] numberPart=cleanWord.split("-");
            int total = 0;
            for(String part:numberPart)
            {
                int number=convertWordToNumber(part);
                if(number==-1)
                {
                    return -1;
                }
                else
                {
                    total += number;
                }
                return total;
            }
        }

        try
        {
            return Integer.parseInt(cleanWord);
        }
        catch (Exception e)
        {

        }
        switch(cleanWord) {
            case "zero": return 0;
            case "one": return 1;
            case "two": return 2;
            case "three": return 3;
            case "four": return 4;
            case "five": return 5;
            case "six": return 6;
            case "seven": return 7;
            case "eight": return 8;
            case "nine": return 9;
            case "ten": return 10;
            case "eleven": return 11;
            case "twelve": return 12;
            case "thirteen": return 13;
            case "fourteen": return 14;
            case "fifteen": return 15;
            case "sixteen": return 16;
            case "seventeen": return 17;
            case "eighteen": return 18;
            case "nineteen": return 19;
            case "twenty": return 20;
            case "twentyone": return 21;
            case "twentytwo": return 22;
            case "twentythree": return 23;
            case "twentyfour": return 24;
            case "twentyfive": return 25;
            case "twentysix": return 26;
            case "twentyseven": return 27;
            case "twentyeight": return 28;
            case "twentynine": return 29;
            case "thirty": return 30;

            default:
                return -1;
        }

    }



    public void clickAgree() {
        try {
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(agree)).click();
            System.out.println("✓ Terms & Conditions checkbox clicked successfully");

        } catch (Exception e) {
            System.out.println("✗ FAILED to click Terms & Conditions checkbox - " + e.getMessage());
        }
    }

    public void submit() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(successMsg),
                    ExpectedConditions.visibilityOfElementLocated(existAccountMsg)
            ));


            if (!driver.findElements(successMsg).isEmpty() &&
                    driver.findElement(successMsg).isDisplayed()) {

                String successText = driver.findElement(successMsg).getText();
               // System.out.println("Success message: " + successText);

                if (successText.contains("Registration successful! Please check your email to verify your account.")) {
                    System.out.println("✓ Submit button clicked successfully");
                    System.out.println("✓ Customer registration Completed");
                }
            }
            else if (!driver.findElements(existAccountMsg).isEmpty() &&
                    driver.findElement(existAccountMsg).isDisplayed()) {

                String errorText = driver.findElement(existAccountMsg).getText();
                //System.out.println("Error message: " + errorText);

                if (errorText.contains("An account with this email already exists.")) {
                    System.out.println("✓ Submit button clicked successfully");
                    System.out.println("✓ But with this email one account already exists.");
                }
            }
            else {
                System.out.println("✗ Something Wrong Happened - No message found");
            }

        } catch (Exception e) {
            System.out.println("✗ FAILED to submit registration form - " + e.getMessage());
        }
    }

//    public void closeModal()
//    {
//        try {
//            wait.until(ExpectedConditions.alertIsPresent());
//
//            Alert alert = driver.switchTo().alert();
//            System.out.println("Alert text: " + alert.getText());
//            alert.accept();
//
//        } catch (Exception e) {
//            System.out.println("No alert present: " + e.getMessage());
//        }
//    }

}
