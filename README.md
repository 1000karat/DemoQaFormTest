#### Changelog
###### 05.12.2023
1. Создан тест shouldHaveCityTest

###### 04.12.2023
1. Изменение на параметризованный тест.
2. Вынесен календарь в CalendarComponent.

###### 03.12.2023
1. Отдельная ветка pageObject.
2. Для теста использован Page Object: реализован отдельный класс, в котором находятся методы и передаваемые аргументы.
3. Вводимые значения (test data) и SelenideElement вынесены в отдельные переменные.
4. Реализована верификация отображаемого результата (verifyResult).

###### 02.12.2023
1. Ветка main.
2. Разработан тест для страницы.

###### 22.02.2024
1. Замена строки которая не работает в Linux:
https://github.com/1000karat/DemoQaFormTest/blob/4de817b72b0902f8a5a063383f2fddcfdd744dd0/src/test/java/com/demoqa/tests/FormTest.java#L63
на работоспособную в Windows + Linux:
https://github.com/1000karat/DemoQaFormTest/blob/fefe1776c23d6441fdc5f80ee5240c164a43166e/src/test/java/com/demoqa/tests/FormTest.java#L63