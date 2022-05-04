package com.tuncayemekci.genericrestapi.model;

import com.tuncayemekci.genericrestapi.util.Util;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
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
                .collect(Collectors.toMap(Map.Entry::getKey, e -> Util.getFormattedValue(e.getValue())));

        return RandomizableImpl.builder()
                .parametersMap(collectedMap)
                .build();
    }

}
