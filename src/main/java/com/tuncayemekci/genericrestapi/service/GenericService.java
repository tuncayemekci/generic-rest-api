package com.tuncayemekci.genericrestapi.service;

import com.tuncayemekci.genericrestapi.randomizable.Randomizable;
import com.tuncayemekci.genericrestapi.randomizable.RandomizableFactory;
import com.tuncayemekci.genericrestapi.randomizable.model.RandomizableImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GenericService {

    public List<Randomizable> getGenericModel(String model, Integer size) {
        return RandomizableFactory.get(model).generateList(size);
    }

    public List<Map<String, String>> getDynamicModel(Map<String, String> params, Integer size) {
        Randomizable randomizable = new RandomizableImpl(params);
        return randomizable
                .generateList(size)
                .stream()
                .map(s -> (RandomizableImpl) s)
                .map(s -> s.getParametersMap())
                .collect(Collectors.toList());
    }
}
