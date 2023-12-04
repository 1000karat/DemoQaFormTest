package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private static final SelenideElement
            dateOfBirthInput = $("#dateOfBirthInput"),
            setMonth = $(".react-datepicker__month-select"),
            setYear = $(".react-datepicker__year-select");

    public CalendarComponent(String day, String month, String year) {
        dateOfBirthInput.click();
        setMonth.selectOption(month);
        setYear.selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
    }
}
