package dchizhova68.lesson5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TestHoverGitHub {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void hoverSolution() {
        open("/");
        $(byTagAndText("button","Solutions")).hover();
        $(byTagAndText("a","Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered"));
    }

}
