package test;

import com.codeborne.selenide.SelenideElement;
import org.example.ConfProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.page;
import org.testng.annotations.Test;

public class LoginAutomation {
    @Test
    public void login() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", conf.getProperty("chromedriver"));
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");

       /* SelenideElement enterBtn=$x("//button[contains(@class, 'resplash-btn resplash-btn_primary')]");
        enterBtn.click();
        SelenideElement username=$x("//input[contains(@name, 'username')]");
        username.sendKeys("andrew_gavr1990");*/
        WebElement enterBtn=driver.findElement(By.xpath("//button[contains(@class, 'resplash-btn resplash-btn_primary')]"));
        enterBtn.click();
        TimeUnit.SECONDS.sleep(2);
        WebElement username=driver.findElement(By.xpath("//input[contains(@name, 'username')]"));
        Assert.assertTrue(username.isDisplayed(), "не найден");
        username.sendKeys("andrew_gavr1990");
        WebElement enterPasswordBtn = driver.findElement(By.xpath("//button[contains(@data-test-id, 'next-button')]"));
        enterPasswordBtn.click();
        WebElement password=driver.findElement(By.xpath("//button[contains(@class, 'resplash-btn resplash-btn_primary')]"));
        password.sendKeys("Master&Margarita");


        WebElement login=driver.findElement(By.xpath("//button[contains (@data-test-id, 'submit-button')]"));
        login.click();

        /*String actualUrl="https://live.browserstack.com/dashboard";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);*/
    }
}