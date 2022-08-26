package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class RegisterPage {
    public final static String REGISTERPAGE_URL = "https://stellarburgers.nomoreparties.site/register";

    //локатор поля ввода имени и емейла клиента
    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private List<SelenideElement> loginFields;
    //локатор поля ввода пароля
    @FindBy(how = How.XPATH, using = ".//input[@type='password']")
    private SelenideElement loginPasswordField;
    //кнопка зарегестрироваться
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement buttonRegistration;
    //ссылка для перехода на вход под клиентом
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement linkToLoginPage;
    //поле ошибки о некорректности пароля
    @FindBy(how = How.XPATH, using = ".//p[@class='input__error text_type_main-default']")
    private SelenideElement errorFieldForIncorrectPassword;

    @Step("Ввод имени в поле имя")
    public void enterLoginFieldName(String name) {
        loginFields.get(0).val(name);
    }

    @Step("Ввод емейла в поле емейла")
    public void enterLoginFieldEmail(String email) {
        loginFields.get(1).val(email);
    }

    @Step("Ввод пароля в поле пароль")
    public void enterLoginPassword(String password) {
        loginPasswordField.val(password);
    }

    @Step("Клик на кнопку Регистрация")
    public void clickOnButtonRegistration() {
        buttonRegistration.click();
    }

    @Step("Клик на Войти")
    public void clickOnLinkToLoginPage() {
        linkToLoginPage.click();
    }

    @Step("Возвращение текста ошибки для некорретного пароля")
    public String errorWhenIncorrectPassword() {
        return errorFieldForIncorrectPassword.getText();
    }
}
