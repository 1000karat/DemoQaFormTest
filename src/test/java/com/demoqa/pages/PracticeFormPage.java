package com.demoqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    private static final String URL_PATH = "/automation-practice-form",
            HEADER_PAGE_TEXT = "Student Registration Form",
            MODAL_TEXT = "Thanks for submitting the form";

    private final SelenideElement header = $(".practice-form-wrapper"),
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            setEmail = $("#userEmail"),
            setGenterWrapper = $("#genterWrapper"),
            setPhone = $("#userNumber"),
            setSubjectsInput = $("#subjectsInput"),
            setHobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            setCurrentAddress = $("#currentAddress"),
            setState = $("#state"),
            setCity = $("#city"),
            buttonSubmit = $("#submit"),
            modalHeader = $(".modal-header"),
            tableResult = $(".table-responsive");

    public PracticeFormPage openPage() {
        open(URL_PATH);
        header.shouldHave(Condition.text(HEADER_PAGE_TEXT));
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public PracticeFormPage setEmail(String value) {
        setEmail.setValue(value);
        return this;
    }

    public PracticeFormPage setGenterWrapper(String value) {
        setGenterWrapper.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setPhone(String value) {
        setPhone.setValue(value);
        return this;
    }

    public PracticeFormPage setCalendarDate(String day, String month, String year) {
        CalendarComponent calendarComponent = new CalendarComponent(day, month, year);
        return this;
    }

    public PracticeFormPage setSubjectsInput(String value) {
        setSubjectsInput.setValue(value).pressEnter();
        return this;
    }

    public PracticeFormPage setHobbiesWrapper(String value) {
        setHobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage uploadPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    public PracticeFormPage setCurrentAddress(String value) {
        setCurrentAddress.setValue(value);
        return this;
    }

    public PracticeFormPage setStateAndCity(String state, String city) {
        setState.click();
        $("#stateCity-wrapper").$(byText(state)).click();
        setCity.click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    public PracticeFormPage buttonSubmit() {
        buttonSubmit.click();
        return this;
    }

    public PracticeFormPage verifyResultModalText() {
        modalHeader.should(Condition.appear);
        modalHeader.shouldHave(Condition.text(MODAL_TEXT));
        return this;
    }

    public PracticeFormPage verifyResult(String key, String value) {
        tableResult.$(byText(key)).parent().shouldHave(Condition.text(value));
        return this;
    }
}
