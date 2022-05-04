package com.tuncayemekci.genericrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Randomizable {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;

    @Override
    public Randomizable randomize() {
        Random random = new Random();
        Integer randomValue = random.nextInt(100);

        return Customer.builder()
                .id((long) (randomValue * 100))
                .name("name" + randomValue)
                .surname("surname" + randomValue)
                .email("email" + randomValue + "@gmail.com")
                .phone("+90532" + random.nextInt(10000000))
                .build();
    }
}
