package com.tuncayemekci.genericrestapi.randomizable;

import com.tuncayemekci.genericrestapi.randomizable.model.Customer;
import com.tuncayemekci.genericrestapi.randomizable.model.User;
import lombok.NonNull;

import java.util.Locale;

public class RandomizableFactory {

    private static final String CUSTOMER_MODEL_NAME = "customer";
    private static final String USER_MODEL_NAME = "user";

    public static Randomizable get(@NonNull String modelName) {
        switch (modelName.toLowerCase()) {
            case CUSTOMER_MODEL_NAME:
                return new Customer();
            case USER_MODEL_NAME:
                return new User();
            default:
                throw new IllegalArgumentException(String.format(Locale.getDefault(), "Model name %s is not supported", modelName));
        }
    }
}
