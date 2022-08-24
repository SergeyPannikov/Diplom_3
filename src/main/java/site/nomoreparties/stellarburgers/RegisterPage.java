package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;
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


    public void enterLoginFieldName(String name){
        loginFields.get(0).val(name);
    }

    public void enterLoginFieldEmail(String email){
        loginFields.get(1).val(email);
    }

    public void enterLoginPassword(String password){
        loginPasswordField.val(password);
    }

    public void clickOnButtonRegistration(){
        buttonRegistration.click();
    }

    public void clickOnLinkToLoginPage(){
        linkToLoginPage.click();
    }

    public String errorWhenIncorrectPassword(){
        return errorFieldForIncorrectPassword.getText();
    }

}
