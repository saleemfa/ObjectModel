package com.testinium.webpages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ShoppingCart {
    private WebDriver driver;

    @FindBy(tagName = "h1")
    WebElement heading;

    @FindBy( className = "title-link")
    WebElement currentProduct;



    @FindBy(className = "gg-icon-bin-medium")
    WebElement deleteCart;


    @FindBy(xpath = "//div[@class='total-price']")
    WebElement currentPrice;

    //Constructor
    public ShoppingCart(WebDriver driver)  {
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void clearCart() {
        deleteCart.click();
    }



    public void selectProductCart() {
        currentProduct.click();
    }


    public String getTitle() {
        return driver.getTitle();
    }

    public String getCartPrice()
    {
        return currentPrice.getText();
    }


}