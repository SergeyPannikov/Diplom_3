package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPage {
    public final static String ACCOUNTPAGE_URL = "https://stellarburgers.nomoreparties.site/account";

    //кнопка выхода из личного кабинета
    @FindBy(how = How.XPATH, using = ".//button[@type='button'and text()='Выход']")
    private SelenideElement buttonLogOut;

    @Step("Клик на кнопку Выход")
    public void clickButtonLogOut() {
        buttonLogOut.click();
    }
}
