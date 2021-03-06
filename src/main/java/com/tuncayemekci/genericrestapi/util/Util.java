package com.tuncayemekci.genericrestapi.util;

import java.util.Random;

public class Util {

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String NUMERIC_STRING = "0123456789";
    private static final String ALPHA_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String generateRandomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static String generateRandomNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * NUMERIC_STRING.length());
            builder.append(NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static String generateAlpha(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_STRING.length());
            builder.append(ALPHA_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static String generateRandomPersonName() {
        String[] names = {"John", "Jane", "Jack", "Jill", "Joe", "Jenny", "Jill", "Jenny", "Joe", "Jack", "Jane", "John"};
        int randomIndex = (int)(Math.random() * names.length);
        return names[randomIndex];
    }

    public static String generateRandomPersonSurname() {
        String[] surnames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas"};
        int randomIndex = (int)(Math.random() * surnames.length);
        return surnames[randomIndex];
    }

    public static String generateRandomUsername() {
        String[] userNames = {"john.smith", "jane.johnson", "jack.williams", "jill.jones", "joe.brown", "jenny.davis", "jill.miller", "jenny.wilson", "joe.moore", "jack.taylor", "jane.anderson", "john.thomas"};
        int randomIndex = (int)(Math.random() * userNames.length);
        return userNames[randomIndex];
    }

    public static String generateRandomEmail() {
        return generateRandomPersonName().toLowerCase() + "." + generateRandomPersonSurname().toLowerCase() + "@gmail.com";
    }

    public static String generateRandomPassword() {
        return generateRandomAlphaNumeric(8);
    }

    public static String generateRandomPhoneNumber() {
        return "+9053" + generateRandomNumeric(8);
    }

    public static String getFormattedValue(String value) {
        Random random = new Random();
        Integer randomValue = random.nextInt(100);

        if (value.equalsIgnoreCase("string")) {
            return generateAlpha(10);
        }

        if (value.equalsIgnoreCase("int")) {
            return String.valueOf(randomValue);
        }

        if (value.equalsIgnoreCase("long")) {
            return String.valueOf(randomValue);
        }

        if (value.equalsIgnoreCase("double")) {
            return String.valueOf(randomValue);
        }

        if (value.equalsIgnoreCase("float")) {
            return String.valueOf(randomValue);
        }

        if (value.equalsIgnoreCase("boolean")) {
            return randomValue > 50 ? "true" : "false";
        }

        if (value.equalsIgnoreCase("name")) {
            return generateRandomPersonName();
        }

        if (value.equalsIgnoreCase("surname")) {
            return generateRandomPersonSurname();
        }

        if (value.equalsIgnoreCase("username")) {
            return generateRandomUsername();
        }

        if (value.equalsIgnoreCase("email")) {
            return generateRandomEmail();
        }

        if (value.equalsIgnoreCase("password")) {
            return generateRandomPassword();
        }

        if (value.equalsIgnoreCase("phone")) {
            return generateRandomPhoneNumber();
        }

        return value;
    }


}
