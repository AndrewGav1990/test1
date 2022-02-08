package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//div[contains (@class, 'submit-button-wrap')]")
    private  WebElement enterPasswordBtn;

    @FindBy(xpath = "//input[contains (@name, 'password')]")
    private  WebElement passwordField;

    @FindBy(xpath = "//button[contains(@class, 'resplash-btn_big')]")
    private WebElement enterBtn;
    /**
     * определение локатора поля ввода логина
     */
  /*  //кнопка Ввод пароля
    @FindBy(xpath = "//button[contains(@data-test-id, 'next-button')]")
    private  WebElement enterPasswordBtn;*/

    @FindBy(xpath = "//button[contains (@data-test-id, 'submit-button')]")
    private WebElement enterBtn1;

    @FindBy(xpath = "//div[@class='base-0-2-57']/div/div/input[contains(@class, 'input-0-2-71')]")
    //@FindBy(xpath = "//*[@id='root']/div/div/div/div[2]/div/div/form/div[2]/div[2]/div[1]/div/div/div/div/div/div[1]/div/input")
    private WebElement loginField;

    /** определение локатора кнопки входа в аккаунт     */
    @FindBy(xpath = "//*[contains(text(), 'Войти')]/..")
    private WebElement loginBtn;

    /** определение локатора поля ввода пароля     */
/*    @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]")
    private WebElement passwdField;*/

    @FindBy(xpath = "//span[contains (@class, 'compose-button__txt')]")
    private WebElement writeLetter;

    @FindBy(xpath = "//input[contains(@class, 'container--H9L5q')]")
    private WebElement addressField;

    @FindBy(xpath = "//div[contains(@class, 'editable-ytoj')]")
    private WebElement textLetter;

    @FindBy(xpath = "//span[contains(@class, 'button2__wrapper')]")
    private WebElement send;

    public void inputAddress(String address){
        addressField.sendKeys(address);
    }
    public void inputLogin(String login) {
        loginField.sendKeys(login); }

    public void inputTextLetter(String text){
        textLetter.sendKeys(text);
    }
    /**
     * метод для ввода пароля
     */
    public void inputPassword(String passwd) {
        passwordField.sendKeys(passwd); }
    /**
     * метод для осуществления нажатия кнопки входа в аккаунт
     */
    public void clickEnterPasswordBtn() {
        enterPasswordBtn.click(); }
    public void clickEnterBtn() {
        enterBtn.click(); }
    public void clickEnterBtn1(){
        enterBtn1.click();
    }
    public void clickWriteLetterBtn(){
        writeLetter.click();
    }
    public void clickSendBtn(){
        send.click();
    }
}