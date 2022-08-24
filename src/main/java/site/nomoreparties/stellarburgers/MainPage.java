package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;
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

    public void clickButtonSighIn(){
        buttonSighIn.click();
    }

    public void clickLinkToAccount(){
        linkToAccount.click();
    }

    public void clickLinkToMainPageFromLogoImage(){
        linkToMainPageFromLogoImage.click();
    }

    public void clickLinkToMainPageFromConstructor(){
        linkToMainPageFromConstructor.click();
    }

    public void clickSectionBunInConstructor(){
        sectionBunInConstructor.click();
    }

    public void clickSectionSauceInConstructor(){
        sectionSauceInConstructor.click();
    }

    public void clickSectionFillingInConstructor(){
        sectionFillingInConstructor.click();
    }

    public boolean checkHeaderFillingSectionInConstructor(){
        return headerFillingSectionInConstructor.isDisplayed();
    }

    public boolean checkHeaderBunSectionInConstructor(){
        return headerBunSectionInConstructor.isDisplayed();
    }

    public boolean checkHeaderSauceSectionInConstructor(){
        return headerSauceSectionInConstructor.isDisplayed();
    }

}
