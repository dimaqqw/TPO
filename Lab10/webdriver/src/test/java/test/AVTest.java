package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.AVPage;

public class AVTest {
    private WebDriver driver;
    private AVPage avPage;

    @BeforeMethod
    public void setup () throws InterruptedException {
        ChromeOptions options = new ChromeOptions().setBinary("\"C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe\"");
        driver = new ChromeDriver(options);
        driver.get("https://av.by/");
        avPage = new AVPage(driver);
    }

    @Test
    public void authTestCase() throws InterruptedException {
        avPage.auth("445577401", "TEST9TPO");
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='nav__item nav__item--user nav__item--dropdown']")).isDisplayed());
    }
    @Test
    public void filterExpensiveBMWs() throws InterruptedException {
        avPage.searchAllExpensiveBMWs();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='listing__items']/div[1]/div/div[2]/h3/a")).isDisplayed());
    }
    @Test
    public void CheckMostExpensiveE39() throws InterruptedException {
        avPage.checkMostExpensiveE39Model();
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='card__title']")).isDisplayed());
    }

    @AfterMethod
    public void getdown(){
        driver.quit();
    }
}
