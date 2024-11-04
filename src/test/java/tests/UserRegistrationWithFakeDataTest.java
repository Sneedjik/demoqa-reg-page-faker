package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class UserRegistrationWithFakeDataTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestDataWithFaker testData = new TestDataWithFaker();

    final String firstName = testData.getFirstName();
    final String lastName = testData.getLastName();
    final String email = testData.getEmail();
    final String gender = testData.getGender();
    final String phoneNumber = testData.getNumber();
    final String badNumber = testData.getBadNumber();
    final String dayOfBirth = testData.getDayOfBirthDate();
    final String monthOfBirth = testData.getMonthOfBirth();
    final String yearOfBirth = testData.getYearOfBirth();
    final String subject = testData.getSubject();
    final String hobby = testData.getHobby();
    final String picture = testData.getPicture();
    final String address = testData.getAddress();
    final String state = testData.getState();
    final String city = testData.getCity(state);

    @Test
    void userRegistrationWithFakeDataTest() {

        registrationPage.
                openPage()
                .removeBanners()

                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .setHobby(hobby)
                .setPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit()

                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", picture)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void partlyFillFormTest() {
        registrationPage.
                openPage()
                .removeBanners()

                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .submit()

                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber);
    }

    @Test
    void negativeFillTest() {
        registrationPage.
                openPage()
                .removeBanners()

                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(badNumber)
                .submit()

                .negativeCheck();
    }

}
