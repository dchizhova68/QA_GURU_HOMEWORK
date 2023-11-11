package dchizhova68.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import dchizhova68.pages.components.CalendarComponent;
import dchizhova68.pages.components.TableResponsiveComponent;

public class RegistrationPage {
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            stateWrapper = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            cityWrapper = $("#stateCity-wrapper"),
            modalDialogLocator = $(".modal-dialog"),
            submiteLocator = $("#submit");

    CalendarComponent calendar = new CalendarComponent();
    TableResponsiveComponent tableResponsive = new TableResponsiveComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
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

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.val(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadFile(String fileName) {
        uploadPictureInput.uploadFromClasspath(fileName);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.click();
        stateWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        cityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage completeRegistration() {
        submiteLocator.click();

        return this;
    }

    public RegistrationPage checkOpenModalDialog() {
        modalDialogLocator.should(appear);

        return this;
    }
    public RegistrationPage checkResult(String key, String value) {
        tableResponsive.checkResult(key, value);

        return this;
    }

    public RegistrationPage checkFaildRegistration() {
        modalDialogLocator.should(disappear);
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

}
