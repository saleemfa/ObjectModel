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

    @FindBy(className = "total-price")
    WebElement currentPrice;

    //Constructor
    public ShoppingCart(WebDriver driver)  {
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }



    public void selectProductCart() {
        //<select class="amount" data-id="493274739" data-maxamount="9" data-value="3" value="3">
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("document.getElementsByClassName('amount')[0].setAttribute('data-value', '3')");

        currentProduct.click();

    }


}