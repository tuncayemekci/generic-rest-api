package com.tuncayemekci.genericrestapi.randomizable.model;

import com.tuncayemekci.genericrestapi.randomizable.Randomizable;
import com.tuncayemekci.genericrestapi.util.Util;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RandomizableImpl implements Randomizable {

    private Map<String, String> parametersMap;

    @Override
    public Randomizable randomize() {
        Map<String, String> collectedMap = parametersMap.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> this.getFormattedValue(e.getValue())));

        return RandomizableImpl.builder()
                .parametersMap(collectedMap)
                .build();
    }

    private String getFormattedValue(String value) {
        Random random = new Random();
        Integer randomValue = random.nextInt(100);

        if (value.equalsIgnoreCase("string")) {
            return Util.generateAlpha(10);
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
            return Util.generateRandomPersonName();
        }

        if (value.equalsIgnoreCase("surname")) {
            return Util.generateRandomPersonSurname();
        }

        if (value.equalsIgnoreCase("username")) {
            return Util.generateRandomUsername();
        }

        if (value.equalsIgnoreCase("email")) {
            return Util.generateRandomEmail();
        }

        if (value.equalsIgnoreCase("password")) {
            return Util.generateRandomPassword();
        }

        if (value.equalsIgnoreCase("phone")) {
            return Util.generateRandomPhoneNumber();
        }

        return value;
    }
}
