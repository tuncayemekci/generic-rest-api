package com.tuncayemekci.genericrestapi.service;

import com.tuncayemekci.genericrestapi.entity.Dynamic;
import com.tuncayemekci.genericrestapi.model.Randomizable;
import com.tuncayemekci.genericrestapi.model.RandomizableImpl;
import com.tuncayemekci.genericrestapi.repository.DynamicRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DynamicService {

    private final DynamicRepository dynamicRepository;

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
