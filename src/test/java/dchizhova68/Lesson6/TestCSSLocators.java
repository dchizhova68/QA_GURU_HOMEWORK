package dchizhova68.Lesson6;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestCSSLocators {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void testHtml(){
        open("/features/actions/");
        $("div h3").shouldHave(text("Linux, macOS, Windows, ARM, and containers"));
    }

}
