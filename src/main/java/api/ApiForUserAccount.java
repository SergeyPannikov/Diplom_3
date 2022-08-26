package api;

import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiForUserAccount {

    public static String accessToken;
    public final static String BASEURI = "https://stellarburgers.nomoreparties.site";
    public static UserAccount userAccount;

    @Step("Удаление юзера")
    public static void deleteUser(String email, String password){
        if (given().header("Content-type", "application/json").
                and().body(userAccount).when().post("api/auth/login").then().extract().statusCode() == 200) {
            getAccessToken(email,password);
            given().auth().oauth2(accessToken).and().when().delete("api/auth/user").then().statusCode(202).and().assertThat().body("success", equalTo(true))
                    .and().assertThat().body("message",equalTo("User successfully removed"));
        }
    }

    @Step("Получение токена клиента")
    public static void getAccessToken(String email, String password){
        if (getStatusCode(email,password) == 200) {
            String accessTokenString = given().header("Content-type", "application/json").
                    and().body(userAccount).when().post("api/auth/login").then().statusCode(200).and().extract().body().path("accessToken");
            accessToken = accessTokenString.substring(accessTokenString.indexOf(' ')+1);
        }
    }

    @Step("Получение кода ответа ")
    public static int getStatusCode(String email, String password){
        userAccount = new UserAccount(email,password);
       return given().header("Content-type", "application/json").
                and().body(userAccount).when().post("api/auth/login").then().extract().statusCode();
    }

    @Step("Создание юзера через апи")
    public static void CreateUser(String name, String email, String password){
        userAccount = new UserAccount(email,password,name);
        given().header("Content-type", "application/json").
                and().body(userAccount).when().post("api/auth/register").then().statusCode(200).and().assertThat().body("success",equalTo(true))
                .and().assertThat().body("user.email",equalTo(email))
                .and().assertThat().body("user.name",equalTo(name));
    }
}
