package com.testinium.webpages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions builder;

    @FindBy(tagName = "h1")
    WebElement heading;

    @FindBy(id="L-UserNameField")
    WebElement userName;

    @FindBy(id="L-PasswordField")
    WebElement password;

    @FindBy(id ="gg-login-enter")
    WebElement login_button;


    //Constructor
    public LoginPage(WebDriver driver)  {
        this.driver=driver;
        builder = new Actions(driver);

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void setHumanUserName(String user)  {

        Action seriesOfActions = builder
                .moveToElement(userName)
                .contextClick()
                .sendKeys(userName,  user)
                .build();
        seriesOfActions.perform() ;

    }

    public void setHumanPassword(String pass)  {
        Action seriesOfActions = builder
                .moveToElement(password)
                .contextClick()
                .sendKeys(password,  pass)
                .build();
        seriesOfActions.perform() ;

    }

    public void setUserName(String user) {
        userName.sendKeys(user);
    }

    public void setPassword(String pass) {
        password.sendKeys(pass);
    }

    public boolean checkPageIsReady() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Initially bellow given if condition will check ready state of page.
        if (js.executeScript("return document.readyState").toString().equals("complete"))
            return true;
        else
            return false;
    }

    public void login() {
        login_button.submit();
    }

    public String getTitle() {
        return driver.getTitle();
    }



    /*
    public boolean isPageOpened(){
        //Assertion
        return heading.getText().toString().contains("Apply to Join\n" +
                "the World's Top Talent Network");
    }
     */
}