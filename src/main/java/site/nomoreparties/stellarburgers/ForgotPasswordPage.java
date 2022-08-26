package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {
    public final static String FORGOTPASSWORDPAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    //ссылка для перехода на вход под клиентом
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement linkToLoginPage;

    @Step("Клик на линк Войти")
    public void clickOnLinkToLoginPage(){
        linkToLoginPage.click();
    }
}
