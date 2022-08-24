import api.apiForUserAccount;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class TestRegistration {

    RegisterPage registerPage;
    public static String email = "teststellarburger@yandex.ru";
    public static String name = "Test Burger";
    public static String password = "password123";
    public static int statusCode;

    @Before
    public void setUpWebDriverAndRestAssured() {
//        чтобы запустить в Яндексе надо расскоментировать строку ниже
//        System.setProperty("webdriver.chrome.driver", "D://Yandex//bin//yandexdriver.exe");
        Configuration.startMaximized = true;
        RestAssured.baseURI = apiForUserAccount.BASEURI;
        registerPage = open(RegisterPage.REGISTERPAGE_URL, RegisterPage.class);
    }

    @After
    public void deleteUser() {
        apiForUserAccount.deleteUser(email,password);
        WebDriverRunner.closeWebDriver();
    }

    @DisplayName("Проверка успешной регистрации клиента на странице регистрации")
    @Test
    public void testSuccessRegistration() {
        registerPage.enterLoginFieldName(name);
        registerPage.enterLoginFieldEmail(email);
        registerPage.enterLoginPassword(password);
        registerPage.clickOnButtonRegistration();
        statusCode = apiForUserAccount.getStatusCode(email,password);
        Assert.assertEquals(200,statusCode);
    }

    @DisplayName("Проверка неверного ввода пароля на странице регистрации")
    @Test
    public void testErrorWhenIncorrectPassword() {
        registerPage.enterLoginFieldName("Test Burger");
        registerPage.enterLoginPassword("passw");
        registerPage.enterLoginFieldEmail("teststellarburger@yandex.ru");
        String error =registerPage.errorWhenIncorrectPassword();
        Assert.assertEquals("Некорректный пароль",error);
    }
}
