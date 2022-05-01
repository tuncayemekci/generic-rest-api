package com.tuncayemekci.genericrestapi.controller;

import com.tuncayemekci.genericrestapi.randomizable.Randomizable;
import com.tuncayemekci.genericrestapi.service.GenericService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/get")
public class GenericController {

    private final GenericService genericService;

    @GetMapping(path = {"/generic", "/generic/{model}", "/generic/{model}/{size}"})
    public ResponseEntity<List<Randomizable>> getGenericModel(@PathVariable(name = "model", required = false) String model,
                                                              @PathVariable(name = "size", required = false) Integer size) {
        size = (size == null || size <= 0) ? 1 : size;
        return ResponseEntity.ok().body(genericService.getGenericModel(model, size));
    }

    @GetMapping(path = {"/dynamic", "/dynamic/{size}"})
    public ResponseEntity<List<Map<String, String>>> getDynamicModel(@RequestParam Map<String, String> params,
                                                                     @PathVariable(name = "size", required = false) Integer size) {
        size = (size == null || size <= 0) ? 1 : size;
        return ResponseEntity.ok().body(genericService.getDynamicModel(params, size));
    }
}
