package tests;

import net.datafaker.Faker;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

public class TestDataWithFaker {

    public static Map<String, String[]> statesWithCities = new HashMap<>() {{
        put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        put("Haryana", new String[]{"Karnal", "Panipat"});
        put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    }};
    static Faker faker = new Faker();
    public static int age = faker.number().numberBetween(0, 124);
    public static LocalDate birthDate = LocalDate.now()
            .minus(Period.ofYears(age));
    static String[] genders = {"Male", "Female", "Other"};
    static String[] subjects = {"Maths", "Computer Science", "Chemistry", "Biology", "History", "English"};
    static String[] hobbies = {"Reading", "Sports", "Music"};
    public static String dayOfBirth = String.format("%02d", birthDate.getDayOfMonth()),
            monthOfBirth = birthDate.getMonth().name().substring(0, 1).toUpperCase() + birthDate.getMonth().name().substring(1).toLowerCase(),
            yearOfBirth = String.valueOf(birthDate.getYear()),
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option(genders),
            number = faker.number().digits(10),
            badNumber = faker.regexify("[A-Za-z]{3}"),
            subject = faker.options().option(subjects),
            hobby = faker.options().option(hobbies),
            picture = faker.options().option("One-Punch Man.jpg","Oogway.jpg","Totoro.jpg"),
            address = faker.address().streetAddress(),
            state = faker.options().option(statesWithCities.keySet().toArray(new String[0])),
            city = faker.options().option(statesWithCities.get(state));

}
