package org.example;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    /**
     * осуществление первоначальной настройки
     */
    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //System.setProperty("webdriver.firefox.driver", ConfProperties.getProperty("firefoxdriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage")); }
    /**
     * тестовый метод для осуществления аутентификации
     */
    @Test
    public void loginTest() {
        //получение доступа к методам класса LoginPage для взаимодействия с элементами страницы
        //значение login/password берутся из файла настроек по аналогии с chromedriver
        //и loginpage
        //вводим логин
        String login="andrew_gav1990";
        String passwrd = "Master&Margarita";
        loginPage.clickEnterBtn();//нажать Вход

        loginPage.inputLogin("andrew_gav1990");
        //нажимаем кнопку ввода пароля
        loginPage.clickEnterPasswordBtn();
        //вводим пароль
        //loginPage.inputPassword(ConfProperties.getProperty("passwd"));
        loginPage.inputPassword(passwrd);
        //нажимаем кнопку входа
        loginPage.clickEnterBtn1();
        //получаем отображаемый логин
        String user = profilePage.getUserName();
        //и сравниваем его с логином из файла настроек
        Assert.assertEquals(ConfProperties.getProperty("login"), user);
        //написать новое письмо
        loginPage.clickWriteLetterBtn();
        //ввод адреса
        loginPage.inputAddress(ConfProperties.getProperty("address"));
        //ввод текста в письме
        loginPage.inputTextLetter(ConfProperties.getProperty("text"));
        //нажать отправить
        loginPage.clickSendBtn();

    }
    /**
     * осуществление выхода из аккаунта с последующим закрытием окна браузера
     */


   /* @AfterClass
    public static void tearDown() {
        profilePage.entryMenu();
        profilePage.userLogout();
        driver.quit(); } }driver.get(ConfProperties.getProperty("loginpage")); } }*/
}