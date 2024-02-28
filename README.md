#### Changelog
###### 02.12.2023
1. Ветка main.
2. Разработан тест для страницы.

###### 03.12.2023
1. Создана ветка pageObject https://github.com/1000karat/DemoQaFormTest/tree/pageObject
2. Для теста использован Page Object: реализован отдельный класс, в котором находятся методы и передаваемые аргументы.
3. Вводимые значения (test data) и SelenideElement вынесены в отдельные переменные.
4. Реализована верификация отображаемого результата (verifyResult).

###### 04.12.2023
1. Изменение на параметризованный тест.
2. Вынесен календарь в CalendarComponent.

###### 05.12.2023
1. Создан тест shouldHaveCityTest.

###### 22.02.2024
1. Замена строки которая не работает в Linux:
https://github.com/1000karat/DemoQaFormTest/blob/4de817b72b0902f8a5a063383f2fddcfdd744dd0/src/test/java/com/demoqa/tests/FormTest.java#L63
на работоспособную в Windows + Linux:
https://github.com/1000karat/DemoQaFormTest/blob/fefe1776c23d6441fdc5f80ee5240c164a43166e/src/test/java/com/demoqa/tests/FormTest.java#L63

###### 23.02.2024
1. Создана ветка faker https://github.com/1000karat/DemoQaFormTest/tree/faker
2. Генерация данных для теста с помощью библиотеки faker.

###### 27.02.2024
1. Создана ветка allure-jenkins https://github.com/1000karat/DemoQaFormTest/tree/allure-jenkins
2. Подключен Allure Report.
3. Добавлена аннотация @Step в классе PracticeFormPage.
4. Тест запускается удалённо на https://jenkins.autotests.cloud/

Скриншоты Allure Report и видео прохождения теста:

<img src="https://github.com/1000karat/DemoQaFormTest/raw/allure-jenkins/result-test/jenkins.png" width="45%" height="45%"> <img src="https://github.com/1000karat/DemoQaFormTest/raw/allure-jenkins/result-test/allure_report_01.png" width="45%" height="45%">
<img src="https://github.com/1000karat/DemoQaFormTest/raw/allure-jenkins/result-test/allure_report_02.png" width="45%" height="45%">  <img src="https://github.com/1000karat/DemoQaFormTest/raw/allure-jenkins/result-test/allure_report_03.png" width="45%" height="45%">

<img src="https://github.com/1000karat/DemoQaFormTest/raw/allure-jenkins/result-test/test.gif" width="45%" height="45%">
