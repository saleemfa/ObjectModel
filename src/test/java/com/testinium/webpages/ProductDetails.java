package com.testinium.webpages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductDetails {
    private WebDriver driver;

    @FindBy(tagName = "h1")
    WebElement heading;

    @FindBy(id = "sp-title")
    WebElement productDescription;

    @FindBy(id = "sp-price-lowPrice")
    WebElement productPrice;

    @FindBy(id = "buy-now")
    WebElement addCartButton;

    @FindBy(xpath = "//a[@aria-label='Adeti Artır']")
    WebElement plusLink;

    //Constructor
    public ProductDetails(WebDriver driver)  {
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }


    public void saveProductsDetails() {
        System.out.println(productDescription.getText());
        System.out.println(productPrice.getText());
    }

    public void increaseQuantitiy() {
        plusLink.click();
        addToCart();
    }

    public void addToCart() {
        addCartButton.click();
    }


}