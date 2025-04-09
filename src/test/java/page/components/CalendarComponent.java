package page.components;

import page.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate( String day, String month, String year){
        $( "#date0fBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day).click();

}
