package dchizhova68.lesson7;

import dchizhova68.TestBase;
import dchizhova68.TestData;
import dchizhova68.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
public class RegistrationWithFakerTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();
    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.gender)
                .setNumber(testData.userNumber)
                .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .setSubject(testData.subjects)
                .setHobbies(testData.hobbies)
                .uploadFile(testData.picture)
                .setAddress(testData.currentAddres)
                .setState(testData.state)
                .setCity(testData.city)
                .completeRegistration();

        registrationPage.checkOpenModalDialog()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth)
                .checkResult("Subjects", testData.subjects)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.currentAddres)
                .checkResult("State and City", testData.state + " " + testData.city);
    }

    @Test
    void successfulRegistrationWithRequiredAttributesTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setNumber(testData.userNumber)
                .completeRegistration();

        registrationPage.checkOpenModalDialog()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber);
    }

    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .completeRegistration();

        registrationPage.checkFaildRegistration();
    }

}
