package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ProfilePage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    /** определение локатора меню пользователя  */
    @FindBy(xpath = "//span[contains (@class, 'ph-project__user-name')]")
    private WebElement userMenu;


    @FindBy(xpath = "//span[contains (@class, 'compose-button__txt')]")
    private WebElement writeLetterBtn;

    /**метод для получения имени пользователя из меню пользователя */
    public String getUserName() {
        String userName = userMenu.getText();
        return userName; }

    /**метод для нажатия кнопки меню пользователя*/
    public void entryMenu() {
        userMenu.click(); }
    /**
     * метод для нажатия кнопки выхода из аккаунта
     */
    public void clickWriteNewLetter() {
        writeLetterBtn.click(); } }