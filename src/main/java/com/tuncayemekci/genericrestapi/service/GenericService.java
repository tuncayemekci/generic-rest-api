package com.tuncayemekci.genericrestapi.service;

import com.tuncayemekci.genericrestapi.randomizable.Randomizable;
import com.tuncayemekci.genericrestapi.randomizable.RandomizableFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericService {

    public List<Randomizable> getGenericModel(String model, Integer size) {
        return RandomizableFactory.get(model).generateList(size);
    }
}
