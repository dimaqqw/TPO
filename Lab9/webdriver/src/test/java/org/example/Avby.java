package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.PreparedStatement;
import java.time.Duration;

public class Avby {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions().setBinary("\"C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe\"");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://av.by/");

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/login']")));
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='phone.number']")));
        driver.findElement(By.xpath("//input[@name='phone.number']")).sendKeys("445577401");

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='phone.number']")));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("TEST9TPO");

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[1]/div[1]/div/div[2]/div[2]/div/div[1]/form/fieldset/div[4]/button")));
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[1]/div[1]/div/div[2]/div[2]/div/div[1]/form/fieldset/div[4]/button")).click();

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div[1]/main/div/div/div/div[2]/div[1]/div[2]/div/ul[3]/li[1]/a")));
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div[1]/main/div/div/div/div[2]/div[1]/div[2]/div/ul[3]/li[1]/a")).click();

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='актуальные']")));
        driver.findElement(By.xpath("//button[@title='актуальные']")).click();

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-item-label='дорогие']")));
        driver.findElement(By.xpath("//button[@data-item-label='дорогие']")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}
