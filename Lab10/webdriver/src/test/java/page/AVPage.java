package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPathEvaluationResult;
import java.time.Duration;

public class AVPage {
    private WebDriver driver;
    public  AVPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@class='button button--default button--block button--large']")
    private WebElement cancelCookieButton;
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
    @FindBy(xpath = "//button[@title='актуальные']")
    private WebElement actualButton; // Выпадающий список фильтрации
    @FindBy(xpath = "//button[@data-item-label='дорогие']")
    private WebElement expensiveFilter; // Указываем фильтрацию 'Дорогие'
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
    @FindBy(xpath = "//div[@class='listing__items']/div[1]/div/div[2]/h3/a")
    private WebElement firstExpensive;


    public void auth(String login, String password) throws InterruptedException {
        skipCookie();
        loginButton.click();
        Thread.sleep(1000);
        phoneInput.sendKeys(login);
        Thread.sleep(1000);
        passwordInput.sendKeys(password);
        Thread.sleep(1000);
        authSubmit.click();
        Thread.sleep(5000);
    }
    public void searchAllExpensiveBMWs() throws InterruptedException {
        skipCookie();
        bmwFilter.click();
        Thread.sleep(1000);
        actualButton.click();
        Thread.sleep(1000);
        expensiveFilter.click();
        Thread.sleep(5000);
    }
    public void checkMostExpensiveE39Model() throws InterruptedException {
        skipCookie();
        bmwFilter.click();
        Thread.sleep(1000);
        model.click();
        Thread.sleep(1000);
        model5Seria.click();
        Thread.sleep(1000);
        generation.click();
        Thread.sleep(1000);
        chooiceE39.click();
        Thread.sleep(1000);
        submitAll.click();
        Thread.sleep(1000);
        actualButton.click();
        Thread.sleep(1000);
        expensiveFilter.click();
        Thread.sleep(1000);
        firstExpensive.click();
        Thread.sleep(3000);
    }
    public void skipCookie() throws InterruptedException {
        Thread.sleep(1000);
        cancelCookieButton.click();
    }
}
