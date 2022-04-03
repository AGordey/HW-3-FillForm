package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestingFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest () {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        //Все простые поля для заполнения
        $("#firstName").setValue("OurFirstName");
        $("#lastName").setValue("OurLastName");
        $("#userEmail").setValue("OurEmail@email.com");
        $("#userNumber").setValue("1234567890");
        $("#currentAddress").setValue("OurCurrentAddress");
        //Поле с радиобаттоном
        $(".custom-control-label").click(); //надо переделать Выбор гендера
        //Кнопка Submit
        $("#submit").click();

        //Проверка введенных данных
        $(".modal-body").shouldHave
                (text("OurFirstName"),
                text("OurLastName"),
                text("OurEmail@email.com"),
                text("1234567890"),
                text("OurCurrentAddress"));
//        нету проверки гендера
//        выбор даты рождения
//                выбор сабджектов
//                        выбор хобби
//                                выбор штата и города
    }
}
