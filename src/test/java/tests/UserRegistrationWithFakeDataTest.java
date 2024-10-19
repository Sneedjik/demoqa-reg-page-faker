package tests;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

public class UserRegistrationWithFakeDataTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker();

    String[] genders = {"Male", "Female", "Other"};
    String[] subjects = {"Maths", "Computer Science", "Chemistry", "Biology", "History", "English"};
    String[] hobbies = {"Reading", "Sports", "Music"};

    int age = faker.number().numberBetween(0, 124);
    LocalDate birthDate = LocalDate.now()
            .minus(Period.ofYears(age));
    String dayOfBirth = String.format("%02d", birthDate.getDayOfMonth());
    String monthOfBirth = birthDate.getMonth().name().substring(0, 1).toUpperCase() + birthDate.getMonth().name().substring(1).toLowerCase();
    String yearOfBirth = String.valueOf(birthDate.getYear());
    Map<String, String[]> statesWithCities = new HashMap<>() {{
        put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        put("Haryana", new String[]{"Karnal", "Panipat"});
        put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    }};
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = faker.options().option(genders);
    String number = faker.number().digits(10);
    String badNumber = faker.regexify("[A-Za-z]{3}");
    String subject = faker.options().option(subjects);
    String hobby = faker.options().option(hobbies);
    String picture = "One-Punch Man.jpg";
    String address = faker.address().streetAddress();
    String state = faker.options().option(statesWithCities.keySet().toArray(new String[0]));
    String city = faker.options().option(statesWithCities.get(state));


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
