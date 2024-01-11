package Etest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;

import static Etest.Selectors.pickName;
import static Etest.Selectors.pickSurname;

public class EcommerceObjects {
    WebDriver driver;
    WebDriverWait wait;
    WebDriverManager manage;
    WebElement element;
    Actions actions;

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get(Selectors.siteUrl);
        driver.manage().window().maximize();
    }
    public void accountCreation(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[name='search']")));
        driver.findElement(By.cssSelector("[name='search']")).sendKeys("hey");
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[id='widget-navbar-217834']")));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[class='navbar-nav horizontal']")));
            driver.findElement(By.xpath(Selectors.loginPage)).click();
            //driver.findElement(By.cssSelector("[class='type-text']")).click();
        }catch(Exception e){
            System.out.println("It's not working");
        }


    }

    public void createUser(){
        try{
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[value='Login']")));
        //driver.findElement(By.cssSelector("a[href='https://ecommerce-playground.lambdatest.io/index.php?route=account/register']")).click();
        driver.findElement(By.xpath("//aside[@id='column-right']//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/register']")).click();
        driver.findElement(By.id(Selectors.fName)).sendKeys(Selectors.availableTestNames[pickName]);
        driver.findElement(By.id(Selectors.lName)).sendKeys(Selectors.surname[pickSurname]);
        driver.findElement(By.id(Selectors.eMail)).sendKeys(Selectors.email);
        driver.findElement(By.id(Selectors.number)).sendKeys(Selectors.phoneNumber);
        driver.findElement(By.id(Selectors.password)).sendKeys(Selectors.getPassword);
        driver.findElement(By.id(Selectors.confirmPassword)).sendKeys(Selectors.getConfirmPassword);
        driver.findElement(By.cssSelector(Selectors.selectNo)).click();
        driver.findElement(By.cssSelector(Selectors.checkPrivatePolicy)).click();
        driver.findElement(By.cssSelector(Selectors.submit)).click();
        }catch (Exception e){
            this.tearDown();
        }


    }
    public void confirmAccountCreation(String element, String webText){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(element)));
        WebElement verifiableElement = driver.findElement(By.cssSelector(element));
        String verifiableText = verifiableElement.getText();
        Assert.assertEquals(webText,verifiableText);
        driver.findElement(By.linkText("Continue")).click();

    }
    public void logout(){
        driver.findElement(By.linkText("Logout")).click();
        driver.findElement(By.linkText("Continue")).click();
    }
    public void login(){
        driver.findElement(By.linkText("My account")).click();
        driver.findElement(By.id("input-email")).sendKeys(Selectors.email);
        driver.findElement(By.id("input-password")).sendKeys(Selectors.getPassword);
        driver.findElement(By.cssSelector("[value=\"Login\"]")).click();
    }
    public void tearDown(){
        driver.quit();
    }
    public static void main(String[] args){
        EcommerceObjects ecommerce = new EcommerceObjects();
        ecommerce.setUp();
        ecommerce.accountCreation();
        ecommerce.createUser();
        ecommerce.confirmAccountCreation(Selectors.element,Selectors.webText);
        ecommerce.logout();
        ecommerce.login();
        ecommerce.tearDown();
        System.out.println(Selectors.getPassword);

    }
}
