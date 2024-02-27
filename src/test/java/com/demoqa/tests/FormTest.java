package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.helper.AttachForTest;
import com.demoqa.helper.GenerateTestData;
import com.demoqa.pages.PracticeFormPage;
import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

@Tag("simple")
public class FormTest {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    Faker faker = new Faker();

    @BeforeAll
    public static void setUp() {
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1366x1085";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.headless = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Tag("UI_TEST")
    @Owner("1000karat")
    @Feature("Student Registration Form")
    @Story("Отправка заполненной формы")
    @DisplayName("Registration Form Test")
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

    @AfterEach
    void tearDown() {
        AttachForTest.screenshotAs("LastScreenshot");
        AttachForTest.pageSource();
        AttachForTest.browserConsoleLogs();
        AttachForTest.addVideo();
    }
}
