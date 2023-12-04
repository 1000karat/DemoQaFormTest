package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.PracticeFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class FormTest {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1366x1085";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @CsvFileSource(resources = "/successfulRegistrationTestData.csv")
    @ParameterizedTest(name = "Регистрация пользователя {0} {1}")
    @Tag("UI_TEST")
    void successfulRegistrationTest(String firstName, String lastName, String email, String genter, String phone,
                                    String day, String month, String year, String subject, String hobbies,
                                    String fileName, String address, String state, String city) {
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGenterWrapper(genter)
                .setPhone(phone)
                .setCalendarDate(day, month, year)
                .setSubjectsInput(subject)
                .setHobbiesWrapper(hobbies)
                .uploadPicture(fileName)
                .setCurrentAddress(address)
                .setStateAndCity(state, city)
                .buttonSubmit()
                .verifyResultModalText()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", genter)
                .verifyResult("Mobile", phone)
                .verifyResult("Date of Birth", day + " " + month + "," + year)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", fileName)
                .verifyResult("Address", address);
    }
}
