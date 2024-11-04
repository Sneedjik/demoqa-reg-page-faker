package tests;

import net.datafaker.Faker;

import java.time.LocalDate;
import java.time.Period;

public class TestDataWithFaker {

    private final Faker faker = new Faker();

    static final String[] genders = {"Male", "Female", "Other"};
    static final String[] subjects = {"Maths", "Computer Science", "Chemistry", "Biology", "History", "English"};
    static final String[] hobbies = {"Reading", "Sports", "Music"};

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getGender() {
        return faker.options().option(genders);
    }

    public String getNumber() {
        return faker.number().digits(10);
    }

    public String getDayOfBirthDate() {
        return String.format("%02d", getBirthDate().getDayOfMonth());
    }

    public String getMonthOfBirth() {
        return getBirthDate().getMonth().name().substring(0, 1).toUpperCase() + getBirthDate().getMonth().name().substring(1).toLowerCase();
    }

    public String getYearOfBirth() {
        return String.valueOf(getBirthDate().getYear());
    }

    public String getBadNumber() {
        return faker.regexify("[A-Za-z]{3}");
    }

    public String getSubject() {
        return faker.options().option(subjects);
    }

    public String getHobby() {
        return faker.options().option(hobbies);
    }

    public String getPicture() {
        return faker.options().option("One-Punch Man.jpg", "Oogway.jpg", "Totoro.jpg");
    }

    public String getAddress() {
        return faker.address().streetAddress();
    }

    public int getAge() {
        return faker.number().numberBetween(0, 124);
    }

    public LocalDate getBirthDate() {
        return LocalDate.now()
                .minus(Period.ofYears(getAge()));
    }

    public String getState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return faker.options().option(states);
    }

    public String getCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Lucknow", "Agra", "Merrut");
            case "Haryana" -> faker.options().option("Panipat", "Karnal");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> throw new IllegalArgumentException("Invalid state");
        };
    }

}