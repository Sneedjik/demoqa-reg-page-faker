package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public final SelenideElement monthInput = $(".react-datepicker__month-select"),
            yearInput = $(".react-datepicker__year-select");

    public void setDate(String day, String month, String year) {

        String daySelector = String.format(".react-datepicker__day--%03d:not(.react-datepicker__day--outside-month)", Integer.parseInt(day));

        monthInput.selectOption(month);
        yearInput.selectOption(year);
        $(daySelector).click();
    }

}
