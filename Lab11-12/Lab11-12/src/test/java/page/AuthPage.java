package page;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.TestDataReader;
import service.UserFactory;


import java.time.Duration;

public class AuthPage extends BasePage {
    private final Logger log = LogManager.getLogger();

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton; // Кнопка для открытия окна авторизации
    @FindBy(xpath = "//input[@name='phone.number']")
    private WebElement phoneInput; // Инпут для телефона
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput; // Инпут для пароля
    @FindBy(xpath = "//div[@class='auth__submit']/button")
    private WebElement authSubmit; // Сабмит для входа
    public AuthPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public AuthPage open() throws InterruptedException {
        driver.navigate().to("https://av.by/");
        log.info("Main page is opened");
        loginButton.click();
        log.info("Auth page is opened");
        return this;
    }
    public User getUser() {
        return UserFactory.getUserInfo();
    }
    public AuthPage fillEmailAndPassword() throws InterruptedException {
        String email = TestDataReader.getTestData("phone");
        String password = TestDataReader.getTestData("password");
        wait.until(ExpectedConditions.elementToBeClickable(phoneInput)).sendKeys(email);
        log.info("Phone is filled");

        wait.until(ExpectedConditions.elementToBeClickable(passwordInput)).sendKeys(password);
        log.info("Password is filled");

        wait.until(ExpectedConditions.elementToBeClickable(authSubmit)).click();
        log.info("Login button is clicked");

        // Проверка успешной авторизации
        java.time.Duration timeout = java.time.Duration.ofSeconds(3);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.withTimeout(timeout)
                    .ignoring(TimeoutException.class)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='error-message']")));
            log.info("User login failed");
        } catch (TimeoutException e) {
            log.info("User is successfully logged in");
            // Добавим проверку, перенаправлены ли мы на главную страницу после авторизации
            try {
                wait.until(ExpectedConditions.urlToBe("https://av.by/"));
                log.info("Redirected to the main page. User is authenticated.");
            } catch (TimeoutException ex) {
                log.error("Redirect to the main page failed. Authentication might have an issue.");
            }
            return this;
        }
        throw new AssertionError("User login failed");
    }
}
