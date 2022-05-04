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
public class User implements Randomizable {

    private Long id;
    private String username;
    private String email;
    private String password;

    @Override
    public Randomizable randomize() {
        Random random = new Random();
        Integer randomValue = random.nextInt(100);

        return User.builder()
                .id((long) (randomValue * 100))
                .username("username" + randomValue)
                .email("email" + randomValue + "@gmail.com")
                .password("password" + randomValue)
                .build();
    }
}
