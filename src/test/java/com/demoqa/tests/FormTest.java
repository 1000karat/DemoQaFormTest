package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.PracticeFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FormTest {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1366x1060";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void successfulRegistrationTest() {
        String firstName = "Fedor",
                lastName = "Kon",
                email = "super@demoqa.com",
                genter = "Other",
                phone = "1223456789",
                day = "03",
                month = "April",
                year = "1979",
                subject = "Social Studies",
                hobbies = "Reading",
                fileName = "test_pic.jpg",
                state = "Haryana",
                city = "Panipat",
                address = "Current Address for successful Registration Test";

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
