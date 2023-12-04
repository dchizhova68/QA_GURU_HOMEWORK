package dchizhova68.lesson10;

import dchizhova68.TestBase;
import dchizhova68.pages.LitresPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


public class LitresTest extends TestBase {
    LitresPage litres = new LitresPage();

    @CsvSource(value = {
            "Гоголь, Вий",
            "Булгаков, Мастер и Маргарита"
    })
    @ParameterizedTest(name = "В результатах поиска по автору {0} должна быть книга {1}")
    @Tag("BLOKER")
    void findBookByAuthorTest(String author, String bookName) {
        litres.openPage()
                .setSearchValue(author)
                .checkSearchResultHavePopularBookByAuthor(bookName);
    }

    @ValueSource(strings = {
            "Гранатовый браслет"
    })
    @DisplayName("Проверка добавления книги в корзину")
    @Tag("BLOKER")
    @ParameterizedTest
    void addBookToBaskettTest(String bookTitle) {
        litres.openPage()
                .setSearchValue(bookTitle)
                .openDetailFormBook(bookTitle)
                .addToBasket()
                .closeModalWindow()
                .openBasket()
                .checkBasketContainsAddedBook(bookTitle);
    }

    @ValueSource(strings = {
            "Новинки"
    })
    @Tag("MINOR")
    @ParameterizedTest
    @DisplayName("Навигационная цепочка в разделе должна содержать название раздела")
    void breadcrumbsTest(String pageName) {
        litres.openPage()
                .openPageByName(pageName)
                .checkBreadCrumbs(pageName);

    }


}
