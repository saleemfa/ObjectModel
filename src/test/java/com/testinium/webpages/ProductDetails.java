package com.testinium.webpages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.*;


public class ProductDetails {
    private WebDriver driver;

    //String directory = System.getProperty("user.home");
    String fileName = "sample.txt";
    String absolutePath =   fileName;

    @FindBy(tagName = "h1")
    WebElement heading;

    @FindBy(id = "sp-title")
    WebElement productDescription;

    @FindBy(id = "sp-price-lowPrice")
    WebElement productPrice;

    @FindBy(id = "buy-now")
    WebElement addCartButton;


    @FindBy(xpath = "//input[@name='buyitnow_adet']")
    WebElement quantity;


    //Constructor
    public ProductDetails(WebDriver driver)  {
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }


    public void saveProductsDetails() {
        //System.out.println(productDescription.getText());
        //System.out.println(productPrice.getText());

        // Write the content in file
        try(FileWriter fileWriter = new FileWriter(absolutePath)) {
            fileWriter.write(productPrice.getText());
            fileWriter.close();
        } catch (IOException e) {
            // Cxception handling
        }
    }

    public String readProductInfo()
    {
        // Read the content from file
        String price = "";
        try(FileReader fileReader = new FileReader(absolutePath))
        {
            int ch = fileReader.read();
            while(ch != -1) {
                price  = price +  (char)ch;
                ch = fileReader.read();
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            // Exception handling
        } catch (IOException e) {
            // Exception handling
        }

        return price;
    }

    public void increaseQuantity()
    {
        //quantity.sendKeys("2");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.getElementById('buyitnow_adet').setAttribute('value', '2')");

    }

    public void addToCart() {
        addCartButton.click();
    }

    public String getTitle() {
        return driver.getTitle();
    }


}