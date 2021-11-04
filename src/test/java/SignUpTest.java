import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SignUpTest {

    @Test
    public void zipCodeShouldAccept5Digits() {
        //Шаги в тест-кейсе(позитивный):
        //1.ОТКРЫТЬ СТАРНИЦУ https://www.sharelane.com/cgi-bin/register.py
        //2.ВВЕСТИ ЛЮБЫЕ 5 ЦИФР (НАПРИМЕР 12345)
        //3.НАЖАТЬ КНОПКУ CONTINUE
        //4.УБЕДИТЬСЯ, ЧТО МЫ НА СТРАНИЦЕ SIGN UP
        //5.ЗАКРЫТЬ БРАУЗЕР.
        //Далее наши действия по автоматизации. Смотри по порядку.
        //0.УСТАНОВКА ПЕРЕМЕННОЙ СРЕДЫ:
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //1.ОТКРЫТЬ СТАРНИЦУ https://www.sharelane.com/cgi-bin/register.py:
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //2.ВВЕСТИ ЛЮБЫЕ 5 ЦИФР (НАПРИМЕР 12345):
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //3.НАЖАТЬ КНОПКУ CONTINUE:
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //4.УБЕДИТЬСЯ, ЧТО МЫ НА СТРАНИЦЕ SIGN UP:
        boolean isOpened = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        assertTrue(isOpened, "Страница регистрации не открыл ась");
        //5.ЗАКРЫТЬ БРАУЗЕР:
        driver.quit();
    }

    @Test
    public void zipCodeShouldNotAccept6Digits() {
        //Шаги в тест-кейсе(негативный):
        //1.ОТКРЫТЬ СТАРНИЦУ https://www.sharelane.com/cgi-bin/register.py
        //2.ВВЕСТИ ЛЮБЫЕ 6 ЦИФР (НАПРИМЕР 123456)
        //3.НАЖАТЬ КНОПКУ CONTINUE
        //4.УБЕДИТЬСЯ, ЧТО СООБЩЕНИЕ ОБ ОШИБКЕ ПОЯВЛЯЕТСЯ (Oops, error on page. ZIP code should have 5 digits);
        //5.ЗАКРЫТЬ БРАУЗЕР.
        //Далее наши действия по автоматизации. Смотри по порядку.
        //0.УСТАНОВКА ПЕРЕМЕННОЙ СРЕДЫ:
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //1.ОТКРЫТЬ СТАРНИЦУ https://www.sharelane.com/cgi-bin/register.py:
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //2.ВВЕСТИ ЛЮБЫЕ 6 ЦИФР (НАПРИМЕР 123456):
        driver.findElement(By.name("zip_code")).sendKeys("123456");
        //3.НАЖАТЬ КНОПКУ CONTINUE:
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //4.УБЕДИТЬСЯ, ЧТО СООБЩЕНИЕ ОБ ОШИБКЕ ПОЯВЛЯЕТСЯ (Oops, error on page. ZIP code should have 5 digits);
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(error, "Oops, error on page. ZIP code should have 5 digits",
                "Сообщение об ошибке некорректное");
        //5.ЗАКРЫТЬ БРАУЗЕР:
        driver.quit();
    }

    @Test
    public void zipCodeShouldNotAccept4Digits() {
        //Шаги в тест-кейсе(негативный):
        //1.ОТКРЫТЬ СТАРНИЦУ https://www.sharelane.com/cgi-bin/register.py
        //2.ВВЕСТИ ЛЮБЫЕ 6 ЦИФР (НАПРИМЕР 123456)
        //3.НАЖАТЬ КНОПКУ CONTINUE
        //4.УБЕДИТЬСЯ, ЧТО СООБЩЕНИЕ ОБ ОШИБКЕ ПОЯВЛЯЕТСЯ (Oops, error on page. ZIP code should have 5 digits);
        //5.ЗАКРЫТЬ БРАУЗЕР.
        //Далее наши действия по автоматизации. Смотри по порядку.
        //0.УСТАНОВКА ПЕРЕМЕННОЙ СРЕДЫ:
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //1.ОТКРЫТЬ СТАРНИЦУ https://www.sharelane.com/cgi-bin/register.py:
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //2.ВВЕСТИ ЛЮБЫЕ 4 ЦИФРЫ (НАПРИМЕР 1234):
        driver.findElement(By.name("zip_code")).sendKeys("1234");
        //3.НАЖАТЬ КНОПКУ CONTINUE:
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //4.УБЕДИТЬСЯ, ЧТО СООБЩЕНИЕ ОБ ОШИБКЕ ПОЯВЛЯЕТСЯ (Oops, error on page. ZIP code should have 5 digits);
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(error, "Oops, error on page. ZIP code should have 5 digits",
                "Сообщение об ошибке некорректное");
        //5.ЗАКРЫТЬ БРАУЗЕР:
        driver.quit();
    }

    @Test
    public void successfulSignUp() {
        //Шаги в тест-кейсе(УСПЕШНАЯ РЕГИСТРАЦИЯ):
        //1.ОТКРЫТЬ СТАРНИЦУ https://www.sharelane.com/cgi-bin/register.py;
        //2.ВВЕСТИ ЛЮБЫЕ 6 ЦИФР (НАПРИМЕР 123456);
        //3.НАЖАТЬ КНОПКУ CONTINUE;
        //4.ЗАПОЛНЯЕМ ПОЛЯ ВАЛИДНЫМИ ДАННЫМИ;
        //5.НАЖАТЬ КНОПКУ REGISTER;
        //6.УБЕДИТЬСЯ, ЧТО СООБЩЕНИЕ ОБ УСПЕШНОЙ РЕГИСТРАЦИИ ПОЯВЛЯЕТСЯ(Account is created!);
        //7.ЗАКРЫТЬ БРАУЗЕР.
        //Далее наши действия по автоматизации. Смотри по порядку.
        //0.УСТАНОВКА ПЕРЕМЕННОЙ СРЕДЫ:
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //1.ОТКРЫТЬ СТАРНИЦУ https://www.sharelane.com/cgi-bin/register.py:
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //2.ВВЕСТИ ЛЮБЫЕ 4 ЦИФРЫ (НАПРИМЕР 1234):
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //3.НАЖАТЬ КНОПКУ CONTINUE:
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //4.ЗАПОЛНЯЕМ ПОЛЯ ВАЛИДНЫМИ ДАННЫМИ:
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Pol");
        driver.findElement(By.name("email")).sendKeys("alex@wrgo.com");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        //5.НАЖАТЬ КНОПКУ REGISTER:
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //6.УБЕДИТЬСЯ, ЧТО СООБЩЕНИЕ ОБ УСПЕШНОЙ РЕГИСТРАЦИИ ПОЯВЛЯЕТСЯ(Account is created!):
        String message = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(message, "Account is created!",
                "Аккаунт не создан");
        //7.ЗАКРЫТЬ БРАУЗЕР:
        driver.quit();
    }
}