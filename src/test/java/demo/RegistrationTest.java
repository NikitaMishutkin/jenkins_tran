package demo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static io.qameta.allure.Allure.step;

public class RegistrationTest extends TestBase{

    @Test
    @DisplayName("Registration test")
    void successfulTest() {


        step("Open page", () -> {
                    open("https://demoqa.com/automation-practice-form");
                });

        step("Fill form", () -> {
                    // Основные поля
                    $("#firstName").setValue("Nikita");
                    $("#lastName").setValue("Mishutkin");
                    $("#userEmail").setValue("nikita@mail.ru");
                    $("#userNumber").setValue("8917323254");

                    // Выбор пола
                    $("label[for='gender-radio-1']").click(); // Male

                    // Дата рождения
                    $("#dateOfBirthInput").click();
                    $(".react-datepicker__month-select").selectOption("January");
                    $(".react-datepicker__year-select").selectOption("2025");
                    $(".react-datepicker__day--001").click();


                    $("#subjectsInput").setValue("Maths");
                    $("#subjectsInput").pressEnter();

                    $("label[for='hobbies-checkbox-1']").click(); // Sports
                    $("label[for='hobbies-checkbox-2']").click(); // Reading


                    $("#currentAddress").setValue("SARATOV-SPB");

                    // State и City
                    $("#state").click();
                    $("#react-select-3-option-0").click(); // NCR

                    $("#city").click();
                    $("#react-select-4-option-0").click(); // Delhi
            $("#submit").click();
                });
        // Отправка формы

            step("Check result", () -> {
                        // Проверка успешной отправки
                        $(".modal-content").shouldBe(visible);
                        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
                    });
        // Небольшая задержка для просмотра результата
        sleep(20000);
    }
}