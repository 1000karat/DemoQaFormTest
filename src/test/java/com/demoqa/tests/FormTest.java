package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.helper.GenerateTestData;
import com.demoqa.pages.PracticeFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class FormTest {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    Faker faker = new Faker();

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1366x1085";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Tag("UI_TEST")
    @Test
    public void successfulRegistrationTest() {

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = faker.options().option("Male", "Female", "Other");
        String phone = faker.phoneNumber().subscriberNumber(10);
        String[] calendarDate = GenerateTestData.getCalendarDate();
        String subject = faker.options().option("History", "Arts", "Biology", "Maths", "Commerce",
                "Social Studies", "Civics", "Hindi");
        String hobbies = faker.options().option("Sports", "Reading", "Music");
        String fileName = "test_pic.jpg";
        String address = faker.address().fullAddress();
        String state = GenerateTestData.getState();
        String city = GenerateTestData.getCity(state);

        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGenterWrapper(gender)
                .setPhone(phone)
                .setCalendarDate(calendarDate[0], calendarDate[1], calendarDate[2])
                .setSubjectsInput(subject)
                .setHobbiesWrapper(hobbies)
                .uploadPicture(fileName)
                .setCurrentAddress(address)
                .setStateAndCity(state, city)
                .buttonSubmit()
                .verifyResultModalText()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phone)
                .verifyResult("Date of Birth", calendarDate[0] + " " + calendarDate[1] + "," + calendarDate[2])
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", fileName)
                .verifyResult("Address", address);
    }
}
