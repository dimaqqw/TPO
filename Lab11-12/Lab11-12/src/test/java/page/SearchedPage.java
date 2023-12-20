package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import service.TestDataReader;

public class SearchedPage extends BasePage{
    private final Logger log = LogManager.getLogger();
    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton; // Кнопка для открытия окна авторизации
    @FindBy(xpath = "//input[@name='phone.number']")
    private WebElement phoneInput; // Инпут для телефона
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput; // Инпут для пароля
    @FindBy(xpath = "//div[@class='auth__submit']/button")
    private WebElement authSubmit; // Сабмит для входа
    @FindBy(xpath = "//a[@title='BMW']")
    private WebElement bmwFilter; // Кнопка всех BMW
    @FindBy(xpath = "//button[@name='p-6-0-3-model']")
    private  WebElement model; // Droplist моделей
    @FindBy(xpath = "//button[@data-item-label='5 серия']")
    private  WebElement model5Seria; // 5 серия
    @FindBy(xpath = "//button[@name='p-6-0-4-generation']")
    private  WebElement generation; // Кнопка поколения
    @FindBy(xpath = "//input[@value='12786']/../..")
    private WebElement chooiceE39;
    @FindBy(xpath = "//button[@class='button button--secondary button--block']")
    private WebElement submitAll;
    @FindBy(xpath = "//div[@class='filter__show-advanced']/button[3]")
    private WebElement saveSearch;
    @FindBy(xpath = "//ul[@class='nav__personal']/li[2]/a")
    private WebElement redirectToSavedSearches;
    @FindBy(xpath = "//div[@class='modal__content']")
    private WebElement modal;

    public SearchedPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public SearchedPage open() throws InterruptedException {
        driver.navigate().to("https://av.by/");
        log.info("Main page is opened");
        loginButton.click();
        log.info("Auth page is opened");
        String email = TestDataReader.getTestData("phone");
        String password = TestDataReader.getTestData("password");
        wait.until(ExpectedConditions.elementToBeClickable(phoneInput)).sendKeys(email);
        log.info("Phone is filled");

        wait.until(ExpectedConditions.elementToBeClickable(passwordInput)).sendKeys(password);
        log.info("Password is filled");

        wait.until(ExpectedConditions.elementToBeClickable(authSubmit)).click();
        log.info("Login button is clicked");
        return this;
    }
    public boolean findAndSaveSearch() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(bmwFilter)).click();
        log.info("Выбраны BMWs");
        wait.until(ExpectedConditions.elementToBeClickable(model)).click();
        log.info("Открыта модель");
        wait.until(ExpectedConditions.elementToBeClickable(model5Seria)).click();
        log.info("Выбрана модель");
        wait.until(ExpectedConditions.elementToBeClickable(generation)).click();
        log.info("Открыто поколение");
        wait.until(ExpectedConditions.elementToBeClickable(chooiceE39)).click();
        log.info("Поколение выбрано");
        wait.until(ExpectedConditions.elementToBeClickable(submitAll)).click();
        log.info("Осуществлён поиск");
        wait.until(ExpectedConditions.elementToBeClickable(saveSearch)).click();
        log.info("Поиск сохранён");
        Thread.sleep(1500);
        if (modal.isDisplayed()){
            log.info("Появилась модалька, УСПЕХ!");
            return true;
        }
        else{
            return false;
        }

    }
}
