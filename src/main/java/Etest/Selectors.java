package Etest;


import java.util.Random;
public interface Selectors {
    Random rand = new Random();
    int[] upperBound = {45,100};
    int randomInt = rand.nextInt(upperBound[0]);
    int randomInt1 = rand.nextInt(upperBound[1]);

    public String [] surname = {"Jude", "Okonkwo","Ademola", "Ajayi", "Iteriba"};
    String [] availableTestNames = {"femi", "okeke", "ajunwa", "thomson","ilabaye"};
    int pickName = rand.nextInt(availableTestNames.length);
    int pickSurname = rand.nextInt(surname.length);
    public String siteUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=common/home";
    public String loginPage = "//div[@id='main-navigation']/div[1]/div/div[3]/nav/div/ul/li[6]/a[@role='button']//span[@class='title']";
    //loginPage Selectors
    String fName  = "input-firstname";
    String lName = "input-lastname";
    String eMail = "input-email";
    String number = "input-telephone";
    String password = "input-password";
    String confirmPassword = "input-confirm";
    String selectNo = "[for='input-newsletter-yes']";
    String checkPrivatePolicy = "[for='input-agree']";
    String submit = "[value='Continue']";
    String accountCreated = "[]";

    String email = String.format("%s%s%d%d@gmail.com",availableTestNames[pickName], surname[pickSurname],randomInt,randomInt1);
    String phoneNumber = "+2348233487690";
    String getPassword = surname[pickSurname]+randomInt;
    String getConfirmPassword = getPassword;

    //successful account creation
    String element = "h1";
    String webText = "Your Account Has Been Created!";

    //display password Used

}


