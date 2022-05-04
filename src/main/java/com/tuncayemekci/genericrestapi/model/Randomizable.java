package com.tuncayemekci.genericrestapi.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Randomizable {

    Randomizable randomize();

    default List<Randomizable> generateList(Integer size) {
        return IntStream
                .range(0, size)
                .mapToObj(i -> this.randomize())
                .collect(Collectors.toList());
    }
}
