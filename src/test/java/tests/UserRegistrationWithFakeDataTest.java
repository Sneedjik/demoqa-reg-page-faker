package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestDataWithFaker.*;

public class UserRegistrationWithFakeDataTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void userRegistrationWithFakeDataTest() {

        registrationPage.
                openPage()
                .removeBanners()

                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(number)
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
                .checkResult("Mobile", number)
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
                .setUserNumber(number)
                .submit()

                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", number);
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
