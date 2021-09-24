package com.testinium.webpages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class ProductPage {
    private WebDriver driver;

    @FindBy(tagName = "h1")
    WebElement heading;

    @FindBy(xpath = "a[title='Sonraki sayfa'] span")
    WebElement nextPage;

    List<WebElement> productList;


    //Constructor
    public ProductPage(WebDriver driver)  {
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void clickNextPage()
    {
        nextPage.click();
    }


    public void clickRandomProduct() {
                productList = driver.findElements(By.xpath("//ul[@class='sc-1yvp483-0 sc-1favwb2-1 dTGwmm brViIn']"));
                Random r = new Random();
                int linkNo= r.nextInt(productList.size());
                System.out.print("Link  no = "  +  linkNo);
                productList.get(linkNo).findElement(By.className("jVhkOY")).click();

    }


}