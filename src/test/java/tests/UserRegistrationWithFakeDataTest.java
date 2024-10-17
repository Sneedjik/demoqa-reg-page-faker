package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class UserRegistrationWithFakeDataTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    String firstName = "Bony";
    String lastName = "Skye";
    String email = "Bony@test.com";
    String gender = "Male";
    String number = "9659112131";
    String badNumber = "j";
    String dayOfBirth = "07";
    String monthOfBirth = "October";
    String yearOfBirth = "1991";
    String subject = "Maths";
    String hobby = "Reading";
    String picture = "One-Punch Man.jpg";
    String address = "Street 1";
    String state = "NCR";
    String city = "Delhi";

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
