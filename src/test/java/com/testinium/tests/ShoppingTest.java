package com.testinium.tests;

import com.testinium.webpages.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;


public class ShoppingTest {
    WebDriver driver;
    static Logger log = Logger.getLogger(ShoppingTest.class);


    @Before
    public void setup() {
        ChromeOptions chrome_options = new  ChromeOptions();
        chrome_options.addArguments("--disable-notifications");
        driver = new ChromeDriver(chrome_options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        BasicConfigurator.configure();

    }

    @Test
    public void ShoppingTest() throws InterruptedException {

        //  - Navigate to www.gittigidiyor.com
        log.info("Test Has Started");
        HomePage home = new HomePage(driver);
        home.acceptCookies();

        //  - Check if the homepage loaded properly, Login to website.
        log.info(" - Check if the homepage loaded properly, Login to website.");
        Assert.assertTrue(home.getTitle().equals("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi"));

        // Login to website.
        log.info("- Login to website.\n.");
        home.clickLoginPage();
        Thread.sleep(5000);

        LoginPage loginPage = new LoginPage(driver);
        /*
        for some reasons, the action is resetting login page. need more investigation

        loginPage.setUserName("saleemfa@mail.com");
        loginPage.setPassword("vsnet7com");
        loginPage.login();

         */

        Thread.sleep(10000);

        // - Check if the Login was successful
        log.info("- Check if the Login was successful");
        Assert.assertTrue(home.getTitle().equals("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi"));

        // Type “Bilgisayar” on search box
        log.info("- Type “Bilgisayar” on search box");

        AccountPage account =  new AccountPage(driver);
        account.searchText("Bilgisayar");
        account.search();

        ProductPage products = new ProductPage(driver);
        Thread.sleep(1000);
        //  Open the second page from “Search Results”
        log.info("- Open the second page from “Search Results");
        products.clickNextPage();

        //  According to the results select a random product
        log.info("- According to the results select a random product");
        products.clickRandomProduct();
        Thread.sleep(1000);

        ProductDetails productDetails = new ProductDetails(driver);
        // - Write the “Product Data” and “Product Price” in to a .txt file.
        log.info("- Write the “Product Data” and “Product Price” in to a .txt file");
        productDetails.saveProductsDetails();

        // - Add product to the cart
        log.info("- Add product to the cart");
        productDetails.addToCart();

        // - Check if the price on product listing page and the price on cart is equal
        log.info("Product Price = " + productDetails.readProductInfo());
        home.reloadHomePage();
        ShoppingCart cart =  new ShoppingCart(driver);
        Thread.sleep(2000);
        account.ClickShoppingCart();
        log.info("Cart Price = " + cart.getCartPrice());
        Assert.assertTrue(productDetails.readProductInfo().equals(cart.getCartPrice()));


        // - Increase the quantity and check if the quantity is 2
        log.info("- Increase the quantity and check if the quantity is 2");

        cart.selectProductCart();
        productDetails.increaseQuantity();
        productDetails.addToCart();


        // - Delete the product from the cart and check if the cart is empty
        log.info("- Delete the product from the cart and check if the cart is empty");
        home.reloadHomePage();
        account.ClickShoppingCart();
        cart.clearCart();

        log.info("Test ended");


    }

    @After
    public void close()  {
        driver.close();
    }
}