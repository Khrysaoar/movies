package com.challenge.movies.controller;

import com.challenge.movies.model.MovieResponse;
import com.challenge.movies.service.DirectorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DirectorController {

    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @Operation(summary = "Get directors with movie threshold")
    @GetMapping("/directors")
    public ResponseEntity<Map<String, List<String>>> getDirectors(@RequestParam int threshold) {
        List<String> directors = directorService.getDirectors(threshold);
        return ResponseEntity.ok(Collections.singletonMap("directors", directors));
    }
}