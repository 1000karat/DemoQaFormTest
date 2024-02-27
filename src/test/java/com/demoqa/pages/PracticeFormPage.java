package com.demoqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import io.qameta.allure.Step;

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


    @Step("Открыть страницу: " + URL_PATH)
    public PracticeFormPage openPage() {
        open(URL_PATH);
        header.shouldHave(Condition.text(HEADER_PAGE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Заполнить firstName: {value}")
    public PracticeFormPage setFirstName(String value) {
        $(".fc-button-label").click();
        firstName.setValue(value);
        return this;
    }

    @Step("Заполнить lastName: {value}")
    public PracticeFormPage setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    @Step("Заполнить eMail: {value}")
    public PracticeFormPage setEmail(String value) {
        setEmail.setValue(value);
        return this;
    }
    @Step("Выбрать пол: {value}")
    public PracticeFormPage setGenterWrapper(String value) {
        setGenterWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Заполнить номер: {value}")
    public PracticeFormPage setPhone(String value) {
        setPhone.setValue(value);
        return this;
    }
    @Step("Заполнить календарь: {day} {month} {year}")
    public PracticeFormPage setCalendarDate(String day, String month, String year) {
        CalendarComponent calendarComponent = new CalendarComponent(day, month, year);
        return this;
    }

    @Step("Заполнить тему: {value}")
    public PracticeFormPage setSubjectsInput(String value) {
        setSubjectsInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Заполнить хобби: {value}")
    public PracticeFormPage setHobbiesWrapper(String value) {
        setHobbiesWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Загрузить фото: {fileName}")
    public PracticeFormPage uploadPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    @Step("Заполнить адрес: {value}")
    public PracticeFormPage setCurrentAddress(String value) {
        setCurrentAddress.setValue(value);
        return this;
    }

    @Step("Выбрать штат: {state} и город: {city}")
    public PracticeFormPage setStateAndCity(String state, String city) {
        setState.click();
        $("#stateCity-wrapper").$(byText(state)).click();
        setCity.click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    @Step("Нажать 'отправить'")
    public PracticeFormPage buttonSubmit() {
        buttonSubmit.click();
        return this;
    }

    @Step("Проверка отображения всплывающего окна")
    public PracticeFormPage verifyResultModalText() {
        modalHeader.should(Condition.appear);
        modalHeader.shouldHave(Condition.text(MODAL_TEXT));
        return this;
    }

    @Step("Верефицировать отправленные данные в окне {key} {value}")
    public PracticeFormPage verifyResult(String key, String value) {
        tableResult.$(byText(key)).parent().shouldHave(Condition.text(value));
        return this;
    }
}
