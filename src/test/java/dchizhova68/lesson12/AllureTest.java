package dchizhova68.lesson12;

import dchizhova68.TestBase;
import dchizhova68.pages.LitresPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvSource;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AllureTest extends TestBase {

    @CsvSource(value = {
            "Гранатовый браслет",
            "Отцы и дети"
    })
    @DisplayName("Проверка добавления книги в корзину")
    @Tag("BLOKER")
    @ParameterizedTest
    void listenerAddBookToBasketTest(String bookTitle) {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://www.litres.ru");
        $(byAttribute("data-test-id", "header__search-input--desktop")).setValue(bookTitle).pressEnter();
        $(byAttribute("data-test-id", "art__cover--desktop")).$("a").click();
        $(byAttribute("data-test-id", "book__addToCartButton--desktop")).click();
        $(byAttribute("data-test-id", "modal-book-label__wrapper")).$("use").click();
        $(byAttribute("data-test-id", "tab-basket")).$("a").click();
        $$(byAttribute("data-test-id", "cart__bookCardTitle--wrapper")).shouldHave(itemWithText(bookTitle));

    }

    @CsvSource(value = {
            "Гранатовый браслет",
            "Отцы и дети"
    })
    @DisplayName("Проверка добавления книги в корзину")
    @Tag("BLOKER")
    @ParameterizedTest
    void lambdaAddBookToBasketTest(String bookTitle) {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> open("https://www.litres.ru"));

        step("Вводим в поисковую строку " + bookTitle, () ->
                $(byAttribute("data-test-id", "header__search-input--desktop")).setValue(bookTitle).pressEnter());

        step("Переходим в детальную форм просмотра первой книги из списка", () ->
                $(byAttribute("data-test-id", "art__cover--desktop")).$("a").click());

        step("Добавляем книгу в корзину", () ->
                $(byAttribute("data-test-id", "book__addToCartButton--desktop")).click());
        step("Закрываем модальное окно", () ->
                $(byAttribute("data-test-id", "modal-book-label__wrapper")).$("use").click());

        step("Переходим в корзину", () ->
                $(byAttribute("data-test-id", "tab-basket")).$("a").click());

        step("Проверяем, что в корзине есть книга " + bookTitle, () ->
                $$(byAttribute("data-test-id", "cart__bookCardTitle--wrapper")).shouldHave(itemWithText(bookTitle)));


    }

    @CsvSource(value = {
            "Гранатовый браслет",
            "Отцы и дети"
    })
    @Tag("BLOKER")
    @ParameterizedTest(name = "Проверка добавления книги в корзину")
    @Feature("BookShop")
    @Owner("Dsria Chizhova")
    @Story("BuyBook")
    @Link("Links")
    void StepsAddBookToBasketTest(String bookTitle) {
        LitresPage litres = new LitresPage();
        litres.openPage()
                .setSearchValue(bookTitle)
                .openDetailFormBook(bookTitle)
                .addToBasket()
                .closeModalWindow()
                .openBasket()
                .checkBasketContainsAddedBook(bookTitle);

    }
}
