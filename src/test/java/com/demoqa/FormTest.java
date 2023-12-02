package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {
    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1366x1060";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        //Configuration.headless = true;
        Selenide.open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
    }

    @Test
    void successfulRegistrationTest() {
        $(".practice-form-wrapper").shouldHave(Condition.text("Student Registration Form"));

        $("#firstName").setValue("SuperFirstName");
        $("#lastName").setValue("SuperLastName");

        $("#userEmail").setValue("super@demoqa.com");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__month").$(byText("1")).click();

        $("#subjectsInput").setValue("Social Studies").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("test_pic.jpg");
        $("#currentAddress").setValue("Current Address for successful Registration Test");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();

        $("#submit").click();

        $(".modal-header").shouldHave(Condition.text("Thanks for submitting the form"));

    }
}
