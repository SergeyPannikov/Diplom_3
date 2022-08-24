package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
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

    public void enterLoginEmailField(String loginEmail){
        loginEmailField.val(loginEmail);
    }

    public void enterLoginPasswordField(String loginPassword){
        loginPasswordField.val(loginPassword);
    }

    public void clickButtonLogin(){
        buttonLogin.click();
    }

    public void waitButtonLoginIsVisible(){
        buttonLogin.shouldBe(visible);
    }

}
