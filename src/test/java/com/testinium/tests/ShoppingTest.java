package com.testinium.tests;

import com.testinium.webpages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ShoppingTest {
    WebDriver driver;

    @Before
    public void setup(){
        //use FF Driver

        ChromeOptions chrome_options = new  ChromeOptions();
        chrome_options.addArguments("--disable-notifications");
        driver = new ChromeDriver(chrome_options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void ShoppingTest() throws InterruptedException {

        //Create object of HomePage Class
        HomePage home = new HomePage(driver);
        home.acceptCookies();
        home.clickLoginPage();

        LoginPage loginPage = new LoginPage(driver);

        /*

        Thread.sleep(3000);
        loginPage.setUserName("saleemfa@mail.com");
        Thread.sleep(3000);
        loginPage.setPassword("vsnet7com");
        Thread.sleep(3000);

         */
        //Thread.sleep(10000);
        Thread.sleep(15000);


        AccountPage account =  new AccountPage(driver);
        account.searchText("Bilgisayar");
        account.search();

        ProductPage products = new ProductPage(driver);
        //products.clickNextPage();
        //Thread.sleep(3000);
        products.clickRandomProduct();
        Thread.sleep(1000);

        ProductDetails productDetails = new ProductDetails(driver);
        productDetails.saveProductsDetails();
        productDetails.addToCart();

        home.reloadHomePage();
        account.ClickShoppingCart();

        ShoppingCart cart =  new ShoppingCart(driver);
        cart.selectProductCart();
        productDetails.increaseQuantitiy();


/*
        //Create object of DeveloperPortalPage
        DeveloperPortalPage devportal= new DeveloperPortalPage(driver);

        //Check if page is opened
        Assert.assertTrue(devportal.isPageOpened());

        //Click on Join Toptal
        devportal.clikOnJoin();

        //Create object of DeveloperApplyPage
        DeveloperApplyPage applyPage =new DeveloperApplyPage(driver);

        //Check if page is opened
        Assert.assertTrue(applyPage.isPageOpened());

        //Fill up data

        applyPage.setTalentKind("I am a developer");
        applyPage.setDeveloper_email("dejan@toptal.com");
        applyPage.setDeveloper_full_name("Dejan Zivanovic Automated Test");
        applyPage.setDeveloper_password("password123");
        applyPage.setDeveloper_password_confirmation("password123");

        //Click on join
        //applyPage.clickOnJoin();

        */
    }

    @After
    public void close(){
       // driver.close();
    }
}