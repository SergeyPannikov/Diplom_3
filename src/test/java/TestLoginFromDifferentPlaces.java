import api.apiForUserAccount;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.ForgotPasswordPage;
import site.nomoreparties.stellarburgers.LoginPage;
import site.nomoreparties.stellarburgers.MainPage;
import site.nomoreparties.stellarburgers.RegisterPage;

import static com.codeborne.selenide.Selenide.*;

public class TestLoginFromDifferentPlaces {

    LoginPage loginPage;
    MainPage mainPage;
    RegisterPage registerPage;
    ForgotPasswordPage forgotPasswordPage;

    @Before
    public void setUpWebDriverAndRestAssured() {
//        чтобы запустить в Яндексе надо расскоментировать строку ниже
//        System.setProperty("webdriver.chrome.driver", "D://Yandex//bin//yandexdriver.exe");
        Configuration.startMaximized = true;
        RestAssured.baseURI = apiForUserAccount.BASEURI;
    }

    @After
    public void deleteUser() {
        apiForUserAccount.deleteUser(TestRegistration.email,TestRegistration.password);
        WebDriverRunner.closeWebDriver();
    }

    @DisplayName("Проверка успешного перехода с главное страницы по кнопке Войти и успешный логин")
    @Test
    public void testLoginFromMainPage() {
        apiForUserAccount.CreateUser(TestRegistration.name,TestRegistration.email,TestRegistration.password);
        mainPage = open(MainPage.MAINPAGE_URL, MainPage.class);
        mainPage.clickButtonSighIn();
        loginPage = page(LoginPage.class);
        loginPage.enterLoginEmailField(TestRegistration.email);
        loginPage.enterLoginPasswordField(TestRegistration.password);
        loginPage.clickButtonLogin();
        mainPage.clickLinkToAccount();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/account",webdriver().driver().getCurrentFrameUrl());
    }

    @DisplayName("Проверка успешного перехода по линку Личный кабинет в верхнем меню и успешный вход в личный кабинет")
    @Test
    public void testLoginFromLinkToAccount() {
        apiForUserAccount.CreateUser(TestRegistration.name,TestRegistration.email,TestRegistration.password);
        mainPage = open(MainPage.MAINPAGE_URL, MainPage.class);
        mainPage.clickLinkToAccount();
        loginPage = page(LoginPage.class);
        loginPage.enterLoginEmailField(TestRegistration.email);
        loginPage.enterLoginPasswordField(TestRegistration.password);
        loginPage.clickButtonLogin();
        mainPage.clickLinkToAccount();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/account",webdriver().driver().getCurrentFrameUrl());
    }

    @DisplayName("Проверка успешного перехода по кнопке Войти со страницы регистрации и успешный вход в личный кабинет")
    @Test
    public void testLoginFromRegisterPage() {
        apiForUserAccount.CreateUser(TestRegistration.name,TestRegistration.email,TestRegistration.password);
        registerPage = open(RegisterPage.REGISTERPAGE_URL,RegisterPage.class);
        registerPage.clickOnLinkToLoginPage();
        loginPage = page(LoginPage.class);
        loginPage.enterLoginEmailField(TestRegistration.email);
        loginPage.enterLoginPasswordField(TestRegistration.password);
        loginPage.clickButtonLogin();
        mainPage = page(MainPage.class);
        mainPage.clickLinkToAccount();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/account",webdriver().driver().getCurrentFrameUrl());
    }

    @DisplayName("Проверка успешного перехода по кнопке Войти со страницы восстановить пароль и успешный вход в личный кабинет")
    @Test
    public void testLoginFromForgotPasswordPage() {
        apiForUserAccount.CreateUser(TestRegistration.name,TestRegistration.email,TestRegistration.password);
        forgotPasswordPage = open(ForgotPasswordPage.FORGOTPASSWORDPAGE_URL,ForgotPasswordPage.class);
        forgotPasswordPage.clickOnLinkToLoginPage();
        loginPage = page(LoginPage.class);
        loginPage.enterLoginEmailField(TestRegistration.email);
        loginPage.enterLoginPasswordField(TestRegistration.password);
        loginPage.clickButtonLogin();
        mainPage = page(MainPage.class);
        mainPage.clickLinkToAccount();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/account",webdriver().driver().getCurrentFrameUrl());
    }


}
