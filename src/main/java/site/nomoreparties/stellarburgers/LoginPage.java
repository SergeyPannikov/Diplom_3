package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class LoginPage {
    public final static String LOGINPAGE_URL = "https://stellarburgers.nomoreparties.site/login";

    //локатор поля ввода емейла клиента
    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement loginEmailField;
    //локатор поля ввода пароля
    @FindBy(how = How.XPATH, using = ".//input[@type='password']")
    private SelenideElement loginPasswordField;
    //кнопка войти
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement buttonLogin;

    @Step("Ввод емейла ")
    public void enterLoginEmailField(String loginEmail) {
        loginEmailField.val(loginEmail);
    }

    @Step("Ввод пароля")
    public void enterLoginPasswordField(String loginPassword) {
        loginPasswordField.val(loginPassword);
    }

    @Step("Клик на кнопку Войти")
    public void clickButtonLogin() {
        buttonLogin.click();
    }

    @Step("Ожидание отображения кнопки Войти")
    public void waitButtonLoginIsVisible() {
        buttonLogin.shouldBe(visible);
    }
}
