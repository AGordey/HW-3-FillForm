package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class TestingFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
//        executeJavaScript("$('footer').remove()");
//        executeJavaScript("$('#fixedban').remove()");
    }

    @Test
    void fillFormTest () {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("[id=firstName]").setValue("OurFirstName");
        $("[id=lastName]").setValue("OurLastName");
        $("[id=userEmail]").setValue("OurEmail@email.com");
    }
}