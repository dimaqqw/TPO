package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VinPage extends BasePage {
    private final Logger log = LogManager.getLogger();
    @FindBy(xpath = "//div[@class='vin-main']/div[2]/input")
    private WebElement vinInput;
    @FindBy(xpath = "//div[@class='vin-main']/div[2]/button")
    private WebElement vinButton;
    @FindBy(xpath = "//button[@class='button button--secondary button--block button--large']")
    private WebElement vinBuy;
    @FindBy(xpath = "//div[@class='error-message']")
    private WebElement errorMessage;
    public VinPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public VinPage open() throws InterruptedException {
        driver.navigate().to("https://av.by/vin");
        log.info("Vin page is opened");
        return this;
    }
    public boolean checkCorectVin(String params) throws InterruptedException {
        vinInput.sendKeys(params);
        log.info("Был введён VIN");
        Thread.sleep(1500);
        vinButton.click();
        log.info("Нажата кнпка проверки VINа");
        Thread.sleep(1500);
        if (vinBuy.isDisplayed()){
            log.info("Появилась кнопка отчёта VIN номера");
            return true;
        }
        else{
            return false;
        }
    }
    public boolean checkUnCorectVin(String params) throws InterruptedException {
        vinInput.sendKeys(params);
        log.info("Был введён VIN");

        Thread.sleep(1500);
        vinButton.click();
        log.info("Нажата кнпка проверки VINа");
        Thread.sleep(1500);
        if (errorMessage.isDisplayed()){
            log.info("Появилась ошибка");
            return true;
        }
        else{
            return false;
        }
    }
}
