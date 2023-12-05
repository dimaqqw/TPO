package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
    }
    @Test
    public void filterExpensiveBMWs() throws InterruptedException {
        avPage.searchAllExpensiveBMWs();
    }
    @Test
    public void CheckMostExpensiveE39() throws InterruptedException {
        avPage.checkMostExpensiveE39Model();
    }

    @AfterMethod
    public void getdown(){
        driver.quit();
    }
}
