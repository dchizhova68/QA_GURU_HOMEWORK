package lesson4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TestGitHub {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
    }
    @Test
    void searchSoftAssertion() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("nav#wiki-pages-box li.wiki-more-pages-link button").click();
        $$("nav#wiki-pages-box").shouldHave(texts("SoftAssertions"));
        $("nav#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").sibling(0).$("pre").shouldHave(text("@Test"));
    }


}
