package page;

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

public class FavoritePage extends BasePage{
    private final Logger log = LogManager.getLogger();
    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton; // Кнопка для открытия окна авторизации
    @FindBy(xpath = "//input[@name='phone.number']")
    private WebElement phoneInput; // Инпут для телефона
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput; // Инпут для пароля
    @FindBy(xpath = "//div[@class='auth__submit']/button")
    private WebElement authSubmit; // Сабмит для входа
    @FindBy(xpath = "//div[@class='listing-top']/div[2]/h3/a")
    private WebElement topCar;
    @FindBy(xpath = "//p[@class='card__actions']/button[2]")
    private WebElement buttonFav;
    @FindBy(xpath = "//a[@href='https://av.by/profile/bookmarks' and @title='Закладки']")
    private WebElement favList;
    @FindBy(xpath = "//div[@class='listing__items']")
    private WebElement checkCar;
    @FindBy(xpath = "//div[@class='bookmarks-empty']")
    private WebElement emptyList;

    public FavoritePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public FavoritePage getListOfCarsWithModel(String model) throws InterruptedException {

        return this;
    }
    public FavoritePage open() throws InterruptedException {
        driver.navigate().to("https://av.by/");
        log.info("Main page is opened");
        loginButton.click();
        log.info("Auth page is opened");
        return this;
    }
    public FavoritePage login() throws InterruptedException {
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
        }

        return this;
    }
    public boolean choiceCar() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(topCar)).click();
        log.info("Car is choice");
        wait.until(ExpectedConditions.elementToBeClickable(buttonFav)).click();
        log.info("Car is added to favs");
        wait.until(ExpectedConditions.elementToBeClickable(favList)).click();
        log.info("Openned fav");
        Thread.sleep(1000);
        if (wait.until(ExpectedConditions.elementToBeClickable(checkCar)).isDisplayed()){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean deleteCar() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(topCar)).click();
        log.info("Car is choice");
        wait.until(ExpectedConditions.elementToBeClickable(buttonFav)).click();
        log.info("Car is added to favs");
        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(buttonFav)).click();
        log.info("Car is deleted to favs");
        wait.until(ExpectedConditions.elementToBeClickable(favList)).click();
        log.info("Openned fav");
        Thread.sleep(1000);
        if (wait.until(ExpectedConditions.elementToBeClickable(emptyList)).isDisplayed()){
            return true;
        }
        else{
            return false;
        }
    }
}
