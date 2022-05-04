package com.tuncayemekci.genericrestapi.controller;

import com.tuncayemekci.genericrestapi.model.Randomizable;
import com.tuncayemekci.genericrestapi.service.GenericService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/generics")
public class GenericController {

    private final GenericService genericService;

    @GetMapping(path = {"/", "/{model}", "/{model}/{size}"})
    public ResponseEntity<List<Randomizable>> getGenericModel(@PathVariable(name = "model", required = false) String model,
                                                              @PathVariable(name = "size", required = false) Integer size) {
        size = (size == null || size <= 0) ? 1 : size;
        return ResponseEntity.ok().body(genericService.getGenericModel(model, size));
    }
}
