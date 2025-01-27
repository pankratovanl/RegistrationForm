package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationform {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "EDGE";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void FillFormTest() {

        open("/automation-practice-form");

        //заполнение формы
        $("#firstName").setValue("Yuriy");
        $("#lastName").setValue("Gagarin");
        $("#userEmail").setValue("gagarin@comp.ru");
        $(byText("Male")).click();
        $("#userNumber").setValue("0700000000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(".react-datepicker__year-select").selectOptionByValue("1934");
        $(".react-datepicker__day--009").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/cat.png");
        $("#currentAddress").setValue("Broadway,11");
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#react-select-4-input").setValue("Jaiselmer").pressEnter();
        $("#submit").click();


    }
}
