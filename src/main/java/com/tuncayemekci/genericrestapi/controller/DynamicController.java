package com.tuncayemekci.genericrestapi.controller;

import com.tuncayemekci.genericrestapi.service.DynamicService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/dynamics")
public class DynamicController {

    private final DynamicService dynamicService;

    @GetMapping(path = {"/", "/{size}"})
    public ResponseEntity<List<Map<String, String>>> getDynamicModel(@RequestParam Map<String, String> params,
                                                                     @PathVariable(name = "size", required = false) Integer size) {
        size = (size == null || size <= 0) ? 1 : size;
        return ResponseEntity.ok().body(dynamicService.getDynamicModel(params, size));
    }

}
