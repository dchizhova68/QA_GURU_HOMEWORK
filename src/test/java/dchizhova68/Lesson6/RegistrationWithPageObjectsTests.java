package dchizhova68.Lesson6;

import dchizhova68.TestBase;
import dchizhova68.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTests extends TestBase {
    final String FIRST_NAME = "QA";
    final String LAST_NAME = "GURU";
    final String USER_EMAIL = "test@test.ru";
    final String GENDER = "Female";
    final String USER_NUMBER = "1234567890";
    final String DATE_OF_BIRTH = "28";
    final String MONTH_OF_BIRTH = "March";
    final String YEAR_OF_BIRTH = "1990";
    final String SUBJECTS = "Chemistry";
    final String HOBBIES = "Sports";
    final String PICTURE = "test.png";
    final String CURRENT_ADDRESS = "Russia";
    final String STATE = "Haryana";
    final String CITY = "Karnal";

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setEmail(USER_EMAIL)
                .setGender(GENDER)
                .setNumber(USER_NUMBER)
                .setDateOfBirth(DATE_OF_BIRTH, MONTH_OF_BIRTH, YEAR_OF_BIRTH)
                .setSubject(SUBJECTS)
                .setHobbies(HOBBIES)
                .uploadFile(PICTURE)
                .setAddress(CURRENT_ADDRESS)
                .setState(STATE)
                .setCity(CITY)
                .completeRegistration();

        registrationPage.checkOpenModalDialog()
                .checkResult("Student Name", FIRST_NAME + " " + LAST_NAME)
                .checkResult("Student Email", USER_EMAIL)
                .checkResult("Gender", GENDER)
                .checkResult("Mobile", USER_NUMBER)
                .checkResult("Date of Birth", DATE_OF_BIRTH + " " + MONTH_OF_BIRTH + "," + YEAR_OF_BIRTH)
                .checkResult("Subjects", SUBJECTS)
                .checkResult("Hobbies", HOBBIES)
                .checkResult("Picture", PICTURE)
                .checkResult("Address", CURRENT_ADDRESS)
                .checkResult("State and City", STATE + " " + CITY);
    }

    @Test
    void successfulRegistrationWithRequiredAttributesTest() {
        registrationPage.openPage()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGender(GENDER)
                .setNumber(USER_NUMBER)
                .completeRegistration();

        registrationPage.checkOpenModalDialog()
                .checkResult("Student Name", FIRST_NAME + " " + LAST_NAME)
                .checkResult("Gender", GENDER)
                .checkResult("Mobile", USER_NUMBER);
    }

    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(FIRST_NAME)
                .completeRegistration();

        registrationPage.checkFaildRegistration();
    }

}
