package com.testinium.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    //Page URL
    private static String PAGE_URL="https://www.gittigidiyor.com";

    //Locators
    @FindBy(how = How.CLASS_NAME, using = "gekhq4-4")
    private WebElement loginLink;

    @FindBy(how =  How.LINK_TEXT, using = "Giriş Yap")
    private WebElement loginButton;

    @FindBy(how = How.CLASS_NAME,using = "lfsBU")
    private WebElement cookiesLink;


    //Constructor
    public HomePage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies() {
        cookiesLink.click();
    }

    public void reloadHomePage() {
        driver.get(PAGE_URL);
    }

    public void clickLoginPage(){

        loginLink.click();
        loginButton.click();

    }

    public String getTitle() {
        return driver.getTitle();
    }


}