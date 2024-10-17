package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResponsiveComponent {

    public final SelenideElement resultTable = $(".table-responsive");

    public void checkResult(String key, String value) {
        $(resultTable).$(byText(key)).parent().shouldHave(text(value));
    }

    public void negativeCheck() {
        $(resultTable).shouldNot(appear);
    }

}
