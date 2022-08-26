package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class MainPage {
    public final static String MAINPAGE_URL = "https://stellarburgers.nomoreparties.site/";

    //локатор кнопки Войти в аккаунт, когда не авторизирован
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement buttonSighIn;
    //локатор  кнопки Личный кабинет
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement linkToAccount;
    //локатор  иконки стелларбургер
    @FindBy(how = How.XPATH, using = ".//div/a[@href='/']")
    private SelenideElement linkToMainPageFromLogoImage;
    //локатор  иконки стелларбургер
    @FindBy(how = How.XPATH, using = ".//ul/li/a[@href='/']")
    private SelenideElement linkToMainPageFromConstructor;
    //локатор раздела Булки в конструкторе
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement sectionBunInConstructor;
    //локатор раздела Соусы в конструкторе
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement sectionSauceInConstructor;
    //локатор раздела Начинки в конструкторе
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement sectionFillingInConstructor;
    //локатор надписи раздела начинка в списке ингридиентов
    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    private SelenideElement headerFillingSectionInConstructor;
    //локатор локатор надписи булки в списке ингридиентов
    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    private SelenideElement headerBunSectionInConstructor;
    //локатор окатор надписи соусы в списке ингридиентов
    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    private SelenideElement headerSauceSectionInConstructor;

    @Step("Клик на кнопку Войти")
    public void clickButtonSighIn() {
        buttonSighIn.click();
    }

    @Step("Клик на линк Личный кабинет")
    public void clickLinkToAccount() {
        linkToAccount.click();
    }

    @Step("Клик на лого Стеллар Бургер")
    public void clickLinkToMainPageFromLogoImage() {
        linkToMainPageFromLogoImage.click();
    }

    @Step("Клик на Конструктор")
    public void clickLinkToMainPageFromConstructor() {
        linkToMainPageFromConstructor.click();
    }

    @Step("Клик на секцию Булки в Конструкторе")
    public void clickSectionBunInConstructor() {
        sectionBunInConstructor.click();
    }

    @Step("Клик на секцию Соусы в Конструкторе")
    public void clickSectionSauceInConstructor() {
        sectionSauceInConstructor.click();
    }

    @Step("Клик на секцию Начинки в Конструкторе")
    public void clickSectionFillingInConstructor() {
        sectionFillingInConstructor.click();
    }

    @Step("Проверка отображения хедера Начинки в списке ингридиентов")
    public boolean checkHeaderFillingSectionInConstructor() {
        return headerFillingSectionInConstructor.isDisplayed();
    }

    @Step("Проверка отображения хедера Булки в списке ингридиентов")
    public boolean checkHeaderBunSectionInConstructor() {
        return headerBunSectionInConstructor.isDisplayed();
    }

    @Step("Проверка отображения хедера Соусы в списке ингридиентов")
    public boolean checkHeaderSauceSectionInConstructor() {
        return headerSauceSectionInConstructor.isDisplayed();
    }
}
