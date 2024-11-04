package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class UserRegistrationWithFakeDataTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestDataWithFaker testData = new TestDataWithFaker();

    String firstName = testData.getFirstName();
    String lastName = testData.getLastName();
    String email = testData.getEmail();
    String gender = testData.getGender();
    String phoneNumber = testData.getNumber();
    String badNumber = testData.getBadNumber();
    String dayOfBirth = testData.getDayOfBirthDate();
    String monthOfBirth = testData.getMonthOfBirth();
    String yearOfBirth = testData.getYearOfBirth();
    String subject = testData.getSubject();
    String hobby = testData.getHobby();
    String picture = testData.getPicture();
    String address = testData.getAddress();
    String state = testData.getState();
    String city = testData.getCity(state);

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
