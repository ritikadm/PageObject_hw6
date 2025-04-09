package page;

import com.codeborne.selenide.SelenideElement;
import page.components.CalendarComponent;
import page.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#gender-radio-2+label"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#date0fBirthInputr"),
            subjectInput = $("#subjectsInput"),
            hobbiesCheckbox = $("#hobbies-checkbox-1+label"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#react-select-3-input"),
            city = $("#react-select-4-input"),
            submit = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender() {
        genderWrapper.click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDate0fBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjectsInput(String value) {

        subjectInput.setValue("value").pressEnter();
        return this;
    }

    public RegistrationPage setHobbiesCheckbox() {
        hobbiesCheckbox.click();
        return this;
    }

    public RegistrationPage selectUploadPicture() {
        uploadPicture.uploadFromClasspath("picture.jpg");
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue("value");
        return this;
    }

    public RegistrationPage setState(String value) {
        state.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String value) {
        city.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submit.click();
        return this;
    }

    public ResultTableComponent getResultTable() {
        return resultTableComponent;
    }

    public void checkError() {
        userNumberInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}


