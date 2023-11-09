package dchizhova68.lesson5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestDragAndDrop {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void dragAndDropAction() {
        open("/drag_and_drop");
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();
        $$("#columns div").first().$("header").shouldHave(text("B"));
    }
    @Test
    void dragAndDrop() {
        open("/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $$("#columns div").first().$("header").shouldHave(text("B"));
    }
}
