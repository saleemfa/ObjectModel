package com.testinium.webpages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountPage {
    private WebDriver driver;

    @FindBy(tagName = "h1")
    WebElement heading;


    @FindBy( name = "k")
    WebElement searchBox;

    @FindBy(className = "searchBtn")
    WebElement searchButton;

    @FindBy(xpath = "//*[@class='gg-icon gg-icon-close icon-close']")
    WebElement resultList;

    @FindBy(className = "hbbXGs")
    WebElement shoppingCart;


    //Constructor
    public AccountPage(WebDriver driver)  {
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void searchText(String search)  {
        searchBox.clear();
        searchBox.sendKeys(search);
    }

    public void search() {
        searchBox.sendKeys("\n");
    }

    public void ClickShoppingCart()
    {
        shoppingCart.click();
    }
}