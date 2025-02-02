package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "EDGE";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;

    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //заполнение формы
        $("#firstName").setValue("Yuriy");
        $("#lastName").setValue("Gagarin");
        $("#userEmail").setValue("gagarin@comp.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("0700000000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(".react-datepicker__year-select").selectOptionByValue("1934");
        $(".react-datepicker__day--009").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/cat.png");
        $("#currentAddress").setValue("Broadway,11");
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#react-select-4-input").setValue("Jaiselmer").pressEnter();
        $("#submit").click();

        //проверка заполненных полей

        $(".table-responsive").shouldHave(Condition.text("Yuriy Gagarin"),
                (Condition.text("gagarin@comp.ru")),
                (Condition.text("Male")),
                (Condition.text("0700000000")),
                (Condition.text("09 March,1934")),
                (Condition.text("Arts")),
                (Condition.text("Music")),
                (Condition.text("cat.png")),
                (Condition.text("Broadway,11")),
                (Condition.text("Rajasthan Jaiselmer")));
        $(".modal-footer").$("#closeLargeModal").click();



    }
}
